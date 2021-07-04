import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phptravels.DemoPage;
import phptravels.ProvidersPage;

public class TestTravels extends Base{
    private WebDriver driver;
    private DemoPage demoTravelPage;
    private ProvidersPage providersTravelPage;

    @BeforeMethod
    public void beforeMethod(){
        driver = initializeDriver();
        demoTravelPage = new DemoPage(driver);
        providersTravelPage = new ProvidersPage(driver);
        driver.get(demoTravelPage.getTravelsurl());
    }

    @Test
    public void travelTest(){
        // Tarea:
        // ir a https://phptravels.com/demo/
        // hacer clic en product (menú superior)
        // hacer clic en Providers (submenu de product)
        // verificar que el título sea Travel XML API Integrations Providers
        // hacer clic en demo (menú superior)
        // verificar que el título sea Application Test Drive

        demoTravelPage.clickProducto();
        demoTravelPage.clickProviders();
        providersTravelPage.waitPageLoadSixSeconds();
        Assert.assertEquals( providersTravelPage.getHeaderTitle(),"Travel XML API Integrations Providers");
        providersTravelPage.clickDemo();
        demoTravelPage.waitDemoLoadSixSeconds();
        Assert.assertEquals( demoTravelPage.getHeaderTitle(),"Application Test Drive");
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}
