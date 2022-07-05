# RetailStoreDiscounts

On a retail website, the following discounts apply:
1.	If the user is an employee of the store, he gets a 30% discount on orders.
2.	If the user is a regular customer of the store, he gets a 10% discount.
3.	For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount).

#### Employee service
Create restful APIs to handle crud opretion for employees.
Method	| Path	| 
------------- | ------------------------- | 
POST	| /retailStore/employee/add	| 
GET	| /retailStore/employee/employees	| 
GET	| /retailStore/employee/{name}	| 
PUT	| /retailStore/employee/update	|
Delete	| /retailStore/employee/delete/{id}| 

`POST /retailStore/employee/add` 

    Request -> { "empName" : "#EMPLOYEE_NAME#","empDepartment" : "#EMPLOYEE_DEPARTMENT#"}
    Response -> { "empId": 1,    "empName": "test",    "empDepartment": "dev_test",    "empCreatedAt": "2022-07-04",    "empUpdateAt": "2022-07-04"}
  
    
 `PUT /retailStore/employee/update` 

    Request -> { "empId": 1,    "empName": "test2",    "empDepartment": "dev_test2"}
    Response -> { "empId": 1,    "empName": "test2",    "empDepartment": "dev_test2",    "empCreatedAt": "2022-07-04",    "empUpdateAt": "2022-07-04"}  
    
#### Net-payable service
  Create restful APIs to finds the net payable amount
  Method	| Path	| 
------------- | ------------------------- | 
POST	| /retailStore/net-payable	| 

`POST  /retailStore/net-payable` 

    Request -> { 
                 "billId" : "#EMPLOYEE_NAME#",
                 "customerName" : "#EMPLOYEE_DEPARTMENT#" ,
                 "payableAmount" : "#PAYABLE_AMOUNT#"
               }
    Response -> {
                   "bill": {
                       "billId": 2113,
                       "customerName": "sh0a",
                       "payableAmount": "12",
                       "decimalAmount": 12.0000
                   },
                   "netPayableAmount": "10.8000",
                   "netPayableDescriptions": [
                       " * 10% Discount on order for regular customer."
                   ]
               }
  
![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) netPayableAmount : Result of applied discounts
  
  
 #### Regular Customer
 Handle regular customer by add config proparty to check number of repetitions customer bill
  `numOfRegularCustomer=1` 
  
 #### UML class diagram 
  ![alt text](/UML.PNG)

  
