/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marco
 */

import com.rosebank.college.st10536635.Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private Login loginSystem;

    @BeforeEach
    public void setUp() {
        loginSystem = new Login();
        loginSystem.setFirstName("user first name");
        loginSystem.setLastName("user last name");
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(loginSystem.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(loginSystem.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(loginSystem.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        assertFalse(loginSystem.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {
        assertTrue(loginSystem.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {
        assertFalse(loginSystem.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccessful() {
        // Setup correct registration details
        loginSystem.setStoredUsername("kyl_1");
        loginSystem.setStoredPassword("Ch&&sec@ke99!");
        
        assertTrue(loginSystem.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        // Setup correct registration details
        loginSystem.setStoredUsername("kyl_1");
        loginSystem.setStoredPassword("Ch&&sec@ke99!");
        
        assertFalse(loginSystem.loginUser("kyl_1", "wrongpassword!"));
    }
}