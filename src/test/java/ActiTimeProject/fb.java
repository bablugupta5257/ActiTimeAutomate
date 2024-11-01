package ActiTimeProject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenersForSS.class)
public class fb{
	public static WebDriver driver;
@Test
public void listner() throws InterruptedException {
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("mail")).sendKeys("dhfjs");
	Thread.sleep(5000);
	Reporter.log("dfdddd",true);
	driver.close();
	
}

}

