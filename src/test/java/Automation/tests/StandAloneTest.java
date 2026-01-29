package Automation.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class StandAloneTest {
//comments to check cicd working
	public static void main(String[] args) throws InterruptedException {
       String Productname="ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/#/dashboard/dash");
		driver.findElement(By.xpath("//Input[@type='email']")).sendKeys("rahulshettyacademy.com");
		driver.findElement(By.xpath("//Input[@type='password']")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(Productname))
				.findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		js.executeScript("window.scrollBy(0, -500)");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		// WebElement cartBtn =
		// driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
		// js.executeScript("arguments[0].click();", cartBtn);
		By cartbutton = By.xpath("//button[@routerlink='/dashboard/cart']");
		wait.until(ExpectedConditions.elementToBeClickable(cartbutton));
		driver.findElement(cartbutton).click();
		Thread.sleep(3000);
		List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(Productname));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='field small']/div/following-sibling::input[1]")).sendKeys("123");
	WebElement nameoncard=	driver.findElement(By.xpath("//div[text()='Name on Card ']"));
		driver.findElement(with(By.tagName("input")).below(nameoncard)).sendKeys("Archana");
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("IND");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		List<WebElement> options=driver.findElements(By.cssSelector(".ta-item.list-group-item"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
			option.click();
			break;
			}
			
		}
		
		driver.findElement(By.cssSelector(".btnn.action__submit")).click();
		Thread.sleep(3000);
		String Confirmmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(Confirmmessage.equalsIgnoreCase("Thankyou for the order."));
		
	
	}
}
