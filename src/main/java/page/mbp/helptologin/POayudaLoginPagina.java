package page.mbp.helptologin;

import controladorlocal.Base;
import controladorlocal.BaseTestAppium;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de ayuda para iniciar sesion
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POayudaLoginPagina extends Base {

    public POayudaLoginPagina(AndroidDriver<AndroidElement> driver) { super(driver); }
    private By validateScreen = By.xpath("//*[contains(@text,'de ayuda')]");
    private By btnHelpLogin= By.xpath("//*[contains(@text,'AYUDA PARA INICIAR SESIÓN')]");
    private By txtCurrentKey = By.xpath("(//android.widget.EditText)[1]");
    private By txtCurrentKey2 = By.xpath("(//android.widget.EditText)[2]");
    private By txtConfirmKey = By.xpath("//android.widget.EditText[@resource-id=\"confirmPassInput\"]");
    private By btnChangeKey = By.xpath("//android.widget.Button[@text=\"CAMBIAR CLAVE\"]");
    private By btnContinue = By.xpath("//android.widget.Button[@text=\"CONTINUAR\"]");
    private By txtMessageConfirmed = By.xpath("//android.view.View[@text=\"Clave modificada con éxito!\"]");
    private By txtDocumentIdentity = By.xpath("//android.widget.EditText");
    private By btnValidateDocument = By.xpath("//android.widget.Button");
    private boolean status;


    /**
     * Método para hacer click en el boton Ayuda para Iniciar Sesion
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToHelpLogin(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnHelpLogin,15)) {
            click(btnHelpLogin, 15,"Ayuda para Iniciar Sesion", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Ayuda para Iniciar Sesion
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void completeDocumentIdentity(boolean report, boolean takeScreenShot){
        if(isElementPresent(txtDocumentIdentity,15)) {
            setText(txtDocumentIdentity,"00111435384",15,report,takeScreenShot);

            if (isElementPresent(btnValidateDocument,15)){
                click(btnValidateDocument,15,"VALIDAR DOCUMENTO",report,takeScreenShot);
            }
        }
    }

    /**
     * Método para hacer click en el continuar
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToContinue(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnContinue,15)) {
            click(btnContinue, 15,"CONTINUAR", report, takeScreenShot);
        }
    }

    /**
     * Método para validar que se muestre la pagina de ayuda para iniciar sesion y se recorre la pagina hasta el final de la misma
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateHelpToLogInPage(boolean report, boolean takeScreenShot) {
        if (isElementPresent(validateScreen, 15)) {
            crearPaso("Se observa la pagina de ayuda para iniciar sesion", true, report, takeScreenShot);
            dropDownCoinicidencia("VALIDAR DOCUMENTO",report,takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pagina de Restaurar clave
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateScreenChangeKey(boolean report, boolean takeScreenShot) {
        if (isElementPresent(btnContinue, 15)) {
            crearPaso("Se muestra mensaje de clave", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pagina de Restaurar clave
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateMessageKey(boolean report, boolean takeScreenShot) {
        if (isElementPresent(txtCurrentKey, 15)) {
            crearPaso("Se observa la pantalla para cambiar clave", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para completar restaurar clave
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void completeKey(boolean report, boolean takeScreenShot) {
        if (isElementPresent(txtCurrentKey, 15)) {
            setText(txtCurrentKey,"1111",15,report,takeScreenShot);

            if(isElementPresent(txtCurrentKey2, 15)){
                setText(txtCurrentKey2,"1111",15,report,takeScreenShot);

                if(isElementPresent(txtConfirmKey, 15)){
                    setText(txtConfirmKey,"1111",15,report,takeScreenShot);

                    if(isElementPresent(btnChangeKey,15)){
                        click(btnChangeKey,15,"CAMBIAR CLAVE",report,takeScreenShot);
                    }
                }
            }
        }
    }

    /**
     * Método para validar que se muestra la confirmacion
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateMessageConfirmed(boolean report, boolean takeScreenShot) {
        if (isElementPresent(txtMessageConfirmed, 15)) {
            crearPaso("Se muestra el mensaje cambio de clave exitoso", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }
}
