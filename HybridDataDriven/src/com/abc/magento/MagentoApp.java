package com.abc.magento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.ranges.RangeException;

public class MagentoApp {

	public static void main(String[] args) throws RangeException, Exception
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\SUHAS\\eclipse-workspace\\test\\HybridDataDriven\\src\\com\\abc\\utilites\\hybrid.properties");
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		String un=p.getProperty("un");
		String password=p.getProperty("password");
		String myacc=p.getProperty("myacc");
		String email=p.getProperty("email");
		String pwd=p.getProperty("pwd");
		String login=p.getProperty("login");
		String logout=p.getProperty("logout");
		System.out.println(url);
		System.out.println(un);
		System.out.println(password);
		System.out.println(myacc);
		System.out.println(email);
		System.out.println(pwd);
		System.out.println(login);
		System.out.println(logout);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath(myacc)).click();
		driver.findElement(By.xpath(email)).sendKeys(un);
		driver.findElement(By.xpath(pwd)).sendKeys(password);
		driver.findElement(By.xpath(login)).click();
		driver.findElement(By.xpath(logout)).click();
		Thread.sleep(3000);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\SUHAS\\eclipse-workspace\\test\\HybridDataDriven\\src\\com\\abc\\utilites\\hybrid.properties");
		p.setProperty("name", "Testing");
		p.save(fos, "Development without testing is impossible");
		driver.quit();

	}

}
