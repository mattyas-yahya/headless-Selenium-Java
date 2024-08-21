package com.mycompany.selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputSelenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

//buat file .txt buat ngisi data yg mau di kirim,lalu ctrl+s saja
        String filePath = "registerData.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                driver.get("https://xxxxxxxxxxxxx.com/register");
                driver.findElement(By.id("email")).sendKeys(data[0]);
                driver.findElement(By.id("username")).sendKeys(data[1]);
                driver.findElement(By.id("contact")).sendKeys(data[2]);
                driver.findElement(By.id("password")).sendKeys(data[3]);
                driver.findElement(By.id("confirm_password")).sendKeys(data[4]);

                WebElement buttonElement = driver.findElement(By.tagName("button"));
                buttonElement.click();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.print(e);
        } finally {
            driver.quit();
        }
    }
}
