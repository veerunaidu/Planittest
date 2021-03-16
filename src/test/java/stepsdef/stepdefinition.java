package stepsdef;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.demopage;

public class stepdefinition
{
	                                 //Declare objects to Page classes and other required classes
	public demopage pageobj;        //page class object
	public Shared sh;              //"Shared" class can provide other reusable classes objects
	public WebDriverWait w;
	public String username ;
	
	
	//Constructor method
	public stepdefinition (Shared sh)
	{
		this.sh=sh;
	}
	
	//Operational methods of class
	@Given("^launch site using \"(.*)\"$")
	public void launch_site(String bn)
	{
		//browser launch
		sh.driver=sh.tu.openBrowser(bn);
		pageobj=new demopage(sh.driver);	
		Integer t=Integer.parseInt((String) sh.p.get("maxtime"));
		w=new WebDriverWait(sh.driver,t);
		//launch site
		sh.tu.launchSite(sh.p.getProperty("url"));
		w.until(ExpectedConditions.visibilityOf(pageobj.logo));
		sh.s.log("demowebshop Site launched Successfully");
	}
	
	
	@When("^Click on Login button$")
    public void Click_on_Login_button()
    {
		w.until(ExpectedConditions.visibilityOf(pageobj.login)).click();
    }
	@Then("^message should be displayed as \"(.*)\"$")
	public void message_should_available(String expected)
	{
		try {
		String actual=pageobj.getwelcomemsg();
		if(expected.equals(actual))
		{
			sh.s.log("Welcome, Please Sign In! Message Displayed TEST PASSED");
		}
		else
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"image/png","Welcome, Please Sign In! Message Not Displayed TEST FAILED");
			Assert.assertTrue(false);
		}
		}
		catch (Exception ex)
    	{
    		byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"png",ex.getMessage());
			Assert.assertTrue(false);
    	}
		
	}
	
	
	
	@When("^Login with given credentials are \"(.*)\",\"(.*)\"$")
	public void Login_with_given_credentials(String uid, String pwd) throws Exception
	{
		pageobj.fillemail(uid);
		pageobj.fillpassword(pwd);
		Thread.sleep(2000);
		pageobj.clickbtnlogin();
		username=uid;
		
	}
	
	@Then("^Validate the account_ID$")
	public void Validate_the_user_account( )
	{
		String expected=username;
		
		//passing a variable string to Xpath
		WebElement accid=sh.driver.findElement(By.xpath("//a[text()='"+username+"']"));
		String actual=accid.getText();
		if(expected.equals(actual))
		{
			sh.s.log("account ID Displayed Test passed");
		}
		else
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"image/png","account ID not Displayed correctly Test failed");
			Assert.assertTrue(false);
		}
	}
	
	
	@And("^Clear the cart$")
	public void Clear_the_shopping_cart()
	{
		String qty =pageobj.getcartqty();
		Pattern p=Pattern.compile("[0-9]");
        Matcher m=p.matcher(qty);
        m.find();
        String qtysring= m.group().toString();
        Integer count= Integer.parseInt(qtysring);
		if (count>0)
		{
			pageobj.clickoncart();
			w.until(ExpectedConditions.visibilityOf(pageobj.removefromcart)).click();
			pageobj.clickupdatecart();
			sh.s.log("Cart cleared Successfully");
			
		}
		else
		{
			sh.s.log("Cart is EMPTY NO items to clear");
		}	
	}
	
	@And("^Select Books from Categories$")
	public void Select_Books()
	{
		w.until(ExpectedConditions.visibilityOf(pageobj.catbooks)).click();
		
	}
	
	@And("^Select a book from the displayed list$")
	public void select_a_book()
	{
		w.until(ExpectedConditions.visibilityOf(pageobj.book1)).click();
				
	}
	@And("^Get the price details and enter the quantity more than one \"(.*)\"$")
	public void get_price_change_qty(String qty) throws Exception
	{
		w.until(ExpectedConditions.visibilityOf(pageobj.actualprice));
		String price=pageobj.getprice();
		sh.s.log("Book price is "+price+"");
		w.until(ExpectedConditions.visibilityOf(pageobj.EnteredQuantity));
		pageobj.enterqty(qty);
		
	}
	
	@And("^Click on Add to cart$")
	public void click_on_Cart()
	{
		w.until(ExpectedConditions.visibilityOf(pageobj.Addtocart)).click();
	}
	
	@Then("^Validate message \"(.*)\"$")
	public void Validate_message(String expectedmsg)
	{
		
		w.until(ExpectedConditions.visibilityOf(pageobj.notification));
		String notif=pageobj.getnotification();
		String trimnotfi=notif.trim();
		String expectednotfi=expectedmsg;
		if(expectednotfi.equalsIgnoreCase(trimnotfi))
		{
			sh.s.log("The product has been added to your shopping cart Message Displayed TEST PASSED");
		}
		else
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"image/png","The product has been added to your shopping cart Message Not Displayed TEST FAILED");
			Assert.assertTrue(false);
		}
		
	}
	
	
    @And("^Click on shopping cart on top right and validate the Sub-Total Price for selected book$")
    public void Click_on_shopping_cart_validate_the_SubTotal()
	{
    	try {
    		
    	
    	w.until(ExpectedConditions.visibilityOf(pageobj.cart)).click();
    	w.until(ExpectedConditions.visibilityOf(pageobj.subtotal));
    	String subtotalamount=pageobj.getsubtotal();
    	sh.s.log("Sub-Total Price for selected books is "+subtotalamount+"");
    	}
    	catch (Exception ex)
    	{
    		byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"png",ex.getMessage());
			Assert.assertTrue(false);
    	}
	}
    @And("^Click on Check-out$")
    public void Click_on_Checkout()
   	{	
       try
   	   {
           w.until(ExpectedConditions.visibilityOf(pageobj.termsofservice)).click();
           w.until(ExpectedConditions.visibilityOf(pageobj.checkout)).click();
     	}
   	
    catch (Exception ex)
	   {
		  byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
		  sh.s.attach(b,"png",ex.getMessage());
		  Assert.assertTrue(false);
	   }
   	}
    
    @And("^Select New Address From Billing Address drop down$")
    public void Select_New_Address()
   	{
    	w.until(ExpectedConditions.visibilityOf(pageobj.billingaddress));
    	pageobj.selectbillingaddress();
    	w.until(ExpectedConditions.visibilityOf(pageobj.Billingsave)).click();
   	}
    @And("^Fill mandatory fields in Billing Address and click on Continue$")
    public void Fill_all_mandatory_fields_in_Billing_Address()
   	{
    	w.until(ExpectedConditions.visibilityOf(pageobj.shippingaddress));
    	pageobj.selectshippingaddress();
    	w.until(ExpectedConditions.visibilityOf(pageobj.Shippingsave)).click();
   		
   	}
    @And("^Select the Shipping Address as same as Billing Address from Shipping Address drop down and click on Continue$")
    public void Select_the_Shipping_Address_as_same_as_Billing_Address()
   	{
    
    	sh.s.log("Selected the Shipping Address as same as Billing Address");
   		
   	}
    @And("^Select the shipping method as Next Day Air and click on Continue$")
    public void Select_the_shipping_method()
   	{
    	w.until(ExpectedConditions.visibilityOf(pageobj.NextDayAir)).click();
    	w.until(ExpectedConditions.visibilityOf(pageobj.ShippingMethodsave)).click();
    	
   	}
    @And("^Choose the payment method as Cash on delivery and click on Continue$")
    public void Choose_the_payment_method_as_Cash_on_delivery() throws InterruptedException
   	{
    	Thread.sleep(3000);
        sh.driver.findElement(By.xpath("//*[@value='Payments.CashOnDelivery']")).click();;
        sh.driver.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        sh.driver.findElement(By.xpath("//*[@onclick='PaymentMethod.save()']")).click();
    	
   	}
    @Then("^Validate the message \"(.*)\" and click on Continue$")
    public void Validate_the_message(String expectedmsg)
   	{
    	w.until(ExpectedConditions.visibilityOf(pageobj.paybyCOD));
    	String actualcodmsg=(String) sh.driver.executeScript("return(arguments[0].textContent);",pageobj.paybyCOD);
		if(expectedmsg.equalsIgnoreCase(actualcodmsg))
		{
			sh.s.log("You will pay by COD Message Displayed TEST PASSED");
		}
		else
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"image/png","You will pay by COD Message Not Displayed TEST FAILED");
			Assert.assertTrue(false);
		}
		w.until(ExpectedConditions.visibilityOf(pageobj.PaymentInfosave)).click();
   	}
    @And("^Click on Confirm Order$")
    public void Click_on_Confirm_Order()
   	{
    	
    	w.until(ExpectedConditions.visibilityOf(pageobj.Confirm)).click();
   		
   	}
    @Then("^Validate the message \"(.*)\" and print the Order number$")
    public void Validate_the_message_and_print_the_Order_number(String expectedmsg)
   	{
    	try 
    	{
    	w.until(ExpectedConditions.visibilityOf(pageobj.ordersucess));
    	String actualmsg=pageobj.ordersucess.getText();
    	String temp=pageobj.orderno.getText();
    	temp.trim();
		Pattern p=Pattern.compile("[0-9]{6}");
        Matcher m=p.matcher(temp);
        m.find();
        String ordernumber= m.group().toString();
        System.out.println(ordernumber);
		if(expectedmsg.equals(actualmsg))
		{
			sh.s.log("Your order has been Successfully processed! is Displayed, and Order ID is "+ordernumber+" TEST PASSED");
		}
		else
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"image/png","Your order has been Successfully processed! is  Not Displayed TEST FAILED");
			Assert.assertTrue(false);
		}
    	}
    	catch (Exception ex)
    	{
    		byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"png",ex.getMessage());
			Assert.assertTrue(false);
    	}
    	
   		
   	}
    @And("^Click on Continue and log out from the application$")
    public void Click_on_Continue_and_log_out()
   	{
    	w.until(ExpectedConditions.visibilityOf(pageobj.Logout)).click();;
   	}
    
    
    
    @Then("^close site$")
	public void method4()
	{
		sh.tu.closeSite();
	}
    
}