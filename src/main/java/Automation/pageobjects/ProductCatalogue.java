package Automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement Email=driver.findElement(By.xpath("//Input[@type='email']"));
//	WebElement Password=driver.findElement(By.xpath("//Input[@type='password']"));
	
	//PageFactory
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	@FindBy(xpath=".ng-animating")
	WebElement Spinner;
	
	
	By prodcutsBy=By.cssSelector(".col-lg-4");
	By addToCartBy=By.cssSelector(".card-body button:last-of-type");
	By Toastmessage=By.cssSelector("#toast-container");
	//Action method
public List<WebElement> getProductList()
{
	waitforElementToAppear(prodcutsBy);
	return products;
	
	
}

public WebElement getProductName(String Productname)
{
	WebElement prod = getProductList().stream()
			.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(Productname))
			.findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
	return prod;
}
public void addProductToCart(String Productname) throws InterruptedException
{
	Jscriptdown(driver);
	WebElement prod=getProductName(Productname);
	prod.findElement(addToCartBy).click();
	waitforElementToAppear(Toastmessage);
	Jscriptup(driver);
	Thread.sleep(3000);
}
	
	
	
	
	
	
	
	

}
