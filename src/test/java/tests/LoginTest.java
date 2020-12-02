package tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.TestDataProvider;

public class LoginTest extends BaseTest {
    HomePage homePageObj;
    LoginPage loginPageObj;

    @Test(dataProvider = "login-data", dataProviderClass = TestDataProvider.class)
    public void verifyLogin(String loginEmail, String loginPassword){
        homePageObj = new HomePage(BaseTest.driver);
        loginPageObj = new LoginPage(BaseTest.driver);
        homePageObj.clickOnLoginButton();
        loginPageObj.login(loginEmail, loginPassword);
        Assert.assertTrue(homePageObj.isLoggedIn());
        homePageObj.clickOnLooutButton();
        Assert.assertTrue(homePageObj.isLoggedOut());
    }

}
