package learnseleniumArtifact;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HomeWork {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\David\\eclipse-workspace\\learnseleniumArtifact\\Driver\\chromedriver.exe");
		
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");
		WebDriver driver = new ChromeDriver(option);
		//driver = new ChromeDriver(option);
		WebDriverManager.chromedriver().setup();
		
		//Login to JIRA in incognito
		driver.get("https://sivasdetteam3.atlassian.net/jira/your-work");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// login
		
		driver.findElement(By.name("username")).sendKeys("shilviyajayaraj86@gmail.com");
		//driver.findElement(By.xpath("//button[@id='login-submit']/span")).click();
	//	driver.findElement(By.xpath("//span[text()=\"Continue with Google\"]")).click();
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password' and @type='password']")).sendKeys("Shilviya@123");
		//Thread.sleep(1000);
		//login.click();
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//span[text()=\'Projects\']")).click();
		//driver.findElement(By.xpath("//span[text()=\'View all projects\']")).click();
		
		
		//Invalid project
		
		driver.findElement(By.xpath("//span[text()='Projects']")).click();
        driver.findElement(By.xpath("(//span[text()='View all projects'])")).click();
        Thread.sleep(10000);
		driver.findElement(By.name("search")).sendKeys("test");
		Thread.sleep(10000);
        String compareError = driver.findElement(By.xpath("//h4[text()='No projects were found that match your search']")).getText();
        Thread.sleep(10000);
		assertEquals("No projects were found that match your search", compareError);
		
		
		
		//valid project
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[@aria-label=\"Clear\"]")).click();
		driver.findElement(By.name("search")).sendKeys("SDETTeamThreePractice");
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[text()='SDETTeamThreePractice']")).click();
		Thread.sleep(5000);
		 String list = driver.findElement(By.xpath("//div[contains(text(), 'To Do')]")).getText();
		    System.out.println(list);
		    String issues = driver.findElement(By.xpath("//h2[contains(@aria-label, 'To Do')]//following-sibling::div[contains(text(), 'issues')]")).getText();
		    System.out.println(issues);
		    String countofIssues = driver.findElement(By.xpath("//span[contains(@style, 'hidden') and contains(text(), '')]")).getText();
		  //Collect the list of issues in the board
		    System.out.println("The list of issues are : " + countofIssues + issues);
		  //Open a new tab and Create a new issues
		   driver.switchTo().newWindow(WindowType.WINDOW);
		
	}
}
