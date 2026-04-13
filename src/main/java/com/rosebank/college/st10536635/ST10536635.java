/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.rosebank.college.st10536635;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class ST10536635 {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        System.out.println("--- REGISTRATION ---");
        
        System.out.print("Enter First Name: ");
        loginSystem.setFirstName(scanner.nextLine());
        
        System.out.print("Enter Last Name: ");
        loginSystem.setLastName(scanner.nextLine());
        
        // Loop until a valid username is entered
        while (true) {
            System.out.print("Enter Username (max 5 chars, must contain '_'): ");
            String username = scanner.nextLine();
            if (loginSystem.checkUserName(username)) {
                loginSystem.setStoredUsername(username);
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // Loop until a valid password is entered
        while (true) {
            System.out.print("Enter Password (min 8 chars, 1 capital, 1 number, 1 special char): ");
            String password = scanner.nextLine();
            if (loginSystem.checkPasswordComplexity(password)) {
                loginSystem.setStoredPassword(password);
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Loop until a valid cell number is entered
        while (true) {
            System.out.print("Enter South African Cell Phone Number (e.g. +27838968976): ");
            String cell = scanner.nextLine();
            if (loginSystem.checkCellPhoneNumber(cell)) {
                loginSystem.setCellNumber(cell);
                System.out.println("Cell number successfully captured.");
                break;
            } else {
                System.out.println("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
            }
        }
        
        // Finalize Registration
        System.out.println("\n" + loginSystem.registerUser());

        System.out.println("\n--- LOGIN ---");
        System.out.print("Enter Username: ");
        String loginUser = scanner.nextLine();
        
        System.out.print("Enter Password: ");
        String loginPass = scanner.nextLine();

        boolean isAuthorized = loginSystem.loginUser(loginUser, loginPass);
        System.out.println(loginSystem.returnLoginStatus(isAuthorized));

        scanner.close();
    }
}

