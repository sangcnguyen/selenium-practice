> This repo is outdated, because the new version of the website is released [here](https://github.com/mirumee/saleor). You can use this repo such as code structure for your project or learning purpose 

Selenium Practice
===========
# Installation
1. JDK: It stands for Java Development Kit. You need it to compile and run the code (since it's written in Java). Here's the [link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) to download it.
2. Maven: Maven is a tool to manage the program lifecycle and dependencies. In this framework, its main purpose is to manage dependencies. You can download it [here](https://maven.apache.org/download.cgi) and find the installation guide [here](https://maven.apache.org/install.html). In case you don't know how to set environment variables, you can find the instruction [here](https://www.java.com/en/download/help/path.xml)

# Write tests
These cases are to test the Saleor system.
## Test case 1: Login successfully
1. Navigate user to login page
2. Fill in username/password fields with valid credentials
3. Click Login btn. Expected result: 
  * User is navigated to Home page. 
  * On the top-right corner, there're three items: DASHBOARD, YOUR ACCOUNT and LOG OUT
4. Click Log out btn. Expected result: 
   * User is navigated to Home page. 
   * On the top-right corner, there're two items: REGISTER, LOGIN. 
   * The message "You have been successfully logged out." is displayed

## Test case 2: Validate add to cart feature
1. Navigate to Apparel page
2. Select a random product, click on it
3. Enter a random quantity number
4. Click add to cart
5. Navigate to Groceries page
6. Select a random product, click on it
7. Enter a random quantity number
8. Click add to cart
9. Navigate to cart page. Expected result:
    - Number of products is correct
    - Product information (Name, quantity, price) is correct
    - Subtotal is correct
