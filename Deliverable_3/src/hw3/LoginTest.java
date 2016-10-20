package hw3;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

public class LoginTest {
	static WebDriver driver = new FirefoxDriver();
	public static String baseUrl = "http://store.demoqa.com/products-page/your-account/";

	@Before
	public void setUp() {
		driver.get(baseUrl);
	}

	@After
	public void close() {
		driver.quit();
	}
	
	// User story 2:
	// As a user
	// I need to log in to my account
	// To buy products

	// Given that I am on the log in page
	// I leave "Username" and "Passport" fields blank and click "Register" button
	// Then I should get the error "Please enter your username and password."
	@Test
	public void blankFieldsTest() {
		
		driver.findElement(By.id("login")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement errorMessage = driver.findElement(By.xpath("//*[@id='ajax_loginform']/p[1]/strong[1]"));

		assertEquals("ERROR", errorMessage.getText());

	}

	// Given that I am on the log in page
	// I enter correct username and passport
	// Then I should log in successfully
	@Test
	public void correctTest() {
		
	    driver.findElement(By.id("log")).sendKeys("rzx1994");
	    driver.findElement(By.id("pwd")).sendKeys("19940422");
	    
	    driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Given that I am on the log in page
	// I enter wrong username and passport
	// Then I should get the error "Invalid login credentials."
	@Test
	public void wrongTest {
		
		driver.findElement(By.id("log")).sendKeys("helloworld");
	    driver.findElement(By.id("pwd")).sendKeys("lhy1222");
	    
	    driver.findElement(By.id("login")).click();
		
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id='ajax_loginform']/p[1]/strong[1]"));
		assertEquals("ERROR: Invalid login credentials.", errorMessage.getText());
		
	}
}