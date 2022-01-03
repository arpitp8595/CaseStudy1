# CaseStudy1


PUT: http://localhost:8080/products/1
Request Body
{
"id": 1,
"name": "test",
"current_price": {
"value": 12.00,
"currency_code": "USD"
}
}


GET: http://localhost:8080/products/1

Response Body:
{
"id": "1",
"name": "test",
"current_price": {
"value": 12,
"currency_code": "USD"
}
}


Swagger UI: http://localhost:8080/swagger-ui/index.html
