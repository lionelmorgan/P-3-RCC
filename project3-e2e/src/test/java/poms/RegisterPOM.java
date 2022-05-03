package poms;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "firstname")
    WebElement firstNameInput;

    @FindBy(id = "lastname")
    WebElement lastNameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "register-form-btn")
    WebElement registerBtn;

    @FindBy(id = "login-form-btn")
    WebElement loginBtn;

    @FindBy(className = "errorMessage")
    WebElement errorMessage;

    public RegisterPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);

    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void enterUsername(String username) {
        this.usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void enterFirstName(String firstName) {
        this.firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        this.lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        this.emailInput.sendKeys(email);
    }

    public void clickBtn() {
        this.registerBtn.click();
    }

    public String waitForErrorMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return this.errorMessage.getText();
    }

    public Boolean getErrorMessage() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public void clickLoginBtn(){
        this.loginBtn.click();
    }

    public void waitForSuccessfulRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));
    }

}



