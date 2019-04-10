package Instagram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class normallyRegister {
    WebDriver driver;

    public normallyRegister(WebDriver driver) {
        this.driver = driver;
    }
//  локаторы страницы
    private By login = By.xpath("//input[@name='email']");
    private By pass = By.xpath("//input[@name='pass']");
    private By registerButton = By.xpath("//button[@name='login']");

    public normallyRegister typeLogin(String loginValue) {
        driver.findElement(login).sendKeys(loginValue);
        return this;
    }

    public normallyRegister typePassword(String passwordValue) {
        driver.findElement(pass).sendKeys(passwordValue);
        return this;
    }

    public normallyRegister registerClick() {
        driver.findElement(registerButton).click();
        return this;
    }

//    public normallyRegister clickRegister(){
//        driver.findElement(registerButton).click();
//        return new normallyRegister(driver);
//    } - должно запускаться из другой страницы

    public normallyRegister registerFacebook (String loginValue, String passwordValue) {
      //  this.clickRegister();
        this.typeLogin(loginValue);
        this.typePassword(passwordValue);
        this.registerClick();

        return this;
    }

}