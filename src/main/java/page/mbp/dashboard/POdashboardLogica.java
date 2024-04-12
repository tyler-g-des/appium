package page.mbp.dashboard;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.detailsproduct.POdetailProductLogica;
import page.mbp.login.POiniciarSesionLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de dashboard
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POdashboardLogica {

    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPage;
    AndroidDriver<AndroidElement> driver;

    public POdashboardLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPage = new POdashboardPagina(driver);
    }

    public static POdashboardLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POdashboardLogica(driver);
    }

    /**
     * Método para validar que se muestre el mensaje para descargar aplicacion TDC
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateMessageTC(String user, String pass){
        loginLogic.login(user,pass,false,false,false);
        dashboardPage.openMenu(true,true);
        dashboardPage.goToTDCDigital(true,false);
        return dashboardPage.validateMessageTC(true,true);
    }

    /**
     * Método para validar que se muestre la tasa de divisas
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateCurrencyExchange(String user, String pass){
        loginLogic.login(user,pass,false,false,false);
        dashboardPage.openMenu(true,true);
        dashboardPage.goToforeignExchange(true,false);
        return true;
    }

    public void validateProductDetail(String session, String account){
        dashboardPage.validateSession(session,true,true);
        dashboardPage.swipeDashboard(account,true,true);
        dashboardPage.goToCard(account,true,false);
    }


}
