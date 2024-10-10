package reusable;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.google.common.io.Files;

import io.opentelemetry.api.logs.Logger;

public class Baseclass {
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	public void openapplication() throws Exception
	{
		driver=new ChromeDriver();
		driver.get("https://zepp.studentpurchaseprogram.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
		
	}
	
	@AfterClass
	public void closeapplication() throws Exception
	{
		Thread.sleep(5000);
		driver.quit();
	}

	public String captureScreenshot() throws IOException
	{
		
		String timestamp=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\Screenshots\\"+timestamp+".png";
		Files.copy(source, new File(destination));
		return destination;
		
	}
	
}
