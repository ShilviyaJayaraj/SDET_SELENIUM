package Homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadProgram {
         public static void main(String[] args) {
        	  
        	 ChromeOptions options=new ChromeOptions();
        	 options.addArguments("--remote-allow-origins=*");
        	 WebDriverManager.chromedriver().setup();
        	 WebDriver driver=new ChromeDriver(options);
        	 driver.manage().window().maximize();
        	 driver.get("http://leaftaps.com/opentaps/control/login");
        	 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        	 driver.findElement(By.id("password")).sendKeys("crmsfa");
        	 driver.findElement(By.className("decorativeSubmit")).click();
        	 driver.findElement(By.partialLinkText("CRM/SFA")).click();
        	 driver.findElement(By.partialLinkText("Leads")).click();
        	 driver.findElement(By.linkText("Create Lead")).click();
        	 
        	 
        	 driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
        	 driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Shilviya");
        	 driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Dhanwansh");
        	 driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Shilviya");
        	 driver.findElement(By.name("departmentName")).sendKeys("Engineering");
        	 driver.findElement(By.name("description")).sendKeys("Selenium Testing Program");
        	 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ABCDEFgh@gmail.com");
        	 WebElement dropdown=driver.findElement(By.name("generalStateProvinceGeoId"));
        	 Select select=new Select(dropdown);
        	 select.selectByVisibleText("New York");
        	 driver.findElement(By.name("submitButton")).click();
        	 
        	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        	 driver.findElement(By.linkText("Edit")).click();
        	 driver.findElement(By.id("updateLeadForm_description")).clear();
        	 driver.findElement(By.name("importantNote")).sendKeys("Edit description");
        	 driver.findElement(By.name("submitButton")).click();
        	 String title=driver.getTitle();
        	 String compare1="View Lead | opentags CRM";
        	StringBuffer compare=new StringBuffer("View Lead | opentags CRM");
        	compare.equals(title);
        	
        	System.out.print(" Resulting title is validated");
         }
}
