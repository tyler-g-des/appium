package controladorlocal;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.nativekey.AndroidKey;

import java.time.Duration;

public class Base {
    protected AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    private int reintento=0;

    public Base(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
    }

    public void click(By element, long timeOut, String description, boolean report, boolean takeScreenShot){

        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(element)));
            this.driver.findElement(element).click();
            crearPaso("Se hizo click en el boton " + description,true,report,takeScreenShot);
        }catch (Exception exception){
            crearPaso("No se puede hacer click en el elemento " + description,false,report,true);
            throw (exception);
        }
    }

    public void clickCoordinates(int X,int Y, long timeOut, String description, boolean report, boolean takeScreenShot){

        try {
            TouchAction touchAction = new TouchAction(driver).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4)));
            touchAction.tap(PointOption.point(X, Y)).perform();
            touchAction.press(PointOption.point(X, Y)).perform();
            crearPaso("Se hizo click en el boton " + description,true,report,takeScreenShot);
        }catch (Exception exception){
            crearPaso("No se puede hacer click en el elemento " + description,false,report,true);
            throw (exception);
        }
    }

    public void nativeButtonBack(boolean report, boolean takeScreenShot){
        try {
            driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
            crearPaso("Se utilizo el boton retroceder nativo " ,true,report,takeScreenShot);
        }catch (Exception exception){
            crearPaso("No se  utilizar el boton retroceder nativ o",false,report,true);
            throw (exception);
        }
    }

    public void pressButtonTAB(boolean report, boolean takeScreenShot){
        try {
            driver.pressKey(new KeyEvent().withKey(AndroidKey.TAB));
            crearPaso("Se utilizo el boton TAB del teclado ",true,report,takeScreenShot);
        }catch (ElementClickInterceptedException exception){
            crearPaso("No se pudo utilizar el boton  TAB",false,report,true);
            throw (exception);
        }
    }

    public  boolean isElementPresent(By element, long timeOut) {
        boolean status = false;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            status = true;
        } catch (NoSuchElementException e) {
            BaseTestAppium.createStep("No se encontro el elemento " + element,false,true);
            throw (e);
        }catch (TimeoutException e) {
            BaseTestAppium.createStep("Se supero el tiempo de espera para encontrar el elemento " + element,false,true);
            throw (e);
        }
        return status;
    }

    public  boolean isElementPresentNotPresent(By element, long timeOut) {
        boolean status = false;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(element))));
            status = true;

        } catch (NoSuchElementException e) {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(element))));
            status = true;

        } catch (TimeoutException e) {
            BaseTestAppium.createStep("Se supero el tiempo de espera para encontrar el elemento " + element,false,true);
            throw (e);
        }
        return status;
    }

    public void setText(By element, String text, long timeOut,Boolean report, boolean takeScreenShot ){
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            driver.findElement(element).sendKeys(text);
            crearPaso("Se introdujo el texto "+ text ,true,report,takeScreenShot);
        }catch (NoSuchElementException e){
            BaseTestAppium.createStep("No se encontro el elemento ",false,false);
            throw (e);
        }
    }

    public void dropDownStep(){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().focusable(true)).scrollForward();");
    }

    public void dropDown(String text, boolean report, boolean takeScreenShot){
        if(reintento != 3) {
            try {
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().focusable(true)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\"));");
                crearPaso("Se deslizo la lista", true, report, takeScreenShot);
            } catch (NoSuchElementException ex) {
                reintento ++;
                dropDown(text, report, takeScreenShot);
            } catch (Exception e) {
                crearPaso("error dropDown " + e, false, report, takeScreenShot);
                throw (e);
            }
        }
    }

    public void dropDownCoinicidencia(String text, boolean report, boolean takeScreenShot){
        if(reintento != 4) {
            try {
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().focusable(true)).scrollIntoView(new UiSelector().textContains(\"" + text + "\"));");
                crearPaso("Se deslizo la lista", true, report, takeScreenShot);
            } catch (NoSuchElementException | TimeoutException ex) {
                reintento ++;
                dropDown(text, report, takeScreenShot);
            } catch (Exception e) {
                crearPaso("error dropDown " + e, false, report, takeScreenShot);
                throw (e);
            }
        }
    }

    /**
     * ✔✔✔... Este método nos permite plasmar en el reporte una acción realizada, si fue exitosa, fallida o si se quiere o no tomar captura de dicho paso.
     * @param description Esta en el reporte será la descripción del paso realizado.
     * @param decision Define si el paso fue éxito o fallido. True = exitoso, False = fallido.
     * @param createReport Define si se creara reporte o no del paso realizado. True = creara el reporte, False = No creara reporte.
     * @param takeScreenShot Este parámetro sirve para tomar o no una captura del paso realizado.
     */
    public void crearPaso(String description, boolean decision, boolean createReport, boolean takeScreenShot){
        if (createReport){
            BaseTestAppium.createStep(description, decision, takeScreenShot);
        }
    }

    public static void scrollAndFindElement(AndroidDriver<AndroidElement> driver, By locator) {
        int maxScrollAttempts = 10;
        int currentScrollAttempts = 0;
        WebElement element = null;

        while (currentScrollAttempts < maxScrollAttempts) {
            try {
                element = new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.presenceOfElementLocated(locator));
                break;  // Element found, exit loop
            } catch (Exception e) {
                // Perform swipe up gesture to scroll
                Dimension size = driver.manage().window().getSize();
                int startX = size.width / 2;
                int startY = (int) (size.height * 0.9);
                int endY = (int) (size.height * 0.1);
                TouchAction touchAction = new TouchAction(driver);
                touchAction.longPress(PointOption.point(startX, startY))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
            }

            currentScrollAttempts++;
        }
    }

}
