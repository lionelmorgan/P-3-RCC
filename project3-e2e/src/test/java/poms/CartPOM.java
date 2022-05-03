package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPOM {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "quantityInput")
    WebElement quantityInput;

    @FindBy(linkText = "\uD83D\uDDD1️")
    WebElement trashCanIcon;

    @FindBy(id = "cartItems")
    WebElement cartItems;

    @FindBy(className = "cartButton")
    WebElement checkoutBtn;

    @FindBy(id = "cartTotals")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "/html/body/app-root/div/app-cart/div/div[2]/div[3]/p[2]")
    WebElement cartTotal;

    @FindBy(xpath = "/html/body/app-root/div/app-cart/div/div[1]/app-cart-item/div/div[1]/div[2]/div/p[1]")
    WebElement productPrice;

//    /html/body/app-root/div/app-cart/div/div[1]/app-cart-item/div/div[2]/a

    public CartPOM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);

    }

    public String getQuantity(){
        return this.quantityInput.getAttribute("ng-reflect-model");
    }

    public void incQuantity(){
        this.quantityInput.sendKeys(Keys.ARROW_UP);
    }



    public boolean checkTotal(){
        String priceString = this.productPrice.getText();
        String totalString = this.cartTotal.getText();
        String quantityString = this.quantityInput.getAttribute("ng-reflect-model");
        Double price = Double.parseDouble(priceString.substring(1));
        Double total = Double.parseDouble(totalString.substring(1));
        Double quantity =  Double.parseDouble(quantityString);

        return price * quantity == total;
    }


    public void deleteItem(){
        this.wait.until(ExpectedConditions.visibilityOf(this.cartItems.findElement(By.tagName("a"))));
        List<WebElement> trashCans =  this.cartItems.findElements(By.tagName("a"));
        trashCans.get(0).click();
        this.wait.until(ExpectedConditions.invisibilityOf(trashCans.get(0)));
    }

    public Integer getCartSize(){
        List<WebElement> items = this.cartItems.findElements(By.className("cartItem"));
        return items.size();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void clickCheckoutBtn(){
        this.checkoutBtn.click();
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/checkout"));
    }

    public void clickContinueShopping(){
        this.continueShoppingBtn.findElement(By.className("foregroundElement")).click();
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/"));
    }

    public void decQuantity(){
        this.quantityInput.sendKeys(Keys.ARROW_DOWN);
    }

    public void insertLetterQuantity(){
        this.quantityInput.sendKeys("a");
    }









}
