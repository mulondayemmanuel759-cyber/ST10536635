/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rosebank.college.st10536635;

/**
 *
 * @author Marco
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Login {
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;
    private String cellNumber;

    // Setters for user details
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStoredUsername(String username) { this.storedUsername = username; }
    public void setStoredPassword(String password) { this.storedPassword = password; }
    public void setCellNumber(String cellNumber) { this.cellNumber = cellNumber; }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        // Regex for at least 8 chars, 1 capital, 1 number, 1 special character
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean checkCellPhoneNumber(String phoneNumber) {
        // South African international format: +27 followed by 9 digits (total length 12)
        String cellRegex = "^\\+27\\d{9}$";
        Pattern pattern = Pattern.compile(cellRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public String registerUser() {
        if (!checkUserName(storedUsername)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(storedPassword)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        return "User has been registered successfully.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
    }

    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
