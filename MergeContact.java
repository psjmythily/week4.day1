package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// To Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// To Launch the chromebrowser
		WebDriver driver = new ChromeDriver();
		
		//To Launch the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//To Maximise the window
		driver.manage().window().maximize();
		
		//To add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//To Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		//To Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//To Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//To Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//To Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//To Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//To  Click on Widget of From Contact
		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdFrom']//following::img")).click();
		
		//To Handle Windows
		Set<String> windowHandles = driver.getWindowHandles();
		
		//To Convert Set to List
		List<String> windows = new ArrayList<String>(windowHandles);
		
		//To Switch to Secondary Window
		driver.switchTo().window(windows.get(1));

		//To Click on First Resulting Contact
		driver.findElement(By.linkText("17147")).click();
		
		//To Move to Primary Window 
		driver.switchTo().window(windows.get(0));
		
		//To Click on Widget of To Contact
		driver.findElement(By.xpath("//input[@name='ComboBox_partyIdTo']//following::img")).click();
		
		//To Handle Windows
		Set<String> windowHandles1 = driver.getWindowHandles();
		
		//To Convert Set to List
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		
		//To Switch to Secondary Window
		driver.switchTo().window(windows1.get(1));
		
		//To Click on Second Resulting Contact
		driver.findElement(By.linkText("DemoCustomer")).click();
		
		//To Move to Primary Window
		driver.switchTo().window(windows1.get(0));
		
		//To Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//To . Accept the Alert
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		//To  Verify the title of the page
		String title = driver.getTitle();
		if(title.contains("View Contact | opentaps CRM"))
		{
			System.out.println("Merge contact is successfully done");
		}
		else
		{
			System.out.println("Merge Contact is unsuccessful");
		}	
	}
}
