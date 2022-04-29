package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NTCreateAccount {
	public static void main(String[] args) throws InterruptedException {

		// Driver Setup
		WebDriverManager.chromedriver().setup();

		// Open a Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Maximize the window
		driver.manage().window().maximize();

		// Find the Web element for Username(by id)
		WebElement findElement = driver.findElement(By.id("username"));

		// Enter value in the field username
		findElement.sendKeys("Demosalesmanager");

		// Find the Web element for Password(by name) and enter the value using
		// .sendKeys without storing the element to a variable
		// This is easier
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");

		// Find Web element for Login(by class) and click the button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Find the Web element using tagname and get the text
		System.out.println(driver.findElement(By.tagName("h2")).getText());

		// Find the Web element CRM/SFA(by linkText) and click on the same
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Find web element Accounts and click on the same
		driver.findElement(By.linkText("Accounts")).click();

		// Find the Web element Create Accounts and click on the same
		driver.findElement(By.partialLinkText("Create")).click();

		// Select preferred currency as Indian Rupee using SelectByValue
		Select currency = new Select(driver.findElement(By.id("currencyUomId")));
		currency.selectByValue("INR");

		// Enter the Description text as "NRI Account"
		driver.findElement(By.xpath("(//textarea[@class = 'inputBox'])[1]")).sendKeys("NRI Account");

		// Enter LocalName Field Using Xpath Locator
		WebElement Element1 = driver.findElement(By.xpath("//input[@id= 'groupNameLocal']"));
		Element1.sendKeys("Localname");

		// Enter SiteName Field Using Xpath Locator
		driver.findElement(By.xpath("//input[@id= 'officeSiteName']")).sendKeys("Chennai");

		// Enter value for AnnualRevenue Field using Xpath Locator but class as
		// attribute
		driver.findElement(By.xpath("(//input[@class= 'inputBox'])[5]")).sendKeys("500000");

		// Click on Create Account using Xpath Locator
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(5000);

		// Get the Text of Error Message Displayed (hint: Red Texts)
		System.out.println("Error Message: " + driver.findElement(By.xpath("//li[@class= 'errorMessage']")).getText());
		Thread.sleep(2000);
		driver.close();

	}
}
