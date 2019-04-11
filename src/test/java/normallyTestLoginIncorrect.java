import Instagram.normallyLogin;
import Instagram.normallyMainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class normallyTestLoginIncorrect {

    private WebDriver driver;
    private normallyMainPage mainPage;
    private normallyLogin loginIncorrect;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\GIT\\seleniumStudy\\src\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com");
        mainPage = new normallyMainPage(driver);
        loginIncorrect = new normallyLogin(driver);
    }

    @Test
    public void instagramLoginpage (){
        mainPage.clickLogin();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // смотрим результат
            e.printStackTrace();
        }

        Assert.assertEquals("Войти" , loginIncorrect.loginMarker());
    }

    @Test
    public void insagramIncorrectAuth () {
        mainPage.clickLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // смотрим результат
            e.printStackTrace();
        }
        loginIncorrect.Auth("111","111");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // смотрим результат
            e.printStackTrace();
        }

        Assert.assertEquals("Введенное вами имя пользователя не принадлежит аккаунту. Проверьте свое имя пользователя и повторите попытку.", loginIncorrect.IncorrectAuthMarkerValue());
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
