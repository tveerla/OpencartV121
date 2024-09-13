package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException 
	{
		logger= LogManager.getLogger(this.getClass());
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		switch(br.toLowerCase())
		{
			case "chrome":  driver=new ChromeDriver();break;
			case "edge" : driver=new EdgeDriver();break;
			case "firefox": driver= new FirefoxDriver();break;
			default : System.out.println("Invalid Browser"); return;
			
		}
		
		
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	 
	public String RandomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	public String RandomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String RandomAlphaNumber()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		return generatedstring+"@"+generatedNumber;
	}
	
}
