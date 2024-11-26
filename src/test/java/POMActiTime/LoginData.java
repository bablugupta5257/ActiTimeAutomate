package POMActiTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActiTimeProject.BaseClass;


public class LoginData extends BaseClass{

	@FindBy(id="username")
	private WebElement un;
	
	@FindBy(name="pwd")
	private WebElement pass;
	
	public LoginData(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getUn() {
		return un;
	}

	public WebElement getPass() {
		return pass;
	}
	
	
	
}
