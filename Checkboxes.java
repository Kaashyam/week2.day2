package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		// Select the languages that you know
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[1]")).click();
		// Confirm if selenium is checked
		System.out.println(driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/input")).isSelected());
		// Deselect only checked
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[2]")).click();
		// Select all below checkboxes
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[6]")).click();
		
		driver.close();
	}
}
