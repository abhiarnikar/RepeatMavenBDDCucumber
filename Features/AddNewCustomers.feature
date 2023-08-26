Feature:Admin

@regression
Scenario Outline: Add New Customers 
 Given User Lanch Chrome Browser
 When  User open url "https://admin-demo.nopcommerce.com/login"
 And  User enter Email as "admin@yourstore.com" and password as "admin"  
 And   User click on Login button
 Then User can view Dashboard
   When user click on customers menu
   And  User click on customers menu item
   And User click on new add button
   Then User can view add new customer page
   When user enter customer info as "<newEmail>" and "<newPass>" and "<fname>" and "<lname>" and "<gender>" and "<comName>" and "<adminCommenet>"
   And user click on save button
   Then User can view confirmation msg "The new customer has been added successfully."
  Then close browser
   
    Examples:
   |Email|Password|newEmail|newPass|fname|lname|gender|comName|adminCommenet|
   |admin@yourstore.com|admin|Abhijit50@gmail.com|2504|Abhijit|Arnikar|Male|ABC|Test1|
   |admin@yourstore.com|admin|Kaivaly60@gmail.com|2110|Kaivaly|Arnikar|Male|XYZ|Test2|
   |admin@yourstore.com|admin|krushna70@gmail.com|1611|Krushna|Arnikar|Male|PQR|Test3|