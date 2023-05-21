package com.mycompany.selenium_java;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ArrayInputSelenium
 {
    public static void main(String[] args) 
    {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        String[][] registerData = 
        {
          {"xxxxxx1@gmail.com", "xxxxx", "123456789","123456789","123456789"},
          {"xxxxxx2@gmail.com", "dddddd", "123456789","123456789","123456789"},
          {"xxxxxx3@gmail.com", "fffffff", "123456789","123456789","123456789"},
          {"xxxxxx4@gmail.com", "bbbbbb", "123456789","123456789","123456789"}
        };
        try {
        for (String[] data : registerData) 
        {
          driver.get("https://xxxxxxxxxxxxx.com/register");
         driver.findElement(By.id("email")).sendKeys(data[0]);
           driver.findElement(By.id("username")).sendKeys(data[1]);
         driver.findElement(By.id("contact")).sendKeys(data[2]);
         driver.findElement(By.id("password")).sendKeys(data[3]);
           driver.findElement(By.id("confirm_password")).sendKeys(data[4]);
          WebElement buttonElement = driver.findElement(By.tagName("button"));
          buttonElement.click();
      }
      driver.quit();
    } catch (org.openqa.selenium.StaleElementReferenceException e) 
    {
System.out.print(e);
  }
    }
}
