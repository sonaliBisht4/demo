package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    // Initialization
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

        // Checkout button
    @FindBy(xpath = "//a[text()='CHECKOUT']")
    private WebElement checkoutButton;

    

    // ===== Getters =====
    

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    

    
}
