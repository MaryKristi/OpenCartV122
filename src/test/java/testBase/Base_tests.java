package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger; //Log4j 
import org.apache.logging.log4j.LogManager; //Log4j 

public class Base_tests {
public static WebDriver driver;
public Logger logger; //Log4j 
public Properties p;
    @Parameters({"os", "browser"})
	@BeforeClass(groups= {"Sanity","Regression", "DataDriven","master"})
	
	public void login(String os, String br) throws IOException
	{
		//loading properties file
		 FileReader file= new FileReader("./src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		 
		 
		logger = LogManager.getLogger(this.getClass()); //10G4J2 
		
		switch(br.toLowerCase())
		{
		  case "chrome" : driver= new ChromeDriver(); break;
		  case "edge" : driver= new EdgeDriver(); break;
		  case "FireFox": driver= new FirefoxDriver(); break;
		  default :System.out.println("Invalid browser...."); return;
		}	
		//driver= new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		driver.get(p.getProperty("appurl")); // reading url from properties file value  
		driver.manage().window().maximize();
		
		
	}
	
	@AfterClass(groups= {"Sanity","Regression", "DataDriven","master"})
	public void TearDown()
	{
		driver.close();
	}

	
	//genarate random values
		public String randomString()
		{
			String genstring= RandomStringUtils.randomAlphabetic(5);
			return genstring;
			
		}

		public String randomNumber()
		{
			String gennumber= RandomStringUtils.randomNumeric(10);
			return gennumber;
			
		}
		
		public String randomAlphaNumber()
		{
			String genstring= RandomStringUtils.randomAlphabetic(5);
			String gennumber= RandomStringUtils.randomNumeric(10);
			return (genstring+"@"+gennumber);
			
		}
		
		public String captureScreen(String tname) throws IOException { 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver; 
		File sourceFile =takesScreenshot.getScreenshotAs (OutputType.FILE); 
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname +"_"+ timeStamp+".png";
		File targetFile=new File(targetFilePath); 
		
		sourceFile.renameTo(targetFile); 
		
		return targetFilePath; 
		}
  }

