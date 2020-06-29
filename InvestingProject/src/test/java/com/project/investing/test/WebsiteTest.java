package com.project.investing.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebsiteTest{
	
	public static WebDriver driver;
	public static final String currentDir = System.getProperty("user.dir");
	
	public static void main(String args[])
	{
		String browserpath=new String();
		
		
		String url="https://www.investing.com/etfs/invesco-bulletshares-2028-corp-bond";

		if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
			browserpath = currentDir + "//Browsers//";
			System.setProperty("webdriver.chrome.driver", browserpath + "//chromedriver");
			
		} else if (Platform.getCurrent().toString().contains("WIN")) {
			browserpath = currentDir + "//Browsers//";
			System.setProperty("webdriver.chrome.driver", browserpath + "//chromedriver.exe");
		}

		
		driver=new ChromeDriver();	
		
		driver.get(url);
		
		

		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'popupCloseIcon largeBanner')]")));

		WebElement closebtn=driver.findElement(By.xpath("//i[contains(@class,'popupCloseIcon largeBanner')]"));
		closebtn.click();
		
		driver.findElement(By.linkText("Historical Data")).click();
		
		WebElement daterange=driver.findElement(By.id("widgetFieldDateRange"));
		daterange.click();
		
		WebDriverWait wait_1=new WebDriverWait(driver,40);
	
		wait_1.until(ExpectedConditions.elementToBeClickable(By.id("startDate")));
		WebElement startdate=driver.findElement(By.id("startDate"));
		startdate.clear();
		
		
		//startdate.sendKeys("05/29/2003");
		
		//selecting date by changing the year
		
		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix']//span[@class='ui-datepicker-year'][contains(text(),'2020')]")).click();
				
		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix']//span[@class='ui-datepicker-year'][contains(text(),'2020')]")).click();
		driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix']//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'2003')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Jun.')]")).click();
		
		driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-week-end')]//a[@class='ui-state-default'][contains(text(),'29')]")).click();
		WebElement applybtn=driver.findElement(By.xpath("//a[@id='applyBtn']"));
		applybtn.click();
		
		
		WebElement downloaddata=driver.findElement(By.xpath("//a[@data-table-id='curr_table']"));
		downloaddata.click();
		//driver.quit();
		
		
		driver.close();
	}
	
}