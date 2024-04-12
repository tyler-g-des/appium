package page.mbp.keycard;

import controladorlocal.Base;
import controladorlocal.BaseTestAppium;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de tarjeta de clave
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POtarjetaDeClavePagina extends Base {

    public POtarjetaDeClavePagina(AndroidDriver<AndroidElement> driver) { super(driver); }
    private TouchAction<?> touchHere = new TouchAction<>(driver);
    private By btnAccept = By.xpath("//android.widget.Button[@text=\"ACEPTAR\"]");
    private By btnNumberOne = By.xpath("//*[contains(@text,\"1\")]");
    private By btnContinue = By.xpath("//*[contains(@text,\"CONTINUAR\")]");
    private WebDriverWait wait;
    private boolean status=false;


    /**
     * Método para hacer click en el boton Aceptar
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToAccept(boolean report, boolean takeScreenShot){
        /*
        Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        clickCoordinates(height-10,width-3,15,"Aceptar",report,takeScreenShot);

         */
        if(isElementPresent(btnAccept,15)) {
            click(btnAccept, 15,"Aceptar",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el 1
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToNumberOne(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnNumberOne,15)) {
            click(btnNumberOne, 15,"1",report,takeScreenShot);
            //touchHere.tap(PointOption.point(243,1024)).release().perform();
        }
    }

    /**
     * Método para hacer click en el boton CONTINUAR
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToContinue(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnContinue,30)) {
            click(btnContinue, 15, "CONTINUAR", report,takeScreenShot);
        }
    }


    /**
     * Método para validar que se muestra la pantalla de tajeta de clave
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateKeyCardPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnContinue,30)){
            crearPaso("Se muestra la pantalla de tajeta de clave", true, report,takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestra la pantalla de tajeta de clave de manera opcional
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateKeyCardPageOptional(boolean report, boolean takeScreenShot){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue));
        crearPaso("Se muestra la pantalla de tajeta de clave", true, report,takeScreenShot);
        status = true;

        return status;
    }


    /**
     * Método para completar tarjeta de clave en caso de que salga
     *
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeKeyOptional(){
        wait = new WebDriverWait(driver, 5);
        try {

            validateKeyCardPageOptional(true, true);

            goToNumberOne(true, false);
            goToNumberOne(true, false);
            goToNumberOne(true, false);
            goToNumberOne(true, false);

            goToContinue(true,false);
        }catch (NoSuchElementException | TimeoutException e){

        }
    }

}
