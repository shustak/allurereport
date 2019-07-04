package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Funds']//span[1]")
    private WebElement buttonFunds;

    @FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'Investments')]")
    private WebElement buttonInvestment;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnFundsButton() {

        driver.get("https://app-fun-5887-dev-ed.lightning.force.com/lightning/o/sfims__Fund__c/list?filterName=Recent");

        buttonFunds.isDisplayed();
        buttonFunds.click();
    }

    public void clickOnInvestmentButton() {
        buttonInvestment.click();
    }


    @Override
    public void openPage() {

        System.out.println("Main Page opened");

    }
}