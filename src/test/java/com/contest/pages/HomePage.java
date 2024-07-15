package com.contest.pages;

import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    
    @FindBy(xpath = "//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")
    private WebElement addCustomerBtn;

    @FindBy(xpath = "//label[@for='done']")
    private WebElement checkRadioBtn;

    @FindBy(css = "#fname")
    private WebElement firstName;

    @FindBy(css = "#lname")
    private WebElement lastName;

    @FindBy(css = "#email")
    private WebElement emailAdd;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement addressHome;

    @FindBy(css = "#telephoneno")
    private WebElement telephone;

    @FindBy(xpath="//input[@name='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/table/tbody/tr[2]/td")
    private WebElement customerLabel;

    // @FindBy(xpath = "//td/h3")
    // private WebElement customerIdNumber;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/ul/li/a")
    private WebElement homeButton;
    
    
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Add methods here
    
    public void addCustomer(){
        addCustomerBtn.click();
    }

    public void fillForm(String fname, String lname, String email, String hAddress, String telephoneNumber){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkRadioBtn);
        // checkRadioBtn.click();
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        emailAdd.sendKeys(email);
        addressHome.sendKeys(hAddress);
        telephone.sendKeys(telephoneNumber);
        submitBtn.click();
        
}
    public String AssertCustomer(){
        // String actaulCustomerLabel = customerLabel.getText();
        return customerLabel.getText();

    }

    public String noteCustomerID(){
        
        String CustomerID= driver.findElement(By.xpath("//td/h3")).getText();
       
        System.out.println(CustomerID);
        return CustomerID;
    }

    public void naviagateHomePage(){
        homeButton.click();
        //return new AddPlanToCustomer(driver);
    }
}
