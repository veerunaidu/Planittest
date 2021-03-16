package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class demopage {
	
	//Properties for locating elements
	public RemoteWebDriver driver;
	
	@FindBy(how=How.XPATH,using="//img[@alt='Tricentis Demo Web Shop']")
	public WebElement logo;
	
	@FindBy(how=How.XPATH,using="//span[@class='cart-qty']")
	public WebElement cart_qty;
	
	@FindBy(how=How.XPATH,using="//*[text()='Shopping cart']")
	public WebElement cart;
	
	@FindBy(how=How.NAME,using="removefromcart")
	public WebElement removefromcart;
	
	@FindBy(how=How.XPATH,using="//*[text()='Log in']")
	public WebElement login;
	
	@FindBy(how=How.XPATH,using="//*[text()='Welcome, Please Sign In!']")
	public WebElement welcomemsg;
	
	@FindBy(how=How.XPATH,using="//input[@id='Email']")
	public WebElement email;

	@FindBy(how=How.XPATH,using="//input[@id='Password']")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@value='Log in']")
	public WebElement btnlogin;
	
	@FindBy(how=How.XPATH,using="//a[text()='atest@gmail.com']")
	public WebElement accountID;
	
	@FindBy(how=How.XPATH,using="//ul[@class='top-menu']//a[normalize-space()='Books']")
	public WebElement catbooks;
	
	@FindBy(how=How.XPATH,using="//img[@title='Show details for Computing and Internet']")
	public WebElement book1;
	
	@FindBy(how=How.XPATH,using="//span[@itemprop='price']")
	public WebElement actualprice;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'EnteredQuantity')]")
	public WebElement EnteredQuantity;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'add-to-cart-button')]")
	public WebElement Addtocart;
	
	@FindBy(how=How.XPATH,using="//div[@id='bar-notification']")
	public WebElement notification;
	
	@FindBy(how=How.XPATH,using="//a[text()='shopping cart']")
	public WebElement shoppingcart;
	
	@FindBy(how=How.XPATH,using="//span[@class='product-price'][1]")
	public WebElement subtotal;
	
	@FindBy(how=How.XPATH,using="//input[@id='termsofservice']")
	public WebElement termsofservice;
	
	@FindBy(how=How.XPATH,using="//*[@name='checkout']")
	public WebElement checkout;
	
	@FindBy(how=How.XPATH,using="//input[@value='Update shopping cart']")
	public WebElement updatecart;
	
	@FindBy(how=How.XPATH,using="//select[@id='billing-address-select']")
	public WebElement billingaddress;
	
	@FindBy(how=How.XPATH,using="//select[@id='shipping-address-select']")
	public WebElement shippingaddress;

	@FindBy(how=How.XPATH,using="//input[@onclick='Billing.save()']")
	public WebElement Billingsave;
	
	@FindBy(how=How.XPATH,using="//input[contains(@value,'Next Day Air')]")
	public WebElement NextDayAir;
	
	@FindBy(how=How.XPATH,using="//input[@onclick='Shipping.save()']")
	public WebElement Shippingsave;
	
	@FindBy(how=How.XPATH,using="//*[@onclick='ShippingMethod.save()']")
	public WebElement ShippingMethodsave;
	
	@FindBy(how=How.XPATH,using="//img[contains(@alt,'Cash On Delivery')]")
	public WebElement CashOnDelivery;
	
	@FindBy(how=How.XPATH,using="//*[text()='You will pay by COD']")
	public WebElement paybyCOD;
	
	@FindBy(how=How.XPATH,using="//input[@onclick='PaymentInfo.save()']")
	public WebElement PaymentInfosave;
	
	@FindBy(how=How.XPATH,using="//input[@value='Confirm']")
	public WebElement Confirm;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Order number')]")
	public WebElement orderno;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Your order has been successfully processed!']")
	public WebElement ordersucess;
	
	@FindBy(how=How.XPATH,using="//input[@value='Continue']")
	public WebElement Continue;
	
	@FindBy(how=How.XPATH,using="//a[text()='Log out']")
	public WebElement Logout;
	
	//Constructor method for connecting runner classes
		public demopage(RemoteWebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
				
		//Operational methods to operate elements
		public void clicklogin()
		{
			login.click();
		}
		
		public String getaccountID()
		{
			String accid =accountID.getText();
			return(accid);
		}
		
		public void fillemail(String uid)
		{
			email.sendKeys(uid);
		}
		
		public void fillpassword(String pass)
		{
			password.sendKeys(pass);
		}
		
		public void clickbtnlogin()
		{
			btnlogin.click();
		}
		
		public String getwelcomemsg()
		{
			String msg =welcomemsg.getText();
			return(msg);
		}
		
		public void clickcatbooks()
		{
			catbooks.click();
		}
		
		public void clickonbook()
		{
			book1.click();
		}
		
		public String getprice()
		{
			String price =actualprice.getText();
			price.trim();
			return(price);
		}
		
		public void enterqty(String number) throws Exception
		{
			EnteredQuantity.clear();
			Thread.sleep(1000);
			EnteredQuantity.sendKeys(number);
		}
		
		public String getnotification()
		{
			String message=notification.getText();
			return(message);
		}
		
		
		public void clickupdatecart()
		{
			updatecart.click();
		}
		
		public void clickBillingsave()
		{
			Billingsave.click();
		}
		
		public void clickShippingsave()
		{
			Shippingsave.click();
		}
		
		public void clickContinue()
		{
			Continue.click();
		}
	
		public void clickpaybyCOD()
		{
			paybyCOD.click();
		}
	
		public void clickPaymentInfosave()
		{
			PaymentInfosave.click();
		}
	
		public void clickConfirm()
		{
			Confirm.click();
		}
	
		public void clickordersucess()
		{
			ordersucess.click();
		}
	
		public void clickLogout()
		{
			Logout.click();
		}
		
		public String getcartqty()
		{
			String cqty=cart_qty.getText();
			return(cqty);
			
		}
		public void clickoncart()
		{
			cart.click();
		}
		
		public void clickremovefromcart()
		{
			removefromcart.click();
		}
	
		public String getsubtotal()
		{
			String amount=subtotal.getText();
			return(amount);
		}
		
		
		public void selectbillingaddress()
		{
		  //billingaddress.click();
		  Select s=new Select(billingaddress);
		  s.selectByIndex(1);
		
		}
		
		public void selectshippingaddress()
		{
			//shippingaddress.click();
		   Select s=new Select(shippingaddress);
		   s.selectByIndex(1);
		
		}
	
		public String getpaymesg()
		{
			String message=paybyCOD.getText();
			return(message);
		}
	
}
