package com.uitest.challenge.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GoogleTestPage {
    WebDriver driver;
    By results = By.xpath("//div[@id=\"rso\"]/div");
    By searchBox = By.xpath("//input[@aria-label=\"Search\"]");

    public GoogleTestPage(WebDriver driver){
        this.driver = driver;

    }
    public void searchStringAndGo(String word){
        Duration seconds = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        driver.findElement(searchBox).sendKeys(word);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);

    }

    public int getResults(){
        System.out.println(driver.findElements(results).size());
        return driver.findElements(results).size();
    }

    public void goToURL(String urlparam){
        driver.get(urlparam);
    }
}
