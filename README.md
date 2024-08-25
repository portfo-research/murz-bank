# Ecomurz Bank Application

## Overview
Ecomurz Bank is a secure and robust banking application developed using Spring Boot. The application includes modules for user authentication, JWT handling, and user management. This README provides an overview of the project structure and key components.

## Project Structure

```plaintext
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───ecomurz
│   │   │           └───bank
│   │   │               ├───config
│   │   │               │   ├───filter
│   │   │               │   └───security
│   │   │               ├───module
│   │   │               │   ├───authentication
│   │   │               │   │   ├───controller
│   │   │               │   │   ├───request
│   │   │               │   │   ├───response
│   │   │               │   │   └───service
│   │   │               │   │       └───impl
│   │   │               │   ├───jwt
│   │   │               │   │   └───service
│   │   │               │   │       └───impl
│   │   │               │   └───user
│   │   │               │       ├───entity
│   │   │               │       ├───enums
│   │   │               │       ├───repository
│   │   │               │       └───service
│   │   │               │           └───impl
│   │   │               └───utils
│   │   │                   ├───exception
│   │   │                   ├───jwt
│   │   │                   └───response
│   │   └───resources
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───ecomurz
│                   └───bank
