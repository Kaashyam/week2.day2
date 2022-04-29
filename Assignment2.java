package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) {
		// Edit - Work with Edit fields
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		// Enter email address
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("kumar.testleaf@gmail.com");
		// Append input and navigate using tab
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("123" + Keys.TAB);
		// Get default text entered
		System.out.println("The default text entered is "
				+ driver.findElement(By.xpath("(//input[@type = 'text'])[3]")).getAttribute("value"));
		// CLear the text
		driver.findElement(By.xpath("(//input[@type = 'text'])[4]")).clear();
		// Confirm the edit field is disabled
		System.out.println(driver.findElement(By.xpath("(//input[@type = 'text'])[5]")).isEnabled());
		// Close browser
		driver.close();

		// Button - Bond with Buttons
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("http://leafground.com/pages/Button.html");
		driver1.manage().window().maximize();
		//Click Button to travel to Homepage
		driver1.findElement(By.id("home")).click();
		driver1.navigate().back();
		//Find position of button(x,y)
		System.out.println("Location: " + driver1.findElement(By.xpath("//button[@id='position']")).getLocation());
		//Find button color
		System.out.println("Color: " + driver1.findElement(By.id("color")).getCssValue("background-color"));
		//Find height and width
		System.out.println("Size: " + driver1.findElement(By.id("size")).getSize());
		driver1.close();

		// Link - Play with Hyper links
		ChromeDriver driver2 = new ChromeDriver();
		driver2.get("http://leafground.com/pages/Link.html");
		driver2.manage().window().maximize();
		// Go to Home page
		driver2.findElement(By.xpath("(//a[@link = 'blue'])[1]")).click();
		driver2.navigate().back();
		// Find where am supposed to go without clicking me?
		System.out.println(driver2.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href"));
		// Verify am I broken
		driver2.findElement(By.linkText("Verify am I broken?")).click();
		System.out.println("The title of the page is " + driver2.getTitle());
		if (driver2.getTitle().contains("404")) {
			System.out.println("The page is broken");
		} else {
			System.out.println("The page is not broken");
		}
		driver2.navigate().back();
		// Go to Home page (Interact with same link name)
		String Link1 = driver2.findElement(By.xpath("(//a[@link = 'blue'])[1]")).getAttribute("href");
		String Link2 = driver2.findElement(By.xpath("(//a[@link = 'blue'])[3]")).getAttribute("href");
		if (Link1.equals(Link2)) {
			Link1 = Link2;
			driver2.findElement(By.xpath("(//a[@link = 'blue'])[1]")).click();
		} else {
			System.out.println("The Home page links " + Link1 + "and " + Link2 + "are not same");
		}
		driver2.navigate().back();
		// How many links are available in this page?
		List<WebElement> links = driver2.findElements(By.tagName("a"));
		System.out.println("The number of links in this page are " + links.size());
		driver2.close();
		
	}
}

