package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage {
	public WebDriver driver;

	By productName = By.xpath("//tr/td[3]");
	By discountTag = By.xpath("//*[@id='yith-wcwl-row-\" + product_ID[i] + \"']/td[4]/del");
	By productprice = By.xpath("//tr/td[4]");
	By addToCartButton = By.xpath(("//tr/td[6]"));
	By navigateTocart = By.xpath(("(//a[@class='cart-contents'])[2]"));
	By addToCart = By.xpath("(//*[@title='Cart'])[1]/i");

	public WishListPage(WebDriver driver) {
		this.driver = driver;

	}

	public int productSize(WebDriver driver) {

		return driver.findElements(productName).size();
	}

	public int findLowestprice(WebDriver driver) {
		int product_code_to_be_added = 0;
		int[] product_ID = { 14, 20, 24, 18 };
		String min_value = "";
		String price = "";

		List<String> price_list = new ArrayList<String>();
		for (int i = 0; i < product_ID.length; i++) {

			price = get_price(driver, product_ID[i]);
			price_list.add(price);
			min_value = Collections.min(price_list, null);

		}
		System.out.println("Minimum value in a list:" + min_value);
		for (int i = 0; i < product_ID.length; i++) {
			price = get_price(driver, product_ID[i]);
			if (price.equalsIgnoreCase(min_value)) {
				product_code_to_be_added = product_ID[i];
				break;
			}
		}
		System.out.println("Product ID of minimum product:" + product_code_to_be_added);
		return product_code_to_be_added;

	}

	public int findLowestProductinWishListTable(String min_value) {
		int[] product_ID = { 14, 20, 24, 18 };
		int product_code_to_be_added = 0;
		for (int i = 0; i < product_ID.length; i++) {
			String price = get_price(driver, product_ID[i]);
			if (price.equalsIgnoreCase(min_value)) {
				product_code_to_be_added = product_ID[i];
				break;
			}
		}
		System.out.println("Product ID of minimum product:" + product_code_to_be_added);

		return product_code_to_be_added;

	}

	public String addLowestProductToCart(WebDriver driver, int product_code_to_be_added) throws InterruptedException {

		// getting the name of product added to cart with min value
		String nameOfproduct = driver
				.findElement(By.xpath("//*[@id='yith-wcwl-row-" + product_code_to_be_added + "']/td[3]/a")).getText()
				.trim().toUpperCase();
		System.out.println("Product on wishlist table:" + nameOfproduct);

		// clicking add to product for min
		driver.findElement(By.xpath("//a[@data-product_id=" + product_code_to_be_added + "]")).click();
		// log.info("URL launched--");
		System.out.println("Product successfully added to cart");
		Thread.sleep(8000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(addToCart));
		js.executeScript("arguments[0].click();", driver.findElement(addToCart));
		return nameOfproduct;

	}

	public String get_price(WebDriver driver, int product_ID) {

		String price = "";
		String price_locator = "";

		String discount_tag = "//*[@id='yith-wcwl-row-" + product_ID + "']/td[4]/del";

		List<WebElement> check_del_tag = driver.findElements(By.xpath(discount_tag));
		if (check_del_tag.size() > 0) {
			price_locator = "//tr[@id='yith-wcwl-row-" + product_ID + "']/td[4]/ins/span/bdi";
		} else {
			price_locator = "//tr[@id='yith-wcwl-row-" + product_ID + "']/td[4]/span[1]/bdi";
		}

		price = driver.findElement(By.xpath(price_locator)).getText();

		return price;

	}

}
