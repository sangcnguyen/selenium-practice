Selenium Practice
===========
# Installation
1. JDK: It stands for Java Development Kit. You need it to compile and run the code (since it's written in Java :D). Here's the [link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) to download it.
2. Maven: Maven is a tool to manage the program lifecycle and dependencies. In this framework, its main purpose is to manage dependencies. You can download it [here](https://maven.apache.org/download.cgi) and find the installation guide [here](https://maven.apache.org/install.html). In case you don't know how to set environment variables, you can find the instruction [here](https://www.java.com/en/download/help/path.xml)

Optional:

1. IDE: You'll need an editor for coding. If you want a full support from writing code to compiling and running, IDE (Integrated Development Environment) is here to help. It provides you an editor and some tools to code easier, as well as compile and run the code. There're many IDEs out there, so you can choose which suites you best. Two recommended ones are [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) and [Eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/oxygen2). As this project is written with IntelliJ, so it might be better if you use that IDE. Beside that, there're some lightweight editors (which only help you to edit your code, no more no less) like: Visual Studio Code, Sublime, Notepad++, Notepad, etc.
2. Git GUI: If you don't want to remember Git commands like `git commit` or `git pull`, you may want to use some tools that transform these commands to GUI button, text, etc. You may want to try [SourceTree](https://www.sourcetreeapp.com/) or [Git Desktop](https://desktop.github.com/).

# Write tests
These cases are to test the Saleor system, it's deployed at http://192.168.74.230.
## Login successfully
1. Navigate user to login page
2. Fill in username/password fields with valid credentials: admin@sample.com/Kms@2017
3. Click Login btn. Expected result: 
  * User is navigated to Home page. 
  * On the top-right corner, there're three items: DASHBOARD, YOUR ACCOUNT and LOG OUT
4. Click Log out btn. Expected result: 
   * User is navigated to Home page. 
   * On the top-right corner, there're two items: REGISTER, LOGIN. 
   * The message "You have been successfully logged out." is displayed

## Validate add to cart feature
1.  Navigate to Apparel page
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


After finishing those test cases, if you still want to practice more, write out some test cases for the Saleor, including the detailed test steps and validation points (I think it's easy since... you're testers, right? Writing test cases is what you do in your daily job) and then try to automate them.