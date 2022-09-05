package in.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@SuppressWarnings("unchecked")
public class ProductPage extends BasePage {
    ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOf(productNameLbl));
        return productNameLbl.getText();
    }

    @FindBy(xpath = "//span[@id=\"productTitle\"]")
    WebElement productNameLbl;
}
