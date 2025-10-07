package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "app_logo")
	private WebElement logo;

	
	// Backpack Add to Cart 
	    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")
	    private WebElement addToCartBackpack;

	    @FindBy(className = "shopping_cart_link")
	    private WebElement cartButton;
	    
	    public WebElement getLogo() {
			return logo;
		}
	    
	    public WebElement getAddToCartBackpack() {
	        return addToCartBackpack;
	    }

	    public void openCart() {
	        cartButton.click();
	    }
}