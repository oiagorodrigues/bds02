# DS Events API

Simple REST Events API made as the second task of the DevSuperior Spring React Bootcamp, using Spring Boot and persiting in a memory database using Spring Data JPA.

## Disclaimer

The repo was forked from [devsuperior/bds02](https://github.com/devsuperior/bds02) with integration tests already made. In order to complete the task, I needed to create **repositores**, **services** and **controllers** to pass the tests.

I've added unit tests after the completion of the task to pratice a bit more.

## How to install

Clone this repo


```bash
git clone https://github.com/oiagorodrigues/dsbootcamp-java-tdd-task.git

or 

git clone git@github.com:oiagorodrigues/dsbootcamp-java-tdd-task.git
```

Open it in your favorite IDE. 
Recommended using [Intellij](https://www.jetbrains.com/pt-br/idea/), [STS](https://spring.io/tools) or [VSCode](https://code.visualstudio.com/).

## Learning topics

- Creating a Data Layer with Entity|Model, Repository and Service
- Creating a API layer with Controller and DTO
- Creating custom Exceptions, custom StandardError and an ExceptionHandler
- Seeding the database
- Integration Tests
- Unit Tests

## Conceptual model

<img src="https://user-images.githubusercontent.com/19571060/122272855-35177980-ceb7-11eb-81e4-68f4bcee4b37.png" width="500">

## Technologies

- Java 11
- Spring Boot 2.4.5
- Spring Data JPA
- H2 Database
- JUnit
- Mockito
- MockMvc

## Endpoints

### City

#### Fetch Cities

> GET - /cities - Returns a list of cities sorted by name

Example Response

```json
// 200 OK

 [
  {
    "id": 11,
    "name": "Belo Horizonte"
  },
  {
    "id": 8,
    "name": "Belém"
  },
  {
    "id": 2,
    "name": "Brasília"
  },
  {
    "id": 6,
    "name": "Curitiba"
  },
  {
    "id": 3,
    "name": "Fortaleza"
  },
  {
    "id": 7,
    "name": "Goiânia"
  },
  {
    "id": 5,
    "name": "Manaus"
  },
  {
    "id": 9,
    "name": "Porto Alegre"
  },
  {
    "id": 10,
    "name": "Rio de Janeiro"
  },
  {
    "id": 4,
    "name": "Salvador"
  },
  {
    "id": 1,
    "name": "São Paulo"
  }
]
```

#### Delete City

> DELETE - /cities/{id}

Example Response

```json
// 201 NO CONTENT  - When a city exists
// 404 NOT FOUND   - When a city doesn't exists
// 400 BAD REQUEST - When a city is associated with one or more events
```

### Event

#### Update Event

> PUT - /events/{id}

Example Request

```json
// Content-Type: application/json

{
  "id": 1,
  "name": "Expo XP",
  "date": "2021-5-18",
  "url": "https://expoxp.com.br",
  "cityId": 7
}
```

Example Success Response

```json
// 200
// Content-Type: application/json

{
  "id": 1,
  "name": "Expo XP",
  "date": "2021-5-18",
  "url": "https://expoxp.com.br",
  "cityId": 7
}
```

Example Response - Not Found
```json
// 404 NOT FOUND
```
