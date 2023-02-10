package registration_practice_today;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Student_Registration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String url="file:///D:/3rd%20year/2nd%20Semester/practical%20SQA/Practice_1/index.html";
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement fname=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		fname.sendKeys("Sandushi");
		
		WebElement lname=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		lname.sendKeys("Rathnayaka");
		
		WebElement dob=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input"));
		dob.sendKeys("7/27/1997");

		
		WebElement email=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input"));
		email.sendKeys("sandushirathnayaka@gmail.com");
		
		
		
		WebElement phone=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"));
		phone.sendKeys("0774145512");
		
		WebElement address=driver.findElement(By.xpath("//*[@id=\"adrs\"]"));
		address.sendKeys("Udawela Gedara,Divithotawela,Welimada");
		
		WebElement gender=driver.findElement(By.xpath("//*[@id=\"female\"]"));
		gender.click();
		
		WebElement hobby1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td[2]/input[1]"));
		hobby1.click();
		
		WebElement hobby2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td[2]/input[4]"));
		hobby2.click();
		
		Select course=new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[9]/td[2]/select")));
		course.selectByValue("MBA");
		
		//WebElement pwd=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[10]/td[2]/input"));
		//pwd.sendKeys("Rathnayaka1@");
		
		//WebElement retypepwd=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[11]/td[2]/input"));
		//retypepwd.sendKeys("Rathnayaka1@");
		
		String pwd="Rathnayaka1@";
		String retypepwd="Rathnayaka1@";


		//driver.findElement(By.xpath("/html/body/form/table/tbody/tr[10]/td[2]/input")).sendKeys(pwd);
				
		//driver.findElement(By.xpath("/html/body/form/table/tbody/tr[11]/td[2]/input")).sendKeys(retypepwd);
		WebElement password=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[10]/td[2]/input"));
		password.sendKeys(pwd);
		
		WebElement retypepwd1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[11]/td[2]/input"));
		retypepwd1.sendKeys(retypepwd);
		
		//System.out.println(password.getAttribute("value"));
		if(password.getAttribute("value").equals(retypepwd1.getAttribute("value"))) {
			System.out.println("Passwords are equal");
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[12]/td[2]/table/tbody/tr/td[2]/input")).sendKeys("2A and B");
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[12]/td[2]/table/tbody/tr/td[3]/input")).sendKeys("1.2225");
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[12]/td[2]/table/tbody/tr/td[4]/input")).sendKeys("1");
		}
		else {
			System.out.println("Passwords are not equal");
		}
		
	}

}
