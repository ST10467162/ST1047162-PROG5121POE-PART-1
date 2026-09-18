# ST1047162-PROG5121POE-PART-1
# Chat App — Part 1: Registration and Login Feature

A console-based Java application that implements user registration and login functionality according to the requirements in the task brief.

The application uses the Java console for user input and does not use a graphical user interface (GUI) or `JOptionPane`.

## Project Files

| File                  | Purpose                                                                                       |
| --------------------- | --------------------------------------------------------------------------------------------- |
| `src/Login.java`      | Contains the `Login` class, including user details, validation, registration and login logic. |
| `src/Main.java`       | The main console driver that handles registration and login interaction with the user.        |
| `test/LoginTest.java` | Contains JUnit 4 unit tests for testing the validation and login functionality.               |

## Login Class Methods

The `Login` class contains the following main methods:

| Method                                  | Functionality                                                                                                                 |
| --------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- |
| `boolean checkUserName()`               | Checks that the username contains an underscore (`_`) and is no more than 5 characters long.                                  |
| `boolean checkPasswordComplexity()`     | Checks that the password is at least 8 characters long and contains a capital letter, a number and a special character.       |
| `boolean checkCellPhoneNumber()`        | Checks that the cellphone number starts with an international country code, such as `+27`, followed by the subscriber number. |
| `String registerUser()`                 | Validates the username, password and cellphone number and returns the appropriate registration message.                       |
| `boolean loginUser(username, password)` | Compares the entered username and password with the details captured during registration.                                     |
| `String returnLoginStatus(boolean)`     | Returns a welcome message when login is successful or an error message when login fails.                                      |

### Overloaded Validation Methods

The application also includes overloaded versions of the validation methods:

* `checkUserName(String)`
* `checkPasswordComplexity(String)`
* `checkCellPhoneNumber(String)`

These methods allow the validation rules to be tested using specific input values rather than only the information stored in a `Login` object.

## Registration Process

The registration process is handled by the `Main` and `Login` classes.

The user is asked to enter:

1. First name
2. Last name
3. Username
4. Password
5. Cellphone number

A `Login` object is then created using the captured information.

The application checks the username, password and cellphone number in the following order:

**Username → Password → Cellphone number**

If all validation requirements are met, registration is completed. If a requirement is not met, the user is asked to try registering again.

## Login Process

After successful registration, the user is asked to enter their username and password.

The `loginUser()` method compares the entered credentials with the username and password stored during registration.

If the details match, the login is successful and the application displays a welcome message containing the user's first and last name.

If the details do not match, an error message is displayed and the user is given the option to try again.

## Cellphone Number Validation

The cellphone number is validated using a regular expression.

The regular expression used is:

```text
^\+\d{2,3}\d{1,10}$
```

This checks that the cellphone number:

* Starts with a `+`
* Contains a 2 or 3 digit international country code
* Is followed by between 1 and 10 digits for the subscriber number

For example, the test value:

```text
+27838968976
```

is accepted because `+27` is the country code and `838968976` contains 9 subscriber digits.

The value:

```text
08966553
```

is rejected because it does not contain the required international country code.

The regular-expression approach was informed by GeeksforGeeks, *Java Regex* (2023), accessed 18 September 2026.

## Password Validation

The password must meet the following requirements:

* At least 8 characters long
* Contains at least one uppercase letter
* Contains at least one number
* Contains at least one special character

Regular expressions are used to check for the uppercase letter, number and special character requirements.

## Username Validation

The username must:

* Contain an underscore (`_`)
* Be no more than 5 characters long

If either requirement is not met, the username is rejected.

## Compiling and Running the Application

The application can be compiled from the command line using:

```bash
javac -d build src/Login.java src/Main.java
```

After compilation, the application can be started using:

```bash
java -cp build Main
```

The program will then run in the console and prompt the user to register and log in.

## Running Unit Tests

The project uses JUnit 4 for unit testing.

In NetBeans, the tests can be run by:

1. Opening the project.
2. Locating `LoginTest.java`.
3. Right-clicking `LoginTest.java`.
4. Selecting **Test File**.

The unit tests check the validation and login functionality using the required test data from the task brief.

## Design Assumptions

### 1. First and Last Name

First name and last name are captured during registration because they are required for the successful login welcome message:

```text
Welcome <first name>, <last name>, it is great to see you again.
```

### 2. Registration Validation Order

The `registerUser()` method validates the information in this order:

**Username → Password → Cellphone number**

If a validation fails, the method returns the relevant error message instead of continuing to the next validation.

If all three requirements are met, the method confirms that the username, password and cellphone number were successfully captured.

### 3. Cellphone Number Length

The cellphone-number requirement is interpreted as allowing the subscriber number to contain no more than 10 digits after the international country code.

For example:

```text
+27838968976
```

is interpreted as:

* `+27` — international country code
* `838968976` — subscriber number

This interpretation allows the supplied valid test data to pass while rejecting numbers without an international country code.

## Summary

The application demonstrates the use of Java classes, objects, constructors, encapsulation, methods, Boolean logic, loops, regular expressions and unit testing.

The `Main` class controls the overall application flow, while the `Login` class contains the registration, validation and login functionality.
