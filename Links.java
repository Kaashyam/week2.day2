package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
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
