package com.uitest.challenge.test;


import com.uitest.challenge.test.pages.SpeedTestPage;
import com.uitest.challenge.test.pages.GoogleTestPage;

import com.uitest.challenge.SpringBootApp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Raj
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AllTest {

    public static WebDriver driver;
    SpeedTestPage speedtest;
    GoogleTestPage googleTest;



    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @Rule
    public ScreenshotRule4 rule = new ScreenshotRule4(driver, "target/surefire-reports/");

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
       }
    }


    @Test
    public void testSpeed()  {
        speedtest = new SpeedTestPage(driver);
        speedtest.goToURL();
        speedtest.clickOnGoButton();
        speedtest.waitforResultsBox();
       float s = Float.parseFloat(speedtest.getDownloadSpeed());
       Assert.assertTrue(s > 1.00);
    }

    @Test
    public void testSearches()  {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
      googleTest = new GoogleTestPage(driver);
      googleTest.goToURL("http://www.google.com");
      googleTest.searchStringAndGo(generatedString);
      int searchResult_1 = googleTest.getResults();
      Assert.assertTrue(searchResult_1 >= 1);
        }
}
