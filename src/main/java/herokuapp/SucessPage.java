package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SucessPage {
    private WebDriver driver;

    //Used elements on test
    @FindBy(xpath = "//h2")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='flash success']")
    private WebElement successText;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutLink;

    public SucessPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements( driver,this);
    }

    public String getTitle(){
        return pageTitle.getText();
    }
    public void waitForTitlePresent(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
    }

    public boolean successMessageIsDisplayed(){
        return successText.isDisplayed();
    }

    public void logout(){
        logoutLink.click();
    }
}
