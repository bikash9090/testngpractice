package testngpractice;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Class2 {

	WebDriver driver;

	@BeforeClass
	public void init() {
		
		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9222");
        
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("file://D:/DEMO-PAGES/settings.html");
	}

	@AfterClass
	public void close() throws InterruptedException {
//		Thread.sleep(4000);
//		driver.quit();
	}

	@Test
	public void class2Method1() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div/div/a[1]")).click();
		System.out.println("This is class 1 method 1");

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("file://D:/DEMO-PAGES/profile.html");

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("file:///D:/DEMO-PAGES/home.html");
		
		manageBrowserTabs(0);

	}

	@Test(dependsOnMethods = "class2Method1")
	public void manageBrowserTabs(int tabNo) {
		Set<String> browserTabs = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(browserTabs);

		if (tabNo < tabs.size()) {
			driver.switchTo().window(tabs.get(tabNo));
			driver.get("file:///D:/DEMO-PAGES/alerts_demo.html");
		}
	}

	@Test(enabled = false)
	public void class2Method2() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div/div/a[1]")).click();
		System.out.println("This is class 1 method 2");
	}

	@Test(enabled = false)
	public void class2Method3() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
		System.out.println("This is class 1 method 3");
		Thread.sleep(6000);
	}
}
