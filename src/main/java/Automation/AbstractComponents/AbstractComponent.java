package Automation.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderheader;
	
	public OrderPage goToordersPage()
	{
		orderheader.click();
		
		OrderPage orderpage=new OrderPage(driver);
				return orderpage;
				
	}

	public void waitforElementToAppear(By findBy) {
		
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

}
	
	public void waitforWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void Jscriptdown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	public void Jscriptup(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -700)");
	}
	
	public void waitforElementtoDisappear(WebElement ele)
	{
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	
}
                                      
