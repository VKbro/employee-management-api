# Employee Management System

This project is a RESTful API for an Employee Management System. It uses Spring Boot, JPA for database operations, and Bean Validation to validate the request bodies for POST and PUT operations.

## API Endpoints

The API supports the following operations:

- `GET /employees`: Fetch a list of all employees. This endpoint supports pagination.
- `GET /employees/{id}`: Fetch details of an employee by ID.
- `POST /employees`: Add a new employee. The request body should contain details of the employee (name, department, etc.).
- `PUT /employees/{id}`: Update details of an existing employee by ID.
- `DELETE /employees/{id}`: Delete an employee by ID.

## Validation

The API uses Bean Validation to validate the request bodies for the POST and PUT operations. The `@Valid` annotation is used in the controller methods to trigger the validation.

## Pagination

The `GET /employees` endpoint supports pagination. The `start` and `end` query parameters can be used to specify the range of employees to fetch.

## Setup and Run

To set up the project, you need to have Java and Maven installed on your machine. You can then clone the repository and run the project using the following command:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

This will start the application on port 8080. You can then use a tool like curl or Postman to send HTTP requests to the API endpoints.

## Sample

Here are some examples of how to test the endpoints of the Spring Boot application:

### Fetch a list of all employees

```bash
curl -X GET http://localhost:8080/employees
```

### Fetch details of an employee by ID

```bash
curl -X GET http://localhost:8080/employees/{id}
```

Replace `{id}` with the ID of the employee.

### Add a new employee

```bash
curl -X POST -H "Content-Type: application/json" -d '{
        "name": "John Doe",
        "salary": {
            "earning": {
                "baseSalary": 32748.0,
                "dearnessAllowance": 3882.0,
                "houseRentAllowance": 23882.0,
                "medicalAllowance": 2883.0,
                "specialAllowance": 8283.0
            },
            "deduction": {
                "professionalTax": 2939.0,
                "taxDeductedAtSource": 8828.0,
                "employeeProvidentFund": 28882.0
            }
        },
        "department": "R&D Department"
    }' http://localhost:8080/employees
```

### Update details of an existing employee by ID

```bash
curl -X PUT -H "Content-Type: application/json" -d '{
        "name": "John Doe",
        "salary": {
            "earning": {
                "baseSalary": 32748.0,
                "dearnessAllowance": 3882.0,
                "houseRentAllowance": 23882.0,
                "medicalAllowance": 2883.0,
                "specialAllowance": 8283.0
            },
            "deduction": {
                "professionalTax": 2939.0,
                "taxDeductedAtSource": 8828.0,
                "employeeProvidentFund": 28882.0
            }
        },
        "department": "Marketing"
    }' http://localhost:8080/employees/{id}
```

Replace `{id}` with the ID of the employee.

### Delete an employee by ID

```bash
curl -X DELETE http://localhost:8080/employees/{id}
```

Replace `{id}` with the ID of the employee.


