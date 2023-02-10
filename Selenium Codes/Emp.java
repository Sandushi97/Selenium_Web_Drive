package Employee;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Emploee {
	WebDriver driver=new ChromeDriver();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		Emploee emp=new Emploee();
		emp.openChrome();
		emp.login("admin", "admin123");
		emp.clickEmployee();
		emp.searchEmployee("mario");
		emp.addEmployee();
		emp.editUser();
		emp.deleteUser();
		emp.close();
	}

	public void openChrome() {
		String url="http://localhost/employee/admin/index.php";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	public void login(String username,String password) {
		WebElement user=driver.findElement(By.xpath("//*[@id=\"login-frm\"]/div[1]/input"));
		user.sendKeys(username);
		
		WebElement pwd=driver.findElement(By.xpath("//*[@id=\"login-frm\"]/div[2]/input"));
		pwd.sendKeys(password);
		
		if((user.getAttribute("value").equals("admin")) && (pwd.getAttribute("value").equals("admin123")) || (user.getAttribute("value").equals("sample")) && (pwd.getAttribute("value").equals("sample123") )){
			
			System.out.println("Successfully logged to employee!");
		}
		 else {
			 System.out.println("Incorrect username and password! ");
		 }
		
		if(user.getAttribute("value").isEmpty()) {
			System.out.println("Username is Empty!");
		}
		else if(pwd.getAttribute("value").isEmpty()) {
			System.out.println("Password is Empty!");
		}
		 
		
		else {
			WebElement clickLogin=driver.findElement(By.xpath("//*[@id=\"login-frm\"]/button[1]"));
			clickLogin.click();
		}
		
	}
	public void clickEmployee() {
		WebElement clickEmp=driver.findElement(By.xpath("//a[@href=\"employee.php\"]"));
		clickEmp.click();
	}
	public void searchEmployee(String name) {
		WebElement search =driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input"));
		search.sendKeys(name);
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		search.clear();
//		search.click();
	}
	public void addEmployee() {
		WebElement addemp =driver.findElement(By.xpath("//*[@id=\"new_emp_btn\"]"));
		addemp.click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement fname=driver.findElement(By.xpath("//*[@id=\"employee_frm\"]/div[1]/div[1]/input[2]"));
		fname.sendKeys("Sandushi");
		
		WebElement mname=driver.findElement(By.name("middlename"));
		mname.sendKeys("Udara");
		
		WebElement lname=driver.findElement(By.name("lastname"));
		lname.sendKeys("Rathnayaka");
		
		WebElement dep=driver.findElement(By.name("department"));
		dep.sendKeys("Computer Science");
		
		WebElement pos=driver.findElement(By.name("position"));
		pos.sendKeys("Lecturer");
		
		if(fname.getAttribute("value").isEmpty()) {
			System.out.println("Firstname is empty");
		}

		else if(lname.getAttribute("value").isEmpty()) {
			System.out.println("Lastname is empty");
		}
		else if(dep.getAttribute("value").isEmpty()) {
			System.out.println("Department is empty");
		}
		else if(pos.getAttribute("value").isEmpty()) {
			System.out.println("Position is empty");
		}
		else {
			WebElement save=driver.findElement(By.xpath("//*[@id=\"employee_frm\"]/div[2]/button"));
			save.click();
			//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message=driver.switchTo().alert().getText();
			System.out.println(message);
			
			driver.switchTo().alert().dismiss();
		}
	}
	
	public void editUser() {
//		driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[5]/td[7]/center/button[1]")).click();
//		WebElement edit=driver.findElement(By.xpath("//*[@id=\"employee_frm\"]/div[1]/div[1]/input[2]"));
//		edit.clear();
//		edit.sendKeys("Sachini");
//		driver.findElement(By.xpath("//*[@id=\"employee_frm\"]/div[2]/button")).click();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String m1=driver.switchTo().alert().getText();
//		System.out.println(m1);
//		driver.switchTo().alert().dismiss();
		searchEmployee("Sandushi");
		WebElement edit=driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[7]/center/button[1]"));
		edit.click();
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("Sachini");
		driver.findElement(By.xpath("//*[@id=\"employee_frm\"]/div[2]/button")).click();
		try {
			Thread.sleep(1000);
	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String m1=driver.switchTo().alert().getText();
		System.out.println(m1);
		driver.switchTo().alert().dismiss();
		
		
	}
	
	public void deleteUser() {
		searchEmployee("Sachini");
		driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[7]/center/button[2]")).click();
		String m2=driver.switchTo().alert().getText();
		System.out.println(m2);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String m3=driver.switchTo().alert().getText();
		System.out.println(m3);
		driver.switchTo().alert().accept();
	}
	
	public void close() {
		driver.quit();
	}


	
	

}

