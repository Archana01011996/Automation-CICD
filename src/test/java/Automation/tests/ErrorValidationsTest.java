package Automation.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import Automation.TestComponenets.BaseTest;
import Automation.TestComponenets.Retry;
import Automation.pageobjects.CartPage;
import Automation.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups={"ErrorHandling"} ,retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws InterruptedException, IOException
	{
       
     landingpage.loginApplication("archana.jan01@gmail.com", "12345@gh");

	Assert.assertEquals("Incorrect email or password.", landingpage.GetErrorMessage());

		
	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException
	{
		 String Productname="ZARA COAT 3";
			ProductCatalogue ps=landingpage.loginApplication("archana.jan01@gmail.com", "Archana@1996");
			List<WebElement> products=ps.getProductList();
			ps.addProductToCart(Productname);
			CartPage cp=new CartPage(driver);
			cp.cartButtonClick(driver);
			Boolean match=cp.verifyProductDisplay("ZARA COAT 33");
			Assert.assertFalse(match);
	}
		
		
		
		
	
	
		}

