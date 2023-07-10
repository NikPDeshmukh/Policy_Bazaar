package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.Utility;

public class BaseStudy
{
   //Driver & Browser SetUp
	static protected WebDriver driver;
	public void LaunchBrowser()
	{
		driver = new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		Reporter.log("Launchig Browser",true);
	}
	public void LaunchBrowserFromPropertyFile() throws IOException
	{
		driver=new ChromeDriver();
		driver.get(Utility.readDataFromPropertyFile("url"));
		driver.manage().window().maximize();
		Reporter.log("Launchig Browser",true);
	}
	public void CloseBrowser() throws InterruptedException
	{
		Utility.wait(1000);
		Reporter.log("Closing Browser",true);
		driver.quit();
		
	}
}
