package Automation.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.TestComponenets.BaseTest;
import Automation.TestComponenets.Retry;
import Automation.pageobjects.CartPage;
import Automation.pageobjects.CheckOutPage;
import Automation.pageobjects.LandingPage;
import Automation.pageobjects.OrderPage;
import Automation.pageobjects.ProductCatalogue;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class SubmitOrderTest extends BaseTest {
	String Productname="ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
//	public void submitorder(String email,String password,String Productname) throws InterruptedException, IOException
	public void submitorder(HashMap<String,String> input) throws InterruptedException, IOException
	{
       
		ProductCatalogue ps=landingpage.loginApplication(input.get("email"),input.get("password") );
		List<WebElement> products=ps.getProductList();
		ps.addProductToCart(input.get("product"));
		CartPage cp=new CartPage(driver);
		cp.cartButtonClick(driver);
		Boolean match=cp.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);	
		cp.checkout(driver);
		CheckOutPage checkout=new CheckOutPage(driver);
		checkout.EnterFiledData("123", "Archana", "ind");
		checkout.HoldDropdownBValues();
		String cfmessage=checkout.confirmationMessage();
		Assert.assertTrue(cfmessage.equalsIgnoreCase("Thankyou for the order."));
	
	}
	
	@Test(dependsOnMethods= {"submitorder"},retryAnalyzer=Retry.class)
	
	public void orderHistoryTest() throws InterruptedException 
	
	{
		ProductCatalogue ps=landingpage.loginApplication("archana.jan01@gmail.com", "Archana@1996");
		OrderPage orderspage=ps.goToordersPage();
		Assert.assertTrue(orderspage.VerifyOrderDisplay(Productname));
	}
		
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "archana.jan01@gmail.com");
//		map.put("password", "Archana@1996");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "archana.rprasad19@gmail.com");
//		map1.put("password", "Archana@1996");
//		map1.put("product", "iphone 13 pro");
		
		List<HashMap<String,String>>  data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Automation\\data\\PurchaseOrder.json");
//		
	return new Object[][] { {data.get(0)} ,{data.get(1)} };  //data.get(0)-retrives firsthashmap all data  
		
	}
		
		
	
	
	

//	@DataProvider
//	public Object[][] getData()
	//{
	//	return new Object[][] { {"archana.jan01@gmail.com", "Archana@1996","ZARA COAT 3"} ,{"archana.rprasad19@gmail.com", "Archana@1996" ,"iphone 13 pro"} };
	//}
		
	
	
		}

