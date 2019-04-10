package Instagram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// просто создаем класс

public class normallyMainPage {
    private WebDriver driver;  // переменная вне метода

//    создаем конструктор класса

    public normallyMainPage(WebDriver driver) {  // конструктор через ALT+insert
        this.driver = driver;  // WTF - зачем этот тут?
    }

//    создаем локаторы вне метода

    private By loginFacebook = (By.xpath("//button[@class=\"_0mzm- sqdOP  L3NKy       \" and @type=\"button\"]")); //войти через Facebook
    private By registerButton = (By.xpath("//button[@class=\"_0mzm- sqdOP  L3NKy       \" and @type=\"button\"]")); //Submit Регистрация
    private By loginLink = (By.xpath("//p[@class=\"izU2O\"]/a")); // ссылка "Вход"
    private By phoneInput = (By.xpath("//input[@name=\"emailOrPhone\"]")); // поле ввода телефона или почты
    private By fullNameInput = (By.xpath("//input[@name=\"fullName\"]")); // поле ввода имени и фамилии
    private By usernameInput = (By.xpath("//input[@name=\"username\"]")); // поле ввода никнейма
    private By passwordInput = (By.xpath("//input[@name=\"password\"]")); // поле ввода имени и фамилии
    private By incorrectRegResult = (By.xpath("//p[@class='Ma93n']")); // поле ввода имени и фамилии



//    дальше пишем методы для работы с кнопками, переводящими на другую страницу. Тут надо быть аакуратным!

    public normallyLogin clickFacebookLogin () {  // при клике произойдет переход на другую страницу. Поэтому
        driver.findElement(loginFacebook).click();        // мы именуем метод ее классом и возвращаем новый объект данного класса с драйвером
        return new normallyLogin(driver);
    }

    public normallyRegister clickRegisterButton () {
        driver.findElement(registerButton).submit();
        return new normallyRegister(driver);
    }

//       тут опишем методы для работы с полями - заполнение полей и т.д.

    public normallyMainPage typeLogin (String login){     // при срабатывании метода все действия будут на данной странице. Поэтому
        driver.findElement(phoneInput).sendKeys(login);   // мы именуем метод текущим классом и возвращаем this.
        return this;
    }

    public normallyMainPage typeFullname (String fullname){
        driver.findElement(fullNameInput).sendKeys(fullname);
        return this;
    }

    public normallyMainPage typeUsername (String username){
        driver.findElement(usernameInput).sendKeys(username);
        return this;
    }

    public normallyMainPage typePassword (String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public normallyRegister clickRegister(){ // переход на страницу регистрации через фейсбук
        driver.findElement(registerButton).click();
        return new normallyRegister(driver);
    }

    public normallyLogin clickLogin(){ // переход на страницу авторизации в инсте
        driver.findElement(loginLink).click();
        return new normallyLogin(driver);
    }


    // напишем метод, проверяющий ответ пи попытке входа с неверными данными. Все действия происходят на одной странице

    public normallyMainPage register (String login, String fullname, String username, String password){
        this.typeLogin(login);       // т.к. используем метод данного класса - пишем this. Если бы был метод другого класса,
        this.typeFullname(fullname); // создали бы объект, и писали бы @className.methodname();
        this.typeUsername(username);
        this.typePassword(password);
        this.clickRegisterButton();
        return this;
    }


    // методы для тестов и проверок

    public String assertIncorrectRegistation (){
        String errorText = driver.findElement(incorrectRegResult).getText();
        return errorText;
    }
}
