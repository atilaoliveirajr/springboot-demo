# Web Service Project with Spring Boot and JPA / Hibernate
## Purpose of this project
This is a Project-based learning, where good coding practices will be applied, such as:
- Java Domain Model.
- Layered Architecture: resources, service and repository.
- Perfom tests with database (H2).
- CRUD - Create, Retrieve, Update, Delete
- Exception handling
- Use HTTP verbs (GET, POST, PUT, DELETE) according with [HTTP/1.1](http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html) standard.

## HTTP Verbs
Bellow is an example that shows how the API will behave and the vebs that it will use.

| HTTP METHOD | GET | POST | PUT | DELETE |
| --- | --- | --- | --- | --- |
| CRUD OP | CREATE | READ | UPDATE | DELETE |
| /users | Create new user | List all users | Error | Error |
| /users/1 | Error | Info about user 1 | Update info of user 1 | ***Delete user 1 |

***If the user is associated to an order, an Error will occur.

## Usage
### List all users
**Definition:** `GET /users`

**Response**:
- `200 - OK`

**Response Body (Success):**:
```json
[
	{
        "id": 1,
        "name": "Atila Oliveira",
        "email": "atila.oliveira.jr@gmail.com",
        "phone": "+4915737289281",
        "password": "abcdefg123"
    }

    {
        "id": 2,
        "name": "String",
        "email": "String",
        "phone": "String",
        "password": "String"
    }
]
```
### List Specific User
**Definition:** `GET /users/(:id)`

**Response:**
- `404 - Not Found`
- `400 - Bad User Request`
- `200 - OK`

**Response Body (Success):**:
```json
{
    "id": 1,
    "name": "Atila Oliveira",
    "email": "atila.oliveira.jr@gmail.com",
    "phone": "+4915737289281",
    "password": "abcdefg123"
}
```

**Response Body (Error 404):**
```json
{
    "timestamp": "2020-07-03T07:58Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Resource not found. id 20",
    "path": "/users/20"
}
```

**Response Body (Error 400):**
```json
{
    "timestamp": "2020-07-03T07:46:30.440+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "",
    "path": "/users/xyz"
}
```
### Create an User
**Definition:** `POST /users`

**Response**:
- `400 - Bad Request`
- `405 - Method Not Allowed`
- `201 - Created`

**Response Body (Success):**:
```json
{
    "id": "n+1",
    "name": "New user's name",
    "email": "New user's email",
    "phone": "New user's phone number",
    "password": "New user's password"
}
```

**Response Body (Error 405):**
```json
{
    "timestamp": "2020-07-04T10:00:20.579+00:00",
    "status": 405,
    "error": "Method Not Allowed",
    "message": "",
    "path": "/users/1"
}
```

**Response Body (Error 400):**
```json
{
    "timestamp": "2020-07-04T10:03:41.661+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "",
    "path": "/users"
}
```
### Update Specific User
**Definition:** `PUT /users/(:id)`

**Response:**
- `400 - Bad Request`
- `405 - Method Not Allowed`
- `200 - OK`

**Response Body (Success):**
```json
{
    "id": 1,
    "name": "Updated name / null if not specified",
    "email": "Updated email / null if not specified",
    "phone": "Updated phone / null if not specified",
    "password": "Updated password / null if not specified"
}
```

**Response Body (Error 400):**
```json
{
    "timestamp": "2020-07-04T10:13:19.275+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "",
    "path": "/users/xyz"
}
```
**Response Body (Error 404):**
```json
{
    "timestamp": "2020-07-04T10:04Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Resource not found. id 1",
    "path": "/users/500"
}
```

**Response Body (Error 405):**
```json
{
    "timestamp": "2020-07-04T10:12:21.534+00:00",
    "status": 405,
    "error": "Method Not Allowed",
    "message": "",
    "path": "/users"
}
```

### Update Specific User
**Definition:** `PUT /users/(:id)`

**Response:**
- `400 - Bad Request`
- `404 - Method Not Allowed`
- `204 - No Content`

**Response Body (Success):**
```json
{
    
}
```

