//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controladorlocal;

import file.FileHelper;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

public class FileHelperEdit {
    private static FileHelperEdit instance = null;
    static Logger logger = LoggerFactory.getLogger(FileHelper.class);

    public FileHelperEdit() {
        // Este constructor está vacío porque la clase FileHelperEdit se utiliza como una clase de utilidad
    }


    public static FileHelperEdit getInstance() {
        if (instance == null) {
            instance = new FileHelperEdit();
        }

        return instance;
    }


    public String takeScreenShotByte(WebDriver driver) {
        String destination = "";

        try {
            File file = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] imageByte = IOUtils.toByteArray(new FileInputStream(file));
            destination = Base64.getEncoder().encodeToString(imageByte);
        } catch (Exception var5) {
            logger.error("Error Class FileHelper in method takeScreenShotByte ", var5);
        }

        return destination;
    }


    public String takeScreenShotByteAppium(AndroidDriver driver) {
        String destination = "";

        try {
            File file = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] imageByte = IOUtils.toByteArray(new FileInputStream(file));
            destination = Base64.getEncoder().encodeToString(imageByte);
        } catch (Exception var5) {
            logger.error("Error Class FileHelper in method takeScreenShotByte ", var5);
        }

        return destination;
    }

    public InputStream getFileInsideJar(String route) {
        return this.getClass().getResourceAsStream(route);
    }
}
