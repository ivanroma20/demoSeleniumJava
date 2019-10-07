package pageObjects;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FiltersPage extends BasePage {
	
	
	public @FindBy(xpath="//span[text()='PUMA']") WebElement checkBrand;
	public @FindBy(xpath = "//div[@id='srp-river-results-query_answer1']//li[9]//div[1]//a[1]") WebElement linkSize;
	public @FindBy(xpath = "//div[@id='w8']//div[@class='srp-controls__control--legacy']") WebElement mouseOver;
	public @FindBy(css = ".srp-sort__menu li:nth-of-type(4) span") WebElement linkOrder; //'Precio + Envío: más bajo primero'
	public @FindBy(css=".srp-controls__count-heading")WebElement textResult;
	//public @FindBy(css=".rcnt") List<WebElement> textResult2;
	public @FindBy(css="ul .s-item h3") List<WebElement> textName;
	public @FindBy(css="ul .s-item__price") List<WebElement> textPrice;
	
	private static Logger LOGGER = LoggerFactory.getLogger(FiltersPage.class);

	
	public FiltersPage() throws IOException {	
		super();
	}
	
	public FiltersPage selectBrand() throws Exception  {
		waitAndClickElement(checkBrand);
		return new FiltersPage();
	}
	
	public FiltersPage selectSize() throws Exception  {
		waitAndClickElement(linkSize);
		return new FiltersPage();
	}
	
	public FiltersPage mouseOverAndClick() throws Exception {
		actionMoveAndClick(mouseOver);
		actionMoveAndClick(mouseOver);
		waitAndClickElement(linkOrder);
		return new FiltersPage();
	}
	
	public boolean assertOrderResults() {
		return assertorder(textPrice, 5);
	}
	
	public String printNumberResults() throws Exception {
		String numberResults= getTextList(textResult);
		return numberResults;
	}
	
	public String showNamePrice() {
		String namePrice=getNamePrice(textName, textPrice, 5);
		return namePrice;
	}
	
	public String showNamesAsc() {
		String nameAsc= orderListAsc(textName, textName.size());
		return nameAsc;
	}
	
	public String showPricesDsc() {
		String priceDsc= orderListDsc(textPrice, textPrice.size());
		return priceDsc;
	}
	
	
}
