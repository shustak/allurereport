package tests;

import PageObject.Steps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;

//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {

    private Steps steps;
    //Test Data

    private final String USERNAME = "loan.user.geodez1985@yandex.ru";
    private final String PASSWORD = "sasha1985";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();

    }

    @Test (priority = 0, description="Create new fund scenario")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Create new fund scenario")
    @Story("Create new fund scenario")
    public void fundTab()
    {
        steps.loginSalesforce(USERNAME, PASSWORD);
        steps.buttonFunds();
    }

    @Test (priority = 1, description="Create new investment.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: create new open ended loan")
    @Story("New Investment")
    public void investment1() {
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
}