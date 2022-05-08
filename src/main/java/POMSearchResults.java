import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class POMSearchResults {
    WebDriver driver;
    List<WebElement> linkList;
    List<WebElement> list = new ArrayList<>();

    public POMSearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectArticles() {
        linkList = (List<WebElement>) driver.findElements(By.className("facet-link"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", linkList.get(1));
        linkList = (List<WebElement>) driver.findElements(By.className("title"));
        for (int i = 0; i < 4; i++) {
            list.add(linkList.get(i));
        }
    }

    public List<WebElement> analyzeResults() {
        this.selectArticles();
        return list;
    }
}
