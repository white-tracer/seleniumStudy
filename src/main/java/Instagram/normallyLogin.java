package Instagram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class normallyLogin {

    WebDriver driver;

    public normallyLogin(WebDriver driver) {
        this.driver = driver;
    }

    private By Login = By.xpath("//input[@name='username']");
    private By Password = By.xpath("//input[@name='password']");
    private By LoginButton = By.xpath("//button[@type='submit']");

    public normallyLogin typeLogin(String LoginValue){ // переход на страницу регистрации через фейсбук
        driver.findElement(Login).sendKeys(LoginValue);
        return new normallyLogin(driver);
    }

    public normallyLogin typePassword(String PasswordValue){ // переход на страницу регистрации через фейсбук
        driver.findElement(Password).sendKeys(PasswordValue);
        return new normallyLogin(driver);
    }

    public normallyLogin clickLogin () {
        driver.findElement(LoginButton).submit();
        return this;
    }

    public normallyLogin Auth (String Loginvalue, String PasswordValue){
        this.typeLogin(Loginvalue);
        this.typePassword(PasswordValue);
        this.clickLogin();
        return this;
    }

//    public normallyLogin Auth () {  - решил попробовать проверить, когда будет отображаться элемент/ надо бы разобраться
//        int i;
//        for (i = 0; i <= 3; i++) {
//            if (driver.findElement(LoginButton).isEnabled()) {
//                driver.findElement(LoginButton).submit();
//                return this;
//            } else {
//                if (i != 3) {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {  // ждем, чтоб проверить - стала ли кнопка активной
//                        e.printStackTrace();
//                    }
//                }
//                else {
//                    return this;
//                    driver.quit();
//                }
//            }
//        }
////        return this;
//    }

}
