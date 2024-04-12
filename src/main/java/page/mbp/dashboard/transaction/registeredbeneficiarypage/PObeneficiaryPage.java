package page.mbp.dashboard.transaction.registeredbeneficiarypage;

import controladorlocal.Base;
import controladorlocal.BaseTestAppium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de beneficiario
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class PObeneficiaryPage extends Base {

    private By validateCard = By.xpath("//*[contains(@text,'Tipo')]");
    private By selectBank = By.xpath("//android.widget.Button[@resource-id=\"ion-sel-0\"]");
    private By optionOtherBank = By.xpath("//*[@text=\"Otros Bancos\"]");
    private By optionPinPesos = By.xpath("//*[@text=\"PIN Pesos\"]");
    private By optionBHD = By.xpath("//*[@text=\"BHD\"]");
    private By successfulMessage = By.xpath("//android.widget.TextView[@text=\"Beneficiario registrado con éxito\"]");
    private WebDriverWait waitElement = new WebDriverWait(driver, 100);

    // ADD NEW BHD
    private By btnNewBeneficiaryNational = By.xpath("//android.view.View[@resource-id=\"private-menu\"]" +
            "/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/" +
            "android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.Button");
    private By txtProductNumber = By.xpath("//android.app.Dialog/android.view.View/android.view.View[2]" +
            "/android.view.View/android.view.View/android.widget.EditText");
    private By txtEmail = By.xpath("//android.app.Dialog/android.view.View/android.view.View[2]" +
            "/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText");
    private By btnSave = By.xpath("//android.widget.Button[@text=\"GUARDAR\"]");

    // ADD NEW OTHER BANK
    private By txtBank = By.xpath("(//*[contains(@text,\"Selecciona banco\")])[1]");
    private By selectProductType = By.xpath("(//*[contains(@text,\"Tipo de producto\")])[1]");
    private By txtProductNumberOtherBank = By.xpath("//android.widget.EditText[@text=\"_______________\"]");
    private By selectDocumentType = By.xpath("(//*[contains(@text,\"Tipo de documento\")])[1]");
    private By selectDocument = By.xpath("//*[contains(@text,\"Cédula\")]");
    private By txtDocumentNumber = By.xpath("//android.widget.EditText[@text=\"___-_______-_\"]");
    private By alias = By.xpath("//*[contains(@text,\"Consultando documento de identidad\")]");
    private By txtEmailOtherBank = By.xpath("//android.app.Dialog/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText");
    private By radioButtonBCRD = By.xpath("//android.widget.RadioButton[@text=\"Pagos al Instante BCRD\"]");
    private String campo = "//*[contains(@text,'";
    private By btnEditBeneficiary =  By.xpath("//android.widget.Button[@text=\"create outline\"]");
    private By btnDeleteBeneficiary =  By.xpath("//android.widget.Button[@text=\"close outline\"]");
    private By btnSaveEditBeneficiary = By.xpath("//android.widget.Button[@text=\"GUARDAR\"]");
    private By btnDeleteConfirmBeneficiary =  By.xpath("//android.widget.Button[@text=\"SÍ, ELIMINAR\"]");
    private By deleteMessage = By.xpath("//android.widget.TextView[@text=\"Beneficiario eliminado con éxito\"]");

    // ADD NEW PIN PESOS
    private By txtTelephoneNumber = By.xpath("//android.widget.EditText[@text=\"(___) ___ ____\"]");
    private By txtNameBeneficiary = By.xpath("//android.app.Dialog/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText");

    //SEARCH BENEFICIARY
    private By txtSearchBeneficiary = By.xpath("//android.widget.EditText");
    private boolean status=false;


    public PObeneficiaryPage(AndroidDriver<AndroidElement> driver) { super(driver); }


    /**
     * Método para hacer click en el boton NUEVO BENEFICIARIO NACIONAL
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToNewBeneficiary(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnNewBeneficiaryNational,30)) {
            click(btnNewBeneficiaryNational, 30, "NUEVO BENEFICIARIO NACIONAL", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton name
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToNameBeneficiary(boolean report, boolean takeScreenShot){
        click(txtProductNumber,30,"name",report, takeScreenShot);
    }

    /**
     * Método para hacer click en el boton GUARDAR
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToSave(boolean report, boolean takeScreenShot){
        click(btnSave,30,"GUARDAR",report, takeScreenShot);
    }


    // Completar Forumulario Beneficiario Banco BHD

    /**
     * Método para seleccionar el tipo de banco seleccionado por parametro
     *
     * @params String
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void selectBank(String bank,boolean report, boolean takeScreenShot){
        click(selectBank,15,"BHD",report,takeScreenShot);

         if (isElementPresent(optionBHD,30)){
             if (bank.equalsIgnoreCase("BHD")){
                 click(optionBHD,30,bank,report,takeScreenShot);
             } else if (bank.equalsIgnoreCase("Otros Bancos")) {
                 click(optionOtherBank,30,bank,report,takeScreenShot);
             } else if (bank.equalsIgnoreCase("PIN Pesos")) {
                 click(optionPinPesos,30,bank,report,takeScreenShot);
             }
         }
    }

    /**
     * Método para escribir en el campo numero de producto recibido por parametro
     *
     * @params String, Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void writeOnProductNumber(String productNumber, boolean report, boolean takeScreenShot){
        setText(txtProductNumber,productNumber,30,report, takeScreenShot);
    }

    /**
     * Método para escribir en el campo correo por parametro
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void writeOnEmail(boolean report, boolean takeScreenShot){
        setText(txtEmail,"test@test.com",15,report,takeScreenShot);
    }

    /**
     * Método para escribir en el campo cuenta recibido por parametro
     *
     * @params String, Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void writeOnFilter(String account, boolean report, boolean takeScreenShot){
        if (isElementPresent(txtSearchBeneficiary,15)) {
            setText(txtSearchBeneficiary, account, 30, report, takeScreenShot);
        }
    }


    // Completar Forumulario Beneficiario Otros Bancos
    protected void seleccionarBanco(String bank, boolean report, boolean takeScreenShot){
        if (isElementPresent(txtBank,30)) {
            click(txtBank, 30, "BHD", report,takeScreenShot);

            try {
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches('" + bank + "')).scrollForward());");
                crearPaso("Se deslizo la pagina", true, report,takeScreenShot);
            } catch (InvalidSelectorException e) {
                crearPaso("Se deslizo la pagina", false, report,takeScreenShot);
            }

            // Seleccionar Banco
            By selectBankDropDown = By.xpath(campo + bank + "')]");
            if (isElementPresent(selectBankDropDown, 15)) {
                click(selectBankDropDown, 15, bank, report, takeScreenShot);
            }
        }
    }
    protected void seleccionarTipoDeDocumento(String typeProduct, String documentNumber, boolean report, boolean takeScreenShot){
        // Seleccionar tipo de documento
        if(isElementPresent(selectDocumentType,15)) {
            click(selectDocumentType, 15, "tipo documento", report, takeScreenShot);

            // Seleccionar cedula
            if (isElementPresent(selectDocument, 15)) {
                click(selectDocument, 15, typeProduct, report, takeScreenShot);

                //Ingresar cedula
                if (isElementPresent(txtDocumentNumber, 15)) {
                    setText(txtDocumentNumber, documentNumber, 15, report, takeScreenShot);
                }
            }
        }
    }
    protected void seleccionarTipoCuenta(String typeAccount, String bank, boolean report, boolean takeScreenShot){
        // Tipo de cuenta
        if(isElementPresent(selectProductType,15)) {
            By selectTypeAccount = By.xpath(campo+typeAccount+"')]");
            click(selectProductType, 15, bank, report, takeScreenShot);

            // Seleccionar tipo de cuenta
            if (isElementPresent(selectTypeAccount, 15)) {
                click(selectTypeAccount, 15, bank, report, takeScreenShot);
            }
        }
    }
    protected void seleccionarTipoDeTransaccion(String type, boolean report, boolean takeScreenShot){
        if(type.equalsIgnoreCase("BCRD") && isElementPresent(radioButtonBCRD, 15)) {
                click(radioButtonBCRD, 15, "Pago al intante BCRD", report, takeScreenShot);
            }
    }
    protected void completeNewBeneficiaryFormBHD(String productNumber, boolean report, boolean takeScreenShot){
        writeOnProductNumber(productNumber,report,takeScreenShot);
        goToNameBeneficiary(report,takeScreenShot);
        pressButtonTAB(report,takeScreenShot);
        writeOnEmail(report,takeScreenShot);
    }


    // Completar Forumulario Pin pesos
    /**
     * Método para escribir en el campo numero de telefono recibido por parametro
     *
     * @params String, Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void writeOnTelephoneNumber(String telephoneNumber, boolean report, boolean takeScreenShot){
        setText(txtTelephoneNumber,telephoneNumber,15, report, takeScreenShot);
    }

    /**
     * Método para escribir en el campo nombre de beneficiario recibido por parametro
     *
     * @params String, Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void writeOnNameBeneficiary(String nameBeneficiary,boolean report, boolean takeScreenShot){
        setText(txtNameBeneficiary,nameBeneficiary,15,report,takeScreenShot);
    }

    /**
     * Método para completar el formulario de nuevo beneficiario Pin Pesos
     *
     * @params String, String
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void completeNewBeneficiaryPinPesos(String telephoneNumber,String nameBeneficiary, boolean report, boolean takeScreenShot){
        writeOnTelephoneNumber(telephoneNumber,report,takeScreenShot);
        writeOnNameBeneficiary(nameBeneficiary,report,takeScreenShot);
        nativeButtonBack(report,takeScreenShot);

        // Seleccionar Documento
        seleccionarTipoDeDocumento("cedula","40229805813",report,takeScreenShot);
        pressButtonTAB(report,takeScreenShot);

    }


    //Editar Beneficiario
    protected boolean searchBeneficiary(String account, boolean report, boolean takeScreenShot){
        By camp = By.xpath("//*[contains(@text,'"+account+"')]");
        writeOnFilter(account,report,takeScreenShot);

        if (isElementPresent(camp,15)){
            crearPaso("Se muestra el beneficiario registrado", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }
    protected void selectArrow(String account, boolean report, boolean takeScreenShot){
        By arrow = By.xpath("//*[@text='"+account+"']/following::*[@text='arrow forward']");

        if (isElementPresent(arrow,15)){
            click(arrow, 15, "flecha", report, takeScreenShot);
        }

    }
    protected void selectEdit(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnEditBeneficiary,15)){
            crearPaso("Se muestras las opciones para editar y ver beneficiario", true, report, takeScreenShot);
            click(btnEditBeneficiary, 15, "editar", report, takeScreenShot);
        }
    }
    protected void selectDelete(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnDeleteBeneficiary,15)){
           crearPaso("Se muestras las opciones para eliminar", true, report, takeScreenShot);

            click(btnDeleteBeneficiary, 15, "eliminar", report,takeScreenShot);
        }
    }
    protected void selectDeleteConfirm(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnDeleteConfirmBeneficiary,15)){
            crearPaso("Se muestras el mensaje de confirmacion para eliminar beneificario", true, report, takeScreenShot);

            click(btnDeleteConfirmBeneficiary, 15, "si, Eliminar", report, takeScreenShot);
        }
    }


    protected boolean validateEditBeneficiaryPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnSaveEditBeneficiary,30)){
            crearPaso("Se muestra la pagina para editar beneficiarios", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }
    protected boolean validateBeneficiaryPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateCard,50)){
            crearPaso("Se muestra la pagina beneficiarios", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }
    protected boolean validateMessageRegisteredSuccessful(boolean report, boolean takeScreenShot){
        if (isElementPresent(successfulMessage,20)){
            crearPaso("Se muestra el mensaje de registro exitoso", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }
    protected boolean validateMessageDeleteBeneficiary(boolean report, boolean takeScreenShot){
        if (isElementPresent(deleteMessage,20)){
            crearPaso("Se muestra el mensaje de se elimino beneficiario", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }


    protected void deleteBeneficiaryRegister(String productNumber, boolean report, boolean takeScreenShot){
        searchBeneficiary(productNumber,report,takeScreenShot);
        selectArrow(productNumber,report,takeScreenShot);
        selectDelete(report,takeScreenShot);
        selectDeleteConfirm(report,takeScreenShot);
    }
    protected void searchBeneficiaryAndEdit(String productNumber,boolean report, boolean takeScreenShot){
        searchBeneficiary(productNumber,report,takeScreenShot);
        selectArrow(productNumber,report,takeScreenShot);
        selectEdit(report,takeScreenShot);
    }
    protected void completeNewBeneficiaryForm(String bank,String productNumber,String typeProduct, boolean report, boolean takeScreenShot){

        if(bank.equalsIgnoreCase("BHD")) {
            completeNewBeneficiaryFormBHD(productNumber,report,takeScreenShot);
        }
        else if ("Pin Pesos".equalsIgnoreCase(bank)) {
            completeNewBeneficiaryPinPesos(productNumber,"text",report,takeScreenShot);

            // Esperar consulta junta campo alias
            if(isElementPresent(alias,30)) {
                waitElement.until(ExpectedConditions.invisibilityOf(driver.findElement(alias)));
            }
        }

        else if(!"BHD".equalsIgnoreCase(bank) && !"Pin Pesos".equalsIgnoreCase(bank)){

            //seleccionar Banco
            seleccionarBanco(bank,report,takeScreenShot);

            //Seleccionar Cuenta
            seleccionarTipoCuenta(typeProduct,bank,report,takeScreenShot);

            //Ingresar numero producto
            if (isElementPresent(txtProductNumberOtherBank,15)){
                setText(txtProductNumberOtherBank,"49584394230349",15,report,takeScreenShot);

                // Seleccionar Documento
                seleccionarTipoDeDocumento("cedula","40229805813",report,takeScreenShot);
                pressButtonTAB(report,takeScreenShot);

                // Esperar consulta junta campo alias
                if(isElementPresent(alias,30)) {
                    waitElement.until(ExpectedConditions.invisibilityOf(driver.findElement(alias)));
                }

                //Seleccionar el tipo de transaccion
                seleccionarTipoDeTransaccion("BCRD",report,takeScreenShot);
                setText(txtEmailOtherBank,"test@test.com",15,report,takeScreenShot);
            }
        }
    }

}
