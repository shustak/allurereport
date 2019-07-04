package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewInvestment extends AbstractPage{

    private final String BASE_URL = "https://app-fun-5887-dev-ed.lightning.force.com/lightning/o/sfims__Investment__c/list?filterName=Recent";

//Investment

    @FindBy(xpath = "(//div[@title='New'])[5]")
    private WebElement newInvestmentButton;
    //nextButton
    @FindBy(xpath = "//span[contains(.,'Next')]")
    private WebElement nextButton;
    //newName
    @FindBy(xpath = "(//span[text()='*']/following::input)[1]")
    private WebElement newNameField;
    //OpenEndedLoan
    @FindBy(xpath = "(//span[text()='Open Ended loans are loans with no fixed end date and no fixed repayment schedule.']/following::input)[1]")
    private WebElement checkBoxOpenEndedLoan;
    //dateDisdurse
    @FindBy(xpath = "(//div[@class='form-element']//input)[1]")
    private WebElement dateDisburse;
    //disburseMethod
    @FindBy(xpath = "//a[contains(text(),'Full disbursement at start')]")
    private WebElement fieldDisburseMethod;

    @FindBy(xpath = "//a[contains(text(),'Tranched disbursement allowed')]")
    private WebElement tranchedDisburseMethod;

    @FindBy(xpath = "//a[contains(text(),'Full disbursement at start')]")
    private WebElement fullStartDisburseMethod;
    //dateRepayment
    @FindBy(xpath = "(//div[@class='form-element']//input)[2]")
    private WebElement dateRepayment;
    //statusInvestment
    @FindBy(xpath = "(//a[@class='select'])[1]")
    private WebElement statusField;

    @FindBy(xpath = "//a[contains(text(),'--None--')]")
    private WebElement statusNone;

    @FindBy(xpath = "//a[contains(text(),'Inactive')]")
    private WebElement statusInactive;

    @FindBy(xpath = "//a[contains(text(),'Pending Disbursal')]")
    private WebElement statusPendingDisbursal;

    @FindBy(xpath = "//a[contains(text(),'Active')]")
    private WebElement statusActive;

    @FindBy(xpath = "//a[contains(text(),'Closed - All Obligations Met')]")
    private WebElement statusClosedAllObligationsMet;

    @FindBy(xpath = "//a[contains(text(),'Closed - Written Off')]")
    private WebElement statusClosedWrittenOff;

    @FindBy(xpath = "//a[contains(text(),'Closed - Early Repayment')]")
    private WebElement statusClosedEarlyRepayment;

    @FindBy(xpath = "//a[contains(text(),'Closed')]")
    private WebElement statusClosed;
    //amountField
    @FindBy(xpath = "(//input[@class=' input'])[4]")
    private WebElement amountField;
    //interestRate
    @FindBy(xpath = "(//span[text()='Interest Rate']/following::input)[1]")
    private WebElement interestRateField;
    //dayCountConvention
    @FindBy(xpath= "//a[contains(text(),'30/360')]")
    private WebElement dayCountConventionField;

    @FindBy(xpath = "//a[contains(.,'30/360')]")
    private WebElement c30360;

    @FindBy(xpath = "//a[contains(.,'Actual/365')]")
    private WebElement actual365;

    @FindBy(xpath = "//a[contains(.,'Actual/365L')]")
    private WebElement actual365L;
    //numberOfInstalements
    @FindBy(xpath = "(//span[text()='Number of Instalments']/following::input)[1]")
    private WebElement numberOfInstalmentsField;
    //repaymentFrequencyUnit
    @FindBy(xpath = "(//a[@class='select'])[4]")
    private WebElement repaymentFrequencyUnitField;

    @FindBy(xpath = "//a[contains(text(),'--None--')]")
    private WebElement repaymentUnitNone;

    @FindBy(xpath = "//a[contains(text(),'Days')]")
    private WebElement repaymentUnitDays;

    @FindBy(xpath = "//a[contains(text(),'Weeks')]")
    private WebElement repaymentUnitWeeks;

    @FindBy(xpath = "//a[contains(text(),'Months')]")
    private WebElement repaymentUnitMonth;

    @FindBy(xpath = "//a[contains(text(),'Years')]")
    private WebElement repaymentUnitYears;

    @FindBy(xpath = "//div[3]/div[2]/div/div/div/input")
    private WebElement repaymentFrequencyField;
    //GracePeriodType
    @FindBy(xpath = "//div[5]/div[2]/div/div/div/div/div/div/div/a")
    private WebElement gracePeriodField;

    @FindBy(xpath = "//a[contains(.,'--None--')]")
    private WebElement graceTypeNone;

    @FindBy(xpath = "//a[contains(.,'No Grace')]")
    private WebElement graceTypeNoGrace;

    @FindBy(xpath = "//a[contains(.,'Pay Admin Fees Only')]")
    private WebElement graceTypePayAdminFeesOnly;

    @FindBy(xpath = "//a[contains(.,'Pay Interest Only')]")
    private WebElement graceTypePayInterestOnly;

    @FindBy(xpath = "//a[contains(.,'Full Grace')]")
    private WebElement graceTypeFullGrace;

    @FindBy(xpath = "(//span[text()='Number of Grace Periods']/following::input)[1]")
    private WebElement numberOfGracePeriods;

    @FindBy(xpath = "//button[3]/span")
    private WebElement saveInvestmentButton;


    public NewInvestment(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public NewInvestment chooseDisburse(String iDisburseMethod) {
        fieldDisburseMethod.click();
        if(iDisburseMethod=="Tranched disbursement allowed"){
            tranchedDisburseMethod.click(); }
        else if(iDisburseMethod=="Full Disbursement at Start"){
            fullStartDisburseMethod.click(); }
        else {System.out.println("Disburse Method wrong value");}
        return this;
    }

    public NewInvestment chooseOpenEndedLoan(String iOpenEndedLoan) {

        if(iOpenEndedLoan=="Yes"){
            checkBoxOpenEndedLoan.click();
            System.out.println("It's Open Ended Loan");
        }
        else {System.out.println("It's not Open Ended Loan");}
        return this;
    }


    public NewInvestment chooseStatus(String iStatus) {
        statusField.click();
        if(iStatus=="--None--"){
            statusNone.click();
        }
        else if(iStatus=="Inactive"){
            statusInactive.click();
        }
        else if(iStatus=="Pending Disbursal"){
            statusPendingDisbursal.click();
        }
        else if(iStatus=="Active") {
            statusActive.click();
        }
        else if(iStatus=="Closed - All Obligations Met") {
            statusClosedAllObligationsMet.click();
        }
        else if(iStatus=="Closed - Written Off") {
            statusClosedWrittenOff.click();
        }
        else if(iStatus=="Closed - Early Repayment") {
            statusClosedEarlyRepayment.click();
        }
        else if(iStatus=="Closed") {
            statusClosed.click();
        }
        else {System.out.println("Status wrong value");}
        return this;
    }

    public NewInvestment chooseDayCountConvention(String iCountConvention) {
        dayCountConventionField.click();
        if(iCountConvention=="30/360"){
            c30360.click();
        }
        else if(iCountConvention=="Actual/365"){
            actual365.click();
        }
        else if(iCountConvention=="Actual/365L"){
            actual365L.click();
        }
        else {System.out.println("Count Convention wrong value");}
        return this;
    }

    public NewInvestment chooseFrequencyUnit(String iFrequencyUnit) {
        repaymentFrequencyUnitField.click();

        if(iFrequencyUnit=="--None--"){
            repaymentUnitNone.click();
        }
        else if(iFrequencyUnit=="Days"){
            repaymentUnitDays.click();
        }
        else if(iFrequencyUnit=="Weeks"){
            repaymentUnitWeeks.click();
        }
        else if(iFrequencyUnit=="Months"){
            repaymentUnitMonth.click();
        }
        else if(iFrequencyUnit=="Years"){
            repaymentUnitYears.click();
        }
        else {System.out.println("Frequency Unit wrong value");}
        return this;
    }

    public NewInvestment chooseGracePeriodType(String iGracePeriodType) {
        gracePeriodField.click();

        if(iGracePeriodType=="--None--"){
            graceTypeNone.click();
        }
        else if(iGracePeriodType=="No Grace"){
            graceTypeNoGrace.click();
        }
        else if(iGracePeriodType=="Pay Admin Fees Only"){
            graceTypePayAdminFeesOnly.click();
        }
        else if(iGracePeriodType=="Pay Interest Only"){
            graceTypePayInterestOnly.click();
        }
        else if(iGracePeriodType=="Full Grace"){
            graceTypeFullGrace.click();
        }
        else {System.out.println("Grace Period Type wrong value");}
        return this;
    }


    public void createInvestment (String iName,
                                  String iOpenEndedLoan,
                                  String iDateDisburse,
                                  String iDisburseMethod,
                                  String iStatus,
                                  String iRepaymentDate,
                                  String iAmount,
                                  String iInterestRate,
                                  String iCountConvention,
                                  String iNumberofInstalements,
                                  String iFrequencyUnit,
                                  String iRepaymentFrequency,
                                  String iGracePeriodType,
                                  String iNumberOfGracePeriod)

    {
        newInvestmentButton.click();
        nextButton.click();
        newNameField.sendKeys(iName);
        chooseOpenEndedLoan(iOpenEndedLoan);
        dateDisburse.sendKeys(iDateDisburse);
        newNameField.click();
        chooseDisburse(iDisburseMethod);
        chooseStatus(iStatus);
        dateRepayment.sendKeys(iRepaymentDate);
        newNameField.click();
        amountField.sendKeys(iAmount);
        interestRateField.clear();
        interestRateField.sendKeys(iInterestRate);
        chooseDayCountConvention(iCountConvention);
        numberOfInstalmentsField.sendKeys(iNumberofInstalements);
        chooseFrequencyUnit(iFrequencyUnit);
        repaymentFrequencyField.sendKeys(iRepaymentFrequency);
        chooseGracePeriodType(iGracePeriodType);
        numberOfGracePeriods.sendKeys(iNumberOfGracePeriod);
        saveInvestmentButton.click();
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        System.out.println("New Investment Page opened");
    }





}
