package Automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	By cartbutton = By.xpath("//button[@routerlink='/dashboard/cart']");
	                
	
	public void cartButtonClick(WebDriver driver) throws InterruptedException
	{
		driver.findElement(cartbutton).click();
		Thread.sleep(3000);
	}
	
	public Boolean verifyProductDisplay(String Productname)
	{
		Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(Productname));
	    return match;
	    
	}
	
	public void checkout(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		checkout.click();
	}

}
