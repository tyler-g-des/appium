package page.mbp.transaction.paymenservice;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.dashboard.transaction.POtransactionLogic;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.transactionconfirm.POconfirmarTransaccionLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba perteneciente a resumen de transacciones
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POpaymentServiceLogic {

    POiniciarSesionLogica iniciarSesionLogica;
    POdashboardPagina dashboardPagina;
    POtransactionLogic transactionLogic;
    POpaymentServicePage paymentServicePage;
    POconfirmarTransaccionLogica confirmarTransaccionLogica;
    AndroidDriver<AndroidElement> driver;

    public POpaymentServiceLogic(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        transactionLogic = new POtransactionLogic(driver);
        dashboardPagina = new POdashboardPagina(driver);
        iniciarSesionLogica = new POiniciarSesionLogica(driver);
        paymentServicePage = new POpaymentServicePage(driver);
        confirmarTransaccionLogica = new POconfirmarTransaccionLogica(driver);
    }

    public static POpaymentServiceLogic getInstance(AndroidDriver<AndroidElement> driver) {
        return new POpaymentServiceLogic(driver);
    }


    /**
     * Método para agregar Nuevo Servicio.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean addNewService() {
        validatePagePaymentServicePage("03102674383", "1111");

        paymentServicePage.goToNewService(true, false);
        paymentServicePage.validateAddPaymentServicePage(true, true);
        //CORAAPLATA
        paymentServicePage.selectSupplier("CAASD", true, true);
        //Pago Factur
        paymentServicePage.selectService("2154", true, true);
        paymentServicePage.writeTextOnContract("1234", true, false);
        paymentServicePage.goToConsult(true, false);
        paymentServicePage.validatePayment(true, true);

        paymentServicePage.selectProduct("0067", true, true);
        paymentServicePage.completeTypePay("Otro monto", "100", true, true);
        return confirmarTransaccionLogica.validateSummaryPage();
    }


    /**
     * Método para pagar servicio inscrito.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean payServiceRegistered() {
        validatePagePaymentServicePage("03102674383", "1111");

        paymentServicePage.selectServicePay("CAASD - 1234", true, true);
        paymentServicePage.validatePayment(true, true);
        paymentServicePage.selectProduct("0067", true, true);
        paymentServicePage.completeTypePay("Otro monto", "100", true, true);

        return confirmarTransaccionLogica.validateSummaryPage();
    }

    /**
     * Método para validar que se muestre la pantalla de pago de servicio.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validatePagePaymentServicePage(String user, String password) {
        iniciarSesionLogica.login(user, password, false, false, false);

        dashboardPagina.goToTransaction(true, false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModule();
        transactionLogic.goToPaymentService();

        return paymentServicePage.validatePaymentServicePage(true, true);
    }


    public void exitPayService() {
        paymentServicePage.validatePaymentServicePage(true, true);
        paymentServicePage.btnBack(true,false);
    }
}
