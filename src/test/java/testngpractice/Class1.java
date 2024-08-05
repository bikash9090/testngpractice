package testngpractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import listeners.CustomListerns;

@Listeners(CustomListerns.class)
public class Class1 extends BaseClass {

	@Parameters({ "url" })
	@BeforeClass
	public void init(String url) {
		driver.get(url);
	}

	@Test
	public void class1Method1() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div/div/a[1]")).click();
		Assert.assertFalse(true);
		System.out.println("This is class 1 method 1");
	}

	@Test()
	public void class1Method2() throws InterruptedException {

//		Alert alert = driver.switchTo().alert();
//		alert.dismiss();

		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div/div/a[1]")).click();
		System.out.println("This is class 1 method 2");
	}

	@Test
	public void class1Method3() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div/div/a[2]")).click();
		System.out.println("This is class 1 method 3");
		Thread.sleep(6000);
	}

}
