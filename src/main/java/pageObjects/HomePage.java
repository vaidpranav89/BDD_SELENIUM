package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public WebDriver driver;

	By addToWishList = By.xpath("//span[text()='Add to wishlist']");
	By productName = By.cssSelector("h2.woocommerce-loop-product__title");
	By wishList = By.xpath("(//*[@title='Wishlist'])[2]/i");
	By consent = By.xpath("//a[@class='cc-btn cc-accept-all cc-btn-no-href']");

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	//// method to handle GDPR consents
	public void consent(WebDriver driver) {

		boolean eleSelected = driver.findElements(consent).size() != 0;
		if (eleSelected) {

			driver.findElement(consent).click();
		}

	}

	// method to navigate to wish list
	public void navigateToWishlist(WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(wishList));
		js.executeScript("arguments[0].click();", driver.findElement(wishList));
		Thread.sleep(4000);

		// return driver.findElement(wishList);
	}

	public void addToWishList(WebDriver driver, int[] product) throws InterruptedException {

		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		for (int i = 0; i < product.length; i++) {

			String Wishlist = ".add_to_wishlist.single_add_to_wishlist[href='?add_to_wishlist=" + product[i] + "']";

			if (i == 3) {
				Js1.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(Wishlist)));
			}
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(Wishlist)).click();
			Thread.sleep(4000);
		}

		Js1.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(wishList));
		Js1.executeScript("arguments[0].click();", driver.findElement(wishList));
		Thread.sleep(4000);

	}

}
