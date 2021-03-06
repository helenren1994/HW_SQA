IS2545- DELIVERABLE 3: Web Testing with BDD
E-Commerce Web Testing (http:store.demoqa.com/)

SUMMARY
As required, there are 3 user stories in total. 
During this project, I met some problems.
First, at the beginning of this project, it is not hard to define 3 stories, but when I finally decide the stories, I find it is really difficult to come up with 3 scenarios for each story. 
Second, because I tried too many times testing so as to my IP was blocked by the website, then I sent emails to them several times to unlock my IP. 
Here are 3 stories and the scenarios following below.

User Story 1: 
As a user, if I want to purchase products on this website I have to register first. 

Scenario 1:
Given that I am on the register page
I leave the "username" field blank and click "Register" button
Then I should get the error "Please enter a username"

Scenario 2	:
Given that I am on the register page
I enter an invalid email address and click "Register" button
Then I should get the error "The email address isn’t correct."

Scenario 3
Given that I am on the register page
I enter a already used username and click "Register" button
Then I should get the error "This username is already registered. Please choose another one."

User Story 2: 
As a user, I need to log in to my account to buy products

Scenario 1:
Given I am on the log in page
I leave "Username" and "Passport" fields blank and click "Register" button
Then I should get the error "Please enter your username and password."

Scenario 2:
Given I am on the log in page
I enter correct username and passport
Then I should log in successfully

Scenario 3:
Given I am on the log in page
I enter wrong username and passport
Then I should get the error "Invalid login credentials."


User Story 3: 
As a user, I need to edit products in the shopping cart.

Scenario 1:
Given that I am on the website
I want to add an item to my empty cart
After adding, I should have exactly 1 item in my cart

Scenario 2:
Given that I have 1 item in my cart
I want to change the quantity of this item to 2
After updating, I should have exactly 2 item in my cart.

Scenario 3:
Give that I have 1 item in my cart
I want to remove the item
After removing, I should have exactly 0 item in my cart
