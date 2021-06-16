package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.exceptions.ResourceNotFoundException;
import com.devsuperior.bds02.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public EventDTO update(Long id, EventDTO eventDTO) {
        try {
            Event event = repository.getOne(id);

            event.setName(eventDTO.getName());
            event.setDate(eventDTO.getDate());
            event.setUrl(eventDTO.getUrl());
            event.setCity(new City(eventDTO.getCityId(), null));

            event = repository.save(event);

            return new EventDTO(event);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Não encontramos registros desse evento");
        }
    }
}
