package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "quantityInput")
    WebElement quantitySelect;

    @FindBy(tagName = "button")
    WebElement addToCartBtn;

    @FindBy(id = "cartMessage")
    WebElement cartMsg;

    @FindBy(xpath = "/html/body/app-root/div/app-product-page/div/div[2]/p[3]")
    WebElement maxStock;

    @FindBy(id = "ContShopBtn")
    WebElement continueShoppingBtn;

    @FindBy(linkText = "Revature Courseware Cornucopia")
    WebElement titleLink;

    @FindBy(id = "edit-btn")
    WebElement editBtn;

    @FindBy(id = "cart-btn")
    WebElement cartHeaderBtn;

    public ProductPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public String getCartAmount(){
        List<WebElement> pTags = this.cartHeaderBtn.findElements(By.tagName("p"));
        return pTags.get(1).getText();
    }

    public String getBtnText(){
        return this.addToCartBtn.getText();
    }

    public String getQuantity(){
        return this.quantitySelect.getAttribute("ng-reflect-model");
    }

    public void incQuantity(){
        this.quantitySelect.sendKeys(Keys.ARROW_UP);
    }

    public void clickAddToCart(){
        this.addToCartBtn.click();
    }

    public void clickGoToCart(){
        this.addToCartBtn.click();
    }

    public String getMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.cartMsg));
        return this.cartMsg.getText();
    }

    public void waitForSuccessfulCartRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/cart"));
    }

    public void waitForSuccessfulLoginRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));
    }


    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public String getErrorMessage() {
        this.wait.until(ExpectedConditions.alertIsPresent());
        String error = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return error;

    }

    public void inputQuantity(String input){
        this.quantitySelect.sendKeys(input);
    }

    public String getMaxStock(){
      return  this.maxStock.getText().substring(10);
    }

    /*public String getCurrentInput(){
        return  this.quantitySelect.getAttribute("ng-reflect-model");
    }*/

    public void clickContinueShoppingBtn(){
        this.wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn));
        this.continueShoppingBtn.click();
    }

    public void waitForSuccessfulRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/"));
    }

    public void clickTitleLink(){this.titleLink.click();}

    public void verifyMainRedirect(){this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/"));}

    public void clickEditBtn(){
        this.wait.until(ExpectedConditions.visibilityOf(editBtn));
        this.editBtn.click();
    }

    public void verifyEditRedirect(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/admin/14"));
    }

}
