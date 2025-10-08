package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement profilePic;

	public WebElement getProfilePic() {
		return profilePic;
	}

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getSignOutLink() {
		return signOutLink;
	}
}