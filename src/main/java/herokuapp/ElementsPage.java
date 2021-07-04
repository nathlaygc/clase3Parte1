package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementsPage {
    private WebDriver driver;

    //Used elements on test
    @FindBy(xpath = "//h3")
    private WebElement title;

    @FindBy(xpath = "//div[@class='example']/button")
    private WebElement addButton;

    @FindBy(className = "added-manually")
    private List<WebElement> deleteButton;

    public ElementsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements( driver,this);
    }

    public String getTitle() {
        return title.getText();
    }

    public void waitForTitlePresent(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void clickAddElement(){
        this.addButton.click();
    }

    public boolean addElementIsVisible(){
        return addButton.isDisplayed();
    }

    public boolean deleteButtonIsVisible(){
        List<WebElement> listDeletes = deleteButton;
        if(listDeletes.size()>0)
            return true;
        else
            return false;
    }
    public void clickDeleteButton(){
        for (int i = 0; i < deleteButton.size(); i++) {
            deleteButton.get(i).click();
        }

    }


}
