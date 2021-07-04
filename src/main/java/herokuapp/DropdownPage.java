package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {
    private WebDriver driver;
    private Select dropList;
    //Used elements on test
    @FindBy(id = "dropdown")
    private WebElement dropdownList;


    public DropdownPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements( driver,this);
    }

    public void waitListAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(this.dropdownList));
    }

    public WebElement getDropdownList(){
        return dropdownList;
    }

    public void selectListByValue(String value){
        dropList = new Select(this.dropdownList);
        dropList.selectByValue(value);
    }

    public boolean optionIndexIsSelected(int index){
        return this.dropList.getOptions().get(index).isSelected();
    }

    public void selectListByVisibleText(String text){
        dropList.selectByVisibleText(text);
    }

    public void selectListByIndex(int index){
        dropList.selectByIndex(index);
    }
}
