import Instagram.TakeScreenshots;
import Instagram.normallyMainPage;
import Instagram.normallyRegister;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class normallyTestRegisterFacebookIncorrect {

    private WebDriver driver;
    private normallyRegister Register;
    private normallyMainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\GIT\\seleniumStudy\\src\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com");
        mainPage = new normallyMainPage(driver);
        Register = new normallyRegister(driver);
    }

    @Test

    public void goToFacebook (){
        mainPage.clickRegister();
        String testValue = Register.facebookPageHeader();
        Assert.assertEquals("Вход на Facebook" ,testValue);

    }


    @Test

    public void incorrectLogin (){
        mainPage.clickRegister();
        Register.registerFacebook("qow","qow");
        String testvalue1 = Register.facebookIncorrectPageHeader();
        System.out.println(testvalue1);
        Assert.assertEquals("Вход",testvalue1);
    }

    @After
    public void tearDown() {
        TakeScreenshots photo = new TakeScreenshots(driver);
        photo.Screenshot();

        driver.quit();
    }

}
