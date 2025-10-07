package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/v1/");
        Thread.sleep(3000);

        // ===== LOGIN PAGE =====
        LoginPage lp = new LoginPage(driver);

        // Declaration & initialization
        WebElement un = lp.getUn();
        WebElement pwd = lp.getPwd();
        WebElement login = lp.getLogin();

        // Refreshing before use (optional)
        driver.navigate().refresh();
        Thread.sleep(2000);

        // Utilization
        un.sendKeys("standard_user");
        pwd.sendKeys("secret_sauce");
        login.click();

        // ===== VERIFY LOGIN =====
        HomePage hp = new HomePage(driver);
        WebElement logo = hp.getLogo();

        if (logo.isDisplayed()) {
            System.out.println("Logged in successfully!");
        } else {
            System.out.println(" Could not log in!");
        }

        Thread.sleep(2000);

        // ===== ADD PRODUCT TO CART =====
        WebElement addToCart = hp.getAddToCartBackpack();
        addToCart.click();
        System.out.println(" Sauce Labs Backpack added to cart!");

        Thread.sleep(2000);

        // ===== OPEN CART =====
        hp.openCart();
        System.out.println(" Cart opened successfully!");

        Thread.sleep(2000);

        // ===== CART PAGE ACTIONS =====
        CartPage cp = new CartPage(driver);

        // Click Checkout button
        WebElement clickcheckoutButton = cp.getCheckoutButton();
        clickcheckoutButton.click();
        System.out.println("Clicked on Checkout button successfully!");

        Thread.sleep(2000);

        // ===== CHECKOUT PAGE =====
        CheckOutOne cp1 = new CheckOutOne(driver);

        // Declaration & initialization
        WebElement fn = cp1.getFN();
        WebElement ln = cp1.getLN();
        WebElement pc = cp1.getPC();
        WebElement cb = cp1.getCB();

        // Utilization
        fn.sendKeys("Sonali");
        ln.sendKeys("Bisht");
        pc.sendKeys("201301");
        System.out.println(" Entered checkout details successfully!");

        Thread.sleep(1000);

        cb.click();
        System.out.println("Clicked on Continue button successfully!");

        Thread.sleep(3000); 
        
     // ===== Checkouttwo PAGE ACTIONS =====
        CheckOutTwo ch2 = new CheckOutTwo(driver);

        // Click Checkout button
        WebElement clickfinishButton = ch2.getFinishButton();
        clickfinishButton.click();
        System.out.println("Clicked on Finish button successfully!");

        Thread.sleep(2000);
        

        driver.quit();
    }
}
