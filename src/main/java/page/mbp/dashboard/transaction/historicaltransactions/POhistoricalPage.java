package page.mbp.dashboard.transaction.historicaltransactions;

import controladorlocal.Base;
import controladorlocal.BaseTestAppium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de historico de transacciones
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POhistoricalPage extends Base {

    private By searchTransaction = By.xpath("//android.widget.EditText");
    private By validatePageHistorical = By.xpath("//*[contains(@text,\"De\")]");
    private By summary = By.xpath("//*[contains(@text,'Ver resumen')]");
    private By btnInternational = By.xpath("//android.widget.Button[@text=\"INTERNACIONALES\"]");
    private boolean status;

    public POhistoricalPage(AndroidDriver<AndroidElement> driver) { super(driver); }


    /**
     * Método para hacer click en el boton ver resumen
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goTSummary(boolean report, boolean takeScreenShot){
        if(isElementPresent(summary,30)) {
            click(summary, 30, "ver resumen", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Internacional
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToInternational(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnInternational,30)) {
            click(btnInternational, 30, "Internacional", report, takeScreenShot);
        }
    }

    /**
     * Método para escribir en el campo busqueda el tipo de producto
     *
     * @params String, Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void writeOnFilter(String typeTransaction, boolean report, boolean takeScreenShot){
        if (isElementPresent(searchTransaction,15)) {
            setText(searchTransaction, typeTransaction, 15, report, takeScreenShot);
        }
    }

    /**
     * Método para buscar transaccion por tipo de transacciones
     *
     * @params String, Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean searchRecord(String typeTransaction, boolean report, boolean takeScreenShot){
        By camp = By.xpath("(//*[contains(@text,'"+typeTransaction+"')])[1]");
        writeOnFilter(typeTransaction,report,takeScreenShot);
        pressButtonTAB(report,takeScreenShot);

        if (isElementPresent(camp,15)){
            crearPaso("Se muestra la transaccion", true, report,takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pantalla de historico de transacciones
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateHistoricalPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validatePageHistorical,50)){
            crearPaso("Se muestra la pagina historico de transacciones", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

}
