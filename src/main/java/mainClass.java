import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\testselenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://www.market.yandex.ru");

        // driver.findElement(By.xpath("//label[text()='$s']/preceding-sibling::span")).isSelected()) - использовали, чтобы проверить выделен ли чекбокс

        selectCheckBox("Atlant"); // - так мы теперь работаем с чекбосами

    }



    // метод для работы с чекбоксами - упрощает постоянные проверки чекбосов. Чтобы постоянно не вписывать длинный xpath, а работать с коротким кодов

    public static void selectCheckBox (String name){

        String rbXpath = "//label[text()='$s']/preceding-sibling::span";  // задаем переиспользуемый xpath
        if (driver.findElement(By.xpath(String.format(rbXpath, name + "input"))).isSelected()); // стало
        driver.findElement(By.xpath(String.format(rbXpath, name))).click(); // стало

//      if (!driver.findElement(By.xpath("//label[text()='ATLANT']/preceding-sibling::span/input"))).isSelected()); - было
//      driver.findElement(By.xpath(String.format("//label[text()='ATLANT']/preceding-sibling::span"))).click();  было
    }
}