package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.opencart.com/index.php?route=account/register");
	Thread.sleep(5000);
	
	//dropdown using sendkeys
	driver.findElement(By.name("country_id")).sendKeys("India");
}
}
