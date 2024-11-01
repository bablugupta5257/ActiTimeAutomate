package ActiTimeProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersForSS.class)
public class TestActiTime extends BaseClass{
	

	@Test(groups= {"Smoke","Regression"}, priority=1)
	public void ClickOnTask() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//div[.='Tasks']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[.='Add New']")).click();
		driver.findElement(By.xpath("//div[.='New Customer']")).click();
		Thread.sleep(5000);
		LoginPropertyFile l = new LoginPropertyFile();
		 String cname = l.DataFromExel("Sheet1", 3, 1);
		String cDetail = l.DataFromExel("Sheet1", 3, 3);
		//	driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")).sendKeys(cname);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(cDetail);
		 WebElement DropDownAddCutomer = driver.findElement(By.xpath("(//div[.='- Select Customer -'])[1]"));
		 DropDownAddCutomer.click();
		 Thread.sleep(3000);
		
		 driver.findElement(By.xpath("//div[@class='searchItemList']/div[6]")).click();
		  Thread.sleep(3000);
	//	Select s = new Select(DropDownAddCutomer);
		//s.selectByVisibleText("Our company");
		driver.findElement(By.xpath("//div[.='Create Customer']")).click();
		Reporter.log("CLick on task And new Customer created successfully!",true);
		Thread.sleep(3000);
	} 
	
	@Test(groups= {"Smoke"}, priority=2)
	public void ClickOnReport() throws InterruptedException {
		driver.findElement(By.xpath("//div[.='Reports']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[.='New Report']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='Create Chart']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("closeCreateChartLightboxButton")).click();
		Reporter.log("Clicking on report , new report, create chart and close");
		
	}
	
	@Test(groups= {"Smoke"} ,priority=3)
	public void ClickOnUser() throws InterruptedException {
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
