package phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProvidersPage {
    private WebDriver driver;

    @FindBy(id = "header-title")
    private WebElement headerTitle;

    @FindBy(xpath = "//a[@href='https://phptravels.com/demo']")
    private WebElement demoLink;

    public ProvidersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver,this);
    }

    public void clickDemo(){
        demoLink.click();
    }

    public String getHeaderTitle(){
        System.out.println("prov title" + headerTitle.getText());
        return headerTitle.getText();
    }

    public void waitPageLoadSixSeconds(){
        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.textToBePresentInElement(this.headerTitle, "Travel XML API Integrations Providers"));
    }

}
