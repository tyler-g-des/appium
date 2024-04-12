package page.mbp.dashboard.securityconfiguration;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;


/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina Editar Resumen
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POconfiguracionSeguridadPagina extends Base {
    public POconfiguracionSeguridadPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    private By validatePage = By.xpath("//android.view.View[@text=\"Configura tus preguntas de seguridad\"]");
    private By btnSecurityConfig = By.xpath("//android.widget.TextView[@text=\"Configuración de seguridad\"]");
    private By btnChangeKey = By.xpath("//android.view.View[@text=\"Cambia tu clave de acceso\"]");
    private By validateText = By.xpath("//android.widget.TextView[@text=\"Preguntas de seguridad establecidas con éxito\"]");
    private By btnDoNotUseKeyCard = By.xpath("//android.widget.CheckBox");
    private By validateMessajeDisableTDC = By.xpath("//android.view.View[@text=\"Tarjeta de claves habilitada para transacciones entre productos propios\"]");

    private boolean status;

    /**
     * Método para hacer click en el boton disahabilitar tarjeta de clave
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToDisableTC (boolean report, boolean takeScreenShot){
        if (isElementPresent(btnDoNotUseKeyCard, 15)) {
            click(btnDoNotUseKeyCard, 15, "No usar tarjeta de claves para realizar transacciones", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Cambiar tu clave actual
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToChangeKeyAccess (boolean report, boolean takeScreenShot){
        if (isElementPresent(btnChangeKey, 15)) {
            click(btnChangeKey, 15, "Configuracion de seguridad", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Cambiar tu pregunta de seguridad
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToChangeSecurityQuestion (boolean report, boolean takeScreenShot){
        if (isElementPresent(validatePage, 15)) {
            click(validatePage, 15, "Configuracion de seguridad", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Configuracion de Seguridad
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToSecurityConfig (boolean report, boolean takeScreenShot){
        if (isElementPresent(btnSecurityConfig, 15)) {
            click(btnSecurityConfig, 15, "Configuracion de seguridad", report, takeScreenShot);
        }
    }

    /**
     * Método para validar que se muestre la pagina de configuracion de seguridad
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateConfigurationSecurityPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validatePage,15)){
            crearPaso("Se observa la pagina de configuracion de seguridad", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre el mensaje para establecer pregunta de seguridad establecida
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
     * Método para validar que se muestre el mensaje para establecer pregunta de seguridad establecida
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateMessageDisabled(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateMessajeDisableTDC, 15)) {
            String text = driver.findElement((validateMessajeDisableTDC)).getText();
            crearPaso("Se observa el mesaje informativo " + text, true, report, takeScreenShot);
            status = true;
        }
        return status;
    }
}
