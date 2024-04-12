package page.mbp.dashboard.transaction;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de transacciones
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POtransactionPage extends Base {

    private By btnBeneficiary = By.xpath("//*[contains(@text,\"Beneficiarios\")]");
    private By btnHistorical= By.xpath("//*[contains(@text,\"Histórico\")]");
    private By btnPayService= By.xpath("//*[contains(@text,\"Pago de servicios\")]");
    private By validateScreen = By.xpath("//android.widget.TextView[@text=\"Propias\"]");
    private By btnSIPA = By.xpath("//android.widget.TextView[@text=\"SIPA\"]");
    private By btnThird = By.xpath("//android.widget.TextView[@text=\"A terceros\"]");
    private By btnOwn = By.xpath("//android.widget.TextView[@text=\"Propias\"]");
    private By btnInternational = By.xpath("//android.widget.TextView[@text=\"Internacional\"]");
    private By btnPinPesos = By.xpath("//android.widget.TextView[@text=\"PIN Pesos\"]");
    private String messageSwipeDown = "Se deslizo la pagina";
    private boolean status;

    public POtransactionPage(AndroidDriver<AndroidElement> driver) { super(driver); }

    /**
     * Método para hacer click en el boton Historico de transacciones
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToHistorical(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnHistorical,15)){
            click(btnHistorical,15,"Historico de transacciones",report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Beneficiarios Inscritos
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToBeneficiary(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnBeneficiary,15)) {
            click(btnBeneficiary, 15, "Beneficiarios Inscritos", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton SIPA
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToSIPA(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnSIPA,15)) {
            click(btnSIPA, 15, "SIPA", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton PIN Pesos
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToPinPesos(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnPinPesos,15)) {
            click(btnPinPesos, 15, "PIN Pesos", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Terceros
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToThird(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnThird,15)) {
            click(btnThird, 15, "A Terceros", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Propias
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToOwn(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnOwn,15)) {
            click(btnOwn, 15, "Propias", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Propias
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToInternational(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnInternational,15)) {
            click(btnInternational, 15, "Internacional", report, takeScreenShot);
        }
    }


    /**
     * Método para hacer click en el boton Pago de servicios
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToPaymentService(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnPayService,15)) {
            click(btnPayService, 15, "Pago de servicios", report, takeScreenShot);
        }
    }

    /**
     * Método validar que se muestre la pagina de Beneficiarios
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateTransactionPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateScreen,15)){
            crearPaso("Se muestra la pagina de tranasacciones", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método validar que se muestre la pagina de soporte y mantenimiento en la pagian de transacciones
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateBeneficiaryOption(boolean report, boolean takeScreenShot){
        try {
            if(isElementPresent(validateScreen,15)) {
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\"SIPA\")).scrollForward());");

               crearPaso(messageSwipeDown, true, report, takeScreenShot);
                status = true;
            }
        }catch (InvalidSelectorException e) {
           crearPaso(messageSwipeDown, true, report, takeScreenShot);
            status = true;
        }catch (Exception e){
            crearPaso("error validateBeneficiaryOption " + e, false, report, takeScreenShot);
            throw (e);
        }
        return status;
    }

    /**
     * Método validar que se muestre la pagina de soporte y mantenimiento en la pagian de transacciones
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateBeneficiaryOptionM(boolean report, boolean takeScreenShot){
        try {
            if(isElementPresent(validateScreen,15)) {
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\"SIPA\"));");

                crearPaso(messageSwipeDown, true, report, takeScreenShot);
                status = true;
            }
        }catch (InvalidSelectorException e) {
            crearPaso(messageSwipeDown, false, report, takeScreenShot);
            status = true;
            throw (e);
        }catch (Exception e){
            crearPaso("error validateBeneficiaryOptionM " + e, false, report, takeScreenShot);
            throw (e);
        }
        return status;
    }

}
