package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-input-field-error-message']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String uname) {
        txtUsername.clear();
        txtUsername.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText().trim();
    }

    /**
     * Combined login action
     */
    public void login(String uname, String pwd) {
        enterUsername(uname);
        enterPassword(pwd);
        clickLogin();
    }
}
