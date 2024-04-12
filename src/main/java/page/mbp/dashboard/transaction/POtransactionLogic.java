package page.mbp.dashboard.transaction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de transacciones
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POtransactionLogic {

    POtransactionPage transactionPage;
    AndroidDriver<AndroidElement> driver;

    public POtransactionLogic(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        transactionPage = new POtransactionPage(driver);
    }

    public static POtransactionLogic getInstance(AndroidDriver<AndroidElement> driver){
        return new POtransactionLogic(driver);
    }

    /**
     * Método para hacer click en el boton Historico de transacciones
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToBeneficiary(){ transactionPage.goToBeneficiary(true,false); }

    /**
     * Método para hacer click en el boton Beneficiarios Inscritos
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToHistorical(){ transactionPage.goToHistorical(true,false); }

    /**
     * Método para hacer click en el boton Pago de servicios
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToPaymentService(){ transactionPage.goToPaymentService(true,false); }

    /**
     * Método para hacer click en el boton Pago de servicios
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToSIPA(){ transactionPage.goToSIPA(true,false); }

    /**
     * Método para hacer click en el boton A terceros
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToThird(){ transactionPage.goToThird(true,false); }

    /**
     * Método para hacer click en el boton Pin Pesos
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToPinPesos(){ transactionPage.goToPinPesos(true,false); }

    /**
     * Método para hacer click en el boton A Propia
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToOwn(){ transactionPage.goToOwn(true,false); }

    /**
     * Método para hacer click en el boton Internacional
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToInternational(){ transactionPage.goToInternational(true,false); }

    /**
     * Método validar que se muestre la pagina de Beneficiarios
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validatePageTransaction(){ return transactionPage.validateTransactionPage(true,true); }

    /**
     * Método validar que se muestre la pagina de soporte y mantenimiento en la pagian de transacciones
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateModule(){ return transactionPage.validateBeneficiaryOptionM(true,true); }

    /**
     * Método validar que se muestre la pagina de soporte y mantenimiento en la pagian de transacciones
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateModuleSupport(){ return transactionPage.validateBeneficiaryOption(true,true); }

}
