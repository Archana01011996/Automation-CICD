package Automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="//div[@class='field small']/div/following-sibling::input[1]")
	WebElement CVV;
	
	@FindBy(xpath="(//div[@class='field'] //input[@type='text'])[2]")
	WebElement Nameoncard;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement Selectedcountry;
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeorder;
	
	@FindBy(css=".hero-primary")
	WebElement confirmationmessage;
	
	By results= By.cssSelector(".ta-results");
	
	
	public void EnterFiledData(String cvv,String name,String country) throws InterruptedException
	{
		CVV.sendKeys(cvv);
		Nameoncard.sendKeys(name);
		Country.sendKeys(country);
		Thread.sleep(5000);
		
	}
	
	public void HoldDropdownBValues() throws InterruptedException
	{
		waitforElementToAppear(results);
		Selectedcountry.click();
			placeorder.click();
			Thread.sleep(3000);
		}
	
		
		public String confirmationMessage()
		{
			String Cfmsg=confirmationmessage.getText();
			return Cfmsg;
			
		}
		
		
		
      }
	
	

