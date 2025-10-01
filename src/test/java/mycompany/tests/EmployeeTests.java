package mycompany.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.DashboardPage;
import pages.AddEmployeelistPage;
import pages.EmployeelistPage;
import util.ConfigReader;

public class EmployeeTests extends BaseTest {

    @Test
    public void testAddEmployee() {
        // login first
        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.get("admin.username"), ConfigReader.get("admin.password"));

        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isDashboardDisplayed(), "Dashboard not displayed");

        // go to PIM > Add Employee
        dash.menuPIM.click();  // (you might need a getter or method in DashboardPage)
        AddEmployeelistPage addEmp = new AddEmployeelistPage(driver);
        addEmp.clickAddEmployee();
        String firstName = "John";
        String lastName = "Doe";
        addEmp.setFirstName(firstName);
        addEmp.setLastName(lastName);
        addEmp.save();

        // now verify via Employee List
        // navigate to Employee List (PIM > Employee List) — you may need a page object or method
        EmployeelistPage empList = new EmployeelistPage(driver);
        empList.searchByName(firstName + " " + lastName);
        Assert.assertTrue(empList.isEmployeeDisplayed(firstName + " " + lastName), "Employee should be displayed in list");
    }
}

