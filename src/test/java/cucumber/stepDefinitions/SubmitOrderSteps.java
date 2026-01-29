package cucumber.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Automation.TestComponenets.BaseTest;
import Automation.pageobjects.CartPage;
import Automation.pageobjects.CheckOutPage;
import Automation.pageobjects.LandingPage;
import Automation.pageobjects.ProductCatalogue;
import io.cucumber.java.en.*;

public class SubmitOrderSteps extends BaseTest {

	public LandingPage landingpage;
	public 	ProductCatalogue ps;
	public CartPage cp;
	public CheckOutPage checkout;
	
	 @Given("I landed on Ecommerce Page")
	    public void i_landed_on_ecommerce_page() throws IOException  {
    	landingpage=launchApplication();
        
    }
    
    @Given("^Logged in with username (.+)  and password (.+)$")  //(,+) -->regular expression  
    public void logged_in_username_and_password(String username,String password) throws InterruptedException
    {
    	 ps=landingpage.loginApplication(username,password) ;
    }

    @When("^I add product (.+) to Cart$")
    public void add_product_to_cart(String Productname) throws InterruptedException {
    	List<WebElement> products=ps.getProductList();
		ps.addProductToCart(Productname);
    }

    @When("^CheckOut (.+) and submit the order$")
    public void check_out_and_submit_the_order(String Productname) throws InterruptedException {
	   CartPage cp=new CartPage(driver);
		cp.cartButtonClick(driver);
		Boolean match=cp.verifyProductDisplay(Productname);
		Assert.assertTrue(match);	
		cp.checkout(driver);
		CheckOutPage checkout=new CheckOutPage(driver);
		checkout.EnterFiledData("123", "Archana", "ind");
		checkout.HoldDropdownBValues();
	   
    }

   @Then ("{string} message is displayed on confirmationPage")
    public void confirmation_message(String string) {
	   String cfmessage=checkout.confirmationMessage();
		Assert.assertTrue(cfmessage.equalsIgnoreCase(string));
		driver.close();
    }
   
   
   @Then("{string} message is displayed")
   public void message_is_displayed(String string)
   {
	   Assert.assertEquals("Incorrect email or password.", landingpage.GetErrorMessage());
	   driver.close();
   }
}
	
	
	
	


