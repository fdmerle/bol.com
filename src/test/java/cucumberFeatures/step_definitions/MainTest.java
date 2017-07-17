package cucumberFeatures.step_definitions;

import configs.DriverTypes;
import configs.DriverWrapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BolMain;

/**
 * Created by U6039822 on 7/15/2017.
 */
public class MainTest {
    public DriverWrapper driver = new DriverWrapper();
    BolMain bolMain;
    String bolUrl = "http://bol.com";
    public static DriverTypes driverTypes;

    @BeforeTest
   public void initializeBolPage() {
        driver.setWebDriver(driverTypes.FireFox);
        driver.getWebDriver().get(bolUrl);
        bolMain = new BolMain(driver);


    }

    @AfterTest
    public void clean(){

        driver.getWebDriver().close();

    }
}
