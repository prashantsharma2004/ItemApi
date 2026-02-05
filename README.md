# Item Management API

This is a simple Spring Boot REST API to manage items.

## How to Run

1. Open project in IntelliJ
2. Run ItemapiApplication.java
3. Server runs on port 8080

## API Endpoints

### Add Item
POST /items

Body:
{
  "name":"Laptop",
  "description":"HP Laptop"
}

### Get Item by ID
GET /items/{id}

Example:
GET /items/1

### Get All Items
GET /items

## Validation

- Name must not be empty
- Description must not be empty

## Storage

- Data is stored in memory using ArrayList
- Data will be lost when server stops

