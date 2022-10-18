import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayProducts {
	WebDriver driver=new ChromeDriver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EbayProducts ebay=new EbayProducts();
		ebay.OpenBrowser();
		
		
		ebay.EnterProduct("Apple Watch","cell phones & Accessories");
		ebay.Search();
		ebay.Print();
		ebay.PrintNthResult(5);
		ebay.PrintAllProducts();
		ebay.printAllResultWithScroll();

	}
	//*[@id="srp-river-results"]/ul/li[6]
	//(1)A method to open the Browser
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	/*public void EnterProduct() {
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Apple Watches");
	}*/
	//(2)A method to enter a product in search bar
	public void EnterProduct(String Product,String Category) {
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys(Product);
		driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")).sendKeys(Category);
		
		
		
	}
	//(3)A method to search 
	public void Search() {
		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
	}
	//(4)A method to print all Results
	public void Print() {
		String results = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div[1]/div[1]/h1")).getAttribute("textContent");
		System.out.println(results);
		
	}
	//(5)A method to  print Nth product details
	public void PrintNthResult(int number) {
		number=number+1;
		WebElement product=driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li["+number+"]")); 
		String aa=product.getText();
		System.out.println("##############################################################################################################");
		System.out.println(aa);
		System.out.println("##############################################################################################################");
		
	}
	

	/*public void printNthResult(int num) {
		List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
		int count = 0;
		for( WebElement product : allProducts){
			
			if(count == num) {
				System.out.println("*********************************************************************");
				
				System.out.println(product.getText());

				System.out.println("*********************************************************************");
			}
			count++;
			
			
			}
	}*/
	
	//(6)A method to print All Products from 1st page
	public void PrintAllProducts() {
		WebElement allProductElement=driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
		String bb=allProductElement.getText();
		System.out.println(bb);
		System.out.println("###############################################################################################");
	}
	//(7) a method to print all products along with scroll down
	public void printAllResultWithScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
		int count = 1;
		
		for( WebElement product : allProducts){
			
			
			
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li["+count+"]")));
			
			System.out.println("*********************************************************************");
			
			System.out.println(product.getText());

			System.out.println("*********************************************************************");
			
			count++;
		}
   
	}

}
