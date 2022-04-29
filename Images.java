package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver3 = new ChromeDriver();
		driver3.get("http://leafground.com/pages/Image.html");
		driver3.manage().window().maximize();
		// Click on this image to go home page
		driver3.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img")).click();
		driver3.navigate().back();
		// Am I broken image?
		String attribute = driver3.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img"))
				.getAttribute("src");
		driver3.navigate().to(attribute);
		System.out.println("Title: " + driver3.getTitle());
		if (driver3.getTitle().contains("404")) {
			System.out.println("The imageis broken");
		} else {
			System.out.println("The image is not broken");
		}
		driver3.navigate().back();
		// Click me using keyboard or mouse
		// Mouse
		driver3.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img")).click();
		driver3.navigate().back();
		driver3.close();
	}
}
