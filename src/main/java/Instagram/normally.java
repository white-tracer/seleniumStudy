package Instagram;
// такая хрень есть только в dev ветке - в мастере нет.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class normally {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\GIT\\seleniumStudy\\src\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        normallyMainPage run = new normallyMainPage(driver);
        normallyRegister runFacebook = new normallyRegister(driver);
        normallyLogin runLogin = new normallyLogin(driver);

        driver.get("https://www.instagram.com");  // пробуем зарегистрироватся в инсте
        run.register("qwerty", "qwerty", "qwerty", "qwerty" );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // смотрим результат
            e.printStackTrace();
        }

        driver.get("https://www.instagram.com");  // переходим в раздел регистрация в фейсбук

        run.clickRegister();
        runFacebook.registerFacebook("qwerty", "qwerty"); // пробуем зарегаться в фейсбук

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // смотрим результат
            e.printStackTrace();
        }

        driver.get("https://www.instagram.com");
        run.clickLogin();  // переходим в авторизацию в инсте

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){  // смотрим результат
            e.printStackTrace();
        }

        runLogin.Auth("qewrty", "qwerty"); // пробуем авторизоваться в инсте

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // смотрим результат
            e.printStackTrace();
        }


        driver.navigate().back(); // возвращаемся назад - видим что в инсте уже окно входа, а не регистрации
        driver.manage().deleteAllCookies();
        ((ChromeDriver) driver).getLocalStorage().clear();
        ((ChromeDriver) driver).getSessionStorage().clear();
        driver.navigate().refresh(); // а вот теперь, по логике, должна снова появиться регистрация в инсте.

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // смотрим результат
            e.printStackTrace();
        }

        driver.quit();
    }
}
