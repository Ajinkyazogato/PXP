package MavenJavaSelProj.MavenJavaSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

public class PxpTest {
 public static void main(String[] args) throws Exception {
	 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ajinkya.dhobale\\Downloads\\chromedriver.exe");
  
        WebDriver	driver = new ChromeDriver();
		driver.get("https://int.contentserv.com/qa-8/");
		Thread.sleep(9000);
		driver.findElement(By.id("userNameField")).sendKeys("admin");
		Thread.sleep(9000);
		driver.findElement(By.id("userPasswordField")).sendKeys("admin");
		Thread.sleep(9000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/button[1]")).click();
}
}
