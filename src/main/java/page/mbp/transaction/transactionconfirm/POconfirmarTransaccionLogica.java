package page.mbp.transaction.transactionconfirm;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Esta clase define los pasos que tienen los casos de prueba
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POconfirmarTransaccionLogica {

    POconfirmarTransaccionPagina confirmarTransaccionPagina;
    AndroidDriver<AndroidElement> driver;

    public POconfirmarTransaccionLogica(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        confirmarTransaccionPagina = new POconfirmarTransaccionPagina(driver);
    }

    /**
     * Método para validar que se muestre la pantalla de resumen de transaccion.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToValidateTransaction(){
         confirmarTransaccionPagina.goToConfirmTransaction(false,true);
    }

    /**
     * Método para validar que se muestre la pantalla de resumen de transaccion.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateSummaryPage(){
        return confirmarTransaccionPagina.validateTransactionConfirmPage(true,true);
    }
}
