package UserInterfacePractice;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);

    String userName;
    String firstName;
    String lastName;
    String dateOfBirth;
    String phoneNumber;
    String email;
    String recoveryEmail;
    String password;

    ArrayList<String> passwords = new ArrayList<>();

    public User (String userName, String firstName, String lastName, String phoneNumber, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

        passwords.add(password);
    } // End User constructor

    public void changeName (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    } // End changeName()

    public void changeDOB (String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    } // End changeDOB

    public void changePassword () {
        String newPassword = "";
        String doubleCheck = "";

        System.out.println("What is your first and last name?");
        String userName = input.nextLine();

        if (firstName.matches(userName.substring(0, userName.indexOf(" "))) && lastName.matches(userName.substring(userName.indexOf(" ")))) {
            // The first name is correct and they are in the system
        } else {
            System.out.println("Something went wrong");
        } // End if-else
        
        System.out.println("What would you like to change your password to?");
        newPassword = input.next();

        if (newPassword.length() < 0) {
            System.out.println("Password must be longer than 0");
        }

        if (passwords.contains(newPassword)) {
            System.out.println("Please use a password that has not been used before");
        } else if (!passwords.contains(newPassword)) {
            System.out.println("Retype password");
            doubleCheck = input.next();

            if (!newPassword.equals(doubleCheck)) {
                System.out.println("Passwords are not the same");
            } else {
                System.out.println("Password is set");
                passwords.add(newPassword);
                this.password = newPassword;
            }
        }
    } // End changePassword()

    public void addRecoveryEmail() {
        String recEmail = "";
        boolean set = false;

        while (set == false) {
            System.out.println("What would you like your recovery email to be?");
            recEmail = input.next();

            if (recEmail.length() < 0) {
                System.out.println("Invalid length, please try again.");
                break; // Break out of this if statement and try again
            }

            if (!recEmail.contains("@gmail") || !recEmail.contains("@hotmail")) {
                System.out.println("Please enter a valid email address.");
                break;
            }

            // Add user confirmation 
            // Make sure they recieved said confirmation
            System.out.println("Recovery email set!");
            this.recoveryEmail = recEmail;
        } // End while loop
    }
    public static void main(String[] args) {
        // Provides a collection/list of users that have made accounts
        ArrayList<String> users = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);
        int userChoice;
        boolean playing = true;

        while (playing) {
            System.out.println("Welcome to OSP (One-Service Provider)!\nHow can I help you today!\n1 - Set up an account\n2 - Account Settings\n3 - Play some games\n0 - Exit");
            userChoice = userInput.nextInt();

            if (userChoice < 0 || userChoice > 3) {
                System.out.println("Invalid input, please try again");
            }

            if (userChoice == 0) {
                System.out.println("Thanks for visiting!");
                System.exit(0);
            }

            if (userChoice == 1) {
                String userName = "";
                String firstName = "";
                String lastName = "";
                String email = "";
                String password = "";

                boolean one = false;
                boolean two = false;
                boolean three = false;
                boolean four = false;

                while (one == false) {
                    System.out.println("What is your first and last name?");
                    firstName = userInput.next();
                    lastName = userInput.next();
                    System.out.println();

                    if (firstName.length() == 0 && lastName.length() == 0) {
                        System.out.println("Invalid length. Please enter your first and last name.");
                        break;
                    }

                    if (firstName.matches("[0-9]") || lastName.matches("[0-9]")) {
                        System.out.println("Invalid input");
                        break;
                    }

                    one = true;
                } // End while loop for check 1

                while (two == false) {
                    System.out.println("What would you like your username to be?"); 
                    userName = userInput.nextLine();

                    if (userName.length() == 0) {
                        System.out.println("Please enter a valid userName.");
                        break;
                    } else {
                        two = true;
                    }
                } // End while loop for check 2

                while (three = false) {
                    System.out.println("We are almost done, we just need an email address and password.");
                    email = userInput.nextLine();

                    if (email.length() == 0) {
                        System.out.println("Invalid try again");
                        break;
                    }

                    if (!email.contains("@gmail") || !email.contains("@hotmail")) {
                        System.out.println("Please enter a valid email address.");
                        break;
                    }

                    three = true;
                } // End while loop for check 3

                while(four == false) {
                    System.out.println("Now type in a password for the account.\nNothing shorter than 8 characters.\nLetters, Numbers, and Symbols are fair game\n");
                    password = userInput.nextLine();

                    if (password.length() < 8) {
                        System.out.println("Please enter a password with a length greater than 8 characters.");
                        break;
                    }

                    if (password.contains(" ")) {
                        System.out.println("Spaces are not encouraged.");
                        break;
                    }
                    
                    four = true;
                } // End while loop for check 4

                System.out.println("Looks like you are all set. Have fun!");
                User newUser = new User(userName, firstName, lastName, lastName, email, password);
            } // End if userChoice is 1

            if (userChoice == 2) {
                System.out.println("What can I help you with today?\n1 - Reset Password\n2 - Change Account Information\n"); // Add more options later
                userChoice = userInput.nextInt();

                if (userChoice == 1) {
                    // Reset the password
                }
            }

            if (userChoice == 3) {
                String name = "";
                System.out.println("What would you like to play?\nWe have Rock, Paper, Scissors.\nHangman\nMagic-8 Ball\n");
                name = userInput.next();

                name.trim();
                name.toUpperCase();

                if (name.equals("ROCKPAPERSCISSORS")) {
                    // Launch and play rock paper scissors
                } else if (name.equals("HANGMAN")) {
                    // Launch Hangman
                } else if (name.equals("MAGIC-8BALL")) {

                }
            }
            
        } // End while loop

        userInput.close();
    } // End main method

} // End User class