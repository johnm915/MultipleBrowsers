package com.spin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//using web-driver Manager
public class webDriverManager {

    private WebDriver driver;
    @BeforeAll
    static void oneTimeSetUp() {
        WebDriverManager.chromedriver().setup();

    }
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }
    @Test
    void test(){
        driver.get("https://google.com");
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }

}
