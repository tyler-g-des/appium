package page.mbp.dashboard.editsummary;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.login.POiniciarSesionLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de Editar Resumen
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POeditarResumenLogica {

    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPage;
    POeditarResumenPagina editSummaryPage;
    AndroidDriver<AndroidElement> driver;

    public POeditarResumenLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPage = new POdashboardPagina(driver);
        editSummaryPage = new POeditarResumenPagina(driver);
    }

    public static POeditarResumenLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POeditarResumenLogica(driver);
    }

    /**
     * Método para editar nombre para el resumen de producto en el dashboard
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateEditSummaryPage(String user, String pass, String session, String account){
        loginLogic.login(user,pass,false,false,false);
        dashboardPage.openMenu(true,false);
        dashboardPage.goToEditSummary(true,false);

        editSummaryPage.validateSummaryPage(true,true);
        editSummaryPage.searchProduct(session,account,true,true);
        editSummaryPage.goToSaveChange(true,false);

        return editSummaryPage.validateFailureLogin(true,true);
    }


}
