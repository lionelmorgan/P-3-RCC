package poms;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPOM {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "/html/body/app-root/div/app-checkout/div[1]/div/div[5]/input")
    WebElement hideBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-checkout/div[2]/div/div/div[1]/input")
    WebElement hiddenInput;


    @FindBy(className = "cartButton")
    WebElement confirmBtn;

    @FindBy(id = "totalCost")
    WebElement checkoutTotal;

    @FindBy(tagName = "html")
    WebElement theme;





    public CheckoutPOM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);

    }


    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void clickHideBtn(){
        this.hideBtn.click();
    }

    public boolean checkIfBillingIsVisible(){
        try {
            driver.findElement(By.xpath("/html/body/app-root/div/app-checkout/div[2]/div/p"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void pageDown(){

        this.theme.click();
        driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL, Keys.END);

    }

    public boolean isTotalVisible(){
        this.wait.until(ExpectedConditions.visibilityOf(checkoutTotal));

        return true;
    }

    public void clickCheckoutBtn(){
        this.confirmBtn.click();
    }

    public String getTotal(){
        return this.checkoutTotal.getText();

    }

    public void waitForSuccessfulRedirct(){
        this.wait.until(ExpectedConditions.urlContains("http://localhost:4200/receipt/"));
    }

    public boolean isBillingVisible(){
        this.wait.until(ExpectedConditions.visibilityOf(hiddenInput));

        return true;

    }

}
