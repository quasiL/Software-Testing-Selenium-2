import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POMSearchForm {
    WebDriver driver;
    @FindBy(id = "all-words")
    WebElement allWords;
    @FindBy(id = "least-words")
    WebElement leastWords;
    @FindBy(id = "date-facet-mode")
    WebElement selectIn;
    @FindBy(id = "facet-start-year")
    WebElement startYear;
    @FindBy(id = "submit-advanced-search")
    WebElement submitButton;

    public POMSearchForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setAllWords(String strAllWords) {
        allWords.sendKeys(strAllWords);
    }

    public void setLeastWords(String strLeastWords) {
        leastWords.sendKeys(strLeastWords);
    }

    public void selectInterval(String strStartYear) {
        Select select = new Select(selectIn);
        select.selectByVisibleText("in");
        startYear.sendKeys(strStartYear);
    }

    public void submitSearch() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", submitButton);
    }

    public void search(String strAllWords, String strLeastWords, String strStartYear) {
        this.setAllWords(strAllWords);
        this.setLeastWords(strLeastWords);
        this.selectInterval(strStartYear);
        this.submitSearch();
    }
}
