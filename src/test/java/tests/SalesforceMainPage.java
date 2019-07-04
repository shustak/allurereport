package tests;

import PageObject.AbstractPage;
import PageObject.MainPage;
import PageObject.NewInvestment;
import PageObject.Steps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import jdk.internal.joptsimple.util.PathConverter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;
import utils.Listeners.TestListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class SalesforceMainPage {


    private Steps steps;

    private final String USERNAME = "loan.user.geodez1985@yandex.ru";
    private final String PASSWORD = "sasha1985";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();

    }

    @Test(priority = 0, description = "Create new fund scenario")
    public void fundTab()
    {
        steps.loginSalesforce(USERNAME, PASSWORD);
        steps.buttonFunds();

    }

    @Test(description = "newInvestment")

    public void investment1() throws InterruptedException{
        steps.loginSalesforce(USERNAME, PASSWORD);
        steps.buttonFunds();
        steps.findElementBY("Test Fund");
        steps.fundLevelInvestmentButton();
        steps.invest1("Second",
                "Yes",
                "01-04-2019",
                "Full Disbursement at Start",
                "Inactive",
                "01-06-2019",
                "35000",
                "15",
                "Actual/365",
                "12",
                "Months",
                "1",
                "No Grace",
                "0");
    }

    @Test(description = "New Transaction")
    public void transaction()
    {
        steps.loginSalesforce(USERNAME, PASSWORD);
        steps.buttonInvestment();
        steps.findElementBY("First");
        steps.newTransaction1("500","Repayment");
    }


    @AfterMethod(description = "Stop Browser")
    public void checkStatus(ITestResult result) throws IOException {
        if (result.isSuccess()) {
            steps.closeDriver();
            return;
        } else {
            steps.getScreenshot("Name");
            steps.closeDriver();
        }
    }
    public void stopBrowser() {
        steps.closeDriver();
    }

}
