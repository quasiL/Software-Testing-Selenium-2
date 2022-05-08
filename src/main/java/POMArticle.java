import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class POMArticle {
    WebDriver driver;
    List<String> list = new ArrayList<>();;
    @FindBy(xpath = "//h1[@class='c-article-title']")
    WebElement articleTitle;
    @FindBy(tagName = "time")
    WebElement articleDate;
    @FindBy(xpath = "//*[contains(text(), 'https://doi.org/')]")
    WebElement articleDOI;

    public POMArticle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTitle() {
        list.add(articleTitle.getText());
    }

    public void getTime() {
        list.add(articleDate.getText());
    }

    public void getDOI() {
        list.add(articleDOI.getText());
    }

    public List<String> getInformationAboutArticle() {
        this.getTitle();
        this.getTime();
        this.getDOI();
        return list;
    }
}
