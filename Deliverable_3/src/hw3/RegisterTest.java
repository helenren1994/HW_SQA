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

public class RegisterTest {
	
	static WebDriver driver = new FirefoxDriver();
	public static String baseUrl= "http://store.demoqa.com/tools-qa/?action=register";

	@Before
	public void setUp() {
		driver.get(baseUrl);
	}

	@After
	public void close() {
		driver.quit();
	}
	
	// User story 1:
	// As a user
	// If I want to purchase products on this website
	// I have to register first
	
	// Given that I am on the register page
	// I leave the "username" field blank and click "Register" button
	// Then I should get the error "Please enter a username"
	@Test
	public void blankUsernameTest() {
		
		driver.findElement(By.id("user_email")).sendKeys("hello@world.com");
		
		driver.findElement(By.id("wp-submit")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]/weak"));
		assertEquals("ERROR: Please enter a username.", errorMessage.getText());
		
	}
	
	// Given that I am on the register page
	// I enter an invalid email address and click "Register" button
	// Then I should get the error "The email address isn¡¯t correct."
	@Test
	public void wrongEmailTest() {

		driver.findElement(By.id("user_login")).sendKeys("rzx1994");
		driver.findElement(By.id("user_email")).sendKeys("helloworld");

		driver.findElement(By.id("wp-submit")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]/weak"));
		assertEquals("ERROR: The email address isn¡¯t correct.", errorMessage.getText());
	
	}
	
	// Given that I am on the register page
	// I enter a already used username and click "Register" button
	// Then I should get the error "This username is already registered. Please choose another one."
	@Test
	public void usedUsernameTest() {
		
		driver.findElement(By.id("user_login")).sendKeys("rzx1994");
		driver.findElement(By.id("user_email")).sendKeys("hello@world.com");
		
		driver.findElement(By.id("wp-submit")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]/weak"));
		assertEquals("ERROR: This username is already registered. Please choose another one.", errorMessage.getText());
	}
}