**Response Body (Error 404):**
```json
{
    "timestamp": "2020-07-22T15:55Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Resource not found. id 500",
    "path": "/users/500"
}
```

**Response Body (Error 400):**
```json
{
    "timestamp": "2020-07-22T15:44:00.371+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "...",
    "path": "/users/xyz"
}
```

### List all Categories
**Definition:** `GET /categories`

**Response**:
- `200 - OK`

**Response Body (Success):**:
```json
[
    {
        "id": 1,
        "name": "Electronics"
    },
    {
        "id": 2,
        "name": "Books"
    },
    {
        "id": 3,
        "name": "Computers"
    }
]
```
### List Specific Category
**Definition:** `GET /categories/(:id)`

**Response:**
- `404 - Not Found`
- `400 - Bad Request`
- `200 - OK`

**Response Body (Success):**:
```json
{
    "id": 1,
    "name": "Electronics"
}
```

**Response Body (Error 404):**
```json
{
    "timestamp": "2020-07-22T15:59Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Resource not found. id 500",
    "path": "/categories/500"
}
```

**Response Body (Error 400):**
```json
{
    "timestamp": "2020-07-06T20:35:35.299+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "",
    "path": "/categories/xyz"
}
```
### List all Order
**Definition:** `GET /orders`

**Response**:
- `200 - OK`

**Response Body (Success):**:
```json
[
    {
        "id": 1,
        "moment": "2019-06-20T19:07Z",
        "orderStatus": "PAID",
        "client": {
            "id": 1,
            "name": "Updated name / null if not specified",
            "email": "Updated email / null if not specified",
            "phone": "Updated phone / null if not specified",
            "password": "123456"
        },
        "items": [
            {
                "quantity": 2,
                "price": 90.5,
                "product": {
                    "id": 1,
                    "name": "The Lord of the Rings",
                    "description": "Lorem ipsum dolor sit amet, consectetur.",
                    "price": 90.5,
                    "imgUrl": "",
                    "categories": [
                        {
                            "id": 2,
                            "name": "Books"
                        }
                    ]
                },
                "subTotal": 181.0
            },
            {
                "quantity": 1,
                "price": 1250.0,
                "product": {
                    "id": 3,
                    "name": "Macbook Pro",
                    "description": "Nam eleifend maximus tortor, at mollis.",
                    "price": 1250.0,
                    "imgUrl": "",
                    "categories": [
                        {
                            "id": 3,
                            "name": "Computers"
                        }
                    ]
                },
                "subTotal": 1250.0
            }
        ],
        "payment": {
            "id": 1,
            "moment": "2019-06-20T21:53:07Z"
        },
        "total": 1431.0
    },
    {
        "id": 2,
        "moment": "2019-07-21T03:10Z",
        "orderStatus": "WAITING_PAYMENT",
        "client": {
            "id": 2,
            "name": "Alex Green",
            "email": "alex@gmail.com",
            "phone": "977777777",
            "password": "123456"
        },
        "items": [
            {
                "quantity": 2,
                "price": 1250.0,
                "product": {
                    "id": 3,
                    "name": "Macbook Pro",
                    "description": "Nam eleifend maximus tortor, at mollis.",
                    "price": 1250.0,
                    "imgUrl": "",
                    "categories": [
                        {
                            "id": 3,
                            "name": "Computers"
                        }
                    ]
                },
                "subTotal": 2500.0
            }
        ],
        "payment": null,
        "total": 2500.0
    },
    {
        "id": 3,
        "moment": "2019-07-22T15:22Z",
        "orderStatus": "WAITING_PAYMENT",
        "client": {
            "id": 1,
            "name": "Updated name / null if not specified",
            "email": "Updated email / null if not specified",
            "phone": "Updated phone / null if not specified",
            "password": "123456"
        },
        "items": [
            {
                "quantity": 2,
                "price": 100.99,
                "product": {
                    "id": 5,
                    "name": "Rails for Dummies",
                    "description": "Cras fringilla convallis sem vel faucibus.",
                    "price": 100.99,
                    "imgUrl": "",
                    "categories": [
                        {
                            "id": 2,
                            "name": "Books"
                        }
                    ]
                },
                "subTotal": 201.98
            }
        ],
        "payment": null,
        "total": 201.98
    }
]
```
### List Specific Order
**Definition:** `GET /orders/(:id)`

