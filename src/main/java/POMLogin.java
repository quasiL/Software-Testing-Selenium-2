import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMLogin {
    WebDriver driver;
    @FindBy(id = "login-box-email")
    WebElement email;
    @FindBy(id = "login-box-pw")
    WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-monster']")
    WebElement submitButton;

    public POMLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Set email in textbox
    public void setEmail(String strEmail) {
        email.sendKeys(strEmail);
    }

    //Set password in password textbox
    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    //Click on submit button
    public void submitLogin() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", submitButton);
    }

    public void loginToSite(String strEmail, String strPasword) {
        //Fill email
        this.setEmail(strEmail);
        //Fill password
        this.setPassword(strPasword);
        //Click submit button
        this.submitLogin();
    }
}
