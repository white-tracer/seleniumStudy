package Instagram;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
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

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("D:\\screenshots\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

}
