#Author: GUMULURU VEERUNAIDU
Feature: book_an_order
  Background: 
    Given launch site using "chrome"
    
  Scenario: order booking test
  
    When Click on Login button
    Then message should be displayed as "Welcome, Please Sign In!"
    When Login with given credentials are "atest@gmail.com","123456"
    Then Validate the account_ID
    And Clear the cart
    And Select Books from Categories
    And Select a book from the displayed list
    And Get the price details and enter the quantity more than one "3"
    And Click on Add to cart
    Then Validate message "The product has been added to your shopping cart"
    And Click on shopping cart on top right and validate the Sub-Total Price for selected book
    And Click on Check-out
    And Select New Address From Billing Address drop down
    And Fill mandatory fields in Billing Address and click on Continue
    And Select the Shipping Address as same as Billing Address from Shipping Address drop down and click on Continue
    And Select the shipping method as Next Day Air and click on Continue
    And Choose the payment method as Cash on delivery and click on Continue
    Then Validate the message "You will pay by COD" and click on Continue
    And Click on Confirm Order
    Then Validate the message "Your order has been successfully processed!" and print the Order number
    And Click on Continue and log out from the application
    Then close site
