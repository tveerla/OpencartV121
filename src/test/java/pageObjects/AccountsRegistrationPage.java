package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsRegistrationPage extends BasePage {

	
	public AccountsRegistrationPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
	 txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txtLastName.sendKeys(lname);
	}
	public void settxtEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void confirmPassword(String pwd)
	{
		txtConfirm.sendKeys(pwd);
	}
	public void checkPolicy() 
	{
		chkdPolicy.click();
	}
	public void continuebtn()
	{
		btnContinue.click();
	}
	
	public String testSendMessage()
	{
		try {
		String TextMsg=msgConfirmation.getText();
		return TextMsg;
	}catch (Exception e) {
		return (e.getMessage());
	}
}
}