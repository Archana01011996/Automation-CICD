

@tag
Feature: Purchase the order from Ecommerce website
I want to use this template for my feature file

Background:
Given  I landed on Ecommerce Page



@Regression
Scenario Outline: 	Positive Test of Submitting the order
Given Logged in with username  <name>  and password <password>
When I add product <Productname> to Cart
And CheckOut <Productname> and submit the order
Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

Examples:
  |  name                      | password          | Productname  |
  | archana.jan01@gmail.com    |  Archana@1996     | ZARA COAT 3  |
