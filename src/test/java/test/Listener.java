package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.BaseStudy;
import utility.Utility;

public class Listener extends BaseStudy implements ITestListener
{
@Override
     public void onTestFailure(ITestResult result)
{
	try {
		Utility.takeScreenShot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

   @Override
	public void onTestSuccess(ITestResult result) 
   {
	   Reporter.log("tc"+result.getName()+"passed successfully", true);
		
	}
   
   @Override
	public void onTestStart(ITestResult result) 
   {
		Reporter.log("tc excution started for tc"+result.getName(),true);
	}
}
