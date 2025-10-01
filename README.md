# Quiz-Application ![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green) ![MySQL](https://img.shields.io/badge/MySQL-8.0-blue) ![License: MIT](https://img.shields.io/badge/License-MIT-yellow)

A **Spring Boot** application to create, manage, and take quizzes. Supports full **CRUD operations** for questions and quizzes, with input validation.

---

## Table of Contents

* [Features](#features)
* [Technologies](#technologies)
* [Installation](#installation)
* [API Endpoints](#api-endpoints)

  * [Questions](#questions)
  * [Quizzes](#quizzes)
* [Usage](#usage)
* [License](#license)

---

## Features

* Full CRUD for **questions** and **quizzes**
* Submit and evaluate quiz answers
* Fetch questions by **category**
* Optional **difficulty level** for quizzes
* Validation for user input

---

## Technologies

* **Java 17**
* **Spring Boot 3**
* **Spring Web**
* **Spring Data JPA**
* **MySQL 8** (via MySQL Workbench)
* **Maven**

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/yourusername/quiz-application.git
```

2. Navigate to the project directory:

```bash
cd quiz-application
```

3. Configure your MySQL database in `application.properties` or `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Build and run the application:

```bash
mvn spring-boot:run
```

5. Access the application at:

```
http://localhost:8080
```

---

## API Endpoints

### Questions

**Get all questions**

* **GET** `/question/getQuestions`
* **Response JSON Example:**

```json
[
  {
    "id": 1,
    "questionTitle": "In Python, how do you create a variable?",
    "option1": "x = 5",
    "option2": "var x = 5",
    "option3": "int x = 5",
    "option4": "declare x = 5",
    "rightAnswer": "x = 5",
    "difficultyLevel": "Easy",
    "category": "Python"
  }
]
```

**Add a new question**

* **POST** `/question/addquestion`
* **Request JSON Example:**

```json
{
  "questionTitle": "In Python, how do you create a variable?",
  "option1": "x = 5",
  "option2": "var x = 5",
  "option3": "int x = 5",
  "option4": "declare x = 5",
  "rightAnswer": "x = 5",
  "difficultyLevel": "Easy",
  "category": "Python"
}
```

**Delete a question**

* **DELETE** `/question/deletequestion/{Id}`
* Throws exception if `{Id}` is invalid.

**Edit a question**

* **PUT** `/question/editquestion/{Id}`
* **Request JSON Example:**

```json
{
  "questionTitle": "In Python, how do you create a variable?",
  "option1": "x = 5",
  "option2": "var x = 5",
  "option3": "int x = 5",
  "option4": "declare x = 5",
  "rightAnswer": "x = 5",
  "difficultyLevel": "Easy",
  "category": "Python"
}
```

**Get questions by category**

* **GET** `/question/category/{category}`
* Example: `/question/category/java` returns all Java questions.

---

### Quizzes

**Create a quiz**

* **POST** `/quiz/create?category=&noOfQuestions=&quizTitle=&difficultyLevel=`
* `category` – required, `noOfQuestions` – required, `quizTitle` – required, `difficultyLevel` – optional

**Delete a quiz**

* **DELETE** `/quiz/delete/{Id}`

**Get quiz questions by quiz ID**

* **GET** `/quiz/{Id}`
* **Response JSON Example:**

```json
[
  {
    "id": 1,
    "questionTitle": "In Python, how do you create a variable?",
    "option1": "x = 5",
    "option2": "var x = 5",
    "option3": "int x = 5",
    "option4": "declare x = 5",
  }
]
```

**Update a quiz**

* **PUT** `/quiz/update/{Id}?category=&difficultyLevel=&quizTitle=&noOfQuestions=`
* Update parameters as needed.

**Submit quiz answers**

* **POST** `/quiz/submit/{Id}`
* **Request JSON Example:**

```json
[
  {
    "questionId": 1,
    "userAnswer": "x = 5"
  },
  {
    "questionId": 2,
    "userAnswer": "var x = 5"
  }
]
```

---

## Usage

1. Use **Postman**, **Insomnia**, or any REST client to test the endpoints.
2. Add questions first.
3. Create quizzes using added questions.
4. Fetch quizzes and submit answers using `/quiz/submit/{Id}`.

---

## License

This project is licensed under the **MIT License**.

