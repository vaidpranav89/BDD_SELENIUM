#Author: vaidpranav89@gmail.com
#Summary : Validate customer is able to add four different product in the wishlist and from the wishlist customer identify the lowest price item and this item is then added to cart

@tag
Feature: Add product in the cart which is having lowest price of the products added in my wishlist
 

  @addProduct
 	Scenario: Add products into wishList and verify products are added in the cart
     Given I Initialize the browser with chrome
     And I navigate to the HomePage
     When I add the four products in wishlist 
     When I view my wishlist table
     Then I find total four selected items in my wishList
     When I search for lowest price product
     And I am able add lowest price item to my cart
     Then I am able to verify the item in my cart
     And I close the browser
    


 