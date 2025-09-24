package Contact;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Add_New_Cont {
public static void main(String[] args)throws InterruptedException {
		
//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Login
		driver.get("http://localhost:8888/");
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
//		Create Contacts
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("bisht");
		
		driver.findElement(By.name("firstname")).sendKeys("sonali");
		
		driver.findElement(By.name("department")).sendKeys("XYZ");
		
		Thread.sleep(3000);
//		Save 
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
//		Verification
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		

		
		
		
	}

}