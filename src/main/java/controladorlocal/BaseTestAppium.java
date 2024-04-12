

package controladorlocal;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import configbrowser.BrowserType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTestAppium {
    private static AndroidDriver<AndroidElement> driver;
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest scenario;
    private static ExtentTest testCase;
    private static String scenarioName = "";
    static Logger logger = LoggerFactory.getLogger(BaseTestAppium.class);
    private static String optionaEmailTo = "";
    private static String optionaEmailCc = "";
    private static AppiumDriverLocalService service;




    public void openBrowser(String url) {
        driver.navigate().to(url);
    }

    @BeforeMethod
    @Parameters({"browserName", "emailTo", "emailCc"})
    public static void beforeMethodMethod(String browserName, Method testMethod, ITestContext context, @Optional String emailTo, @Optional String emailCc) throws DriverCreationException {
        if (!scenarioName.equalsIgnoreCase(context.getCurrentXmlTest().getName())) {
            scenarioName = context.getCurrentXmlTest().getName();
            scenario = extent.createTest(scenarioName);
        }

        optionaEmailTo = emailTo;
        optionaEmailCc = emailCc;
        testCase = scenario.createNode(((Test)testMethod.getAnnotation(Test.class)).description());
        testCase.assignCategory(new String[]{scenarioName});
        testCase.assignCategory(new String[]{"<b>TOTALS</b>"});
        if (!BrowserType.valueOf(browserName).equals(BrowserType.NONE)) {
            setupDriver();
            scenario.assignDevice(new String[]{browserName});
        }

    }

    @AfterMethod
    public void  afterMethodMethod(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "Test case: " + methodName;
        if (result.getStatus() == 2) {
            logText = logText + " (Fallido) ";
            testCase.log(Status.FAIL, logText);
        } else if (result.getStatus() == 3) {
            logText = logText + " (Saltado) " + methodName;
            testCase.log(Status.SKIP, logText);
        }

        if (driver != null) {
            driver.quit();
        }

    }

    public void createStep(String textInfo) {
        testCase.log(Status.PASS, "<pre>" + textInfo + "</pre>");
    }

    public static void createStep(String description, boolean decision, boolean takeScreenShot) {
        String screenshot = "";
        screenshot = takeScreenShot ? FileHelperEdit.getInstance().takeScreenShotByte(driver) : "";
        testCase = decision && takeScreenShot ? testCase.pass(description, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build()) : testCase;
        testCase = decision && !takeScreenShot ? testCase.pass(description) : testCase;
        testCase = !decision && takeScreenShot ? testCase.fail(description, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build()) : testCase;
        testCase = !decision && !takeScreenShot ? testCase.fail(description) : testCase;
    }





    public static void setupDriver() throws DriverCreationException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.artech.infocorp_bhd.bhd.dev");
        capabilities.setCapability("appActivity", "com.artech.infocorp_bhd.bhd.dev.MainActivity");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("deviceName", "Pixel5w");

        try {
            URL remoteUrl = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(remoteUrl, capabilities);
        } catch (MalformedURLException e) {
            throw new DriverCreationException(e);
        }


    }


    public static class DriverCreationException extends Exception {
        public DriverCreationException(Throwable cause) {
            super(cause);
        }
    }



    public static String getEmailCc() {
        return optionaEmailCc;
    }

    public static String getOptionaEmailTo() {
        return optionaEmailTo;
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public static ExtentReports getExtent() {
        return extent;
    }
}
