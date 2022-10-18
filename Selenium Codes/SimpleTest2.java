import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practical2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver;
		driver= new ChromeDriver();
		
		driver.navigate().to("file:///D:/3rd%20year/2nd%20Semester/practical%20SQA/index.html");
		
		driver.manage().window().maximize();
		// To check using web element
		WebElement element=driver.findElement(By.name("f_name"));
		element.sendKeys("Joshep Vijay");
		WebElement element1=driver.findElement(By.name("lname"));
		element1.sendKeys("Chandrasekar");
		WebElement element2=driver.findElement(By.name("dob"));
		element2.sendKeys("06-22-1974");
		WebElement element3=driver.findElement(By.id("email"));
		element3.sendKeys("vijay@yahoo.com");
		WebElement element4=driver.findElement(By.name("phnno"));
		element4.sendKeys("+91677654321");
		WebElement element5=driver.findElement(By.id("adrs"));
		element5.sendKeys("64, Kaveri Street, Saligramam, Chennai 600093, Tamil \r\n"
				+ "Nadu, India");
		
		//driver.findElement(By.id("male")).click();
		//driver.findElement(By.name("hobby_1")).click();
		//driver.findElement(By.name("hobby_2")).click();
		
		WebElement radio=driver.findElement(By.id("male"));
		radio.click();
		
		WebElement checkbox1=driver.findElement(By.name("hobby_1"));
		checkbox1.click();
		
		WebElement checkbox2=driver.findElement(By.name("hobby_2"));
		checkbox2.click();
		
		//driver.findElement(By.id("subject")).sendKeys("B.Tech");
		WebElement select=driver.findElement(By.id("subject"));
		select.sendKeys("B.Tech");
		
		String pswd="vijay@12345";
		String rypw="vijay@12345";
		driver.findElement(By.name("pswd")).sendKeys(pswd);
		driver.findElement(By.id("rypw")).sendKeys(rypw);
		if(pswd==rypw) {
			System.out.println("Password are equal");
			driver.findElement(By.name("result")).sendKeys("2A and B");
			driver.findElement(By.name("z_score")).sendKeys("1.225");
			driver.findElement(By.name("d_rank")).sendKeys("1");
		}
			
		
		else {
			System.out.println("Password are not equal");
		}
			
		
	}

}
