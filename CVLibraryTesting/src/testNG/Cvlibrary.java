package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Cvlibrary {
	
	WebDriver bo;
	
  @Test
  public void TC_00001() throws InterruptedException {
	    bo = new ChromeDriver();
	  
	    bo.manage().window().maximize();
		bo.manage().deleteAllCookies();
		Actions action = new Actions(bo);
		
		
		//bo.findElement(By.xpath("//body[1]/div[9]/iframe[1]")).click();
		
		bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[1]/input[1]")).sendKeys("Software Tester");
		bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[2]/input[1]")).sendKeys("Ruislip, Greater London");
		Select distanceobject = new Select(bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[3]/select[1]")));
		distanceobject.selectByIndex(3);
		action.moveToElement(bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[2]/button[1]"))).perform();
		Thread.sleep(3000);
		
		bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[2]/button[1]")).click();
		Thread.sleep(3000);
		bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/input[1]")).sendKeys("30000");
		Thread.sleep(3000);
		bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[2]/input[1]")).sendKeys("40000");
		
		Select salarytype = new Select(bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[3]/select[1]")));
		salarytype.selectByIndex(3);
		Thread.sleep(3000);
		
		Select jobtype = new Select(bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[4]/select[1]")));
		jobtype.selectByIndex(2);
		
		Thread.sleep(2000);
		bo.findElement(By.xpath("//body[1]/main[1]/div[1]/section[1]/div[1]/form[1]/div[1]/input[1]")).click();
		
		System.out.println(bo.getTitle());
		if(bo.getTitle().equals("Job Search - Find 175,000 UK jobs on CV-Library")) {

			System.out.println("PASS");
		}
		
		else{
			System.out.println("FAIL");
		}
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "/Users/vikaskumar/Documents/Seleniumjar's/chromedriver");
		
		bo.get("https://www.cv-library.co.uk");
  }

  
  @AfterTest
  public void afterTest() {
	  
	  bo.close();
  }

}
