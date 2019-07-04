package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class LoginPage extends AbstractPage
{


    private final String BASE_URL = "https://test.salesforce.com/";

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"Login\"]")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        System.out.println("Login Page opened");
    }

    public void login(String username, String password)
    {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
    }



}



