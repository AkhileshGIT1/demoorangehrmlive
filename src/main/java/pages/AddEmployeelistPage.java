package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class AddEmployeelistPage {
    public WebDriver driver;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement linkAddEmployee;

    @FindBy(name = "firstName")
    private WebElement txtFirstName;

    @FindBy(name = "lastName")
    private WebElement txtLastName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;

    public AddEmployeelistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddEmployee() {
        linkAddEmployee.click();
    }

    public void setFirstName(String fn) {
        txtFirstName.clear();
        txtFirstName.sendKeys(fn);
    }

    public void setLastName(String ln) {
        txtLastName.clear();
        txtLastName.sendKeys(ln);
    }

    public void save() {
        btnSave.click();
    }
}
