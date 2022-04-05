package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TelevisionValidation {
	static WebDriver driver;
	static String text;
	static String tn;
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	}

	@Given("user closes the login tab")
	public void user_closes_the_login_tab() {
		WebElement close = driver.findElement(By.xpath("//button[contains(@class,'2doB4z')]"));
		close.click();
	}

	@When("user search television")
	public void user_search_television() {
		tn = "oneplus tv";
		WebElement srch = driver.findElement(By.name("q"));
		srch.sendKeys(tn,Keys.ENTER);
	}

	@When("user clicks the television")
	public void user_clicks_the_television() {
		WebElement option = driver.findElement(By.xpath("(//div[contains(text(),'LED Smart')])[1]"));
		text = option.getText();
		option.click();
	}
	
	@Then("user validates the television names")
	public void user_validates_the_television_names() {  
		String pw = driver.getWindowHandle();
		Set<String> cw = driver.getWindowHandles();
		for(String x : cw) {
			if (!pw.equals(cw)) {
				driver.switchTo().window(x);
			}
		}
		WebElement tv = driver.findElement(By.xpath("//span[contains(text(),'LED Smart')]"));
		String text1 = tv.getText();
		Assert.assertEquals(text, text1);
	}
	@When("user search television using one dime list")
	public void user_search_television_using_one_dime_list(DataTable dataTable) {
		WebElement srch = driver.findElement(By.name("q"));
		List<String> tvlist = dataTable.asList();
		tn = tvlist.get(1);
	    srch.sendKeys(tn, Keys.ENTER);
	}
	@When("user search television using one dime Map")
	public void user_search_television_using_one_dime_Map(DataTable dataTable) {
		WebElement srch = driver.findElement(By.name("q"));
		Map<String, String> tvMap = dataTable.asMap(String.class, String.class);
		tn =tvMap.get("2");
		srch.sendKeys(tn, Keys.ENTER);
	}
	@When("user search television {string}")
	public void user_search_television(String Televisions) {
		tn = Televisions;
		WebElement srch = driver.findElement(By.name("q"));
		srch.sendKeys(tn,Keys.ENTER);
	}
	
}
