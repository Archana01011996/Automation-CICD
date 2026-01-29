package Automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization -settingup driver scope to local
		this.driver=driver;
		//to know which driver we use we need to call pageFactory method
		PageFactory.initElements(driver, this);
		
	}
	
//	WebElement Email=driver.findElement(By.xpath("//Input[@type='email']"));
//	WebElement Password=driver.findElement(By.xpath("//Input[@type='password']"));
	
	//PageFactory
	
	@FindBy(xpath="//Input[@type='email']")
	WebElement Email;
	
	@FindBy(xpath="//Input[@type='password']")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Submit;
	
	
	
	//@FindBy(css="[class*='toast-error']")
	//WebElement Errormessage;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement Errormessage;
			
			
	//Action method
	public ProductCatalogue loginApplication(String email,String password) throws InterruptedException
	{
		Email.sendKeys(email);
		Password.sendKeys(password);
		Submit.click();
		//Thread.sleep(3000);
		//if we are sure by clicking on submit we are going to next page then we can call that page here only
		ProductCatalogue ps=new ProductCatalogue(driver);
		return ps;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/#/dashboard/dash");
	}
	
	public String GetErrorMessage()
	{
		waitforWebElementToAppear(Errormessage);
		 return Errormessage.getText();
		 
	}
	
	
	
	
	
	
	
	

}
