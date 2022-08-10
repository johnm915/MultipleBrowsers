package com.spin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleBrowsers
{
    private WebDriver driver;
    private static String browser;

    @BeforeAll
    static void oneTimeSetUp() throws IOException {
        var prop = new Properties();
        //FileInputStream file = new FileInputStream("resources/browser.config");
        prop.load(new FileInputStream("Browser.config"));
        browser =  prop.getProperty("Browser");


    }
    @BeforeEach
    void setUp()
    {
        switch (browser)
        {
          case "chrome" ->{System.setProperty("webdriver.chrome.driver", "C:\\Users\\John\\OneDrive\\Desktop\\Drivers\\chromedriver.exe");
              driver = new ChromeDriver();}
           case "firefox"->{System.setProperty("webdriver.gecko.driver", "C:\\Users\\John\\OneDrive\\Desktop\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();}
            case "edge" ->{System.setProperty("webdriver.edge.driver", "C:\\Users\\John\\OneDrive\\Desktop\\Drivers\\msedgedriver.exe");
                driver = new EdgeDriver();}

        }

        driver.manage().window().maximize();
    }
    @Test
    void test() throws InterruptedException {
    driver.get("https://www.selenium.dev/");
    assertEquals("Selenium", driver.getTitle());
    Thread.sleep(3000);

    }
    @AfterEach()
    void tearDown(){
        driver.quit();
    }
}
