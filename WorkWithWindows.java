package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// To Download and set the path 
	    WebDriverManager.chromedriver().setup();
				
		// To Lunch the chrome browser
		WebDriver driver = new ChromeDriver();
				
		//To Launch the URL
		driver.get("http://www.leafground.com/pages/Window.html");
		
		//To maximize Window
		driver.manage().window().maximize();
		
		//To Click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		
		//To Handle Windows
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windows = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windows.get(1));
		
		//To print the title of the Secondary Window
		String title = driver.getTitle();
		
		System.out.println("Title of Secondary window: " + title);
		
		driver.switchTo().window(windows.get(0));
		
		//To Open Multiple Windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		//To Find the number of opened windows
        Set<String> windowHandles1 = driver.getWindowHandles();
		
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		
		System.out.println("No.of Opened Windows : " + windows1.size());
		
		//To Close all windows except Primary Window
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		
        Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> windows2 = new ArrayList<String>(windowHandles2);

		for(int i=1; i<windows2.size(); i++)
		{
			driver.switchTo().window(windows2.get(i));
			
			driver.close();
		}
		
		//To Switch to Primary Window
		driver.switchTo().window(windows2.get(0));
		
		//To Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		System.out.println("Waited for 2 new Windows to get opened");

	}

}
