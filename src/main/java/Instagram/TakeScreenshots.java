package Instagram;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshots {
    WebDriver driver;

    public TakeScreenshots(WebDriver driver) {
        this.driver = driver;
    }

    public TakeScreenshots Screenshot () {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
        String fileName = format.format(dateNow) + ".png";

//        File screenshot =
    return this;
    }

}
