package ActiTimeProject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POMActiTime.LoginData;



public class BaseClass {
   public static WebDriver driver;
   LoginPropertyFile l = new LoginPropertyFile();
  // LoginData Ld = new LoginData(driver);

	
	@BeforeSuite
	public void DataBaseConnection() {
		Reporter.log("DataBase : Data Base Connected successfully",true);
	}
	@Parameters("browser")
	@BeforeTest
	public void LaunchBrowser(String browser) throws IOException, InterruptedException {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = l.loginActiTime("url");
		driver.get(url);
		
		Reporter.log(" Browser Launch : Browser Launched successfully!",true);
		Thread.sleep(4000);
		
	}
	
	@BeforeMethod
	public void login_Actitime() throws IOException {
	String un = l.loginActiTime("username");
		String pass = l.loginActiTime("password");
		LoginData Ld = new LoginData(driver);
		 WebElement username = Ld.getUn();
		 username.sendKeys(un);
		//driver.findElement(By.id("username")).sendKeys(un);
		 WebElement pwd = Ld.getPass();
		 pwd.sendKeys(pass);
		 
		 driver.findElement(By.xpath("//div[.='Login ']")).click();
		 Reporter.log("Login : Login successfull!",true);
		 
	}
	
	@AfterMethod
	public void Logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logout : Successefully Logout!",true);
	}
	
	@AfterTest
	public void CloseDriver() {
		driver.close();
		Reporter.log("Close : Driver closed successfully!",true);
	}
	
	@AfterSuite
	public void DatabaseDisconect() {
		Reporter.log("DataBase : Database Disconnected successfully!",true);
	}
}
