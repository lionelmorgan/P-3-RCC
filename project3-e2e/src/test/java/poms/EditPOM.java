package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "productName")
    WebElement nameInput;

    @FindBy(id = "productDescription")
    WebElement descInput;

    @FindBy(id = "productPrice")
    WebElement priceInput;

    @FindBy(id = "salePrice")
    WebElement saleInput;

    @FindBy(id = "product-inventory")
    WebElement stockInput;

    @FindBy(id = "productImageInput")
    WebElement imageInput;

    @FindBy(id = "update-btn")
    WebElement updateBtn;




    public EditPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void enterProductName(String productName){
        this.nameInput.sendKeys(productName);
    }

    public void enterProductDescription(String productDescription){
        this.descInput.sendKeys(productDescription);
    }

    public void enterProductRegularPrice(String productRegularPrice){
        this.priceInput.sendKeys(productRegularPrice);
    }

    public void enterProductSalesPrice(String productSalesPrice){
        this.saleInput.sendKeys(productSalesPrice);
    }

    public void enterProductStock(String productStock){
        this.stockInput.sendKeys(productStock);
    }

    public void clickUpdateBtn(){
        this.wait.until(ExpectedConditions.visibilityOf(this.updateBtn));
        this.updateBtn.click();
    }

    public void verifyRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/product/14"));
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }
}
