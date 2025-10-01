package mycompany.tests;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.DashboardPage;
import util.ConfigReader;

public class LoginTests extends BaseTest {
	protected WebDriver driver;
    @Test
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.get("admin.username"), ConfigReader.get("admin.password"));

        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isDashboardDisplayed(), "Dashboard header should be displayed");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("wrongUser", "wrongPass");

        String errMsg = login.getErrorMessage();
        Assert.assertTrue(errMsg.contains("Invalid credentials"), 
            "Error message should say invalid credentials but was: " + errMsg);
    }
}
