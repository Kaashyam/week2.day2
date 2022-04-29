package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAccount {
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

		// Find the Web element Find Accounts and click on the same
		driver.findElement(By.partialLinkText("Find")).click();

		// Enter AccountName as "Credit Limited Account"
		driver.findElement(By.xpath("(//input[@name='accountName'])[2]")).sendKeys("Credit Limited Account");

		// Click on Find Accounts using xpath Locator
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("accountlimit100")).click();

		// Click on the edit Button
		driver.findElement(By.xpath("(//a[text() = 'Edit'])[1]")).click();

		// Get the Text of Account Name and verify
		String text = driver.findElement(By.xpath("//input[@id = 'accountName']")).getText();
		if (text.equals("Creit Account Number")) {
			System.out.println("Account Name is verified successfully");
		} else {
			System.out.println("Account Name does not match");
		}

		// Get the Text of Description
		System.out.println("Description: " + driver.findElement(By.xpath("//textarea[@name='description']")).getText());

		// Get the title of the page and verify it
		System.out.println("The title of the page is " + driver.getTitle());
		if (driver.getTitle().equals("Edit Account | opentaps CRM")) {
			System.out.println("Title verified successfully");
		} else {
			System.out.println("Title does not match");
		}

		// Logout and Close
		driver.findElement(By.linkText("Logout")).click();
		driver.close();

	}
}
