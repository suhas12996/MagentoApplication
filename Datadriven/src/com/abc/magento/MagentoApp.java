package com.abc.magento;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagentoApp
{
public static void main(String [] args)throws Exception {
	FileInputStream fis=new FileInputStream("C:\\Users\\SUHAS\\eclipse-workspace\\test\\Datadriven\\src\\com\\abc\\utilities\\data.properties");
	Properties p=new Properties();
	p.load(fis);
	String url=p.getProperty("url");
	String un=p.getProperty("un");
	String pwd=p.getProperty("pwd");
System.out.println("the url is:"+url);
System.out.println("the un is:"+un);
System.out.println("the pwd is:"+pwd);
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get(url);
Thread.sleep(3000);
driver.findElement(By.linkText("My Account")).click();
driver.findElement(By.id("email")).sendKeys(un);
driver.findElement(By.id("pass")).sendKeys(pwd);
driver.findElement(By.id("send2")).click();
Thread.sleep(3000);
driver.findElement(By.linkText("Log Out")).click();
Thread.sleep(3000);
driver.quit();
}
}

