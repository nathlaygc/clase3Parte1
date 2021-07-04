package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuappPage {
    private WebDriver driver;
    private String herokuurl ="http://the-internet.herokuapp.com/";

    //Used elements on test
    @FindBy(xpath = "//a[@href='/dropdown']")
    private WebElement dropdownLink;

    @FindBy(xpath = "//a[@href='/add_remove_elements/']")
    private WebElement addRemoveLink;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement formLink;

    public HerokuappPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements( driver,this);
    }

    public String getHerokuurl() {
        return herokuurl;
    }

    public void clickDropdownLink() {
        dropdownLink.click();
    }
    public void clickAddRemoveLink() {
        addRemoveLink.click();
    }
    public void clickFormLink() {
        formLink.click();
    }
}
