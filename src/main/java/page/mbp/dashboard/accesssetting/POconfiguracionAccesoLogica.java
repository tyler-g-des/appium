package page.mbp.dashboard.accesssetting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.keycard.POtarjetaDeClaveLogica;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.login.POiniciarSesionPagina;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de dashboard
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POconfiguracionAccesoLogica {

    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPage;
    POiniciarSesionPagina loginPage;
    POconfiguracionAccesoPagina configuracionAcceso;
    POtarjetaDeClaveLogica tarjetaDeClaveLogica;
    AndroidDriver<AndroidElement> driver;

    public POconfiguracionAccesoLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPage = new POdashboardPagina(driver);
        loginPage = new POiniciarSesionPagina(driver);
        configuracionAcceso = new POconfiguracionAccesoPagina(driver);
        tarjetaDeClaveLogica = new POtarjetaDeClaveLogica(driver);
    }

    public static POconfiguracionAccesoLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POconfiguracionAccesoLogica(driver);
    }


    /**
     * Método para ingresar a la pagina de configuracion de acceso por PIN
     *
     * @params String, String, Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void enterThePageConfigAccess(){
        dashboardPage.openMenu(true,true);
        dashboardPage.goToConfigAccess(true,false);

        configuracionAcceso.validateConfigurationAccessPage(true,true);
        configuracionAcceso.goToAccessConfig(true,false);
    }

    /**
     * Método para cambiar configuracion de acceso
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean changePassword(String user, String pass){
        loginLogic.login(user,pass,false,false,false);

        enterThePageConfigAccess();

        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);

        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);

        tarjetaDeClaveLogica.completeKeyTC();

        configuracionAcceso.validateMessage(true,true);

        dashboardPage.nativeButtonBack(true,false);

        loginLogic.closeSession();

        configuracionAcceso.validatePin(true,true);

        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);
        configuracionAcceso.completeForm(true,false);

        loginPage.validateDashboardPage(true,true);
        enterThePageConfigAccess();
        configuracionAcceso.validatePinActive(true,true);
        configuracionAcceso.goToDeactivate(true,false);
        configuracionAcceso.validateMessageInformative(true,true);
        configuracionAcceso.goToDisable(true,false);
        return configuracionAcceso.validateConfigurationAccessPage(true,true);
    }


}
