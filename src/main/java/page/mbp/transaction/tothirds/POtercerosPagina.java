package page.mbp.transaction.tothirds;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POtercerosPagina extends Base {

    ////android.app.Dialog[@resource-id="ion-overlay-15"]/android.view.View[2]
    private By validateScreen = By.xpath("//android.app.Dialog");
    private By validateScreenDestiny = By.xpath("//android.widget.TextView[contains(@text,\"Toca para seleccionar\")]");
    private By validateBeneficiaryLoad = By.xpath("//android.view.View[@text=\"Nuevo beneficiario\"]");
    private By txtAmount = By.xpath("//android.view.View[@text=\"0.00\"]");
    private By searchAccount = By.xpath("//android.widget.EditText");
    private By txtAmountForm = By.xpath("(//android.view.View/android.widget.EditText)[1]");
    private By txtDescription = By.xpath("(//android.view.View/android.widget.EditText)[3]");
    private By btnContinue = By.xpath("//android.widget.Button[@text=\"CONTINUAR\"]");
    //NEW BENEFICIARY OUTSIDE BHD
    private  By selectBank = By.xpath("//android.widget.Spinner[@resource-id=\"ion-sel-0\"]");
    private By selectTypeProduct = By.xpath("//android.widget.Spinner[@resource-id=\"ion-sel-1\"]");
    private By txtNumberProduct = By.xpath("//android.widget.EditText[contains(@text,\"____\")]");
    private By selectTypeDocument = By.xpath("//*[@text=\"Tipo de documento\"]");
    private By txtIndetityDocument = By.xpath("//android.widget.EditText[@text=\"___-_______-_\"]");
    private By validateConsultJunta = By.xpath("//android.widget.Spinner[contains(@text,\"REPUBLICA\")]");

    private By btnCancel = By.xpath("//*[contains(@text,\"SÍ, CANCELAR\")]");

    //NEW BENEFICIARY BHD
    private By txtProductNumber = By.xpath("//android.widget.EditText[@resource-id=\"account-credit-product-number\"]");
    private By messageJunta = By.xpath("//*[contains(@text,'Consultando')]");
    WebDriverWait waits = new WebDriverWait(driver, 20);
    private boolean status;

    public POtercerosPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

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
     * Método para hacer click en el tipo trasnsaccion
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectType(String type, boolean report, boolean takeScreenShot){
        By achRB = By.xpath("//android.widget.RadioButton[@text=\"ACH\"]");
        By BCRD_RD = By.xpath("//android.widget.RadioButton[@text=\"Pagos al Instante BCRD\"]");

        if(type.equalsIgnoreCase("ach")){
            if (isElementPresent(achRB, 15)) {
                click(achRB, 15,"ACH", report, takeScreenShot);
            }
        }else {
            if (isElementPresent(BCRD_RD, 15)) {
                click(BCRD_RD, 15,"Pago al instante BCRD", report, takeScreenShot);
            }
        }

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
     * Método para hacer seleccionar la cuenta Origen
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectAccountDestiny(String bank, String accountNumber, boolean report, boolean takeScreenShot){
        By account = By.xpath("//*[contains(@text,'"+bank+"')  and contains(@text,'"+accountNumber+"')]");

        click(searchAccount,15,"buscar producto",false,false);
        setText(searchAccount,accountNumber,15,report,takeScreenShot);
        nativeButtonBack(false,false);
        dropDownCoinicidencia(bank+"- "+accountNumber+" -",report,takeScreenShot);

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
    public void selectNewBeneficary(boolean report, boolean takeScreenShot){
        if(isElementPresent(validateBeneficiaryLoad,15)){
            click(validateBeneficiaryLoad,15,"producto",report,takeScreenShot);
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
     * Método para hacer completar formulario transacciones entre cuentas BHD
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeFormNewBeneficiaryOutsideBHD(String mount, String bank,String typeProduct, String productNumber, boolean report, boolean takeScreenShot){
        // ingresar monto
        if(isElementPresent(txtAmount,10)) {
            click(txtAmount, 15, "", false, false);
            setText(txtAmountForm, mount, 15, report, takeScreenShot);
            nativeButtonBack(false, false);

            //Selccionar banco
            if(isElementPresent(selectBank,10)) {
                click(selectBank,15,"",false,false);
                dropDownCoinicidencia(bank,report,true);
                By bankSelect = By.xpath("//android.widget.Button[contains(@text,\""+bank+"\")]");
                click(bankSelect,15,bank,report,false);

                //Seleccionar tipo de producto
                if(isElementPresent(selectTypeProduct,10)) {
                    click(selectTypeProduct,15,"",false,false);
                    By typeProductSelect = By.xpath("//android.widget.Button[contains(@text,\""+typeProduct+"\")]");

                    if(isElementPresent(typeProductSelect,10)) {
                        click(typeProductSelect, 15, bank, report, false);

                        //digitar numero de producto]
                        if(isElementPresent(txtNumberProduct,10)) {
                            setText(txtNumberProduct,productNumber,15,report,false);

                            crearPaso("Se completo los primeros campos la transaccion", true, report, true);

                            dropDown("ACH",false,false);

                            //Seleccionar INFORMACION BENEFICIARIO
                            if(isElementPresent(selectTypeDocument,10)) {
                                click(selectTypeDocument,10,"Tipo de documento",true,false);
                                By typeDocumentSelect = By.xpath("//android.widget.Button[@text=\"Cédula\"]");

                                if(isElementPresent(typeDocumentSelect,10)) {
                                    click(typeDocumentSelect, 15, "Cedula", report, false);

                                    if (isElementPresent(txtIndetityDocument,10)) {
                                        setText(txtIndetityDocument,"40229805813",10,report,false);
                                        pressButtonTAB(false,false);
                                        nativeButtonBack(false,false);
                                        pressButtonTAB(false,false);

                                        if(isElementPresent(validateConsultJunta,15)){
                                            crearPaso("Se completo los campos requeridos", true, report, true);
                                        }

                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }


    /**
     * Método para hacer completar formulario nuevo beneficiario BHD
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeFormNewBeneficiaryBHD(String mount, String productNumber, boolean report, boolean takeScreenShot){
        // ingresar monto
        if(isElementPresent(txtAmount,10)) {
            click(txtAmount, 15, "", false, false);
            setText(txtAmountForm, mount, 15, report, takeScreenShot);
            nativeButtonBack(false, false);

            click(txtProductNumber, 15, "", false, false);
            setText(txtProductNumber,productNumber,10,report,true);
            pressButtonTAB(false,false);

            try {waits.until(ExpectedConditions.invisibilityOf(driver.findElement(messageJunta)));}catch (NoSuchElementException e){}
            crearPaso("Se completo los campos requeridos", true, report, true);


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
    protected boolean validateTransactionThirdPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateScreen,30)){
            crearPaso("Se muestra la pagina de tranasacciones a terceros", true, report, takeScreenShot);
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
            crearPaso("Se muestra la pagina de tranasacciones a terceros", true, report, takeScreenShot);
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
    protected boolean validateForm(boolean report, boolean takeScreenShot){
        if (isElementPresent(txtAmount,30)){
            crearPaso("Se muestra la pagina de tranasacciones a terceros", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }


    /**
     * Método validar que se muestre el formulario para agregar nuevo beneficiario
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateFormNewBeneficiary(boolean report, boolean takeScreenShot){
        if (isElementPresent(selectBank,30)){
            crearPaso("Se muestra el formulario con los datos a introducir", true, report, takeScreenShot);
            status = true;
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
}
