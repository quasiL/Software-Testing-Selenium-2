import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMGetAdvancedSearchPage {
    WebDriver driver;
    @FindBy(xpath = "//button[@class='pillow-btn open-search-options']")
    WebElement searchButton;
    @FindBy(id = "advanced-search-link")
    WebElement searchLink;

    public POMGetAdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Click on search button
    public void clickSearch() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", searchButton);
        executor.executeScript("arguments[0].click();", searchLink);
    }
}
