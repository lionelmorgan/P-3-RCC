package poms;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-form-btn")
    WebElement loginBtn;

    @FindBy(id = "register-form-btn")
    WebElement registerBtn;

    @FindBy(id = "errorMessage")
    WebElement errMessage;

    @FindBy(id = "new-product")
    WebElement newProductBtn;

    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void enterUsername(String username){
        this.usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void submitLogin(){
        this.loginBtn.click();
    }

    public void waitForSuccessfulLogin(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/"));
    }

    public void waitForSuccessfulRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/register"));
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }


    public Boolean isErrMessageVisible(){
        this.wait.until(ExpectedConditions.visibilityOf(errMessage));
        return true;
    }

    public void clickRegisterBtn() {
        this.registerBtn.click();
    }

    public Boolean waitForBtn(){
        try {
            this.wait.until(ExpectedConditions.visibilityOf(newProductBtn));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }
}
