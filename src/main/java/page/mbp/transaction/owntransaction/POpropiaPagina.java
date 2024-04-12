package page.mbp.transaction.owntransaction;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class POpropiaPagina extends Base {

    private By validateScreen = By.xpath("//android.app.Dialog");
    private By validateScreenDestiny = By.xpath("//android.widget.TextView[contains(@text,\"Toca para seleccionar\")]");
    private By validateBeneficiaryLoad = By.xpath("(//android.widget.TextView[@text=\"\uE908\"])[1]");
    private By txtAmount = By.xpath("//*[contains(@text,\"0.00\")]");
    private By searchAccount = By.xpath("//android.widget.EditText");
    private By txtAmountForm = By.xpath("(//android.view.View/android.widget.EditText)[1]");
    private By txtDescription = By.xpath("(//android.view.View/android.widget.EditText)[3]");
    private By btnContinue = By.xpath("//android.widget.Button[contains(@text,\"CONTINUAR\")]");
    private By btnContinueLoad = By.xpath("(//android.widget.Button)[2]");
    private By validateDifferentCurrency = By.xpath("(//*[contains(@text,\"$\")])[5]");
    private By rbOutstandingFee = By.xpath("(//android.widget.RadioButton)[1]");
    private By rbAmountDecrease = By.xpath("(//android.widget.RadioButton)[2]");
    private By rbQuotaDecrease = By.xpath("(//android.widget.RadioButton)[3]");
    private By btnCancel = By.xpath("//*[contains(@text,\"SÍ, CANCELAR\")]");

    private boolean status;


    public POpropiaPagina(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Método para hacer click en el Editar Resumen
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
     * Método para hacer click en el CONTINUAR
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToContinueLoad(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnContinueLoad, 15)) {
            click(btnContinueLoad, 15,"CONTINUAR", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el Si,Cancelar
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToCancel(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnCancel, 15)) {
            click(btnCancel, 15,"SI, CANCELAR", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton para RETROCEDER
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void btnBack(boolean report, boolean takeScreenShot){
        clickCoordinates(106,182,15,"back",report,takeScreenShot);
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
     * Método para hacer completar formulario transacciones entre cuentas BHD
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeFormPayLoan(String paymentType, String amount, boolean report, boolean takeScreenShot){

        By txtAmountLoan = By.xpath("(//android.view.View/android.widget.EditText)[1]");

      if(isElementPresent(rbOutstandingFee,15)) {
          if(paymentType != "Cuota pendiente") {
              if (paymentType.equalsIgnoreCase("Disminucion de monto")) {
                  click(rbAmountDecrease, 10, "Abono de prestamo con dismucion de monto a cuotas", report, false);

                  txtAmountLoan = By.xpath("(//android.view.View/android.widget.EditText)[1]");

              } else if (paymentType.equalsIgnoreCase("Disminucion de cuotas")) {
                  click(rbQuotaDecrease, 10, "Abono de prestamo con dismucion de cantidad de cuotas", report, false);

                  txtAmountLoan = By.xpath("(//android.view.View/android.widget.EditText)[2]");
              }
              click(txtAmount,15,"",false,false);
              setText(txtAmountLoan,amount,15,report,takeScreenShot);
              nativeButtonBack(false,false);
          }
          crearPaso("Se completo los campos requeridos", true, report, takeScreenShot);
      }
    }

    /**
     * Método para hacer completar formulario transacciones entre cuentas BHD
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeFormAccount(String mount, boolean report, boolean takeScreenShot){

        click(txtAmount,15,"",false,false);
        setText(txtAmountForm,mount,15,report,takeScreenShot);
        nativeButtonBack(false,false);

        setText(txtDescription,"prueba",15,report,takeScreenShot);
        crearPaso("Se completo los campos requeridos", true, report, takeScreenShot);
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
     * Método validar que se muestre la pagina de transacciones a tercero
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateForm(String currencyOrigin, String currencyDestiny, boolean report, boolean takeScreenShot){

        if(currencyOrigin != currencyDestiny) {
            if (isElementPresent(txtAmount, 30)) {
                crearPaso("Se el formulario para completar las informaciones de la tranasaccion", true, report, takeScreenShot);
                status = true;
            }
        }
        else {
            if (isElementPresent(validateDifferentCurrency, 30)) {
                crearPaso("Se el formulario para completar las informaciones de la tranasaccion", true, report, takeScreenShot);
                status = true;
            }
        }
        return status;
    }


    /**
     * Método validar mesaje de cancelacion de transaccion
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateMessage(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnCancel,30)){
            crearPaso("Se muestra un mensaje informativo indicando que se va a cancelar la transaccion", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método validar que se muestre la cuenta de origen seleccionada
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateProductOriginSelect(String accountNumber,boolean report, boolean takeScreenShot){
        By account = By.xpath("//*[contains(@text,'"+accountNumber+"')]");
        if (isElementPresent(account,30)){
            crearPaso("Se muestra la cuenta seleccionada", true, report, takeScreenShot);
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
    protected boolean validateTransactionOwnPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateScreen,30)){
            crearPaso("Se muestra la pagina de tranasacciones a propia", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

}
