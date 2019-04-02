package Instagram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class mainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\GIT\\seleniumStudy\\src\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        mainFrame action = new mainFrame();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("https://www.instagram.com/?hl=ru");


        action.registerFromMain();
        driver.quit();
    }

}



