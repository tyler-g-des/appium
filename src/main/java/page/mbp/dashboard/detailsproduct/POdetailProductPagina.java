package page.mbp.dashboard.detailsproduct;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de Dashboard
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POdetailProductPagina extends Base {

    public POdetailProductPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    private By btnTransferToThird = By.xpath("//*[contains(@text,\"A terceros\")]");
    private By btnPayTC = By.xpath("//*[contains(@text,\"Pagar tarjeta\")]");
    private By btnPayService = By.xpath("//*[contains(@text,\"Pago de servicios\")]");
    private By btnCurrencyExchange = By.xpath("//*[contains(@text,\"Cambio divisas\")]");
    private By validateDetail = By.xpath("//*[contains(@text,\"Balance\")]");
    private By btnTransfer = By.xpath("//*[contains(@text,\"Transferencias\")]");

    private boolean status;

    /**
     * Método para hacer click en el Tranferencia a Terceros
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToPayService(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnPayService,10)){
            click(btnPayService,10,"Pago de servicios",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton cambio Divisas
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToCurrencyExchange(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnCurrencyExchange,10)){
            click(btnCurrencyExchange,10,"Cambio divisas",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton transferencias
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToTransfer(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnTransfer,10)){
            click(btnTransfer,10,"Transfer",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el Pago de servicio
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToTransferToThird(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnTransferToThird,10)){
            click(btnTransferToThird,10,"A terceros y otros bancos",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Pagar tarjeta de credito
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToPayTC(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnPayTC,10)){
            click(btnPayTC,10,"Pagar tarjeta de credito",report,takeScreenShot);
        }
    }


    /**
     * Método para validar que se muestre el detalle de producto
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateProductDetail(boolean report, boolean takeScreenShot){
        if(isElementPresent(validateDetail,30)){
            crearPaso("Se muestra el detalle de producto",true,report,takeScreenShot);
            status = true;
        }
        return status;
    }

//63-10% = 58 reservas


}
