package com.contest.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.contest.pages.AddPlanToCustomer;
import com.contest.pages.AddTarriffPlanPage;
import com.contest.pages.HomePage;
import com.contest.pages.PayBillingPage;

public class TelecomProjectTests extends BaseTest {

    public String cID;
   
    //public String CustomerID;
    @BeforeMethod
    public void setUps(){
        driver.get("https://demo.guru99.com/telecom/index.html");
    }
    @Test
    public void addCustomerTest() {
        HomePage homePage = new HomePage(driver);
        homePage.addCustomer();
        
        homePage.fillForm("John","Doe","john.doe@example.com","123 Main St","1234567890");
        //homePage.AssertCustomer();
        String actaulCustomerLabel = homePage.AssertCustomer();
        String expectedLabel = "Please Note Down Your CustomerID";
        Assert.assertEquals(actaulCustomerLabel, expectedLabel);
        cID= homePage.noteCustomerID();
        homePage.naviagateHomePage();
        

    }
    @Test
    public void addTarrifPlanToCustomerTest() throws InterruptedException {
        addCustomerTest();
        Thread.sleep(1000);
        AddPlanToCustomer addPlanToCustomer = new AddPlanToCustomer(driver);
        addPlanToCustomer.addPTC();
        //Thread.sleep(1000);
        addPlanToCustomer.enterCustomerID(cID);
        addPlanToCustomer.submitClick();
        addPlanToCustomer.checkRadio();
        String ActualCnfrmTxt = addPlanToCustomer.AssertPlantext();
        String ExpectedCnfrmTxt = "Congratulation Tariff Plan assigned";
        Assert.assertEquals(ActualCnfrmTxt, ExpectedCnfrmTxt);
        addPlanToCustomer.naviagateHomePage();

        

    }
    @Test
    public void addTarrifPlanTest() {
        AddTarriffPlanPage addTarriffPlanPage = new AddTarriffPlanPage(driver);
        addTarriffPlanPage.tarriffPlanPage("49","1000","100","500","0","1","1");
        HomePage homePage1 = new HomePage(driver);
        homePage1.addCustomer();
        homePage1.fillForm("Jane","Smith","jane.smith@example.com","143 Main St","1234567890");
        String actaulCustomerLabel = homePage1.AssertCustomer();
        String expectedLabel = "Please Note Down Your CustomerID";
        Assert.assertEquals(actaulCustomerLabel, expectedLabel);
        cID= homePage1.noteCustomerID();
        homePage1.naviagateHomePage();
        AddPlanToCustomer addPlanToCustomer = new AddPlanToCustomer(driver);
        addPlanToCustomer.addPTC();
        addPlanToCustomer.enterCustomerID(cID);
        addPlanToCustomer.submitClick();
       
        




        
         
        
    }

   
    @Test
    public void payBillingTest() throws InterruptedException {
        addTarrifPlanToCustomerTest();
        PayBillingPage payBillingPage = new PayBillingPage(driver);
        payBillingPage.BillPage();
        payBillingPage.EntercustomerID(cID);
        
    }
}
