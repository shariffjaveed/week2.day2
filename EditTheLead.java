package week2.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditTheLead 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		

		driver.findElement(By.xpath("//label[text()='First name:']//following::input[@name='firstName'][3]")).sendKeys("Javeed");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a[1]")).click();
		String currentTitle = driver.getTitle();
		String expectedTitle = "View Lead | opentaps CRM";
		
		if(currentTitle.contentEquals(expectedTitle))
			System.out.println("The loaded title has verified successfully");
			else
				System.out.println("This is not expected title");
		
		driver.findElement(By.linkText("Edit")).click();
		
		WebElement newCompany = driver.findElement(By.id("updateLeadForm_companyName"));
		newCompany.clear();
		String companyName = "Cognizant";
		newCompany.sendKeys(companyName);
		driver.findElement(By.name("submitButton")).click();
		
		String updatedCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(updatedCompany);
		
		if(updatedCompany.contains(companyName))
			System.out.println("The company name updated successfully");
		else
			System.out.println("The company name not updated");
		
		driver.close();
		
		
}
}
	
