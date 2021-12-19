package tvnet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TvNetTests2 {

    private final String HOME_PAGE_URL = "http://tvnet.lv"; // url zanosim v peremennuju
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']"); //locator na acceptcookies button
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop ='headline name']"); //locator na nazvanie statji (ljuboj)
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name]"); //locator na zagolovok na stanice
    private final String GIVEN_TITLE = "Katarā aizturētie Norvēģijas žurnālisti atgriezušies mājās"; //nazvanie staji
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
        // System.out.println(firstTitle.getText()); //vivesti v console tekstom/strokoj pervij zagolovok

        List<WebElement> titles = browser.findElements(ARTICLE_TITLE); //najti spisok elementov zagolok statej

        // cikl for
    //   for (int i = 0; i < titles.size(); i++) { //kuda zapisivaem, s kakogo elementa nachinaem, do kakix por begaem po spisku (size- do konca), i kakoj po porjadku berem - i+1 = i++ -kazhdij /kazdij vtoroj i+2 i t.d
    //       System.out.println(i + 1 + ": " + titles.get(i).getText()); //raspechatatj porjadkovij nomer i vse titles v console

    //   }

        //cikl for each
        for (WebElement title : titles) { // ukazivaem kuda klastj kazdij element(peremennaja- tile), i u kazdoj peremennoj tip dannix -webelement) i spisok kot nado obojti
            if (title.getText().startsWith(GIVEN_TITLE)) { //esli poluchili nuzhnij zagolovok, kot sovpadaet s dannim title, to klikaem, esli net idem dalwe
                title.click(); //esli poluchili nuznoe nazvanie, to klikaem po nemu
                break; // chtobi cikl perestal rabotatj kak toljko nasli nuzhnij element; chtobi test ne padal

            }

        }

 //      //cikl while
 //      int i = 0;
 //      while (i < titles.size()) { //uslovie pri kot cikl budet rabotatj (poka uslovie vipolnjaetsja)
 //          System.out.println(i + 1 + ": " + titles.get(i).getText());
 //          i++; //esli ne napishem budet pechaetj po krugu pervoe v spiske

 //       }

        //      titles.get(0).click(); //kliknutj na 1ij zagolovok iz spiska
//
              WebElement articlePageTitle = browser.findElement(ARTICLE_PAGE_TITLE); //browser najdet element po locator i soxranit v peremmunuju articlePageTitle, WebElement- tip dannix
        //      System.out.println(articlePageTitle.getText()); //raspechatatj najdennij zagolovok, getText chtobi bil textom, t.k articlePageTitle prosto webelement
        //proveritj chto poluchennij zagolovok raven dannomu, kot xoteli poluchitj; v skobkax snachala expected i potom actual result, get text zdesj t.k articlepagetile webelement a nam nuzhen string; i zatem text oshibki
       Assertions.assertEquals( GIVEN_TITLE, articlePageTitle.getText(), "Wrong title!");

//
   }

    @AfterEach //chtobi zakrivalsja v ljubom sluchae passed test ili net, posle kazdogo zakrivatj
    public void closeBrowser() {
        browser.close(); //poetomu luchwe tak, otdeljnim metodom

    }
}
