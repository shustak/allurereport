package PageObject;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Steps {

    private WebDriver driver;

    public void initBrowser()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Step("Close Page")
    public void closeDriver()
    {
        driver.quit();
    }

    public String getScreenshot (String screenshotName) throws IOException{
        DateFormat dateformate = new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
        Date date = new Date();
        String currentdate = dateformate.format(date);
        String imageName =screenshotName+currentdate;
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String location =System.getProperty("user.dir")+"\\testOutput\\screenshot\\"+imageName+".png";
        File screenshotLocation =new File (location);
        FileUtils.copyFile(source, screenshotLocation);
        return location;
    }
    @Step("Open login Page")
    public void loginSalesforce(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }
    @Step("Create new investment")
    public void invest1(String iName,
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
        NewInvestment invest = new NewInvestment(driver);
        invest.createInvestment(iName,
                iOpenEndedLoan,
                iDateDisburse,
                iDisburseMethod,
                iStatus,
                iRepaymentDate,
                iAmount,
                iInterestRate,
                iCountConvention,
                iNumberofInstalements,
                iFrequencyUnit,
                iRepaymentFrequency,
                iGracePeriodType,
                iNumberOfGracePeriod);

    }
    @Step("Create new transaction")
    public void newTransaction1(String ntAmount,
                                String ntType)
    {
        NewTransaction transaction = new NewTransaction(driver);
        transaction.createTransaction(ntAmount,
                ntType);
    }

    public void buttonInvestment(){
        driver.get("https://app-fun-5887-dev-ed.lightning.force.com/lightning/o/sfims__Investment__c/list?filterName=Recent");
    }
    @Step("Open funds page")
    public void buttonFunds(){
        driver.get("https://app-fun-5887-dev-ed.lightning.force.com/lightning/o/sfims__Fund__c/list?filterName=Recent");
    }

    public  void findElementBY(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    @Step("Open all funds investments")
    public  void fundLevelInvestmentButton(){

        FundLevel fundInvest = new FundLevel(driver);
        fundInvest.clickInvestment();

    }


}
