@tag
Feature: Error Validation
I want to use this template for my feature file




@tag2
Scenario Outline: 	Error validation  
Given  I landed on Ecommerce Page
Given Logged in with username  <name>  and password <password>
Then "Incorrect email or password." message is displayed 

Examples:
  |  name                      | password          |
  | archana.jan01@gmail.com    |  Archana12345    |