package com.contest.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddTarriffPlanPage extends BasePage {

    public AddTarriffPlanPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    // Addmethods here
    public void tarriffPlanPage(String rental,String local_minutes,String inter_minutes,String sms_pack,String minutes_charges,String inter_charges,String sms_charges){
        driver.findElement(By.xpath("//h3/a[text()='Add Tariff Plan']")).click();
        driver.findElement(By.xpath("//input[@name='rental']")).sendKeys(rental);
        driver.findElement(By.xpath("//input[@name='local_minutes']")).sendKeys(local_minutes);
        driver.findElement(By.xpath("//input[@name='inter_minutes']")).sendKeys(inter_minutes);
        driver.findElement(By.xpath("//input[@name='sms_pack']")).sendKeys(sms_pack);
        driver.findElement(By.xpath("//input[@name='minutes_charges']")).sendKeys(minutes_charges);
        driver.findElement(By.xpath("//input[@name='inter_charges']")).sendKeys(inter_charges);
        driver.findElement(By.xpath("//input[@name='sms_charges']")).sendKeys(sms_charges);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String Expected = driver.findElement(By.xpath("//*[@id='main']/div/h2")).getText();
        String Actual = "Congratulation you add Tariff Plan";
        Assert.assertEquals(Expected, Actual);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();

        
    }
    
    
        
    }

