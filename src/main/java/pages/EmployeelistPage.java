package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeelistPage {
    public WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement empNameSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]")
    private WebElement tableBody;

    public EmployeelistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchByName(String empName) {
        empNameSearch.clear();
        empNameSearch.sendKeys(empName);
        btnSearch.click();
    }

    public boolean isEmployeeDisplayed(String empName) {
        // A simple contains check in the table body text
        String bodyText = tableBody.getText();
        return bodyText.contains(empName);
    }
}
