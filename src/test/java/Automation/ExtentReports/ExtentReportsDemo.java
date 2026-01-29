package Automation.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	ExtentReports extent;
	
	@BeforeTest
	
	public void ExtentReportconfiguration()
	{
		//ExtentReports ,ExtentSparkReporter
		String path=System.getProperty("user.dir") + "//reports// index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//ExtentSparkReporter will help in setting required configurations  and will finally report to main class Extent Report by providing its object
		extent =new ExtentReports();  //this object is respondible to drive all execution results
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Archana");
		
		
		
		
		}
	
	
	
	
	
	@Test
	public void initialDemo()
	{
		//how test case is attached tp main class variable(extentreport)
		
	ExtentTest test	=extent.createTest("initialDemo");
		//this test object is responsible for listening and reporting all the happenings in extent report
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		driver.getTitle();
		extent.flush(); //notify test is done
	//	test.fail("results do not match");
		
		
	}
	
}
