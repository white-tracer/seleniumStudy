package Instagram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class mainFrame {

    WebDriver driver;

    public static void main(String[] args) {
    }

    // Локаторы главной страницы

    private By loginFacebook = (By.xpath("//button[@class=\"_0mzm- sqdOP  L3NKy       \" and @type=\"button\"]")); //войти через Facebook
    private By registerButton = (By.xpath("//button[@class=\"_0mzm- sqdOP  L3NKy       \" and @type=\"button\"]")); //Submit Регистрация
    private By loginLink = (By.xpath("//p[@class=\"izU2O\"]/a")); // ссылка "Вход"
    private By phoneInput = (By.xpath("//input[@name=\"emailOrPhone\"]")); // поле ввода телефона или почты
    private By fullNameInput = (By.xpath("//input[@name=\"fullName\"]")); // поле ввода имени и фамилии
    private By usernameInput = (By.xpath("//input[@name=\"username\"]")); // поле ввода никнейма
    private By passwordInput = (By.xpath("//input[@name=\"password\"]")); // поле ввода имени и фамилии

    String login = "Вася";
    String fullName = "Вася Пупкин";
    String username = "vasyan94";
    String password = "12345";

    private mainFrame typeLogin (String login) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){  // задержка для орректной подгрузки страницы
            e.printStackTrace();
        }

        driver.findElement(phoneInput).sendKeys(login);
        return this;
    }
    private mainFrame typeFullName (String fullName) {
        driver.findElement(fullNameInput).sendKeys(fullName);
        return this;
    }
    private mainFrame typeUsername (String username) {
        driver.findElement(usernameInput).sendKeys(username);
        return this;
    }
    private mainFrame typePassword (String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }
    private mainFrame clickFacebookLogin () {
        driver.findElement(loginFacebook).click();
        return this;
    }
    private mainFrame clickRegisterButton () {
        driver.findElement(registerButton).submit();
        return this;
    }
    private mainFrame clickloginLink () {
        driver.findElement(loginLink).click();
        return this;
    }

    public mainFrame registerFromMain () {

//        WebDriverWait wait = new WebDriverWait(driver, 5);
        mainFrame reg = new mainFrame();
//        wait.until(ExpectedConditions.presenceOfElementLocated(phoneInput));
        reg.typeLogin(login);
        reg.typeFullName(fullName);
        reg.typeUsername(username);
        reg.typePassword(password);
        reg.clickRegisterButton();

        return this;

//        for (int i=1 ; i < 4 ; i++){
//            if ()
//        }

    }

}
