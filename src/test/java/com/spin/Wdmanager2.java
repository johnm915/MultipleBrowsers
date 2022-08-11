package com.spin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Wdmanager2 {
    private WebDriver driver;

    @Test
    void openChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }
    @Test
    void openFireFox() {
        WebDriverManager.firefoxdriver();
        driver = new FirefoxDriver();
        driver.get("https://google.com");
    }
    @Test
    void openEdge() {
        WebDriverManager.edgedriver();
        driver = new EdgeDriver();
        driver.get("https://www.google.com");
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
