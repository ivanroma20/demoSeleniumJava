package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FiltersPage extends BasePage {
	
	
	public @FindBy(xpath="//span[text()='PUMA']") WebElement checkBrand;
	public @FindBy(xpath = "//div[@id='srp-river-results-query_answer1']//li[9]//div[1]//a[1]") WebElement linkSize;
	public @FindBy(xpath = "//div[@id='w8']//div[@class='srp-controls__control--legacy']") WebElement mouseOver;
	public @FindBy(css = ".srp-sort__menu li:nth-of-type(4) span") WebElement linkOrder; //'Precio + Envío: más bajo primero'
	public @FindBy(css=".srp-controls__count-heading")List<WebElement> textResult1;
	public @FindBy(css=".rcnt") List<WebElement> textResult2;
	public @FindBy(css="ul .s-item h3") List<WebElement> textName;
	public @FindBy(css="ul .s-item__price") List<WebElement> textPrice;

	
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
	
	public String printNumberResults() throws Exception {
		String numberResults= getTextList(textResult1,textResult2, 0);
		return numberResults;
	}
	
	public String showNamePrice() {
		String namePrice=getNamePrice(textName, textPrice, 5);
		return namePrice;
	}
	
	public String showNamesAsc() {
		String nameAsc= orderListAsc(textName, 5);
		return nameAsc;
	}
	
	public String showPricesDsc() {
		String priceDsc= orderListDsc(textPrice, 5);
		return priceDsc;
	}
	
}
