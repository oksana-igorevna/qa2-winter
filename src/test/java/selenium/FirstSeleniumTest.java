package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    @Test
    public void firstTvNetTest() {
        //propisatj sistemnuju peremennuju
        //Setting path where driver is stored
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe"); //kljuch, on v oshibke v console i putj k chrome driver ; .exe toljko dlja windows
        //Opening browser window. Variable (peremennaja) browser will contain Browser Window
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize(); //chtobi browser otkrilsja vo vesj ekran

        browser.get("http://tvnet.lv");
    }
}
