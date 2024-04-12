package page.mbp.transaction.transactionconfirm;

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
public class POconfirmarTransaccionPagina extends Base {

    private By validatePage = By.xpath("//android.widget.TextView[@text=\"Monto total de la transacción\"]");
    private By btnConfirmTrnasaction = By.xpath("(//android.widget.Button)[1]");
    private boolean status;

    public POconfirmarTransaccionPagina(AndroidDriver<AndroidElement> driver) { super(driver); }


    /**
     * Método para hacer click en el Editar Resumen
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToConfirmTransaction(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnConfirmTrnasaction, 15)) {
            click(btnConfirmTrnasaction, 15,"CONFIRMAR TRANSACCION", report, takeScreenShot);
        }
    }


    /**
     * Método para validar que se muestre la pagina de confirmacion de transaccion
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateTransactionConfirmPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validatePage,50)){
            BaseTestAppium.createStep("Se muestra la pagina del resumen de transaccion", true, takeScreenShot);
            dropDown("CONFIRMAR TRANSACCIÓN",report,takeScreenShot);
            status = true;
        }
        return status;
    }
}
