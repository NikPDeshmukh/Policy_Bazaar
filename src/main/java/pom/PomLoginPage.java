package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PomLoginPage
{
//variable
	@FindBy(xpath = "//a[text()='Sign in']")private WebElement signbutton;
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement Mobilenofield;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]")private WebElement signinwithpassword;
	@FindBy(name="password")private WebElement passwordfield;
	@FindBy(xpath = "//span[text()='Sign in']")private WebElement loginwithsigninbutton;
	@FindBy(xpath = "//div[text()='My Account']")private WebElement createmyaccount;
	@FindBy(xpath = "//span[text()=' My profile ']")private WebElement clickonmyprofile;
	
	//constructor
	public PomLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//method
	public void ClickOnSignInButtonHomePage()
	{
		signbutton.click();
		Reporter.log("click on sign in button", true);
	}
	public void EnterMobileNo(String MobNo)
	{
		Mobilenofield.sendKeys(MobNo);
		Reporter.log("Enter mobile number", true);
	}
	public void ClickWithSignInButton()
	{
		signinwithpassword.click();
		Reporter.log("click with sign in button", true);
	}
	public void EnterPassword(String Password)
	{
		passwordfield.sendKeys(Password);
		Reporter.log("Enter password", true);
	}
	public void LogInWithSignInButtonHomePage()
	{
		loginwithsigninbutton.click();
		Reporter.log("login with sign in button home page", true);
	}
	public void MyAccount()
	{
		createmyaccount.click();
		Reporter.log("my account page ", true);
	}
	public void MyProfile()
	{
		clickonmyprofile.click();
		Reporter.log("my profile page", true);
	}
}
