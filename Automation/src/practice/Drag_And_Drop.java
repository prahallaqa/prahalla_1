package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_And_Drop {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/drag-and-drop");
		WebElement draggable = driver.findElement(By.id("column-a"));
		WebElement drop = driver.findElement(By.id("column-b"));
		Actions a = new Actions(driver);
		a.dragAndDrop(draggable, drop).perform();
		System.out.println("Drag and Drop performed");
	}
}
