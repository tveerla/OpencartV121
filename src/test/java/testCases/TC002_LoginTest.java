package testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test
	public void verify_login(){
		try {
	
		logger.info("**********Starting TC002_LoginTest**********");
	
	
      HomePage hp=new HomePage(driver);
      hp.clickMyAccount();
      hp.clickLogin();
      LoginPage lp=new LoginPage(driver);
      lp.setEmail(p.getProperty("email"));
      
      lp.setPwd(p.getProperty("pwd"));
      lp.clickLogin();
      
      MyAccountsPage macc=new MyAccountsPage(driver);
      boolean targetPage= macc.isMyAccountPageExists();
      Assert.assertTrue(targetPage);
    		  
      
	}catch(Exception e)
		{
		Assert.fail();
		}
	}
	
	
	
	
 
	
			

}
