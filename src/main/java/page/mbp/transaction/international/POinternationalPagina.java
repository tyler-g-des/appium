package page.mbp.transaction.international;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class POinternationalPagina extends Base {

    private By validateScreen = By.xpath("//android.app.Dialog");
    private By validateScreenDestiny = By.xpath("//android.widget.TextView[contains(@text,\"Toca para seleccionar\")]");
    private By validateBeneficiaryLoad = By.xpath("(//android.widget.TextView[@text=\"\uE970\"])[1]");
    private By searchAccount = By.xpath("//android.widget.EditText");
    private By validateForm = By.xpath("//android.widget.TextView[@text=\"Monto equivalente\"]");
    private By txtAmount = By.xpath("//*[contains(@text,\"0.00\")]");
    private By txtAmountForm = By.xpath("(//android.view.View/android.widget.EditText)[1]");
    private By selectProposito = By.xpath("//android.widget.Spinner[@resource-id=\"ion-sel-1\"]");
    private By txtEmail = By.xpath("(//android.widget.EditText)[1]");
    private By txtDescription = By.xpath("(//android.widget.EditText)[2]");
    private By btnContinue = By.xpath("(//android.widget.Button)[5]");
    private boolean status;

    public POinternationalPagina(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    /**
     * Método para hacer click en el CONTINUAR
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToContinue(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnContinue, 15)) {
            click(btnContinue, 15,"CONTINUAR", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el Editar Resumen
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToDestiny(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateScreenDestiny, 15)) {
            click(validateScreenDestiny, 15,"Seleccionar Cuenta destino", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer seleccionar la cuenta Destino
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectAccountDestiny(String accountNumber, boolean report, boolean takeScreenShot){
        By account = By.xpath("(//*[contains(@text,'"+accountNumber+"')])[2]");

        click(searchAccount,15,"buscar producto",false,false);
        setText(searchAccount,accountNumber,15,report,takeScreenShot);
        nativeButtonBack(false,false);

        if(isElementPresent(account,15)){
            click(account,15,"producto",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer seleccionar la cuenta Origen
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectAccountOrigin(String accountNumber, boolean report, boolean takeScreenShot){
        By account = By.xpath("//*[contains(@text,'"+accountNumber+"')]");

        dropDownCoinicidencia(accountNumber,report,takeScreenShot);

        if(isElementPresent(account,15)){
            click(account,15,"producto",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer completar formulario transacciones internacionales
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeFormInternational(String amount, String currencyOrigin, String currencyDestiny, boolean report, boolean takeScreenShot) {

        if (!currencyOrigin.equalsIgnoreCase(currencyDestiny)){
            isElementPresent(validateForm, 15);
       }

        if(isElementPresent(txtAmount,15)) {
            click(txtAmount, 15, "", false, false);
            setText(txtAmountForm, amount, 15, report, takeScreenShot);
            nativeButtonBack(false, false);

            dropDownCoinicidencia("Hoy", report, true);

            if (isElementPresent(txtDescription, 15)) {
                setText(txtEmail, "INFO@BHD.COM.DO", 15, report, false);

                if (isElementPresent(txtDescription, 15)) {
                    setText(txtDescription, "prueba", 15, report, false);
                }
            }
        }
    }

    /**
     * Método validar que se muestre la pagina de transacciones a tercero
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateProductDestiny(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateBeneficiaryLoad,30)){
            crearPaso("Se muestra los beneficiarios", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método validar que se muestre la pagina de transacciones a tercero
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateTransactionDestiny(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateScreenDestiny,30)){
            crearPaso("Se muestra los productos del destino", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método validar que se muestre la pagina de transacciones internacionales
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateTransactionInternationalPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateScreen,30)){
            crearPaso("Se muestra la pagina de tranasacciones a terceros", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }
}
