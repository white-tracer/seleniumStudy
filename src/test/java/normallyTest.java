import Instagram.normallyMainPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class normallyTest {

    private WebDriver driver;
    private normallyMainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\GIT\\seleniumStudy\\src\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com");
        mainPage = new normallyMainPage(driver);
    }

    @Test
    public void incorrectLogin (){
        mainPage.register("qwe","qwe","qwe", "qwe");
        String testValue = mainPage.assertIncorrectRegistation();
        Assert.assertEquals("Это имя пользователя уже занято. Попробуйте другое." ,testValue);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
