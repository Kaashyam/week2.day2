package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {
	public static void main(String[] args) {
		// Button - Bond with Buttons
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver1 = new ChromeDriver();
		driver1.get("http://leafground.com/pages/Button.html");
		driver1.manage().window().maximize();
		// Click Button to travel to Homepage
		driver1.findElement(By.id("home")).click();
		driver1.navigate().back();
		// Find position of button(x,y)
		System.out.println("Location: " + driver1.findElement(By.xpath("//button[@id='position']")).getLocation());
		// Find button color
		System.out.println("Color: " + driver1.findElement(By.id("color")).getCssValue("background-color"));
		// Find height and width
		System.out.println("Size: " + driver1.findElement(By.id("size")).getSize());
		driver1.close();
	}
}
