package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // locators
    private static final String CARD_HEADER = "#content > div > div > div.card-header > h3";
    private static final String EMAIL_FIELD = "spree_user_email";
    private static final String PASSWORD_FIELD = "spree_user_password";
    private static final String LOGIN_BUTTON = "commit";

    //method
    public String getCardHeaderText(){
        WebElement header = this.driver.findElement(By.cssSelector(CARD_HEADER));
        return header.getText();
    }

    public void setEmailField(String emailAddress){
        this.driver.findElement(By.id(EMAIL_FIELD)).sendKeys(emailAddress);
    }

    public void setPasswordField(String password){
        this.driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(password);
    }

    public void clickOnLoginButton(){
        this.driver.findElement(By.name(LOGIN_BUTTON)).click();
    }

    public void login(String email, String password){
        setEmailField(email);
        setPasswordField(password);
        clickOnLoginButton();
    }
}
