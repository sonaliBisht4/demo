package Contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ADD_Contact_Cd_Test {

    public static void main(String[] args) throws InterruptedException, IOException {
        
        // --- 1.Read Data  from Properties File  ---
        
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties pObj = new Properties();
        pObj.load(fis);
        
        //retrieve values  from Properties file 
       
        String URL = pObj.getProperty("url");
        String USERNAME = pObj.getProperty("un"); 
        String PASSWORD = pObj.getProperty("pwd"); 
        
        fis.close(); // FileInputStream should be closed
        
//		Open Browser 
		WebDriver driver = new ChromeDriver();
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

        // --- 4. Create Contact ---
        
        driver.findElement(By.linkText("Contacts")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
        
        driver.findElement(By.name("lastname")).sendKeys("WERT");
        driver.findElement(By.name("firstname")).sendKeys("AHVD");
        driver.findElement(By.name("department")).sendKeys("XYZ");
        
        Thread.sleep(3000);
        
        // Save 
        driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
        
       
        
        // --- 5. Sign Out and Quit ---
        
        WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
        Actions act = new Actions(driver);
        act.moveToElement(profilePic).build().perform();
        driver.findElement(By.linkText("Sign Out")).click();
        
        Thread.sleep(3000);
        driver.quit();
    }
}
