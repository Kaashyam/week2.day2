package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
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

		// Find web element Leads and click on the same
		driver.findElement(By.linkText("Leads")).click();

		// Find the Web element Create Lead and click on the same
		driver.findElement(By.partialLinkText("Create")).click();

		// Enter the Company Name, First name and Last name and click on Create Lead

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Shyam sundar");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Venugopal");

		// Click on Create Lead Button
		driver.findElement(By.xpath(" //input[contains(@value,'Create')]")).click();

		String text = driver.findElement(By.xpath("//span[contains(text(),'TestLeaf')]")).getText();

		System.out.println("Lead ID is " + text);
		
		//Logout and Close
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
}
