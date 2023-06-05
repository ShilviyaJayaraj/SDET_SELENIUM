package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadProgram {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		// get USername and password by Id
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	//	driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
	    driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
	    driver.findElement(By.id("createLeadForm_firstName")).sendKeys("shilviya");
	    driver.findElement(By.id("createLeadForm_lastName")).sendKeys("jayaraj");
	    driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("shilviya");
	    driver.findElement(By.name("departmentName")).sendKeys("Testing");
	    driver.findElement(By.name("description")).sendKeys("Selenium Program test dry run");
	    
	    driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testleaf@gmail.com");
	    
	    WebElement dropdown=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	    Select select=new Select(dropdown);
	    select.selectByVisibleText("New York");
	    driver.findElement(By.xpath("//input[contains(@value, 'Create Lead')]")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    String title=driver.getTitle();
	    //String actualtitle="View Lead | opentags CRM";
	    StringBuffer sb=new StringBuffer("\"View Lead | opentags CRM\"");
	    sb.equals(title);
	    System.out.print(title);
    }

	}