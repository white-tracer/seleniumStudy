import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



/*
Тест-кейс 1.
Формат описания: действия - ОР

Шаг 1:
Переход на mail.ru - Открылся mail.ru
Шаг 2:
Ввод неверных данных учетки - Переход на страницу с ошибкой входа
Шаг 3:
Ввод корректных данных - переход в учетку
Шаг 4:
Нажатие на кнопку "выход" в учетке - выход на страницу авторизации

*/

public class mainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        String mailRuURL = "https://mail.ru/";

        System.setProperty("webdriver.chrome.driver", "D:\\soft\\javaProject\\testselenium\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));

        // шаг 1-ый. Заходим на mail.ru и проверяем что сайт работает
        driver.get("https://mail.ru/");

        String URL = driver.getCurrentUrl();
        if (URL.equals(mailRuURL)) {
            System.out.println("Шаг 1: УСПЕШНО - Вход на сайт выполнен");
        }
        else {
            System.out.println("Шаг 1: ТЕСТ ПРОВАЛЕН");
            driver.quit();
            return;
        }

        // Шаг 2-ой. Входим в учетную запись с некорректным паролем

        driver.manage().deleteAllCookies(); // чистим куки

        WebElement login = driver.findElement(By.xpath("//input[@id=\"mailbox:login\"]"));
        login.sendKeys("helmut77"); // вводим логин
        WebElement password = driver.findElement(By.xpath("//input[@id=\"mailbox:password\"]"));
        password.sendKeys("qwerty"); // вводим пароль

        driver.findElement(By.xpath("//label[@id=\"mailbox:submit\"]")).submit(); // пытаемся войти в учетку

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // задержка для орректной подгрузки страницы
            e.printStackTrace();
        }

        if ( driver.findElements(By.xpath("//p[@class=\"c0126 c0126 c0143 c0138\"]")).size() > 0) {
            System.out.println("Шаг 2: УСПЕШНО - Вход с некорректным паролем недоступен");
        }
        else {
            System.out.println("Шаг 2: ТЕСТ ПРОВАЛЕН");
            driver.quit();
            return;
        }

        // Шаг 3. Заходим корректным юзером helmut77@mail.ru / 777888AQW

//        driver.manage().deleteAllCookies(); // чистим куки
        driver.get("https://mail.ru/");

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e){  // задержка для орректной подгрузки страницы
            e.printStackTrace();
        }

//        WebDriverWait wait = new WebDriverWait() {
////        };

        WebElement loginCorrect = driver.findElement(By.xpath("//input[@id=\"mailbox:login\"]"));
        WebElement passwordCorrect = driver.findElement(By.xpath("//input[@id=\"mailbox:password\"]"));
        loginCorrect.sendKeys("helmut77"); // вводим логин
        passwordCorrect.sendKeys("777888AQW"); // вводим пароль

        driver.findElement(By.xpath("//label[@id=\"mailbox:submit\"]")).submit(); // пытаемся войти в учетку

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e){  // задержка для орректной подгрузки страницы
            e.printStackTrace();
        }

        if (driver.findElements(By.xpath("//i[@id=\"PH_user-email\"]")).size()> 0 && driver.findElements(By.xpath("//a[@title=\"выход\"]")).size()> 0  )
            System.out.println("Шаг 3: УСПЕШНО - Вход с верным паролем доступен");
        else {
            System.out.println("Шаг 3: ТЕСТ ПРОВАЛЕН");
            driver.quit();
            return;
        }

        // Шаг 4. Выходим из учетки.

        driver.findElement(By.xpath("//a[@title=\"выход\"]")).click();  // выходим из учетки

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){  // задержка для орректной подгрузки страницы
            e.printStackTrace();
        }


        if (driver.getTitle().equals("Авторизация")) {
            System.out.println("Шаг 4: УСПЕШНО - Выход из учетной записи выполнен");
            System.out.println("ТЕСТ ВЫПОЛНЕН !!!");
        }
        else {
                System.out.println("Шаг 4: ТЕСТ ПРОВАЛЕН");
                driver.quit();
                return;

            }

        driver.quit();
    }

}
//
////   public static class implicityWait {
////        WebDriver.Timeouts wait = driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
////       implicityWait.wait;