**Response:**
- `404 - Not Found`
- `400 - Bad Request`
- `200 - OK`

**Response Body (Success):**:
```json
{
    "id": 1,
    "moment": "2019-06-20T19:07Z",
    "orderStatus": "PAID",
    "client": {
        "id": 1,
        "name": "Updated name / null if not specified",
        "email": "Updated email / null if not specified",
        "phone": "Updated phone / null if not specified",
        "password": "123456"
    },
    "items": [
        {
            "quantity": 2,
            "price": 90.5,
            "product": {
                "id": 1,
                "name": "The Lord of the Rings",
                "description": "Lorem ipsum dolor sit amet, consectetur.",
                "price": 90.5,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 2,
                        "name": "Books"
                    }
                ]
            },
            "subTotal": 181.0
        },
        {
            "quantity": 1,
            "price": 1250.0,
            "product": {
                "id": 3,
                "name": "Macbook Pro",
                "description": "Nam eleifend maximus tortor, at mollis.",
                "price": 1250.0,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 3,
                        "name": "Computers"
                    }
                ]
            },
            "subTotal": 1250.0
        }
    ],
    "payment": {
        "id": 1,
        "moment": "2019-06-20T21:53:07Z"
    },
    "total": 1431.0
}
```

**Response Body (Error 404):**
```json
{
    "timestamp": "2020-07-22T15:18Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Resource not found. id 500",
    "path": "/orders/500"
}
```

**Response Body (Error 400):**
```json
{
    "timestamp": "2020-07-06T20:48:35.886+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "",
    "path": "/orders/xyz"
}
```
### List all Products
**Definition:** `GET /products`

**Response**:
- `200 - OK`

**Response Body (Success):**:
```json
[
    [
    {
        "id": 1,
        "name": "The Lord of the Rings",
        "description": "Lorem ipsum dolor sit amet, consectetur.",
        "price": 90.5,
        "imgUrl": "",
        "categories": [
            {
                "id": 2,
                "name": "Books"
            }
        ]
    },
    {
        "id": 2,
        "name": "Smart TV",
        "description": "Nulla eu imperdiet purus. Maecenas ante.",
        "price": 2190.0,
        "imgUrl": "",
        "categories": [
            {
                "id": 1,
                "name": "Electronics"
            },
            {
                "id": 3,
                "name": "Computers"
            }
        ]
    },
    {
        "id": 3,
        "name": "Macbook Pro",
        "description": "Nam eleifend maximus tortor, at mollis.",
        "price": 1250.0,
        "imgUrl": "",
        "categories": [
            {
                "id": 3,
                "name": "Computers"
            }
        ]
    }
]
```
### List Specific Product
**Definition:** `GET /products/(:id)`

**Response:**
- `404 - Not Found`
- `400 - Bad Request`
- `200 - OK`

**Response Body (Success):**:
```json
{
    "id": 1,
    "name": "The Lord of the Rings",
    "description": "Lorem ipsum dolor sit amet, consectetur.",
    "price": 90.5,
    "imgUrl": "",
    "categories": [
        {
            "id": 2,
            "name": "Books"
        }
    ]
}
```

**Response Body (Error 404):**
```json
{
    "timestamp": "2020-07-22T15:47Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Resource not found. id 500",
    "path": "/products/500"
}
```

**Response Body (Error 400):**
```json
{
    "timestamp": "2020-07-06T21:23:22.193+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "",
    "path": "/products/xyz"
}
```

## Requirements (No Docker)
- Java (+11)
- Maven (+3)
- [WebServiceWithSpringBootAndHibernate-demo](https://github.com/Guergeiro/jdbc-rmi-server)

## By
[Átila Oliveira](https://www.linkedin.com/in/%C3%A1tila-oliveira-jr-60869319a/)
