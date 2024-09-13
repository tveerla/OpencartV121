package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccountsRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test
	public void verify_account_registration()
	{
		logger.info("****Starting Testing*************");
		try{
		HomePage hp=new HomePage(driver);
		logger.info("****Starting clicking on My account*************");
		hp.clickMyAccount();
		logger.info("****Startingclicking on Register*************");
		hp.clickRegister();
		AccountsRegistrationPage Ap =new AccountsRegistrationPage(driver);
		Ap.setFirstName(RandomString().toUpperCase());
		Ap.setLastName(RandomString().toUpperCase());
		Ap.settxtEmail(RandomString().toLowerCase()+"@gmail.com");
		Ap.setTelephone(RandomNumber());
		String pwd=RandomAlphaNumber();
		Ap.setPassword(pwd);
		Ap.confirmPassword(pwd);
		Ap.checkPolicy();
		Ap.continuebtn();
		String confrmsg=Ap.testSendMessage();
		Assert.assertEquals(confrmsg, "Your Account Has Been Created!");
		}catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
	}
	     
		
	}

