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

public class EditTest {
	
	static WebDriver driver = new FirefoxDriver();
	public static String baseUrl = "http://store.demoqa.com/";
	public static String product = "http://store.demoqa.com/products-page/product-category/magic-mouse/";
	public static String checkoutPage = "http://store.demoqa.com/products-page/checkout/";

	@Before
	public void setUp() {
		driver.get(baseUrl);
	}

	@After
	public void close() {
		driver.quit();
	}
	
	// User story 3:
    // As a user
    // I need to edit products in the shopping cart
	
	// Given that I am on the website
	// I want to add an item to my empty cart
	// After adding, I should have exactly 1 item in my cart
	@Test
    public void addItemTest() {

        driver.get(product);
        driver.findElement(By.className("wpsc_buy_button")).click();

        WebDriverWait newwait = new WebDriverWait(driver,5);
        WebElement itemCnt = driver.findElement(By.xpath("//div[@id='header_cart']/a/em[@class='count']"));
        assertEquals("1",itemCnt.getText());
    }
	
	// Given that I have 1 item in my cart
	// I want to change the quantity of this item to 2
	// After updating, I should have exactly 2 item in my cart.
	public void updateTest() {

        driver.get(product);
        driver.findElement(By.className("wpsc_buy_button")).click();

        driver.get(checkoutPage);
        
        WebElement itemQuant = driver.findElement(By.xpath("//td[@class='wpsc_product_quantity wpsc_product_quantity_0']/form/input[@type='text']"));

        itemQuant.clear();
        itemQuant.sendKeys("2");
        itemQuant.submit();

        WebDriverWait newwait = new WebDriverWait(driver,5);
        WebElement itemCnt = driver.findElement(By.xpath("//td[@class='wpsc_product_quantity wpsc_product_quantity_0']/form/input[@type='text']"));
        assertEquals("2",itemCnt.getAttribute("value"));

    }
	
	// Given that I have 1 item in my cart
	// I want to remove the item
	// After removing, I should have exactly 0 item in my cart
	public void addItemTest() {

        driver.get(product);
        driver.findElement(By.className("wpsc_buy_button")).click();
        
        driver.get(checkoutPage);
        driver.findElement(By.xpath("//td[@class='wpsc_product_remove wpsc_product_remove_0']/form/input[@type='submit']")).submit();

        WebDriverWait newwait = new WebDriverWait(driver,5);
        WebElement itemCnt = driver.findElement(By.xpath("//div[@id='header_cart']/a/em[@class='count']"));
        assertEquals("0",itemCnt.getText());
    }
}
