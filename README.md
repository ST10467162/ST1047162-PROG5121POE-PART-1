# ST1047162-PROG5121POE-PART-1
# Chat App — Part 1: Registration and Login

This is a console-based Java application that allows a user to register an account and then log in using the details they registered with. The program follows the requirements given in the task brief.

The application runs through the console and does not use a GUI or `JOptionPane`.

## Project Files

| File                  | What it does                                                                           |
| --------------------- | -------------------------------------------------------------------------------------- |
| `src/Login.java`      | Contains the login class and handles the validation, registration and login functions. |
| `src/Main.java`       | Runs the program and allows the user to enter their registration and login details.    |
| `test/LoginTest.java` | Contains the JUnit 4 tests used to test the different functions in the Login class.    |

## Login Class Methods

The main methods in the `Login` class are:

| Method                          | What it does                                                                                                |
| ------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `checkUserName()`               | Checks if the username contains an underscore and is 5 characters or less.                                  |
| `checkPasswordComplexity()`     | Checks if the password has at least 8 characters, one capital letter, one number and one special character. |
| `checkCellPhoneNumber()`        | Checks if the cellphone number has an international country code, such as `+27`.                            |
| `registerUser()`                | Checks the username, password and cellphone number and gives the user the correct registration message.     |
| `loginUser(username, password)` | Checks whether the username and password entered during login match the registered details.                 |
| `returnLoginStatus(boolean)`    | Displays a message depending on whether the login was successful or not.                                    |

There are also overloaded versions of the username, password and cellphone validation methods. These allow different values to be tested directly instead of only testing the information stored in the Login object.

## How Registration Works

The user first enters their:

1. First name
2. Last name
3. Username
4. Password
5. Cellphone number

The information is then used to create a `Login` object.

The program checks the information in this order:

**Username → Password → Cellphone number**

If all the details are correct, the registration is completed. If something is wrong, the user is asked to register again.

## How Login Works

Once registration is successful, the user is asked to enter their username and password.

The `loginUser()` method checks the details entered against the username and password that were saved during registration.

If both details are correct, the user is logged in and receives a welcome message using their first and last name.

If the details are incorrect, the program tells the user that the username or password is incorrect and gives them the option to try again.

## Cellphone Number Validation

The cellphone number is checked using a regular expression:

```text id="c4v9nm"
^\+\d{2,3}\d{1,10}$
```

The pattern checks that the number:

* Starts with a `+`
* Has a 2 or 3 digit country code
* Has between 1 and 10 digits after the country code

For example:

```text id="x7n2qa"
+27838968976
```

is accepted because `+27` is the country code and the remaining part is the subscriber number.

A number such as:

```text id="m1k6pz"
08966553
```

is rejected because it does not start with an international country code.

I used GeeksforGeeks' *Java Regex* article from 2023 as a reference when working with regular expressions.

## Password Validation

The password has to meet four requirements:

* It must have at least 8 characters.
* It must contain a capital letter.
* It must contain a number.
* It must contain a special character.

The program uses regular expressions to check some of these requirements.

## Username Validation

The username must contain an underscore (`_`) and cannot be longer than 5 characters.

If the username does not meet these requirements, the program will not allow the registration to continue.

## Running the Application

The project can be compiled using:

```bash id="q6b1wd"
javac -d build src/Login.java src/Main.java
```

Then the application can be run using:

```bash id="v2k8hx"
java -cp build Main
```

The program will then open in the console and ask the user to register and log in.

## Running the Tests

JUnit 4 is used to test the Login class.

In NetBeans, I can run the tests by:

1. Opening the project.
2. Finding `LoginTest.java`.
3. Right-clicking on the file.
4. Selecting **Test File**.

The tests check whether the different validation and login methods work correctly using the test information provided in the task brief.

## Assumptions Made

### First Name and Last Name

I included the first name and last name during registration because they are needed for the welcome message after a successful login.

### Registration Order

The `registerUser()` method checks the information in the following order:

**Username → Password → Cellphone number**

If one of the checks fails, the method returns the relevant message instead of continuing with the remaining checks.

If everything is correct, the program confirms that the information was successfully captured.

### Cellphone Number

For the cellphone number, I interpreted the requirement as meaning that the subscriber number can have up to 10 digits after the international country code.

For example, in:

```text id="r9h3tc"
+27838968976
```

`+27` is the international country code and `838968976` is the subscriber number.

This is why the regular expression allows a 2 or 3 digit country code followed by up to 10 digits.

## Summary

Overall, this project uses Java to create a simple registration and login system.

The `Main` class controls what happens in the program, such as asking the user for information and controlling the registration and login loops.

The `Login` class contains the main validation and login methods. The project also uses concepts such as classes, objects, constructors, getters and setters, Boolean values, loops, regular expressions and JUnit testing.
