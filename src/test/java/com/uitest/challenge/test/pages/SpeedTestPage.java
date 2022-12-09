package com.uitest.challenge.test.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpeedTestPage {
   WebDriver driver;
   By goButton = By.xpath("//span[@class=\"start-text\"]");
   By resultsContainer = By.xpath("//div[@class=\"result-container-speed result-container-speed-active\"]");
   By downloadspeed = By.className("result-data-large");

    public SpeedTestPage(WebDriver driver){
        this.driver = driver;

    }
    public void clickOnGoButton(){
        driver.findElement(goButton).click();
    }

    public void waitforResultsBox(){
        Duration seconds = Duration.ofSeconds(60);

        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsContainer));
    }

    public String getDownloadSpeed(){
        return   driver.findElement(downloadspeed).getText();

    }

    public void goToURL(){
        driver.get("http://www.speedtest.net");
    }
}

