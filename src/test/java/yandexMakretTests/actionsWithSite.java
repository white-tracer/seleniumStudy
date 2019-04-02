package yandexMakretTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class actionsWithSite {
    public static void main(String[] args) {

        System.out.println("Блять");
        actionsWithSite.navigate("https://market.yandex.ru/");

    }

    static WebDriver driver;

    public static void navigate(String siteName) {
       System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\testselenium\\drivers\\chromedriver.e/xe");
       WebElement goSite = driver.get("siteName");
    }

}
