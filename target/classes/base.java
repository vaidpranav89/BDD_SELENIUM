package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;

public class base {

	public static  WebDriver driver;
	//public WebDriver driver;
	public Properties prop,properties;
	public static Logger log = LogManager.getLogger(base.class.getName());
	private String WebURL= "http://amazon.co.uk";
	public WebDriver initializeDriver() throws IOException
	{

		prop= new Properties();
		//System.getProperty("user.dir")
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		//mvn test -Dbrowser=chrome
	
		//String browserName=System.getProperty("browser");  // Uncomment this line if you are sending parameter from Maven
		String browserName=prop.getProperty("browser");// comment this line if you are sending parameter from Maven
		System.out.println(browserName);

		if(browserName.contains("chrome"))
		{
			
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
			//execute in chrome driver

		}
		else if (browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.contains("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}




		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver ;

	}
	
	


	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+ CurrentDateTime() +".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		

	}
	public String getURL() {
		return WebURL;
	}
	
	
	
	public String CurrentDateTime() {    

		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now);  
		  } 
}    

