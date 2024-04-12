package page.mbp.dashboard.transaction.registeredbeneficiarypage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.dashboard.transaction.POtransactionLogic;
import page.mbp.keycard.POtarjetaDeClaveLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de Beneficiarios
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class PObeneficiaryLogic {

    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPage;
    POtransactionLogic transactionLogic;
    PObeneficiaryPage beneficiaryPage;
    POtarjetaDeClaveLogica keyCardLogic;
    AndroidDriver<AndroidElement> driver;
    private String user="03102674383";

    public PObeneficiaryLogic(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPage = new POdashboardPagina(driver);
        transactionLogic = new POtransactionLogic(driver);
        beneficiaryPage = new PObeneficiaryPage(driver);
        keyCardLogic = new POtarjetaDeClaveLogica(driver);
    }

    public static PObeneficiaryLogic getInstance(AndroidDriver<AndroidElement>  driver){
        return new PObeneficiaryLogic(driver);
    }

    /**
     * Método para validar pagina mantenimiento beneficiario.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateBeneficiaryPage(){
        loginLogic.login(user,"1111",false,false,false);

        dashboardPage.goToTransaction(true,false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModuleSupport();
        transactionLogic.goToBeneficiary();

        return beneficiaryPage.validateBeneficiaryPage(true,true);
    }

    /**
     * Método para agregar beneficiario desde el mantemiento de beneficiario.
     *
     * @params String, String, String
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean addNewBeneficiary(String bank, String productNumber, String bankSelect, String typeProduct ){
        loginLogic.login(user,"1111",false,false,false);

        dashboardPage.goToTransaction(true,false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModuleSupport();
        transactionLogic.goToBeneficiary();

        beneficiaryPage.validateBeneficiaryPage(true,true);
        beneficiaryPage.selectBank(bank,true,true);
        beneficiaryPage.goToNewBeneficiary(true,false);
        beneficiaryPage.completeNewBeneficiaryForm(bankSelect, productNumber,typeProduct ,true,true);
        beneficiaryPage.goToSave(true,false);

        keyCardLogic.completeKeyTC();
        return beneficiaryPage.validateMessageRegisteredSuccessful(true,true);
    }

    /**
     * Método para ver detalle de beneficiario desde el mantenimiento  por el numero de producto.
     *
     * @params String
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean seeBeneficiary(String productNumber){
        loginLogic.login(user,"1111",false,false,false);

        dashboardPage.goToTransaction(true,false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModuleSupport();
        transactionLogic.goToBeneficiary();

        beneficiaryPage.validateBeneficiaryPage(true,true);
        beneficiaryPage.searchBeneficiaryAndEdit(productNumber,true,true);

        return beneficiaryPage.validateEditBeneficiaryPage(true,true);
    }

    /**
     * Método para eliminar beneficiario desde el mantenimiento por el numero de producto.
     *
     * @params String
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean deleteBeneficiary(String productNumber){
        loginLogic.login(user,"1111",false,false,false);

        dashboardPage.goToTransaction(true,false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModuleSupport();
        transactionLogic.goToBeneficiary();

        beneficiaryPage.validateBeneficiaryPage(true,true);
        beneficiaryPage.deleteBeneficiaryRegister(productNumber,true,true);

        return beneficiaryPage.validateMessageDeleteBeneficiary(true,true);
    }
}
