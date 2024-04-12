package page.mbp.login;

import controladorlocal.BaseTestAppium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import controladorlocal.Base;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.ArrayList;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de Inicio de Sesion
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POiniciarSesionPagina extends Base {

    public POiniciarSesionPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    private By txtIdentityDocument = By.xpath("//android.view.View[1]/android.widget.EditText");
    private By txtPassword = By.xpath("//android.view.View[2]/android.widget.EditText");
    private By btnLogin = By.xpath("//android.view.View[@resource-id='goToLoginButton']/android.widget.Button");
    private By btnLoginLogin = By.className("android.widget.Button");
    private By validateScreen = By.xpath("//*[contains(@text,'CUENTAS')] | " +
            "//*[contains(@text,'TARJETAS DE CRÉDITO')] |" +
            "//*[contains(@text,'PRÉSTAMOS')]");

    private By btnRememberUser = By.xpath("//android.widget.ToggleButton[@resource-id=\"ion-tg-0\"] | //android.widget.ToggleButton[@resource-id=\"ion-tg-1\"] | //android.widget.CheckBox[@resource-id=\"ion-tg-0\"] | //android.widget.CheckBox[@resource-id=\"ion-tg-0\"]");
    private By messageIncorrect = By.xpath("//android.app.Dialog[@resource-id='ion-overlay-2']/android.view.View/android.view.View");
    private By validateContract = By.xpath("//*[contains(@text,\"Términos y Condiciones\") or //android.webkit.WebView]");

    //----MENU

    //-- CONSULTA RAPIDA
    private By btnQuickReference = By.xpath("//*[contains(@text,'Consulta rápida')]");
    private By validateQuickReference = By.xpath("//*[contains(@text,'Consulta rápida')]");

    //--DIVISAS
    private By btnForeignExchange = By.xpath("//*[contains(@text,'Divisas')]");
    private By validateForeignExchange = By.xpath("//*[contains(@text,\"Si quieres vender\")]");
    private By btnX = By.xpath("//android.app.Dialog/android.view.View/android.view.View/android.view.View[1]/android.view.View");

    //--LOCALIZACIONES

    //Entidad financiera
    private By btnFinancialEntity= By.xpath("//android.widget.Button[@text='Entidad financiera autorizada']");
    private By btnGoToWebSB = By.xpath("//android.widget.Button[@text='IR AL PORTAL WEB DE LA SB']");
    private By validateFF = By.xpath("//android.widget.Image[@text='Logo del Banco BHD']");
    private By btnCloseFF = By.xpath("//android.widget.ImageButton[@content-desc='Close Button']");

    //Derecho y deberes
    private By btnRightsAndDuties = By.xpath("//android.widget.Button[@text='Deberes y derechos de los usuarios']");
    private By validateRightsAndDuties = By.xpath("//android.widget.Image[@text='image_160_0380742b54']");

    //--Cerrar Sesion
    private By btnCloseSession = By.xpath("//android.widget.Button[@text='CERRAR SESIÓN']");
    private By btnOpenMenuDashboard = By.xpath("//android.view.View[@resource-id=\"private-menu\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.TextView[1]");
    private By validateCloseSession = By.xpath("//*[contains(@text,'¡La sesión se ha cerrado satisfactoriamente!')]");
    private By btnReturnLogin = By.className("android.widget.Button");
    private By carrusel = By.xpath("//*[@resource-id='public-menu']");
    private By btnNext = By.xpath("//*[@text='Siguiente']");
    private By btnFinal = By.xpath("//android.app.Dialog[@resource-id=\"driver-popover-content\"]//android.widget.Button[@text=\"Finalizar\"]");
    private By messageTutorial = By.xpath("//android.app.Dialog[@resource-id=\"driver-popover-content\"]");
    private By slideAvailable = By.xpath("//android.app.Dialog[@resource-id=\"driver-popover-content\"]//android.widget.TextView[contains(@text,\"1\")]");
    private By close = By.xpath( "//*[contains(@text,'CERRAR')]");
    private By Menu =  By.xpath("//android.view.View[@text=\"menu\"]/android.view.View");
    private boolean status;

    /**
     * Método para hacer click en el boton INICIAR SESION
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToLoginPage(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnLogin,30)) {
            click(btnLogin, 15,"Inicia Sesion", report, takeScreenShot);
        }
    }

    public void goToCerrar(boolean report, boolean takeScreenShot){
        try {
                click(close, 10, "close", report, takeScreenShot);
        }catch (NoSuchElementException ex){
            crearPaso("no se mostro mensaje para cerrar ",true,false,false);
        }
        catch (TimeoutException ee){
            crearPaso("no se mostro mensaje para cerrar",true,false,false);
        } catch (Exception e){
            throw (e);
        }
    }

    /**
     * Método para hacer click en el boton INICIAR SESION
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToLogIn(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnLoginLogin,15)) {
            click(btnLoginLogin, 15,"Inicia Sesion",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton MENU
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
     * Método para hacer click en el boton para RETROCEDER
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void btnBack(boolean report, boolean takeScreenShot){
        clickCoordinates(106,182,15,"back",report,takeScreenShot);
    }

    /**
     * Método para hacer click en el boton CERRAR
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void btnClose(boolean report, boolean takeScreenShot){
            clickCoordinates(106,182,15,"close",report,takeScreenShot);
    }

    public void btnX(boolean report, boolean takeScreenShot) {
        try {
            click(btnX, 15, "cerrar", report, takeScreenShot);
        } catch (NoSuchElementException | TimeoutException ex) {
            crearPaso("no salio el mensaje inforamativo", true, false, false);
        }
    }

        /**
         * Método para hacer click en el boton TAB
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void tapRemember ( boolean report, boolean takeScreenShot){
            if (isElementPresent(btnRememberUser, 15)) {
                click(btnRememberUser, 15, "tap recordar usuario", report, takeScreenShot);
            }
        }

        //----Menu
        /**
         * Método para hacer click en el boton Consulta Rapida
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void goToQuickReference ( boolean report, boolean takeScreenShot){
            if (isElementPresent(btnQuickReference, 30)) {
                click(btnQuickReference, 30, "Consulta Rapida", report, takeScreenShot);
            }
        }

        /**
         * Método para hacer click en el boton Divisas
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void goToForeignExchange ( boolean report, boolean takeScreenShot){
            if (isElementPresent(btnForeignExchange, 30)) {
                click(btnForeignExchange, 30, "Divisas", report, takeScreenShot);
            }
        }

        /**
         * Método para hacer click en el boton Entidad finaciera autorizada"
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void goToFinancialEntity ( boolean report, boolean takeScreenShot){
            if (isElementPresent(btnFinancialEntity, 30)) {
                click(btnFinancialEntity, 30, "Entidad finaciera autorizada", report, takeScreenShot);
            }
        }

        /**
         * Método para hacer click en el boton Ir al portal WEB
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void goToWebFinancialEntity ( boolean report, boolean takeScreenShot){
            if (isElementPresent(btnGoToWebSB, 30)) {
                click(btnGoToWebSB, 30, "Ir al portal WEB", report, takeScreenShot);
            }
        }

        /**
         * Método para hacer click en el boton CERRAR
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void btnCloseFF (boolean report, boolean takeScreenShot){
            if (isElementPresent(btnCloseFF, 30)) {
                click(btnCloseFF, 30, "CERRAR", report, takeScreenShot);
            }
        }

        /**
         * Método para hacer click en el boton Derechos y Deberes
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void goToRightsAndDuties (boolean report, boolean takeScreenShot){
            if (isElementPresent(btnRightsAndDuties, 30)) {
                click(btnRightsAndDuties, 30, "Derechos y Deberes", report, takeScreenShot);
            }
        }

        /**
         * Método para validar que se muestre la pagina de Consulta Rapida
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected boolean validateQuickReferencePage (boolean report, boolean takeScreenShot){
            if (isElementPresent(validateQuickReference, 15)) {
                crearPaso("Se observa la pagina consulta rapida ", true, report, takeScreenShot);
                status = true;
            }
            return status;
        }

        /**
         * Método para validar que se muestre la pagina de Divisas
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected boolean validateForeignExchangePage (boolean report, boolean takeScreenShot){
            if (isElementPresent(validateForeignExchange, 30)) {
                crearPaso("Se observa la pagina Divisas ", true, report, takeScreenShot);
                status = true;
            }
            return status;
        }

        /**
         * Método para validar que se muestre la pagina de ENTIDAD AUTORIZADA
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected boolean validateFinancialEntityPage (boolean report, boolean takeScreenShot){
            if (isElementPresent(btnGoToWebSB, 15)) {
                crearPaso("Se observa la pagina de ENTIDAD AUTORIZADA ", true, report, takeScreenShot);
                status = true;
            }
            return status;
        }

        /**
         * Método para validar que se muestre la pagina de SB
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected boolean validateFinancialEntitySBPage (boolean report, boolean takeScreenShot){
            if (isElementPresent(validateFF, 15)) {
                crearPaso("Se observa la pagina de SB ", true, report, takeScreenShot);
                status = true;
            }
            return status;
        }

        /**
         * Método para validar que se muestre la carta de dechos y deberes
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected boolean validateRightsAndDutiesPage (boolean report, boolean takeScreenShot){
            if (isElementPresent(validateRightsAndDuties, 15)) {
                crearPaso("Se observa la carta de dechos y deberes", true, report, takeScreenShot);
                nativeButtonBack(report, takeScreenShot);
                status = true;
            }
            return status;
        }

        /**
         * Método para escribir en el campo numero de documento el numero de documento recibido por parametro
         *
         * @params String, Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void writeTextOnIdentityDocument (String text,boolean report, boolean takeScreenShot){
            if (isElementPresent(txtIdentityDocument, 15)) {
                setText(txtIdentityDocument, text, 15, report, takeScreenShot);
            }
        }

        /**
         * Método para escribir en el campo clave recibido por parametro
         *
         * @params String, Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void writeTextOnPassword (String text,boolean report, boolean takeScreenShot){
            if (isElementPresent(txtPassword, 15)) {
                setText(txtPassword, text, 15, report, takeScreenShot);
            }
        }

        /**
         * Método para escribir en el campo clave recibido por parametro
         *
         * @params String, Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void completeLoginForm (String user, String pass,boolean report, boolean takeScreenShot){
            writeTextOnIdentityDocument(user, report, takeScreenShot);
            writeTextOnPassword(pass, report, takeScreenShot);
        }

        /**
         * Método para validar que se muestre el mensaje de error al introducir datos incorrectos
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected boolean validateFailureLogin (boolean report, boolean takeScreenShot){
            if (isElementPresent(messageIncorrect, 15)) {
                String text = driver.findElement((messageIncorrect)).getText();
                crearPaso("Se observa el mesaje informativo " + text, true, report, takeScreenShot);
                status = true;
            }
            return status;
        }

        /**
         * Método para validar que se muestre el mensaje de error al introducir datos incorrectos
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected boolean validateLoginPage (boolean report, boolean takeScreenShot){
            if (isElementPresent(btnLoginLogin, 15)) {
                crearPaso("Se obeserva la pagina login ", true, report, takeScreenShot);
                status = true;
            }
            return status;
        }

        /**
         * Método para validar que se muestre la pagina de Dashboard
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        public boolean validateDashboardPage (boolean report, boolean takeScreenShot){
            goToCerrar(false,false);
            if (isElementPresent(validateScreen, 30)) {
                crearPaso("Se obeserva la pagina Dashboard ", true, report, takeScreenShot);
                status = true;
            }
            return status;
        }

        /**
         * Método para validar que se muestre el contrato con terminos y condiciones
         *
         * @params Boolean
         * @return Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected boolean validateContract (boolean report, boolean takeScreenShot){
            //valisateContract
            if (isElementPresent(validateContract, 30)) {
                crearPaso("Se ve el contrato de terminos y condiciones", true, report, takeScreenShot);
                status = true;
            }
            return status;
        }


        //Cerrar Sesion
        /**
         * Método para hacer click en el boton abrir menu
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void openMenuDashboard (boolean report, boolean takeScreenShot){
            if (isElementPresent(btnOpenMenuDashboard, 15)) {
                click(btnOpenMenuDashboard, 15, "abrir menu", report, takeScreenShot);
            }
        }

        /**
         * Método para hacer click en el Cerrar Sesion
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
         protected void goToSignOff (boolean report, boolean takeScreenShot){
             if (isElementPresent(btnCloseSession, 30)) {
                 click(btnCloseSession, 30, "Cerrar Sesion", report, takeScreenShot);
             }
         }

        /**
         * Método para hacer click en el boton Ingrese su cuenta
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        protected void goToReturnLogin (boolean report, boolean takeScreenShot){
            if (isElementPresent(btnReturnLogin, 30)) {
                click(btnReturnLogin, 30, "Ingrese su cuenta", report, takeScreenShot);
            }
        }

        /**
         * Método para hacer click en el Iniciar Sesion del carrusel
         *
         * @params Boolean
         * @author Tyler Diaz
         * @since 15/01/2024
         */
        public void goToLoginCarousel (boolean report, boolean takeScreenShot){
            Dimension size = driver.manage().window().getSize();
            int width = size.getWidth();
            int height = size.getHeight();
            int y = (int) (height * 0.9598);
            int x = (int) (width * 0.5);

            // 740,2104,
            clickCoordinates(x,y, 15, "INICIAR SESION", report, takeScreenShot);
        }

        /**
        * Método validar que se muestre el mensaje informativo indicando que la sesion se cerro
        *
        * @params Boolean
        * @return Boolean
        * @author Tyler Diaz
        * @since 15/01/2024
        */
        protected boolean validateSignOffPage (boolean report, boolean takeScreenShot){
            if (isElementPresent(validateCloseSession, 15)) {
                crearPaso("Se observa la pagina de la sesion cerrado con el mensaje"
                        + driver.findElement(validateCloseSession).getText(), true, report, takeScreenShot);
                status = true;
            }
            return status;
        }

        public void carousel () {
            int slides = 0;

            if (isElementPresent(carrusel, 60)) {
                // Intentar encontrar el carrusel
                try {

                    MobileElement carousel = driver.findElement(carrusel);

                    // Deslizar el carrusel 6 veces
                    while (slides < 9) {

                        int startX = carousel.getLocation().getX() + (carousel.getSize().getWidth() / 2);
                        int startY = carousel.getLocation().getY() + (carousel.getSize().getHeight() / 2);
                         new TouchAction<>(driver)
                                .press(PointOption.point(startX, startY))
                                // Esperar 500ms
                                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
                                .moveTo(PointOption.point(startX - 500, startY))
                                .release()
                                .perform();
                        slides++;
                    }
                } catch (NoSuchElementException e) {
                    throw (e);
                }
            }
        }

        public void closeMenu (boolean report, boolean takeScreenShot) {
            //971,280
            //1200,400
            clickCoordinates(971,280,15,"cerrar menu",report,takeScreenShot);
        }

        /**
        * Método validar que se muestre el mensaje informativo indicando que la sesion se cerro
        *
        * @params Boolean
        * @return Boolean
        * @author Tyler Diaz
        * @since 15/01/2024
        */
        protected void completeTutorial ( boolean report, boolean takeScreenShot){
            if (isElementPresent(btnNext,30)){
                openMenu(false,false);
                if (isElementPresent(btnFinal,10)) {
                    click(btnFinal, 10, "Finalizar", report, takeScreenShot);
                }
            }

        }

        public void switchToWebContext() {
        ArrayList<String> contexts = new ArrayList(driver.getContextHandles());
        for (String context : contexts) {
            //System.out.println(context);
            if (context.contains("WEBVIEW")) {
                driver.context(context);
            }
        }
    }

        public void switchToNativeContext() {
        ArrayList<String> contexts = new ArrayList(driver.getContextHandles());
        for (String context : contexts) {
            //System.out.println(context);
            if (context.contains("NATIVE")) {
                driver.context(context);
            }
        }
    }
}
