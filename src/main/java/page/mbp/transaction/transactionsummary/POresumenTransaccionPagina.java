package page.mbp.transaction.transactionsummary;

import controladorlocal.Base;
import controladorlocal.BaseTestAppium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina resumen de transaccion
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POresumenTransaccionPagina extends Base {

    private By validatePage = By.xpath("//*[contains(@text,\"Transacción completada\") or contains(@text,\"Transacción en proceso\") or contains(@text,\"ORIGEN\")]");
    private boolean status;

    public POresumenTransaccionPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    /**
     * Método para validar que se muestre la pagina de resumen de transaccion
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateTransactionSummaryPage(boolean screenshot){
        if (isElementPresent(validatePage,50)){
            BaseTestAppium.createStep("Se muestra la pagina del resumen de transaccion", true, screenshot);
            status = true;
        }
        return status;
    }


    /**
     * Método para validar que se muestre la pagina de resumen de transaccion
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean completeTr(boolean screenshot){
        if (isElementPresent(validatePage,50)){
            BaseTestAppium.createStep("Se muestra la pagina del resumen de transaccion", true, screenshot);
            status = true;
        }
        return status;
    }
}
