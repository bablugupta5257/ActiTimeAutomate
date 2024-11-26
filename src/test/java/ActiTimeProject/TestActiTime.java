package ActiTimeProject;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentRepoertForActiTIme.class)
public class TestActiTime extends BaseClass{
	

	@Test(groups= {"Smoke","Regression"}, priority=1)
	public void ClickOnTask() throws InterruptedException, IOException {
		long threadID = Thread.currentThread().getId();
		Reporter.log("The current thread id is: "+threadID);
		driver.findElement(By.xpath("//div[.='Tasks']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[.='Add New']")).click();
		driver.findElement(By.xpath("//div[.='New Customer']")).click();
		Thread.sleep(5000);
		LoginPropertyFile l = new LoginPropertyFile();
		 String cname = l.DataFromExel("Sheet1", 2, 1);
		String cDetail = l.DataFromExel("Sheet1", 2, 3);
		//	driver.switchTo().frame(0);
		 WebElement cnames = driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']"));
		 WebElement cdetails = driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']"));
		 WebElement DropDownAddCutomer = driver.findElement(By.xpath("(//div[.='- Select Customer -'])[1]"));
		 DropDownAddCutomer.click();
		 Thread.sleep(3000);
		
		 WebElement compname=driver.findElement(By.xpath("//div[contains(text(),'Copy Projects from an Existing Customer:')]/../div[2]/span/div/div[2]/div/div/div/div[4]"));
		  Thread.sleep(3000);
	cnames.sendKeys(cname);
	Thread.sleep(1000);
	cdetails.sendKeys(cDetail);
	Thread.sleep(2000);
	compname.click();
	Thread.sleep(2000);
	cnames.clear();
	Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='greyButton cancelBtn']")).click();
		  driver.switchTo().alert().accept();
		Reporter.log("CLick on task And new Customer created successfully!",true);
		Thread.sleep(3000);
	} 
	
	@Test(groups= {"Smoke"}, priority=2)
	public void ClickOnReport() throws InterruptedException {
		long threadID = Thread.currentThread().getId();
		Reporter.log("The current thread id is: "+threadID);
		driver.findElement(By.xpath("//div[.='Reports']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[.='New Report']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='Create Chart']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='closeCreateChartLightboxButton']")).click();
		Reporter.log("Clicking on report , new report, create chart and close");
		
	}
	
	@Test(groups= {"Smoke"} ,priority=3)
	public void ClickOnUser() throws InterruptedException  {
		long threadID = Thread.currentThread().getId();
		Reporter.log("The current thread id is: "+threadID);
		driver.findElement(By.xpath("//div[.='Users']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),' Accounts & Permissions ')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'PTO Settings')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Sick Days Settings')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Work Assignments')]")).click();
		driver.findElement(By.xpath("//div[.='New User']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='closeButton hideButton_panelContainer']")).click();
		Thread.sleep(3000);
		
		
	}
	
	
}
