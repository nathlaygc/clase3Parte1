package phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoPage {
    private WebDriver driver;
    String travelsUrl = "https://phptravels.com/demo/";

    //Elements used in the test
    @FindBy(xpath = "//span[contains(text(),'Product')]")
    private WebElement productoLink;

    @FindBy(xpath = "//div[@class='dropdown-content featuresDropdown']//a[@href='https://phptravels.com/providers/']")
    private WebElement providerLink;

    @FindBy(id = "header-title")
    private WebElement headerTitle;

    @FindBy(xpath = "//a[@href='https://phptravels.com/demo']")
    private WebElement demoLink;


    public DemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver,this);
    }

    public String getTravelsurl() {
        return travelsUrl;
    }

    public void clickProducto(){
        productoLink.click();
    }

    public void clickProviders(){
        providerLink.click();
    }

    public void clickDemo(){
        demoLink.click();
    }

    public String getHeaderTitle(){
        return headerTitle.getText();
    }

    public void waitDemoLoadSixSeconds(){
        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.textToBePresentInElement(this.headerTitle, "Application Test Drive"));
    }

}
