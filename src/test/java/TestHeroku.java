import herokuapp.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import phptravels.DemoPage;
import phptravels.ProvidersPage;

import java.util.List;

public class TestHeroku extends Base{
    private WebDriver driver;
    private HerokuappPage herokuPage;
    private DropdownPage dropPage;
    private ElementsPage dinamicElementPage;
    private FormPage loginPage;
    private SucessPage sucessPage;

    @BeforeMethod
    public void beforeMethod(){
        driver = initializeDriver();
        herokuPage = new HerokuappPage(driver);
        dinamicElementPage = new ElementsPage(driver);
        loginPage = new FormPage(driver);
        sucessPage = new SucessPage(driver);
        driver.get(herokuPage.getHerokuurl());
    }

    @Test
    public void testOne(){
        SoftAssert softAssert = new SoftAssert();

        // Seleccionar la opción dropdown
        herokuPage.clickDropdownLink();
        dropPage = new DropdownPage(driver);

        // Seleccionar la opción 2 (por value)
        dropPage.waitListAvailable();
        dropPage.selectListByValue("2");

        // Verificar que la opción 1 NO esté seleccionada
        softAssert.assertFalse(dropPage.optionIndexIsSelected(1));

        // Verificar que la opción 2 esté seleccionada
        softAssert.assertTrue(dropPage.optionIndexIsSelected(2));

        // Seleccionar la opción 1 (por visible text)
        dropPage.selectListByVisibleText("Option 1");

        // Verificar que la opción 1 esté seleccionada
        softAssert.assertTrue(dropPage.optionIndexIsSelected(1));

        // Verificar que la opción 2 NO esté seleccionada
        softAssert.assertFalse(dropPage.optionIndexIsSelected(2));

        // Seleccionar la opción 2 (por index)
        dropPage.selectListByIndex(2);

        // Verificar que la opción 1 NO esté seleccionada
        softAssert.assertFalse(dropPage.optionIndexIsSelected(1));

        // Verificar que la opción 2 esté seleccionada
        softAssert.assertTrue(dropPage.optionIndexIsSelected(2));

        softAssert.assertAll();

    }

    @Test
    public void testTwo() {
        SoftAssert softAssert = new SoftAssert();

        // Seleccionar la opción add/remove elements
        herokuPage.clickAddRemoveLink();

        // Verificar que el título diga Add/Remove Elements (assert)
        dinamicElementPage.waitForTitlePresent();
        Assert.assertEquals(dinamicElementPage.getTitle(),"Add/Remove Elements");

        // Verificar que add element es visible
        softAssert.assertTrue(dinamicElementPage.addElementIsVisible());

        // Verificar que el botón delete no es visible
        softAssert.assertFalse(dinamicElementPage.deleteButtonIsVisible());

        // Hacer clic en add element
        dinamicElementPage.clickAddElement();

        //  Verificar que el botón delete es visible
        softAssert.assertTrue(dinamicElementPage.deleteButtonIsVisible());

        // Hacer clic en delete
        dinamicElementPage.clickDeleteButton();

        // Verificar que el botón delete NO es visible
        softAssert.assertFalse(dinamicElementPage.deleteButtonIsVisible());

        softAssert.assertAll();
    }

    @Test
    public void testThree() {
        SoftAssert softAssert = new SoftAssert();

        // Seleccionar la opción Form Authentication
        herokuPage.clickFormLink();

        // Verificar que el título sea login page (assert)
        loginPage.waitForTitlePresent();
        Assert.assertEquals(loginPage.getTitle(),"Login Page");

        // Hacer clic en el botón login (sin poner usuario ni contaseña)
        loginPage.clickLogin();

        // Verificar que el mensaje de error se muestre
        softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='flash error']")).isDisplayed());

        // Llenar el usuario y contraseña que indica la página
        // Escribir el usuario y contraseña que dicen el página
        loginPage.autoFillLoginForm();
        loginPage.clickLogin();

        // Verificar que el título sea "Secure Area" (assert)
        sucessPage.waitForTitlePresent();
        Assert.assertEquals(sucessPage.getTitle(),"Secure Area");

        // Verificar que el mensaje de éxito salga arriba (assert)
        // usando find by class no encuentra el elemento
        Assert.assertTrue(sucessPage.successMessageIsDisplayed());

        // Hacer clic en logout
        sucessPage.logout();

        // Verificar que el título sea nuevamente login page (assert)
        Assert.assertEquals(loginPage.getTitle(),"Login Page");

        softAssert.assertAll();
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}
