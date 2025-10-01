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
# Populate Database for Testing

You can quickly populate your database without manually adding questions using AI-generated SQL inserts.

## Steps

1. **Generate SQL Insert Statements via AI Tool**  
   Use this example prompt in your preferred AI tool (e.g., Grok, ChatGPT):

   ```
   Generate SQL INSERT statements for table `question` with columns:
   category, difficulty_level (0=Easy,1=Medium,2=Hard), option1, option2, option3, option4, question_title, right_answer.

   Requirements:
   - Languages: Python, Java, C, C++
   - Topics: basic syntax, data structures, object-oriented programming
   - Distribute difficulty levels 0,1,2
   - Escape single quotes for MySQL
   - Avoid duplicates
   - Generate [number] unique questions
   ```

   *Note:* Replace `[number]` with the desired number of questions (e.g., 300).

2. **Save SQL to a File**  
   Copy the generated SQL statements and save them to a file.  
   Example filename:

   ```
   questions.sql
   ```

3. **Run SQL File in MySQL Workbench or CLI**  
   Execute the SQL file to insert the questions into your database:

   ```
   mysql -u username -p database_name < questions.sql
   ```

   - Replace `username` with your MySQL username (e.g., `root`).  
   - Replace `database_name` with your database name (e.g., `quizdb`).

4. **Database Ready**  
   All questions are now loaded for testing quizzes.
## Usage

1. Use **Postman**, **Insomnia**, or any REST client to test the endpoints.
2. Add questions first.
3. Create quizzes using added questions.
4. Fetch quizzes and submit answers using `/quiz/submit/{Id}`.

---

## License

This project is licensed under the **MIT License**.

