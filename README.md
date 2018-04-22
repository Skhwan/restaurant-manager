# restaurant-manager
2-days REST API project for restaurant management system using Java Spring Boot

### Techonologies & Tools
* Maven
* Spring Boot
* H2 in-memory database
* Postman

### APIs
#### Menu Service
* Add menu - add new menu

Post request:
```
{
	"name" : "test Menu",
	"description" : "test menu naja",
	"image" : "test image",
	"price" : 250,
	"additional" : "1,2,3"
}
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS"
}
```
<br/> <br/>

* Update Menu - update existing menu. It's actually the same API with _Add Menu_. <br/>
This will add a new menu if that menu isn't already exist, otherwise update the existing one.

POST request:
```
{
	"name" : "test Menu",
	"description" : "test menu naja",
	"image" : "test image",
	"price" : 250,
	"additional" : "1,2,3"
}
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS"
}
```
<br/> <br/>

* Remove Menu - remove menu

GET request:
```
localhost:8080/restaurant-manager/removeMenu?name=<MENU_NAME>
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS"
}
```
<br/> <br/>
* Search Menu - use keyword to search for relevant menu

GET request:
```
localhost:8080/restaurant-manager/searchMenu?keyword=Pizza&limit=<LIMIT>&offset=<OFFSET>
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS",
    "menus": [
        {
            "name": "HAWAIIAN PIZZA",
            "description": "All-time favorite topping, Hawaiian pizza in Topical Hawaii style",
            "image": "https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu1.jpg",
            "price": 300,
            "additional": [
                "Italian",
                "Ham",
                "Pineapple"
            ]
        }
    ],
    "previousPage": null,
    "nextPage": "/restaurant-manager/searchMenu?limit=1&offset=1"
}
```
<br/> <br/>

* Get All Menu - get all existing menus

GET request:
```
localhost:8080/restaurant-manager/getAllMenu?limit=<LIMIT>&offset=<OFFSET>
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS",
    "menus": [
        {
            "name": "XIAOLONGBAO",
            "description": "Chinese steamed bun",
            "image": "https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu3.jpg",
            "price": 300,
            "additional": [
                "Chinese",
                "Pork",
                "Recommended"
            ]
        },
        {
            "name": "KIMCHI",
            "description": "Traditional side-dish made from salted and fermented vegetables",
            "image": "https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu4.jpg",
            "price": 300,
            "additional": [
                "Korean",
                "Radish",
                "Cabbage"
            ]
        }
    ],
    "previousPage": "/restaurant-manager/getAllMenu?limit=2&offset=0",
    "nextPage": "/restaurant-manager/getAllMenu?limit=2$offset=4"
}
```
<br/> <br/>

#### Order Service
* Add Order

Post request:
```
{
	"billNo" : "4",
	"menu" : "Test Menu",
	"quantity" : 1
}
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS"
}
```
<br/> <br/>

* Remove Order

GET request:
```
localhost:8080/restaurant-manager/removeOrder?id=<ID>
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS"
}
```
<br/> <br/>

* Get Order By Bill

GET request:
```
localhost:8080/restaurant-manager/getOrder?billNo=<BILL_NO>
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS",
    "totalPrice": 600,
    "orders": [
        {
            "id": 1,
            "billNo": "1",
            "menu": "HAWAIIAN PIZZA",
            "quantity": 1,
            "orderedTime": "2017-01-01 10:00:00.0"
        },
        {
            "id": 3,
            "billNo": "1",
            "menu": "KIMCHI",
            "quantity": 1,
            "orderedTime": "2017-01-01 11:00:00.0"
        }
    ]
}
```
<br/> <br/>

* Check out

GET request:
```
localhost:8080/restaurant-manager/checkoutOrder?billNo=<BILL_NO>
```

response:
```
{
    "responseCode": "0",
    "responseDesc": "SUCCESS",
    "responseStatus": "SUCCESS",
    "totalPrice": 600,
    "orders": [
        {
            "id": 4,
            "billNo": "2",
            "menu": "XIAOLONGBAO",
            "quantity": 1,
            "orderedTime": "2017-01-01 00:00:00.0"
        },
        {
            "id": 5,
            "billNo": "2",
            "menu": "BEER",
            "quantity": 1,
            "orderedTime": "2017-01-01 00:00:00.0"
        }
    ]
}
```
<br/> <br/>
