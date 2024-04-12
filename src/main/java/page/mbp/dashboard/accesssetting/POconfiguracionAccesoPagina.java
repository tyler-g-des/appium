package page.mbp.dashboard.accesssetting;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;


/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina Editar Resumen
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POconfiguracionAccesoPagina extends Base {
    public POconfiguracionAccesoPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    private By validatePage = By.xpath("//*[contains(@text,\"Acceder con PIN de 6\")]");
    private By btn1 = By.xpath("//android.widget.Button[@text=\"1\"]");
    private By validateText = By.xpath("//android.widget.TextView[@text=\"PIN activado\"]");
    private By btnDeactivate = By.xpath("//android.widget.Button[@text=\"DESACTIVAR\"]");
    private By btnDisable = By.xpath("//android.widget.Button[@text=\"DESHABILITAR\"]");
    private boolean status;


    /**
     * Método para hacer click en el DESACTIVAR
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToDeactivate (boolean report, boolean takeScreenShot){
        if (isElementPresent(btnDeactivate, 30)) {
            click(btnDeactivate, 30, "DESACTIVAR", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el DESHABILITAR
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToDisable (boolean report, boolean takeScreenShot){
        if (isElementPresent(btnDisable, 30)) {
            click(btnDisable, 30, "DESAHABILITAR", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Acceder con PIN
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToAccessConfig (boolean report, boolean takeScreenShot){
        if (isElementPresent(validatePage, 30)) {
            click(validatePage, 30, driver.findElement(validatePage).getText(), report, takeScreenShot);
        }
    }

    /**
     * Método para completar clave de acceso
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void completeForm(boolean report, boolean takeScreenShot){
       // if (isElementPresent(btn1,15)){
         //   for (int i =0; i < 5; i++){
                if (isElementPresent(btn1,15)) {
                    click(btn1, 15, "1", report, takeScreenShot);
                }
           // }
        //}
    }

    /**
     * Método para validar que se muestre el mensaje informativo para confirmar el mensaje informativo
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateMessageInformative(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnDisable,15)){
            crearPaso("Se muestra el mensaje de confirmacion para desactivar", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre el mensaje informativo
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validatePin(boolean report, boolean takeScreenShot){
        if (isElementPresent(btn1,15)){
            crearPaso("Se muestra la pantalla de inicio sesion con pin", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pagina de configuracion de acceso
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateConfigurationAccessPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validatePage,15)){
            crearPaso("Se observa la pagina de configuracion de acceso", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre el mensaje de de que el PIN fue activado
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateMessage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateText, 15)) {
            String text = driver.findElement((validateText)).getText();
            crearPaso("Se observa el mesaje informativo " + text, true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre el PIN activado
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validatePinActive(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnDeactivate, 15)) {
            crearPaso("Se observa que esta activo el acceso con PIN", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

}
