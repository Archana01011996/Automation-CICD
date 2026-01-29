package Automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//@FindBy(css="tr td:nth-child(3)")
//	private List<WebElement> Productsnames;
	
	@FindBy(xpath="//tr//td[1]/following-sibling::td[1]")
	private List<WebElement> Productsnames;
	
	By productslist=By.xpath("//tr//td[1]/following-sibling::td[1]");
	
	public Boolean VerifyOrderDisplay(String Productname)
	{
		waitforElementToAppear(productslist);
		Boolean match=Productsnames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(Productname));
		return match;
	}
	
	

}
