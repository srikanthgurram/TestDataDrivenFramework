package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
       this.driver = driver;
    }
    //Locators
    private static final String LOGIN_BUTON_LINK = "Login";
    private static final String LOGOUT_BUTON_LINK = "Logout";
    private static final String MYACCOUNT_LINK_TEXT = "My Account";
    private static final String SEARCH_BUTTON = "#search-bar > form > input.btn.btn-success";
    private  static final String SEARCH_TEXT_FIELD = "keywords";


    // methods
    public void clickOnLoginButton(){
        WebDriverWait wait = new WebDriverWait(this.driver, 60);
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LOGIN_BUTON_LINK)));
        loginButton.click();
    }

    public void clickOnLooutButton(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LOGOUT_BUTON_LINK)));
        logoutButton.click();
    }

    public void clickOnSearchButton(){
        driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
    }

    public void searchForProduct(String searchText){
        driver.findElement(By.id(SEARCH_TEXT_FIELD)).sendKeys(searchText);
        clickOnSearchButton();
    }

    public boolean isLoggedIn(){
        WebDriverWait wait = new WebDriverWait(this.driver, 20);
        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(MYACCOUNT_LINK_TEXT)));
        return myAccount.isDisplayed();
    }

    public boolean isLoggedOut(){
        WebDriverWait wait = new WebDriverWait(this.driver, 20);
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LOGIN_BUTON_LINK)));
        return loginButton.isDisplayed();
    }
}
