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
        driver.get("https://www.instagram.com");
        run.register("qwerty", "qwerty", "qwerty", "qwerty" );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // задержка для орректной подгрузки страницы
            e.printStackTrace();
        }

        driver.quit();
    }
}
