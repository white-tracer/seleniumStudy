import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\testselenium\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.seleniumhq.org");
    }
}
