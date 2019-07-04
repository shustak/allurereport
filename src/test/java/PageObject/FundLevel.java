package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundLevel extends AbstractPage {

    private final String BASE_URL = " https://app-fun-5887-dev-ed.lightning.force.com/lightning/o/sfims__Fund__c/list?filterName=Recent";

    public FundLevel(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "(//a[@class='slds-card__header-link baseCard__header-title-container']//span)[3]")
    private WebElement InvestmentButton;


    public void  clickInvestment() {
        InvestmentButton.click();

    }


    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        System.out.println("Opened fund level");
    }

}
