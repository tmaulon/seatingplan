# SEATING PLAN CESI 

## What is seating plan ?
A CESI project to manage offices, equipment and workers in a business...

## Docker
This project is a Docker stack.

### Prerequisites
* install Docker
* install Docker Compose

This stack contains 4 services :
* Spring boot app (exposed port : 8082)
* MySQL db
* phpMyAdmin (exposed port : 8091)
* Jenkins (disabled by now)

### Run the stack 1st time
`docker-compose up --build` (add `-d` if you wanna liberate the term)

### Run the stack
`docker-compose up` (add `-d` if you wanna liberate the term)

Local api endpoint : `localhost:8082/api/1.0`

### Stop the stack 
`docker-compose down`

### Custom ports

Feel free to change used ports in `.env` file.
You can also change DB password and user.
Make sure to delete the database folder in order to apply thiese changes.


