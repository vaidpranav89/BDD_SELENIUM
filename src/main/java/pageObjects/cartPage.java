package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage {

	public WebDriver driver;

	By productNameValidateinCart = By.xpath("//td[@class='product-price']/span/bdi");

	public cartPage(WebDriver driver) {
		this.driver = driver;

	}

	public String productNameValidationCart(WebDriver driver) {

		return driver.findElement(productNameValidateinCart).getText();
	}

	public String print_product_name(WebDriver driver) {
		String product_S = driver.findElement(By.xpath("(//*[@class='product-name'])[2]/a")).getAttribute("href");
		System.out.println("Href value:" + product_S);
		String[] product_name = product_S.split("=");
		System.out.println("On cart page:" + product_name[1].trim().toUpperCase());

		return product_name[1].trim().toUpperCase();

	}

}
