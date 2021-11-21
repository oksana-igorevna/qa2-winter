package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DelfiTest {
    private final String WEBSITE_LINK = "http://delfi.lv";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".// button [@mode = 'primary']");
    private final By ARTICLE_TITLE = By.xpath(".//h1 [contains(@class, 'headline__title')]");
    private WebDriver driver;


    @Test
    public void titleCheck() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(WEBSITE_LINK);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        driver.findElement(ACCEPT_COOKIES_BTN).click();

        WebElement firstTitle = driver.findElement(ARTICLE_TITLE);
        System.out.println(firstTitle.getText());

        List<WebElement> titles = driver.findElements(ARTICLE_TITLE);

        for (int i = 0; i < titles.size(); i++) {
            System.out.println(titles.get(i).getText());
        }
        driver.findElement(ARTICLE_TITLE).click();
    }


    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

}

