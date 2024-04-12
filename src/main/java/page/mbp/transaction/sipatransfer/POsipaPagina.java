package page.mbp.transaction.sipatransfer;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class POsipaPagina extends Base {

    private By validateScreen = By.xpath("//android.app.Dialog/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]");
    private By txtNameBeneficiary =  By.xpath("(//android.view.View/android.widget.EditText)[1]");
    private By txtNumberBeneficiary =  By.xpath("(//android.view.View/android.widget.EditText)[2]");
    private By selectCountry = By.xpath("//android.widget.Button[@resource-id=\"ion-sel-0\"]");
    private By selectBankDestiny = By.xpath("//android.widget.Button[@resource-id=\"ion-sel-1\"]");
    private By txtCountry = By.xpath("(//android.view.View/android.widget.EditText)[3]");
    private By txtEmail = By.xpath("(//android.view.View/android.widget.EditText)[4]");
    private By txtProductNumber = By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText)[2]");
    private By txtAmount = By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText)[3]");
    private By txtDescription = By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText)[4]");
    private By btnContinue = By.xpath("//android.widget.Button[@text=\"CONTINUAR\"]");
    private boolean status;

    public POsipaPagina(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    /**
     * Método para hacer click en el boton CONTINUAR
     *
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToContinue(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnContinue,30)) {
            click(btnContinue, 30,"CONTINUAR", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer seleccionar la cuenta
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectAccount(String accountNumber, boolean report, boolean takeScreenShot){
        By account = By.xpath("//*[contains(@text,'"+accountNumber+"')]");

        if(isElementPresent(account,15)){
            click(account,15,"Seleccionar Producto",report,takeScreenShot);
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
    protected boolean validateForm(boolean report, boolean takeScreenShot){
        if (isElementPresent(selectCountry,15)){
            crearPaso("Se muestra el formulario para completar transferecia SIPA", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método validar que se muestre la pagina de Beneficiarios
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateSipaPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateScreen,15)){
            crearPaso("Se muestra la pagina de tranasacciones", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }


    /**
     * Método para completar formulario para transferencia SIPA
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeFormSIPA(boolean report, boolean takeScreenShot){

        setText(txtNameBeneficiary,"prueba",15,report,false);
        setText(txtNumberBeneficiary,"2222",15,report,false);

        //Selccionar pais
        click(selectCountry,15,"Seleccionar pais",report,false);
        dropDown("GUATEMALA",report,false);
        By country = By.xpath("//android.widget.Button[@text=\"GUATEMALA\"]");
        click(country,15,"Seleccionar pais",report,false);

        setText(txtCountry,"GUATEMALA",15,report,false);
        setText(txtEmail,"prueba@hotmail.com",15,report,takeScreenShot);

        dropDown("Hoy",false,false);

        //Seleccionar Banco
        click(selectBankDestiny,15,"Seleccionar banco",report,false);
        By bank = By.xpath("//android.widget.Button[@text=\"BANCO DE GUATEMALA\"]");
        dropDown("BANCO DE LOS TRABAJADORES",report,false);
        click(bank,15,"Seleccionar",report,takeScreenShot);


        setText(txtProductNumber,"777777777",15,report,false);
        setText(txtAmount,"100",15,report,false);
        setText(txtDescription,"prueba",15,report,takeScreenShot);
    }
}
