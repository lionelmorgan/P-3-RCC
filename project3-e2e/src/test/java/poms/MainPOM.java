package poms;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class MainPOM {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(id = "register-btn")
    WebElement registerBtn;

    @FindBy(id = "login-btn")
    WebElement loginBtn;

    @FindBy(id = "searchInput")
    WebElement searchInput;

    @FindBy(id = "searchButton")
    WebElement searchBtn;

    @FindBy(id = "cart-btn")
    WebElement cartBtn;

    @FindBy(id = "products")
    WebElement productsContainer;

    @FindBy(tagName = "a")
    List<WebElement> anchors;

    @FindBy(tagName = "html")
    WebElement theme;

    @FindBy(className = "oldPrice")
    List<WebElement> oldPrice;

    @FindBy(className = "saleRibbon")
    List<WebElement> saleRibbon;

    @FindBy(id = "new-product")
    WebElement newProductBtn;

    @FindBy(className = "outOfStockMessage")
    WebElement outOfStock;

    @FindBy(id = "anything")
    WebElement anything;

    @FindBy(className = "largeGap")
    WebElement name;

    @FindBy(id = "logout-btn")
    WebElement logoutBtn;


    public MainPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.js = (JavascriptExecutor) driver;


        PageFactory.initElements(this.driver, this);
    }

    public void waitForSales() {
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("oldPrice"), 0));
    }

    public Boolean checkSales() {
        if (this.saleRibbon.isEmpty() && this.oldPrice.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void clickDarkModeBtn() {
        this.anchors.get(4).click();
    }

    public String checkThemeColor() {
        if (this.theme.getAttribute("style").contains("4:black")) {
            return "white";
        } else {
            return "black";
        }
    }

    public String checkProductTitle() {
        List<WebElement> titleList = this.productsContainer.findElements(By.className("mediumFont"));
        return titleList.get(0).getText();
    }

    public String checkProductDescription() {
        List<WebElement> descriptionList = this.productsContainer.findElements(By.className("productDescription"));
        return descriptionList.get(0).getText();
    }

    public boolean checkSearch(String search, String productTitle, String productDescription) {
        return productTitle.toLowerCase().contains(search.toLowerCase()) || productDescription.toLowerCase().contains(search.toLowerCase());
    }

    public void clickRegisterBtn() {
        this.registerBtn.click();
    }

    public void clickLoginBtn() {
        this.loginBtn.click();
    }

    public void search(String searchInput) {
        List<WebElement> productList = this.productsContainer.findElements(By.className("product"));
        this.searchInput.sendKeys(searchInput);
        this.searchBtn.click();


        this.wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.className("products"), productList.size()));
    }

    public void clickProduct() {

        List<WebElement> productList = this.productsContainer.findElements(By.className("product"));
        productList.get(1).click();

    }

    public String getId() {
        List<WebElement> productList = this.productsContainer.findElements(By.className("product"));
        return productList.get(1).getAttribute("id").split("#")[1];
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void verifyRegisterRedirect() {
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/register"));
    }

    public void verifyLoginRedirect() {
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));
    }

    public void verifyCartRedirect() {
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/cart"));
    }

    public void verifyProductRedirect(String id) {
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/product/" + id));
    }

    public void clickCartBtn() {
        this.cartBtn.click();
    }

    public void clickNewProductButton() {
        this.newProductBtn.click();
    }

    public void verifyAdminRedirect() {
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/admin-new-product"));
    }

    public void waitForLoad() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(anything));
        } catch (TimeoutException e) {
            String error = "";
        }
    }

    public void scrollToBottom() {
        this.searchBtn.click();
        driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public Integer getProductsSize() {
        List<WebElement> productList = this.productsContainer.findElements(By.className("product"));
        return productList.size();
    }

    public Boolean checkIncreasedProducts(Integer size) {
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("product"), size));
        List<WebElement> productList = this.productsContainer.findElements(By.className("product"));
        return productList.size() > size;
    }

    public Boolean checkOutOfStock() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(outOfStock));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean checkName() {
        if (this.name.isDisplayed()) {
            return true;
        } else {
            return false;
        }


    }

    public void clickLogoutBtn() {
        this.logoutBtn.click();
    }

    public Boolean checkCartAndLogoutBtn() {
        if (this.cartBtn.isDisplayed() && this.logoutBtn.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkRegisterAndLoginBtn(){
        if(this.registerBtn.isDisplayed() && this.loginBtn.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

}