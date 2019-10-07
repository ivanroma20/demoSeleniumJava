package pageObjects;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public @FindBy(id="gh-ac") WebElement inputSearch;

	public @FindBy(id="gh-btn") WebElement buttonSearch;

	
	public HomePage() throws IOException {
		super();
	}
	
	public HomePage getIndexEbay() throws IOException {
		getDriver().get("https://www.ebay.com/");
		return new HomePage();
	}
	
	public HomePage enterCategoryName(String categoryName) throws Exception {
		sendKeysToWebElement(inputSearch, categoryName);  
		return new HomePage();
	}
	
	public HomePage clickOnSubmiButton() throws Exception {
		waitAndClickElement(buttonSearch);
		return new HomePage();
	}

}
