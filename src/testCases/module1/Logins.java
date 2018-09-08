package testCases.module1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import testCases.TestBase;
import framework.helpers.Elements;
import framework.helpers.VerifyAsserts;


@Listeners({framework.providers.WebDriverListener.class})
public class Logins extends TestBase{
	
	@Test
	public void validLogin(){
		LoginPage.loginSuplierUser();			
		VerifyAsserts.verifyTrue(Elements.getCurrentURL().endsWith("/home"));
	}
	
	@Test
	public void invalidLogin(){
		String message = LoginPage.loginWithInvalidUserNamePassword();
		VerifyAsserts.verifyEquals(message, "Sign In Failed!. Please try again.");
	}
	
	@Test
	public void loginPublisherUser(){		
		LoginPage.loginSuplierUser();		
		VerifyAsserts.verifyEquals(LoginPage.getHeaderText(), "Master Data Services - Publisher");
				
	}
	
	
	@Test
	public void loginPublisherUser1(){
		LoginPage.loginNonGDSNUser();		
		VerifyAsserts.verifyEquals(LoginPage.getHeaderText(), "Master Data Services - Subscriber");
	}
	
	@Test
	public void loginComboUser(){
		LoginPage.loginComboUser();		
		VerifyAsserts.verifyEquals(LoginPage.getHeaderText(), "Master Data Services");
	}

}
