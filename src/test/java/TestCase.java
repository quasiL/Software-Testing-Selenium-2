import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
    String driverPath = "/usr/local/bin/chromedriver";
    WebDriver driver;
    POMGetLoginPage objPageLogin;
    POMLogin objLogin;
    POMGetAdvancedSearchPage objPageSearch;
    POMSearchForm objSearchForm;
    POMSearchResults objSearchResults;
    List<WebElement> linkList = new ArrayList<>();
    POMArticle objArticle;
    List<List<String>> articleList = new ArrayList<>();
    List<String> articleTestList = new ArrayList<>();

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get("https://link.springer.com/");
    }

    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
        //Create Find Login Page object
        objPageLogin = new POMGetLoginPage(driver);
        //Click on login button
        objPageLogin.clickLogin();
        //Create Login Page object
        objLogin = new POMLogin(driver);
        //login to application
        objLogin.loginToSite("", "");

        objPageSearch = new POMGetAdvancedSearchPage(driver);
        objPageSearch.clickSearch();
        objSearchForm = new POMSearchForm(driver);
        objSearchForm.search("Page Object Model", "Selenium Testing", "2022");
        objSearchResults = new POMSearchResults(driver);
        linkList = objSearchResults.analyzeResults();

        for (int i = 0; i < linkList.size(); i++) {
            driver.get(linkList.get(i).getAttribute("href"));
            objArticle = new POMArticle(driver);
            articleList.add(objArticle.getInformationAboutArticle());
            driver.navigate().back();
        }

        //Tests;
        Assert.assertEquals(articleList.get(0).get(0), "APOGEN: automatic page object generator for web testing");
        Assert.assertEquals(articleList.get(1).get(0), "Model-based testing leveraged for automated web tests");
        Assert.assertEquals(articleList.get(2).get(0), "ESICM LIVES 2017");
        Assert.assertEquals(articleList.get(3).get(0), "ESICM LIVES 2020");

        Assert.assertEquals(articleList.get(0).get(1), "09 August 2016");
        Assert.assertEquals(articleList.get(1).get(1), "27 November 2021");
        Assert.assertEquals(articleList.get(2).get(1), "20 September 2017");
        Assert.assertEquals(articleList.get(3).get(1), "14 December 2020");
    }
}
