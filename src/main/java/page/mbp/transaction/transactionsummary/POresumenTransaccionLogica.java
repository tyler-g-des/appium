package page.mbp.transaction.transactionsummary;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Esta clase define los pasos que tienen los casos de prueba
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POresumenTransaccionLogica {

    POresumenTransaccionPagina transactionSummaryPage;
    AndroidDriver<AndroidElement> driver;

    public POresumenTransaccionLogica(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        transactionSummaryPage = new POresumenTransaccionPagina(driver);
    }

    /**
     * Método para validar que se muestre la pantalla de resumen de transaccion.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateSummaryPage(){
        return transactionSummaryPage.validateTransactionSummaryPage(true);
    }
}
