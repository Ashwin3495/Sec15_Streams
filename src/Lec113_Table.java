import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lec113_Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//1. CLick on columns
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//2. Get data into a list
		List<WebElement> list=driver.findElements(By.xpath("//tr/td[1]"));
		
		//3. Get data into a new list as string 
		List<String> orginalList=list.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//4.Sort the original list
		List<String> sorted=orginalList.stream().sorted().collect(Collectors.toList());
		
		//5.Compare original vs Sorted
		Assert.assertTrue(orginalList.equals(sorted),"Compared");
		
		List<String> price=list.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		
		
		
	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String a=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return a;
		
	}

}
