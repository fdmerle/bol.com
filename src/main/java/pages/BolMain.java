package pages;

import configs.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by U6039822 on 7/15/2017.
 */
public class BolMain {
    DriverWrapper driver;
    public WebElement searchField;
    public WebElement submitButton;
    public WebElement basketButton;

    public String searchFieldXpath = ".//*[@id='searchfor']";
    public String submitButtonXpath = ".//*[@type='submit'][@data-test='search-button']";
    public String addToBasketButtonXpath = ".//a[@data-button-type='add_to_basket']";
    public String basketButtonXpath = ".//div[@class='basket__button']";
    public String modalWindowElementXpath = "//div[@class='js_close_modal_window modal__window--close-hitarea']";
    public String shippingCostXpath = ".//*[@id='tst_shipping_costs']";


    public BolMain(DriverWrapper driverWrapper) {

        driver = driverWrapper;
        searchField = driver.getWebDriver().findElement(By.xpath(searchFieldXpath));
        submitButton = driver.getWebDriver().findElement(By.xpath(submitButtonXpath));
    }

    public void searchForGood(String goodForSearch) {
        driver.getWebDriver().switchTo().activeElement();
        driver.getWebDriver().findElement(By.xpath(searchFieldXpath)).sendKeys(goodForSearch);
        driver.waitElementToBeVisible(submitButtonXpath, 10);
        driver.getWebDriver().findElement(By.xpath(submitButtonXpath)).click();
        driver.waitElementToBeVisible(searchFieldXpath, 3);
        driver.getWebDriver().findElement(By.xpath(searchFieldXpath)).clear();


    }

    public void addToBasket() {
        driver.getWebDriver().findElement(By.xpath(addToBasketButtonXpath)).click();
        closeModalWindow(modalWindowElementXpath);

    }

    public void closeModalWindow(String xpath) {

        if (driver.waitElementToBeVisible(xpath, 10)) {
            driver.getWebDriver().findElement(By.xpath(xpath)).click();
            driver.waitElementToBecomeInvisible(xpath, 10);
        }
    }

    public void navigateToBasket() {
        driver.getWebDriver().switchTo().activeElement();
        driver.waitElementToBecomeInvisible(modalWindowElementXpath, 3);
        basketButton = driver.getWebDriver().findElement(By.xpath(basketButtonXpath));
        driver.waitElementToBeActive(basketButtonXpath, 3);
        basketButton.click();
    }

    public String returnDeliveryPrice() {
        driver.waitElementToBeVisible(shippingCostXpath, 3);
        return driver.getWebDriver().findElement(By.xpath(shippingCostXpath)).getText();

    }

    public void deleteFromBasket() {
        driver.getWebDriver().findElements(By.xpath(".//*[@id='tst_remove_from_basket']")).get(1).click();


    }

}
