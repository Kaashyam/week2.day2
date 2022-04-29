package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {
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
	}
}
