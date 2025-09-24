package Email;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class To_Subject {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		Thread.sleep(3000);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.linkText("Compose")).click();
		
		String pid = driver.getWindowHandle();
		Set<String> cid = driver.getWindowHandles();
		System.out.println(pid);
		System.out.println(cid);
		cid.remove(pid);
		
		for(String s : cid)
		{
			driver.switchTo().window(s);
			driver.findElement(By.cssSelector("[title=\'Select\']")).click();
			
			Set<String> cid1 = driver.getWindowHandles();
			for (String s1 : cid1) 
			{
				driver.switchTo().window(s1);
				if (driver.getCurrentUrl().contains("Contacts")) 
				{
					driver.findElement(By.linkText("Mary Smith")).click();					
			    }
			}
			
			for (String win : cid) {
			    if (!win.equals(pid)) {
			        driver.switchTo().window(win);
			    }
			}

			System.out.println(pid);
			System.out.println(cid);
			cid.remove(pid);

			// ==== Compose Window ====
			driver.findElement(By.name("parent_name")).sendKeys("sakshi@mail.com");
			driver.findElement(By.id("cc_name")).sendKeys("sonali@gmail.com");
			driver.findElement(By.name("subject")).sendKeys("sonali@gmail.com");

			Thread.sleep(2000);

		
			
			
			driver.quit();

	
	}
	

	}
}
