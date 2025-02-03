package com.contest.pages;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPlanToCustomer extends BasePage {

    @FindBy(xpath = "//*[@id=\"one\"]/div/div[1]/div[2]/h3/a")
    private WebElement addTarrifPlanBtn;

    @FindBy(css = "#customer_id")
    private WebElement customerIdTxtBx;

    @FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[6]/input")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div/h2")
    private WebElement AssignedPlantext;

    @FindBy(xpath = "//*[@id=\"main\"]/div/ul/li/a")
    private WebElement returnHome;
   
    //addplantocustomer is addes
    public AddPlanToCustomer(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addPTC(){
        addTarrifPlanBtn.click();
    }

    public void enterCustomerID(String CustomerID){
        customerIdTxtBx.sendKeys(CustomerID);
    }
    public void submitClick(){
        submitBtn.click();
    }
    public void checkRadio(){
       WebElement hiddenButton = driver.findElement(By.xpath("//label[@for='sele']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",hiddenButton);
        driver.findElement(By.xpath("//input[@value='Add Tariff Plan to Customer']")).click();
        System.out.println("Tariff plan is correctly assigned to the customer");
    }
    public String AssertPlantext(){
        return AssignedPlantext.getText();

    }

    public void naviagateHomePage(){
        returnHome.click();
    }

}
    


