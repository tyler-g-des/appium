package page.mbp.dashboard;

import controladorlocal.Base;
import controladorlocal.BaseTestAppium;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de Dashboard
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POdashboardPagina extends Base {

    public POdashboardPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    private By messageDownloadTC = By.xpath("//*[contains(@text,\"DESCARGA EN LA TIENDA\")]");
    private By btnTDC = By.xpath("//*[contains(@text,\"Tarjeta de Claves\")]");
    private By btnConfigureAccess = By.xpath("//*[contains(@text,\"Configuración de acceso\")]");
    private By validateConfigAccess = By.xpath("//*[contains(@text,\"Selecciona el mecanismo de\")]");
    private By btnEditSummary = By.xpath("//*[contains(@text,\"Editar Resumen\")]");
    private By btnTransaction = By.xpath("//*[contains(@text,\"Transacciones\")]");
    private By btnForeignExchange = By.xpath("//android.widget.TextView[@text=\"Divisas\"]");
    private By validateScreen = By.xpath("//*[contains(@text,'CUENTAS')] | " +
            "//*[contains(@text,'TARJETAS DE CRÉDITO')] |" +
            "//*[contains(@text,'PRÉSTAMOS')]");
    int reintento = 0;

    private boolean status;


    /**
     * Método para hacer click en el boton Menu
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void openMenu(boolean report, boolean takeScreenShot){
        try {
            clickCoordinates(106,182,15,"hamburguesa",report,false);
        }catch (Exception e){
            BaseTestAppium.createStep("error openMenu " + e, false, takeScreenShot);
            throw (e);
        }
    }

    /**
     * Método para hacer click en el boton Menu
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToforeignExchange(boolean report, boolean takeScreenShot){
        dropDown("Divisas",report,true);
        if (isElementPresent(btnForeignExchange, 15)) {
            click(btnForeignExchange, 15, "divisas", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el Tarjeta de Claves Digital
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToTDCDigital(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnTDC, 15)) {
            click(btnTDC, 15, "Tarjeta de Claves Digital", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el configuracion de acceso
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToConfigAccess(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnConfigureAccess, 15)) {
            click(btnConfigureAccess, 15, driver.findElement(btnConfigureAccess).getText(), report, takeScreenShot);
        }

    }

    /**
     * Método para hacer click en el Editar Resumen
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToEditSummary(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnEditSummary, 15)) {
            click(btnEditSummary, 15, driver.findElement(btnEditSummary).getText(), report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton transacciones
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToTransaction(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnTransaction, 15)) {
            click(btnTransaction, 15, driver.findElement(btnTransaction).getText(), report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el Card en la sesion de dashboard
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToCard(String account, boolean report, boolean takeScreenShot){
        By btnCard = By.xpath("//*[contains(@text,'"+account+"')]");

        if (isElementPresent(btnCard, 15)) {
            click(btnCard, 15, "Se hizo click en el card " + account, report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton transacciones
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void swipeDashboard(String text, boolean report , boolean takeScreenShot){
        if(reintento != 5) {
            try {
                String scrollableList = "new UiScrollable(new UiSelector().scrollable(true).instance(0))";
                String scrollIntoView = ".scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))";
                driver.findElement(MobileBy.AndroidUIAutomator(scrollableList + scrollIntoView));
                crearPaso("Se observa el card con el numero " + text, true,report,takeScreenShot);
            } catch (NoSuchElementException ex) {
                reintento ++;
                swipeDashboard(text,report,takeScreenShot);
            } catch (Exception e) {
                crearPaso("error dropDown " + e, false, report, takeScreenShot);
                throw (e);
            }
        }
    }

    /**
     * Método para validar que se muestre el mensaje para dercargar la aplicaicon tarjeta de clave
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateMessageTC(boolean report, boolean takeScreenShot){
        if (isElementPresent(messageDownloadTC,15)){
            crearPaso("Se observa el mensaje para descargar la TC", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pantalla de configuracion de acceso
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateConfigureAccess(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateConfigAccess,15)){
            crearPaso("Se observa la pantalla de configuracion de accesos", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pantalla de configuracion de acceso
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateSession(String session, boolean report, boolean takeScreenShot){
        By sessionDashboard = By.xpath("//*[contains(@text,'"+session+"')]");

        if(isElementPresent(validateScreen,20)) {

            if (session.equalsIgnoreCase("CUENTAS")) {
                dropDownCoinicidencia(session, report, takeScreenShot);
            } else {
                swipeDashboard(session, report, takeScreenShot);
            }

            if (isElementPresent(sessionDashboard, 10)) {
                crearPaso("Se muestra el apartado " + session, true, report, takeScreenShot);
                status = true;
            }
        }
        return status;
    }

}
