package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    public WebDriver driver;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement headerDashboard;

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement menuAdmin;

    @FindBy(xpath = "//span[text()='PIM']")
	public WebElement menuPIM;

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement menuMyInfo;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement linkLogout;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        return headerDashboard.isDisplayed();
    }

    public void clickLogout() {
        userDropdown.click();
        linkLogout.click();
    }
}
