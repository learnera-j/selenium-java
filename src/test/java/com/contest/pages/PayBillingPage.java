package com.contest.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PayBillingPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"one\"]/div/div[3]/div[2]/h3/a")
    private WebElement payBillPage;

    @FindBy(xpath = "//*[@id=\"customer_id\"]")
    private WebElement CustomerIdBox;

    @FindBy(xpath = "//*[@id=\"main\"]/div/form/div/div[6]/input")
    private WebElement submitBtn;
    public PayBillingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void BillPage(){
        payBillPage.click();
    }
    
    public void EntercustomerID(String CustomerID){
        CustomerIdBox.sendKeys(CustomerID);
        //submit
        submitBtn.click();
        String ActualAssignedamnt = driver.findElement(By.xpath("//tr[4]")).getText();
        String ExpectedAssignedamnt ="Tariff Plan Amount 500";
        Assert.assertEquals(ExpectedAssignedamnt, ActualAssignedamnt);
        String TotalAmnt = driver.findElement(By.xpath("//tr[6]/td[2]/b")).getText();
        System.out.println(TotalAmnt);


    }
        
}
    

