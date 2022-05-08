import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMGetLoginPage {
    WebDriver driver;
    @FindBy(xpath = "//a[@class='register-link flyout-caption']")
    WebElement loginButton;

    public POMGetLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Click on login button
    public void clickLogin() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", loginButton);
    }
}
