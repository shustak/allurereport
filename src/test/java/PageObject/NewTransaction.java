package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewTransaction extends AbstractPage{


    //NewTransactionButton
    @FindBy(xpath = "(//div[@class='slds-truncate'][contains(.,'New Transaction')])[2]")
    private WebElement newTransactionButton;

    @FindBy(xpath = "(//input[@class=' input'])[1]")
    private WebElement newTransactionAmount;
    //NewTransactionDate
    @FindBy(xpath = "//span[text()='Transaction Date']/following::input")
    private WebElement newTransactionDate;
    //NewTransactionType
    @FindBy(xpath = "(//a[@class='select'])[1]")
    private WebElement newTransactionTypeField;

    @FindBy(xpath = "(//a[contains(text(),'Disbursement')])[2]")
    private WebElement newTransactionTypeDisburse;

    @FindBy(xpath = "//a[contains(text(),'Repayment')]")
    private WebElement newTransactionTypeRepayment;



    public NewTransaction(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public NewTransaction chooseNewTransactionType(String ntType)
    {
        Select transactionType = new Select(driver.findElement(By.xpath("(//a[@class='select'])[1]")));
        transactionType.selectByVisibleText(ntType);
        return this;
    }

    public void createTransaction (String ntAmount,
                                   String ntType)

    {
        newTransactionButton.click();
        newTransactionAmount.sendKeys(ntAmount);
        chooseNewTransactionType(ntType);

    }
    @Override
    public void openPage()
    {
        System.out.println("New Investment Page opened");
    }

}


