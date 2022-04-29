package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {
	public static void main(String[] args) {
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
		driver.findElement(By.tagName("h2")).getText();

		// Find the Web element CRM/SFA(by linkText) and click on the same
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Find web element Accounts and click on the same
		driver.findElement(By.linkText("Accounts")).click();

		// Find the Web element Create Accounts and click on the same
		driver.findElement(By.partialLinkText("Create")).click();

		// Enter AccountName Field Using Xpath Locator value as Debit Limited Account
		driver.findElement(By.xpath("//input[@id = 'accountName']")).sendKeys("Debit Limited Account");

		// Enter Descriptiion as "Selenium Automation Tester"
		driver.findElement(By.xpath("//textarea[@name = 'description']")).sendKeys("Selenium Automation Tester");

		// Enter LocalName Field Using Xpath Locator
		driver.findElement(By.xpath("//input[@name = 'groupNameLocal']")).sendKeys("Local Name");

		// Enter SiteName Field Using Xpath Locator
		driver.findElement(By.xpath("//input[@name = 'officeSiteName']")).sendKeys("Chennai");

		// Enter value for AnnualRevenue Field using Xpath Locator but class as
		// Attribute
		driver.findElement(By.xpath("(//input[@class= 'inputBox'])[5]")).sendKeys("100000");

		// Click on Create Account Button
		driver.findElement(By.xpath(" //input[contains(@value,'Create')]")).click();

		// Logout and Close
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
}
