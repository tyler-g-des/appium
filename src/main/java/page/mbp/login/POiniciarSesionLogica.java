package page.mbp.login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.keycard.POtarjetaDeClaveLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de Iniciar Sesion
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POiniciarSesionLogica {
    POiniciarSesionPagina loginPage;
    POtarjetaDeClaveLogica keyCardLogic;
    POpreguntaSeguridadLogica preguntasSeguridad;
    AndroidDriver<AndroidElement> driver;
    public POiniciarSesionLogica(AndroidDriver<AndroidElement>  driver){
        this.driver = driver;
        loginPage = new POiniciarSesionPagina(driver);
        keyCardLogic = new POtarjetaDeClaveLogica(driver);
        preguntasSeguridad = new POpreguntaSeguridadLogica(driver);
    }

    public static POiniciarSesionLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POiniciarSesionLogica(driver);
    }

    /**
     * Método para hacer iniciar sesion.
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean login(String user, String pass, boolean rememberUser, boolean report, boolean takeScreenShot){
        loginPage.carousel();
        loginPage.goToLoginCarousel(report,takeScreenShot);
        loginPage.goToLoginPage(report,takeScreenShot);
        loginPage.btnX(false,false);
        loginPage.completeLoginForm(user,pass,report,takeScreenShot);

        if (rememberUser){ loginPage.tapRemember(report,takeScreenShot); }

        loginPage.goToLogIn(report,false);
        preguntasSeguridad.completeSecurityQuestion(false);
        loginPage.completeTutorial(true,true);
        loginPage.closeMenu(false,false);
        loginPage.closeMenu(false,false);
        return loginPage.validateDashboardPage(report,takeScreenShot);
    }

    /**
     * Método para navegar en las opciones de la pagian de inicio de sesion.
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateHomeScreenOptions(){
        loginPage.carousel();
        loginPage.goToLoginCarousel(false,false);
        loginPage.goToLoginPage(true,false);
        loginPage.btnX(false,false);
        loginPage.openMenu(true,false);
        loginPage.goToQuickReference(true,false);
        loginPage.validateQuickReferencePage(true,true);
        loginPage.btnBack(true,false);

        loginPage.openMenu(true,false);
        loginPage.openMenu(true,false);
        loginPage.goToForeignExchange(true,false);
        loginPage.validateForeignExchangePage(true,true);
        loginPage.btnClose(true,true);

        loginPage.openMenu(true,false);
        loginPage.goToFinancialEntity(true,false);
        loginPage.validateFinancialEntityPage(true,true);
        loginPage.goToWebFinancialEntity(true,true);
        loginPage.validateFinancialEntitySBPage(true,true);
        loginPage.btnCloseFF(true,false);

        return loginPage.validateFinancialEntityPage(true,true);
    }

    /**
     * Método para comprobar mensaje de error al introducir datos incorrectos.
     *
     * @params String, String
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean failureLogin(String user, String pass){
        loginPage.carousel();
        loginPage.goToLoginCarousel(false,false);
        loginPage.goToLoginPage(true,false);
        loginPage.btnX(false,false);
        loginPage.completeLoginForm(user,pass,true,true);
        loginPage.goToLogIn(true,false);
        return loginPage.validateFailureLogin(true,true);
    }

    /**
     * Método para Iniciar Sesion y recordar el usuario que inicio sesion.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean rememberUser(){
        login("00111435384","1111",true,false,false);

        closeSession();
        loginPage.validateLoginPage(true,true);
        loginPage.tapRemember(true,true);

        return loginPage.validateLoginPage(true,true);
    }

    /**
     * Método para validar que se muestre el contrato.
     *
     * @params String, String
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateContract(String user, String pass){
        loginPage.carousel();
        loginPage.goToLoginCarousel(false,false);
        loginPage.goToLoginPage(true,false);
        loginPage.btnX(false,false);
        loginPage.completeLoginForm(user, pass,true,true);
        loginPage.goToLogIn(true,false);
        preguntasSeguridad.completeSecurityQuestion(false);
        loginPage.switchToNativeContext();
        return loginPage.validateContract(true,true);
    }

    /**
     * Método para aceptar terminos y condiciones usuarios con contracto no aceptados
     *
     * @params String, String
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean acceptTermAndConditions(String user, String pass){
        validateContract(user, pass);
        keyCardLogic.signContract();
        return loginPage.validateDashboardPage(true,true);
    }

    /**
     * Método para validar la carta de Derechos y Deberes.
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateRightsAndDutiesPage(){
        loginPage.carousel();
        loginPage.goToLoginCarousel(false,false);
        loginPage.goToLoginPage(true,false);
        loginPage.openMenu(true,false);
        loginPage.openMenu(true,false);
        loginPage.goToRightsAndDuties(true,false);
        return loginPage.validateRightsAndDutiesPage(true,true);
    }


    public void closeSession() {
        loginPage.openMenu(true,false);
        loginPage.goToSignOff(true,false);
        loginPage.validateSignOffPage(true,true);
        loginPage.goToReturnLogin(true,false);
    }


}
