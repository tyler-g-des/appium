package page.mbp.transaction.pinpesos;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class POpinPesosPage extends Base {

    private By btnSelectProduct = By.xpath("//android.view.View[@text=\"Selecciona un producto\"]//following::android.view.View[2]");
    private By validateSelect = By.xpath("//android.widget.TextView[@text=\"DESTINO\"]");
    private By btnSelectContact = By.xpath("//android.widget.Spinner[@resource-id=\"ion-sel-0\"]");
    private By btnEnterNumber = By.xpath("//android.view.View[@text=\"Ingresa un número de celular\"]");
    private By validatePageBeneficiary = By.xpath("//android.app.Dialog/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]");
    private By btnContinue = By.xpath("//android.widget.Button[@text=\"CONTINUAR\"]");
    private By txtSex = By.xpath("(//android.widget.Spinner[@text=\"Sexo\"])[1]");
    private By txtBeneficiaryName = By.xpath("//android.widget.TextView[@text=\"INFORMACIÓN DEL BENEFICIARIO\"]//parent::android.view.View/android.view.View[4]/android.widget.EditText");
    private By txtAmount = By.xpath("//android.view.View[@text=\"0.00\"]");
    private By txtAmountForm = By.xpath("//android.widget.Spinner[@text=\"Pesos\"]//parent::android.view.View//following-sibling::android.view.View/android.view.View/android.view.View/android.widget.EditText");
    private By txtNumberBeneficiary = By.xpath("//android.widget.EditText[@text=\"(___) ___ ____\"]");
    private By txtBeneficiaryNamePhone = By.xpath("//android.widget.TextView[@text=\"DESTINO\"]//parent::android.view.View/android.view.View[3]/android.widget.EditText");
    private By txtDescription = By.xpath("");

    private By selectTypeDocument = By.xpath("//*[@text=\"Tipo de documento\"]");
    private By txtIndetityDocument = By.xpath("//android.widget.EditText[@text=\"___-_______-_\"]");
    private By validateConsultJunta = By.xpath("//android.widget.Spinner[contains(@text,\"REPUBLICA\")]");
    private boolean status;

    public POpinPesosPage(AndroidDriver<AndroidElement> driver) {
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
     * Método para hacer seleccionar contactos
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectDocumentType(String documentNumber, boolean report, boolean takeScreenShot){
        //Seleccionar INFORMACION BENEFICIARIO
        if(isElementPresent(selectTypeDocument,10)) {
            click(selectTypeDocument,10,"Tipo de documento",true,false);
            By typeDocumentSelect = By.xpath("//android.widget.Button[@text=\"Cédula\"]");

            if(isElementPresent(typeDocumentSelect,10)) {
                click(typeDocumentSelect, 15, "Cedula", report, false);

                if (isElementPresent(txtIndetityDocument,10)) {
                    setText(txtIndetityDocument,documentNumber,10,report,false);
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


    /**
     * Método para hacer seleccionar contactos
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectContact(String beneficiary, boolean report, boolean takeScreenShot){
        By beneficiaryType = By.xpath("//*[contains(@text,'"+beneficiary+"')]");

        if(isElementPresent(btnSelectContact,15)) {
            click(btnSelectContact,15,"",false,false);

            if (isElementPresent(beneficiaryType, 15)) {
                click(beneficiaryType, 15, beneficiary, report, takeScreenShot);
            }
        }
    }

    /**
     * Método para hacer seleccionar beneficiario de la lista de contactos
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectBeneficiaryList(String beneficiary, boolean report, boolean takeScreenShot){
        By beneficiarySelect = By.xpath("//*[contains(@text,'"+beneficiary+"')]");

        if(isElementPresent(validatePageBeneficiary,15)) {
            crearPaso("Se muestra la pantalla lista de beneficiarios", true, report, takeScreenShot);

            dropDownCoinicidencia(beneficiary,report,false);

            if (isElementPresent(beneficiarySelect, 15)) {
                crearPaso("Se muestra el beneficiario " + beneficiary, true, report, takeScreenShot);
                click(beneficiarySelect,15,beneficiary,report,false);
            }
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

        if(isElementPresent(btnSelectProduct,15)) {
            click(btnSelectProduct,15,"",false,false);
            dropDownCoinicidencia(accountNumber, report, takeScreenShot);

            if (isElementPresent(account, 15)) {
                click(account, 15, "producto", report, takeScreenShot);
            }
        }
    }

    /**
     * Método para hacer completar el formulario y las informaciones
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeForm(String amount, boolean report, boolean takeScreenShot){
        dropDownCoinicidencia("Tu PIN",false,false);
        try {
            if (isElementPresent(txtBeneficiaryName,15)){
                completeNoConsultJCE(amount,report,takeScreenShot);
            }
        }catch (NoSuchElementException | TimeoutException e){
            if (isElementPresent(txtAmount,15)){
                click(txtAmount,15,"",false,false);
                setText(txtAmountForm,amount,15,report,takeScreenShot);
                nativeButtonBack(false,false);
            }
        }
    }

    /**
     * Método para hacer completar si falla la consulta de la junta
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeNoConsultJCE(String amount, boolean report, boolean takeScreenShot){
        By btnMan = By.xpath("//android.widget.Button[@text=\"Masculino\"]");

        if (isElementPresent(txtBeneficiaryName,15)){
            setText(txtBeneficiaryName,"prueba",15,report,false);

            if (isElementPresent(txtSex, 15)) {
                click(txtSex, 10, "", false, false);

                if (isElementPresent(btnMan, 15)) {
                    click(btnMan, 15, "Masculino", report, false);

                    if (isElementPresent(txtAmount, 15)) {
                        click(txtAmount, 15, "", false, false);
                        setText(txtAmountForm, amount, 15, report, takeScreenShot);
                        nativeButtonBack(false, false);
                    }
                }
            }
        }
    }

    /**
     * Método para hacer seleccionar contactos
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeFormEnterNumber(String phoneNumber, boolean report, boolean takeScreenShot){
        if(isElementPresent(btnEnterNumber,15)) {
            click(btnEnterNumber,15,"Ingresa un numero",false,false);

            if(isElementPresent(txtNumberBeneficiary,15)) {
                setText(txtNumberBeneficiary, phoneNumber, 15, report, false);

                if(isElementPresent(txtBeneficiaryNamePhone,15)) {
                    setText(txtBeneficiaryNamePhone,"prueba",15,report,false);
                    crearPaso("Se completo la primera parte del formulario",true,report,takeScreenShot);
                }
            }
        }
    }

    /**
     * Método para hacer validar que se selecciono la cuenta origen
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateSelectOriginAccount(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateSelect,30)){
            crearPaso("Se selecciono la cuenta origin", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método validar que se muestre la pagina de Pin Pesos
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validatePinPesosPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnSelectProduct,30)){
            crearPaso("Se muestra los beneficiarios", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método validar que se muestre la pagina de Pin Pesos
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateFormNoComplete(boolean report, boolean takeScreenShot){
        if (isElementPresent(txtBeneficiaryName,15)){
            crearPaso("Se muestra los campos requeridos no completados en rojo", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }
}
