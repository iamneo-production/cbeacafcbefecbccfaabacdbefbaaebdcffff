package ai.iamneo.testing.Testing_Selenium_TestNg;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppTest {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception {
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
	}

	@Test
	public void testcase_1() throws InterruptedException //Go to Ebay
	{
		driver.navigate().to("https://www.flipkart.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		//String title = "Get the Title";
		//Assert.assertEquals(title, " ");
	}

	@Test
	public void testcase_2() throws InterruptedException 
      {
	       //write Your Code here to Login
             /*int nlinks=10;//   //Get the Number of links
		 int get = 0;*/
		 List<WebElement> links=driver.findElements(By.tagName("a"));
		 int get=links.size();
		//System.out.println(get);// 368
		Assert.assertEquals(get,368);
		String allText=driver.findElement(By.xpath("//body")).getText();
		System.out.println(allText);
		for(WebElement linktotal:links)
		{
			System.out.println(linktotal.getText());
		}

	}

		
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
