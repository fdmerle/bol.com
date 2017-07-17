package cucumberFeatures.step_definitions;


import configs.DriverTypes;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.BolMain;

import java.util.List;


public class MyStepdefs extends MainTest {

    @Given("^I open bol page in \"(.+)\"$")
    public void iOpenBolPageIn(DriverTypes arg1) {
        driver.setWebDriver(arg1);
        driver.getWebDriver().get(bolUrl);
        bolMain = new BolMain(driver);
    }


    @When("^I add into basket$")
    public void iAddIntoBasket(List<String> arg1) {
        for (String good : arg1) {
            if (good != null && !good.isEmpty()&& good!=""&&good!="\"\""){
            bolMain.searchForGood(good);
            bolMain.addToBasket();}
        }
    }

    @And("^I navigate to basket$")
    public void iNavigateToBasket() {
        bolMain.navigateToBasket();
    }


    @Then("^Then delivery cost should be \"(.+)\"$")
    public void thenDeliveryCostShouldBe(String arg1){
        Assert.assertEquals(bolMain.returnDeliveryPrice(), arg1);
        driver.getWebDriver().close();
    }

    @And("^I remove one good from basket$")
    public void iRemoveFromBasket(){
        bolMain.deleteFromBasket();

    }
}
