package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FormPage {
    private WebDriver driver;

    //Used elements on test
    @FindBy(xpath = "//a[@href='/dropdown']")
    private WebElement dropdownLink;

    @FindBy(xpath = "//h2")
    private WebElement pageTitle;

    @FindBy(className = "radius")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='flash error']")
    private WebElement errorMessageLabel;

    @FindBy(xpath = "//h4[@class='subheader']/em")
    private List<WebElement> loginCredentials;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;


    public FormPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements( driver,this);
    }

    public String getTitle(){
        return pageTitle.getText();
    }

    public void clickLogin(){
        loginButton.click();
    }

    public void autoFillLoginForm(){
        usernameInput.sendKeys(loginCredentials.get(0).getText());
        passwordInput.sendKeys(loginCredentials.get(1).getText());
    }
    public void waitForTitlePresent(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
    }
}
