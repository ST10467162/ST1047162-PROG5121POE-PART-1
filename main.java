import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //Declaration of scanner obnect fo user input
        Scanner scanner = new Scanner(System.in);
        
        //Declaration of login object to store the registered user
        Login registeredUser = null;

        System.out.println("=== Welcome to the Chat App ===");

        //Declaration of boolean variable to track registration
        boolean registered = false;
        
        //Registration loop
        while (!registered) {
            System.out.println("\n--- Registration ---");
            
            //declaration of first name variable
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            
            //declaration of last name varible
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            
            //declaration of username
            System.out.print("Enter a username (must contain an underscore and be no more than 5 characters): ");
            String username = scanner.nextLine();
            
            //declaration of password
            System.out.print("Enter a password (min 8 characters, 1 capital letter, 1 number, 1 special character): ");
            String password = scanner.nextLine();
            
            //declaration of number
            System.out.print("Enter your cell phone number (must include the international country code, e.g. +27...): ");
            String cellPhoneNumber = scanner.nextLine();
            
            //declaration and creation of login object
            Login candidate = new Login(firstName, lastName, username, password, cellPhoneNumber);
            String result = candidate.registerUser();
            System.out.println(result);
            
            //checking if all regisration details are valid
            if (candidate.checkUserName() && candidate.checkPasswordComplexity() && candidate.checkCellPhoneNumber()) {
                registered = true;
                registeredUser = candidate;
                System.out.println("Registration complete!");    
            } else {
                System.out.println("Please try registering again.\n");
            }
        }

        //declaration of login status variable
        boolean loggedIn = false;
        
        //login loop
        while (!loggedIn) {
            System.out.println("\n--- Login ---");
            
            //declaration of username variable
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();
            
            //declaration of login password variable
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();
            
            //declaration of success variable
            boolean success = registeredUser.loginUser(loginUsername, loginPassword);
            System.out.println(registeredUser.returnLoginStatus(success));

            if (success) {
                loggedIn = true;
            } else {
                System.out.print("Would you like to try again? (y/n): ");
                String tryAgain = scanner.nextLine();
                if (!tryAgain.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }

        System.out.println("\nGoodbye!");
        scanner.close();
    }
}

