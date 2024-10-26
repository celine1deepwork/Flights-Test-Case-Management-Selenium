package case1.com.enuygundemo.tests.login;
import org.junit.Assert;
import org.junit.Test;

import com.enuygundemo.pages.LoginPage;

import case1.com.enuygundemo.base.BaseTest;

public class LoginTest extends BaseTest {
	LoginPage loginPage = new LoginPage();
	
@Test
public void testLoginErrorMessage() {
	
	loginPage.setMail("standard_user@gmail.com");
	loginPage.setPassword("iamwrongpassword123");
	loginPage.clickLoginButton();
	String actualResult = loginPage.getErrorMessage();
	 Assert.assertTrue(actualResult.contains("yeniden deneyin"));
}

}
