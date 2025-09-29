package Email;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Mail_Cd {
	public static void main(String[] args) throws InterruptedException , IOException 
	{
 // --- 1.Read Data  from Properties File  ---
        
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties pObj = new Properties();
        pObj.load(fis);
        
        //retrieve values  from Properties file 
        String BROWSER = pObj.getProperty("bro");
        String URL = pObj.getProperty("url");
        String USERNAME = pObj.getProperty("un"); 
        String PASSWORD = pObj.getProperty("pwd"); 
        
        fis.close(); // FileInputStream should be closed
        
        // --- 2. Browser Initialize 
        
        WebDriver driver;

        // BROWSER variable ki value ke base par driver initialize hoga
        if (BROWSER.equalsIgnoreCase("chrome")) {
            // NOTE: Agar aapke system mein ChromeDriver environment path mein nahi hai, 
            // toh aapko System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe"); 
            // set karna padega.
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.err.println("Error: Invalid browser name specified in properties file: " + BROWSER);
            return;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // --- 3. Login 
        
        driver.get(URL); // 
        
        // Login credentials are replaced from properties file variables 
        WebElement username = driver.findElement(By.name("user_name"));
        username.sendKeys(USERNAME); 
        
        WebElement password = driver.findElement(By.name("user_password"));
        password.sendKeys(PASSWORD); 
        
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(3000);
        
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
			driver.findElement(By.name("parent_name")).sendKeys("sonali@mail.com");
			driver.findElement(By.id("cc_name")).sendKeys("dinga@gmail.com");
			driver.findElement(By.name("subject")).sendKeys("dinga@gmail.com");

			Thread.sleep(2000);

		
			
			
			driver.quit();

	
	}
	

	}
}
