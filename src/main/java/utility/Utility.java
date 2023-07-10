package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
//commonly used method
	//screenshot
	//scrolling
	//data reading
	//wait
	 //wait
		public static void wait(int WaitTime) throws InterruptedException
		{
		  Reporter.log("Waiting time for"+WaitTime+"milli sec",true);	
			Thread.sleep(WaitTime);
		}
		//Screenshot
		public static void takeScreenShot(WebDriver driver, String fileName) throws IOException
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File dest = new File("E:\\ScreenShot\\MyScreenShot\\"+fileName+ " .png");
		    FileHandler.copy(src, dest);
		    Reporter.log("taking screenshot", true);
		    Reporter.log("Screenshot LocationIs--"+dest,true);
		}
		//Scrolling
		public static void ScrollIntoView(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)",element );
			Reporter.log("scrolling IntoView", true);
		}
		//Read Data from excelSheet
		public static String ReadDataFromExcel(int rownum,int cellnum) throws EncryptedDocumentException, IOException
		{
			FileInputStream myfile=new FileInputStream("D:\\VELOCITY ASSIGNMENT\\ExcelSheet\\My File.xlsx");
			Reporter.log("read data from excel row num is "+ rownum+"cell num is "+cellnum,true);
			String value=WorkbookFactory.create(myfile).getSheet("Sheet1").getRow(rownum).getCell(cellnum).getStringCellValue();
			return value;
		}
		public static String readDataFromPropertyFile(String Key) throws IOException
		{
			Properties prop=new Properties();
			FileInputStream myfile=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\NikSelenium\\myProperty.Properties");
			prop.load(myfile);
			String value=prop.getProperty(Key);
			Reporter.log("reading data"+Key+"from property",true);
			return value;
			
		}
	
}
