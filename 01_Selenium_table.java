package dynamicwebtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTest {

	@Test
	public void Table() {
		System.out.println("Starting ReadingTable");
		
//		Create driver
		
		WebDriver driver = new ChromeDriver();

		// sleep for 3 seconds
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();

//		open test page
		String url = "https://the-internet.herokuapp.com/challenging_dom";
		driver.get(url);
		System.out.println("Page is opened.");
		
		// sleep for 2 seconds
		sleep(2000);
		List<WebElement> cols = driver.findElements(By.xpath(".//*[@id=\"content\"]/div/div/div/div[2]/table/thead/tr/th"));
		int rowCount = cols.size();
		System.out.println("No of rows in this table : " + rowCount);

		//Finding number of Columns

		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr"));
		int columnCount = rows.size();
		System.out.println("No of columns in this table : " + columnCount);
		
		for (WebElement col : cols) {
			 List<WebElement> cells = col.findElements(By.tagName("td"));
			 
				 System.out.print("     " + col.getText());
			 }
		for (WebElement row : rows) {
			 List<WebElement> cells = row.findElements(By.tagName("td"));
			 		
			 
			 	 System.out.println("\n");	
				 System.out.println( row.getText());
			 }
			
		
		

		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
