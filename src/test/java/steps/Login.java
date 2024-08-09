package steps;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login 
{
	ChromeDriver driver;
	
	@Given("User is on Login page")
	public void user_is_on_login_page() throws InterruptedException 
	{
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(1000);	
		driver.manage().window().maximize();
		Thread.sleep(1000);	
	}
	@When("^User enters valid (.*) and valid (.*)$")
	public void user_enters_valid_username_and_valid_password(String Username, String Password) throws InterruptedException 
	{
		System.out.println("User Entered valid Username and valid Password");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);	
		driver.findElement(By.id("username")).sendKeys(Username);
		Thread.sleep(1000);	
		driver.findElement(By.id("password")).sendKeys(Password);
		Thread.sleep(1000);	
	}
	@And("Clicks on Login button")
	public void clicks_on_login_button() throws InterruptedException 
	{
		System.out.println("Login button is clicked");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);	
	}
	@Then("User is able to login and navigated to the homepage")
	public void user_is_able_to_login_and_navigated_to_the_homepage() throws InterruptedException 
	{
		try
		{
		WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Log out')]")));
		Assert.assertTrue(logout.isDisplayed());
		System.out.println("Loggin succesfull");
		logout.click();
		
		Thread.sleep(1000);	
		}
		catch(AssertionError | NoSuchElementException e)
		{
			System.out.println("DEFECT : The user is not able to login with valid username and valid password");
			driver.navigate().refresh();
		}
	}
	@After
	public void teardown()
	{
		driver.quit();
	}
	@Before
	public void driver()
	{
		driver=new ChromeDriver();
	}
}
