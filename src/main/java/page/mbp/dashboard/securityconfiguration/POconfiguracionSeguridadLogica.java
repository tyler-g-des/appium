package page.mbp.dashboard.securityconfiguration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.dashboard.accesssetting.POconfiguracionAccesoPagina;
import page.mbp.helptologin.POayudaLoginLogica;
import page.mbp.keycard.POtarjetaDeClaveLogica;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.login.POiniciarSesionPagina;
import page.mbp.login.POpreguntaSeguridadLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de dashboard
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POconfiguracionSeguridadLogica {

    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPage;
    POiniciarSesionPagina loginPage;
    POconfiguracionSeguridadPagina configuracionSeguridad;
    POtarjetaDeClaveLogica tarjetaDeClaveLogica;
    POpreguntaSeguridadLogica seguridadLogica;
    POayudaLoginLogica ayudaLoginLogica;
    AndroidDriver<AndroidElement> driver;

    public POconfiguracionSeguridadLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPage = new POdashboardPagina(driver);
        loginPage = new POiniciarSesionPagina(driver);
        configuracionSeguridad = new POconfiguracionSeguridadPagina(driver);
        tarjetaDeClaveLogica = new POtarjetaDeClaveLogica(driver);
        seguridadLogica = new POpreguntaSeguridadLogica(driver);
        ayudaLoginLogica = new POayudaLoginLogica(driver);
    }

    public static POconfiguracionSeguridadLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POconfiguracionSeguridadLogica(driver);
    }


    /**
     * Método para ingresar a la pagina de configuracion de seguridad
     *
     * @params String, String, Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void enterThePageConfigSecurity(){
        dashboardPage.openMenu(true,true);

        configuracionSeguridad.goToSecurityConfig(true,false);
        configuracionSeguridad.validateConfigurationSecurityPage(true,true);
    }


    /**
     * Método para cambiar preguntas de seguridad
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean changeSecurityQuestion(String user, String pass) {
        loginLogic.login(user, pass, false, false, false);

        enterThePageConfigSecurity();
        configuracionSeguridad.goToChangeSecurityQuestion(true,false);

        seguridadLogica.completeSecurityQuestion(true);
        return configuracionSeguridad.validateMessage(true,true);
    }

    /**
     * Método para cambiar clave de accewsp
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean changeKeyAccess(String user, String pass) {
        loginLogic.login(user, pass, false, false, false);

        enterThePageConfigSecurity();
        configuracionSeguridad.goToChangeKeyAccess(true,false);

        ayudaLoginLogica.changeKeyCurrent();
        tarjetaDeClaveLogica.completeKeyTC();

        return ayudaLoginLogica.validateMessage();
    }

    /**
     * Método para desahbilitar el uso de tarjeta de clave entre transacciones propia
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean disabledTDCandTrasactionOwn(String user, String pass) {
        loginLogic.login(user, pass, false, false, false);

        enterThePageConfigSecurity();
        configuracionSeguridad.goToDisableTC(true,false);

        tarjetaDeClaveLogica.completeKeyTC();
        return configuracionSeguridad.validateMessageDisabled(true,true);
    }

}
