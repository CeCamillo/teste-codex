# Teste-Codex

Resolution for the exercises proposed in Codex Utilities Tech Challenge

## Exercises

1. [CNPJ Validator](#1-cnpj-validator)
2. [Rectangle Intersection](#2-rectangle-intersection)
4. [Simple Todo List](#4-simple-todo-list)
5. [World Clock Client](#5-world-clock-client)
6. [World Clock Server](#6-world-clock-server)
7. [Entity Relationship Diagram](#7-entity-relationship-diagram)

## Building and Running the Project

The whole resolution is presented as an API, each exercise corresponds as one endpoint.
The API was built using Java Spring Boot

## 1. CNPJ Validator

### Description

Checks if a CNPJ is valid or not

### Features

* Validates CNPJ in both formatted ("00.000.000/0001-00") and unformatted ("00000000000000") strings
* Calculates and verifies the check digits according to the Receita Federal rules

### API Endpoint

* **URL** : `/cnpj`
* **Method** : POST
* **Body** : Raw string containing the CNPJ to be validated
* **Response** : Boolean (true if valid, false if invalid)

### Implementation Details

* The validation is performed in the `checkDigit` method of the `CNPJController` class
* Non-digit characters are removed using the `removeNonDigits` method

## 2. Rectangle Intersection

### Description

Returns if 2 rectangles intersect with each other

### API Endpoints

   * **URL** : `/rectangles/intersection`
   * **Method** : POST
   * **Body** : JSON object representing the rectangles

```
{
  "rectA": [0, 0, 2, 3],
  "rectB": [4, 4, 3, 2]
}
```

## 4. Simple Todo List

### Description

ToDo List was built using JPA and H2 DataBase

### Features

* Create new tasks
* Retrieve all tasks
* Delete tasks by ID

### API Endpoints

1. Create a Task

   * **URL** : `/task`
   * **Method** : POST
   * **Body** : JSON object representing the task

```
{
   "title":"Task Title",
   "description":"Task Description",
   "isCompleted":false
}
```

2. Get All Tasks

   * **URL** : `/task`
   * **Method** : GET
   * **Response** : List of all tasks
3. Delete a Task

   * **URL** : `/task/{id}`
   * **Method** : DELETE
   * **Path Variable** : `id` - The ID of the task to delete

   ### Data Model

   The `Task` entity has the following properties:


   * `id` (Long): Unique identifier
   * `title` (String): Title of the task
   * `description` (String): Description of the task
   * `isCompleted` (Boolean): Status of the task

   ### Implementation Details

   * Tasks are stored in a H2 database.
   * The `TaskController` handles the HTTP requests and logic


## 5. World Clock Client

### Description

Queries WorldClockApi for the current UTC time.

### Features

* Queries the World Clock API ([http://worldclockapi.com](http://worldclockapi.com))
* Returns the raw JSON response from the World Clock API

### API Endpoint

* **URL** : `/clockclient`
* **Method** : GET
* **Response** : JSON string containing the current UTC time information

### Implementation Details

* The `WorldClockClientController` class handles the HTTP GET request to the `/clockclient` endpoint

## 6. World Clock Server

### Description

Returns the Local Date Time

### Features

* Returns the current date and time

### API Endpoint

* **URL** : `/WorldClock`
* **Method** : GET
* **Response** : JSON object containing the current date and time

### Implementation Details

* The `WorldClockController` class handles the HTTP GET request to the `/WorldClock` endpoint

## 7. Entity Relationship Diagram

The Diagram is represented as SQL

### Description

An Entity Relationship Diagram for a simple Order Manager System

### Implementation Details
* `Client` Client Entity
* `Product` Product Entity
* `Order` Order Entity
* `Order_Item` Order_Item Entity, represents the items within the order