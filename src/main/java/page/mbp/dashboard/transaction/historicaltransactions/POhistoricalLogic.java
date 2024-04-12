package page.mbp.dashboard.transaction.historicaltransactions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.dashboard.transaction.POtransactionLogic;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.transactionsummary.POresumenTransaccionLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de historico
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POhistoricalLogic {

    POhistoricalPage historicalPage ;
    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPage;
    POtransactionLogic transactionLogic;
    POresumenTransaccionLogica transactionSummaryLogic;
    AndroidDriver<AndroidElement> driver;
    private String user = "00111435384";

    public POhistoricalLogic(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPage = new  POdashboardPagina(driver);
        transactionLogic = new POtransactionLogic(driver);
        historicalPage = new POhistoricalPage(driver);
        transactionSummaryLogic = new POresumenTransaccionLogica(driver);
    }

    public static POhistoricalLogic getInstance(AndroidDriver<AndroidElement> driver){
        return new POhistoricalLogic(driver);
    }

    /**
     * Método para validar que se muestre la pagina historico de transacciones.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateHistoricalPage(){
        loginLogic.login(user,"1111",false,false,false);

        dashboardPage.goToTransaction(true,false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModuleSupport();
        transactionLogic.goToHistorical();

        return historicalPage.validateHistoricalPage(true,true);
    }

    /**
     * Método para validar que se muestre el detalle de transacciones.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateSummaryHistorical(String typeTransaction){
        loginLogic.login(user,"1111",false,false,false);

        dashboardPage.goToTransaction(true,false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModuleSupport();
        transactionLogic.goToHistorical();

        historicalPage.validateHistoricalPage(true,true);
        historicalPage.searchRecord(typeTransaction,true,true);
        historicalPage.goTSummary(true,false);

        return transactionSummaryLogic.validateSummaryPage();
    }


    /**
     * Método para validar que se muestre la pagina historico de resumen transacciones internacionales.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateHistoricalInternationalPage(){
        loginLogic.login(user,"1111",false,false,false);

        dashboardPage.goToTransaction(true,false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModuleSupport();
        transactionLogic.goToHistorical();

        historicalPage.goToInternational(true,false);
        return historicalPage.validateHistoricalPage(true,true);
    }

    /**
     * Método para validar que se muestre el detalle de transacciones internacional.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateSummaryHistoricalInternational(String typeTransaction){
        loginLogic.login(user,"1111",false,false,false);

        dashboardPage.goToTransaction(true,false);

        transactionLogic.validatePageTransaction();
        transactionLogic.validateModuleSupport();
        transactionLogic.goToHistorical();

        historicalPage.goToInternational(true,false);
        historicalPage.validateHistoricalPage(true,true);
        historicalPage.searchRecord(typeTransaction,true,true);
        historicalPage.goTSummary(true,false);

        return transactionSummaryLogic.validateSummaryPage();
    }

}
