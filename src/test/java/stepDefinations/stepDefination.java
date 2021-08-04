package stepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.HomePage;
import pageObjects.WishListPage;
import pageObjects.cartPage;
import resources.base;

public class stepDefination extends base {

	public WebDriver driver;
	HomePage homepage = new HomePage(driver);;
	WishListPage wishlist = new WishListPage(driver);
	cartPage cp = new cartPage(driver);
	int LowestProductindex;
	String LowestProductName;
	String LowestPrice;
	int LowestProductid;

	@Given("^I Initialize the browser with chrome$")
	public void i_initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@When("^I add the four products in wishlist$")
	public void i_add_the_four_product_in_wishlist() throws Throwable {

		int[] product_ID = { 14, 20, 24, 18 };
		homepage.addToWishList(driver, product_ID);

	}

	@When("^I view my wishlist table$")
	public void i_view_my_wishlist_table() throws Throwable {

		homepage.navigateToWishlist(driver);
	}

	@When("^I search for lowest price product$")
	public void i_search_for_lowest_price_product() throws Throwable {

		LowestProductid = wishlist.findLowestprice(driver);

	}

	@Then("^I find total four selected items in my wishList$")
	public void i_find_total_four_selected_items_in_my_wishlist() throws Throwable {

		Assert.assertEquals(wishlist.productSize(driver), 4);
	}

	@Then("^I am able to verify the item in my cart$")
	public void i_am_able_to_verify_the_item_in_my_cart() throws Throwable {
		String cartProductName = cp.print_product_name(driver);

		Assert.assertEquals(cartProductName, LowestProductName);

	}

	@And("^I navigate to the HomePage$")
	public void i_navigate_to_the_homepage() throws Throwable {

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		homepage.consent(driver);
	}

	@And("^I am able add lowest price item to my cart$")
	public void i_am_able_add_lowest_price_item_to_my_cart() throws Throwable {

		LowestProductName = wishlist.addLowestProductToCart(driver, LowestProductid);

	}

	@And("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.close();
	}

	// method to get the price for the product on the wishlistpage
	public String get_price(int product_ID) {

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
