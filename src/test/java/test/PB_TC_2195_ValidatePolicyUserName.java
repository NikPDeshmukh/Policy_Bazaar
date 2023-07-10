package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseStudy;
import pom.MyAccountPage;
import pom.PomLoginPage;
import utility.Utility;

public class PB_TC_2195_ValidatePolicyUserName extends BaseStudy
{    
     PomLoginPage login;
     MyAccountPage myAcc;
     String TCID="PB_TC2190";
    
     
     
	@BeforeClass
	public void launchBrowser() throws InterruptedException, IOException
	{
		Utility.wait(1000);
		LaunchBrowserFromPropertyFile();
		
		login=new PomLoginPage(driver);
		myAcc=new MyAccountPage(driver);
	}
	
	@BeforeMethod
	public void signintoPolicyBazaar() throws EncryptedDocumentException, IOException, InterruptedException
	{
	   	Utility.wait(1000);
		login.ClickOnSignInButtonHomePage();
		  	Utility.wait(1000);
		login.EnterMobileNo(Utility.readDataFromPropertyFile("mobNum"));
		  	Utility.wait(1000);
		login.ClickWithSignInButton();
		  	Utility.wait(1000);
	    login.EnterPassword(Utility.readDataFromPropertyFile("pwd"));
	         Utility.wait(1000);
	    login.LogInWithSignInButtonHomePage();
		  	Utility.wait(1000);
		login.MyAccount();
		  	Utility.wait(1000);
		login.MyProfile();
		  	Utility.wait(1000);
		  	
		Set<String> allWindowID = driver.getWindowHandles();
		List<String>id=new ArrayList<>(allWindowID);
		//SWITCHING FOCUS TO CHILD PAGE
		driver.switchTo().window(id.get(1));
		Reporter.log("Switching to child pge id",true);
		  	Utility.wait(1000);
		
	}
  @Test
  public void ValidateUserName() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  String expUN=Utility.readDataFromPropertyFile("UN");
	  String actualUN = myAcc.getActualUserName();
	  Utility.wait(1000);
	  Assert.assertEquals(actualUN, expUN,"TC FAILED EXP & ACT UN NOT MATCH");
	  
  }
  @AfterMethod
  public void logOutFromPolicyBazaar() throws InterruptedException
  {
        	Utility.wait(1000);
	  myAcc.clickOnLogOutButton();
  }
  @AfterClass
  public void closeBrowser()
  {
	 driver.quit(); 
  }
}
