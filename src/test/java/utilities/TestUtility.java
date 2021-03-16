package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtility
{
	//Properties
	public RemoteWebDriver driver;
	//Constructor method 
	public TestUtility()
	{
		driver=null;
	}
	//Operational methods
	public RemoteWebDriver openBrowser(String bn)
	{
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			//String[] s=new String[] {"enable-automation"};
			//co.setExperimentalOption("excludeSwitches",s);
			co.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.silentOutput","true");
			driver=new ChromeDriver(co);
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			//Set IE browser zoom level to 100% manually
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();	
		}
		return(driver);
	}
	public void launchSite(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void closeSite()
	{
		driver.quit();
	}
}