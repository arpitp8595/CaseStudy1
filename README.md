# CaseStudy1

**Note**: Below is just a sample Request Body and Response body. this won't be the same everytime. I used them in my local environment just to test whether code is working perfectly or not.



SAVE: http://localhost:8080/products/saveProduct

Request Body
{
        "id": 1,
        "name": "Hamer",
        "current_price": {
        "value": 50,
        "currency_code": "USD"
    }
}

Response Body
{
        "id": "61df3f262f913362aba3b9c0",
        "name": "Hamer",
        "current_price": {
        "value": 50,
        "currency_code": "USD"
    }
}

Note: id (61df3f262f913362aba3b9c0) won't be same in all scenario.

PUT: http://localhost:8080/products/61df3f262f913362aba3b9c0
Request Body
{
        "id": "61df3f262f913362aba3b9c0",
        "name": "Hamer",
        "current_price": {
        "value": 120.00,
        "currency_code": "USD"
    }
}

Response Body
{
        "id": "61df3f262f913362aba3b9c0",
        "name": "Hamer",
        "current_price": {
        "value": 120,
        "currency_code": "USD"
    }
}

GET: http://localhost:8080/products/61df3f262f913362aba3b9c0

Response Body:
{
        "id": "61df3f262f913362aba3b9c0",
        "name": "Hamer",
        "current_price": {
        "value": 120,
        "currency_code": "USD"
    }
}


**Swagger UI: http://localhost:8080/swagger-ui/index.html**
