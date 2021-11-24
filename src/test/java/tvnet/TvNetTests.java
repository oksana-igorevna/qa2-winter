package tvnet;

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

public class TvNetTests {
    private final String HOME_PAGE_URL = "http://tvnet.lv"; // url zanosim v peremennuju
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']"); //locator na acceptcookies button
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop ='headline name']"); //locator na nazvanie statji (ljuboj)
    private WebDriver browser; //viveli na urovenj classa, prinadlezit classu

    @Test
    public void titleCheck() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver(); //prinadlezit metodu
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10)); //zdet element poka zagruzitsja 10 sek, kak nashel poshel dalwe
        browser.manage().window().maximize();

        browser.get(HOME_PAGE_URL); //perejti po ssilke
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));//chego nuzno dozdatjsja
        browser.findElement(ACCEPT_COOKIES_BTN).click(); //klikaem na acceptcookies button

        WebElement firstTitle = browser.findElement(ARTICLE_TITLE);//najti pervij element po locator
        System.out.println(firstTitle.getText()); //vivesti v console tekstom/strokoj pervij zagolovok

        List<WebElement> titles = browser.findElements(ARTICLE_TITLE); //najti spisok elementov zagolok statej
        System.out.println(titles.get(0).getText()); //raspechatatj pervij iz spiska v console, pervogo t.k index 0

        //browser.close(); //zakritj browser posle testa, no esli test upadet do browser ne zakroetsja

    }

    @AfterEach //chtobi zakrivalsja v ljubom sluchae passed test ili net, posle kazdogo zakrivatj
    public void closeBrowser() {
        browser.close(); //poetomu luchwe tak, otdeljnim metodom

    }
}
