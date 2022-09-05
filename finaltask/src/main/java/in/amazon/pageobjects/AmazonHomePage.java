package in.amazon.pageobjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class AmazonHomePage extends BasePage {
    final static Logger logger = LogManager.getLogger(AmazonHomePage.class);

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isOpen() {
        wait.until(ExpectedConditions.visibilityOf(searchBarTxt));
        logger.info("Verifying, is amazon page open");
        return driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }

    public void searchProduct(String productName) {
        logger.info("Searching for product");
        searchBarTxt.sendKeys(productName, Keys.ENTER);
    }

    public boolean areResultsVisible() {
        wait.until(ExpectedConditions.visibilityOf(resultsLbl));
        logger.info("Verifying whether it is a results page");
        return resultsLbl.getText().equalsIgnoreCase("Results");
    }

    public void selectDeliveryDay(String string) {
        String xpath = String.format("//span[contains(text(),\"%s\")]/ancestor::a[@class=\"a-link-normal s-navigation-item\"]//i[@class=\"a-icon a-icon-checkbox\"]", string);
        logger.info("Selecting the checkbox " + string);
        driver.findElement(By.xpath(xpath)).click();
    }

    public List<WebElement> getProductSearchResults() {
        String xpath = "//div[@data-component-type=\"s-search-result\"]//a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"]";
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), 10));
        logger.info("Getting the list of results from the results obtained from the product search");
        return driver.findElements(By.xpath(xpath));
    }

    public List<String> verifyProduct(WebElement element) {
        List<String> results = new ArrayList<>();
        results.add(element.getText());
        String currentWindowHandle = driver.getWindowHandle();
        element.click();
        Set<String> windowHandles = driver.getWindowHandles();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
        ProductPage productPage = new ProductPage(driver);
        results.add(productPage.getProductName());
        driver.close();
        driver.switchTo().window(currentWindowHandle);
        return results;
    }


    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBarTxt;

    @FindBy(xpath = "//span[contains(text(),\"RESULTS\")]")
    WebElement resultsLbl;

}
