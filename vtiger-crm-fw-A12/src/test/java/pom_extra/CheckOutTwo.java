package pom_extra;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CheckOutTwo {
	// Initialization
    public CheckOutTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

   

    // finish button
    @FindBy(partialLinkText= "FINISH")
    private WebElement finishButton;

    

    // ===== Getters =====
    

    public WebElement getFinishButton() {
        return finishButton;
    }

    

}
