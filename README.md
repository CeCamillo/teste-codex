# Teste-Codex Project

This repository contains my solutions for the Kaffa Mobile Pre-qualification test (v1.10). The project includes implementations for various programming exercises as specified in the test document.

## Table of Contents

1. [CNPJ Validator](#1-cnpj-validator)
2. [Rectangle Intersection](#2-rectangle-intersection)
3. [Rectangle Intersection Area](#3-rectangle-intersection-area)
4. [Simple Todo List](#4-simple-todo-list)
5. [World Clock Client](#5-world-clock-client)
6. [World Clock Server](#6-world-clock-server)
7. [Entity Relationship Diagram](#7-entity-relationship-diagram)

## Building and Running the Project

Each exercise is implemented as a separate module within this project. Follow the instructions below to build and run each exercise.

## 1. CNPJ Validator

### Description

This module validates CNPJ (Cadastro Nacional da Pessoa Jurídica) formats and check digits. It's implemented as a REST API endpoint using Spring Boot.

### Features

* Validates CNPJ in both formatted ("00.000.000/0001-00") and unformatted ("00000000000000") strings
* Removes non-digit characters from the input
* Calculates and verifies the check digits according to the Receita Federal algorithm

### API Endpoint

* **URL** : `/cnpj`
* **Method** : POST
* **Body** : Raw string containing the CNPJ to be validated
* **Response** : Boolean (true if valid, false if invalid)

### Implementation Details

* The validation is performed in the `checkDigit` method of the `CNPJController` class.
* Non-digit characters are removed using the `removeNonDigits` method.
* The algorithm uses multiplication factors (5,4,3,2,9,8,7,6,5,4,3,2) for the first check digit and (6,5,4,3,2,9,8,7,6,5,4,3,2) for the second check digit.
* Check digits are calculated based on the remainder of the sum divided by 11.

## 2. Rectangle Intersection

### Description

This module tests if two rectangles intersect.

### How to Run

[Placeholder: Provide specific instructions on how to build and run the rectangle intersection checker]

## 3. Rectangle Intersection Area

### Description

This module computes the area of intersection between two rectangles.

### How to Run

[Placeholder: Provide specific instructions on how to build and run the rectangle intersection area calculator]

## 4. Simple Todo List

### Description

This module implements a simple Todo List application as a REST API using Spring Boot. It allows for the creation, retrieval, and deletion of tasks, with data persistence handled by JPA.

### Features

* Create new tasks
* Retrieve all tasks
* Delete tasks by ID
* Persistent storage of tasks

### API Endpoints

1. Create a Task

   * **URL** : `/task`
   * **Method** : POST
   * **Body** : JSON object representing the task

   <pre><div class="relative flex flex-col rounded-lg"><div class="text-text-300 absolute pl-3 pt-2.5 text-xs">json</div><div class="pointer-events-none sticky my-0.5 ml-0.5 flex items-center justify-end px-1.5 py-1 mix-blend-luminosity top-0"><div class="from-bg-300/90 to-bg-300/70 pointer-events-auto rounded-md bg-gradient-to-b p-0.5 backdrop-blur-md"><button class="flex flex-row items-center gap-1 rounded-md p-1 py-0.5 text-xs transition-opacity delay-100 hover:bg-bg-200 opacity-60 hover:opacity-100"><svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" viewBox="0 0 256 256" class="text-text-500 mr-px -translate-y-[0.5px]"><path d="M200,32H163.74a47.92,47.92,0,0,0-71.48,0H56A16,16,0,0,0,40,48V216a16,16,0,0,0,16,16H200a16,16,0,0,0,16-16V48A16,16,0,0,0,200,32Zm-72,0a32,32,0,0,1,32,32H96A32,32,0,0,1,128,32Zm72,184H56V48H82.75A47.93,47.93,0,0,0,80,64v8a8,8,0,0,0,8,8h80a8,8,0,0,0,8-8V64a47.93,47.93,0,0,0-2.75-16H200Z"></path></svg><span class="text-text-200 pr-0.5">Copy</span></button></div></div><div><div class="code-block__code !my-0 !rounded-lg !text-sm !leading-relaxed"><code class="language-json"><span><span class="token">{</span><span>
   </span></span><span><span></span><span class="token">"title"</span><span class="token">:</span><span></span><span class="token">"Task Title"</span><span class="token">,</span><span>
   </span></span><span><span></span><span class="token">"description"</span><span class="token">:</span><span></span><span class="token">"Task Description"</span><span class="token">,</span><span>
   </span></span><span><span></span><span class="token">"isCompleted"</span><span class="token">:</span><span></span><span class="token">false</span><span>
   </span></span><span><span></span><span class="token">}</span></span></code></div></div></div></pre>
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


   * `id` (Long): Automatically generated unique identifier
   * `title` (String): Title of the task
   * `description` (String): Description of the task
   * `isCompleted` (Boolean): Status of the task

   ### Implementation Details

   * The application uses Spring Boot and Spring Data JPA for simplicity and rapid development.
   * Tasks are stored in a database (the specific database isn't specified in the provided code, but it's likely using an in-memory database like H2 for development purposes).
   * The `TaskRepository` interface extends `CrudRepository`, providing basic CRUD operations out of the box.
   * The `TaskController` handles the HTTP requests and delegates to the repository for data operations.

[Placeholder: Provide specific instructions on how to build and run the todo list application]

## 5. World Clock Client

### How to Run

### Description

This module implements a simple World Clock Client as a REST API using Spring Boot. It queries an external world clock API and returns the current UTC time.

### Features

* Queries the World Clock API ([http://worldclockapi.com](http://worldclockapi.com))
* Returns the raw JSON response from the World Clock API

### API Endpoint

* **URL** : `/clockclient`
* **Method** : GET
* **Response** : JSON string containing the current UTC time information

### Implementation Details

* The application uses Spring Boot for simplicity and rapid development.
* The `WorldClockClientController` class handles the HTTP GET request to the `/clockclient` endpoint.
* The client makes a GET request to the World Clock API ([http://worldclockapi.com/api/json/utc/now](http://worldclockapi.com/api/json/utc/now)).
* The response from the World Clock API is read and returned as a string without any processing.

## 6. World Clock Server

### Description

This module implements a simple World Clock Server as a REST API using Spring Boot. It provides the current date and time when queried.

### Features

* Returns the current date and time in ISO-8601 format
* Uses the system's default time zone

### API Endpoint

* **URL** : `/WorldClock`
* **Method** : GET
* **Response** : JSON object containing the current date and time

### Implementation Details

* The application uses Spring Boot for simplicity and rapid development.
* The `WorldClockController` class handles the HTTP GET request to the `/WorldClock` endpoint.
* The current date and time are obtained using Java's `LocalDateTime.now()` method, which returns the current date-time using the system clock in the default time zone.
* The response is automatically serialized to JSON format by Spring's `@ResponseBody` annotation.

## 7. Entity Relationship Diagram

### Description

An Entity Relationship Diagram for a simple Order Manager System.

[Placeholder: Insert or link to the ERD image/description]
