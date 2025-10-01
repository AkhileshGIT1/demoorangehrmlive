package mycompany.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.DashboardPage;
import util.ConfigReader;

public class LogoutTests extends BaseTest {

    @Test
    public void testLogout() {
        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.get("admin.username"), ConfigReader.get("admin.password"));

        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isDashboardDisplayed(), "Dashboard should be visible after login");

        // logout
        dash.clickLogout();

        // After logout, you should be back to login page. You might verify login button is visible
        LoginPage loginAfter = new LoginPage(driver);
        // Maybe verify that username field is present (indicates login page)
        // If you have a method isLoginPageDisplayed, you can assert that
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"), "Should be on login page after logout");
    }
}
