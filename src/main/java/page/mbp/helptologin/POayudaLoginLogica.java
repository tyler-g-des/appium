package page.mbp.helptologin;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.keycard.POtarjetaDeClaveLogica;
import page.mbp.login.POiniciarSesionPagina;
import page.mbp.login.POpreguntaSeguridadLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de ayuda para iniciar sesion
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POayudaLoginLogica {

    POayudaLoginPagina helpToLogInPage;
    POiniciarSesionPagina loginPage;
    POpreguntaSeguridadLogica preguntasSeguridad;
    POtarjetaDeClaveLogica keyCardLogic;
    AndroidDriver<AndroidElement> driver;

    public POayudaLoginLogica(AndroidDriver<AndroidElement>  driver){
        this.driver = driver;
        helpToLogInPage = new POayudaLoginPagina(driver);
        loginPage = new POiniciarSesionPagina(driver);
        preguntasSeguridad = new POpreguntaSeguridadLogica(driver);
        keyCardLogic = new POtarjetaDeClaveLogica(driver);
    }

    public static POayudaLoginLogica getInstance(AndroidDriver<AndroidElement>  driver){
        return new POayudaLoginLogica(driver);
    }

    /**
     * Método para validar que se muestre la pagina de ayuda para iniciar sesion
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateHelpToLogInLogic(){
        loginPage.carousel();
        loginPage.goToLoginCarousel(false,false);
        loginPage.goToLoginPage(true,false);
        loginPage.btnX(false,false);
        helpToLogInPage.goToHelpLogin(true,false);
       return helpToLogInPage.validateHelpToLogInPage(true,true);
    }

    public void changeKeyCurrent(){
        helpToLogInPage.validateMessageKey(true,true);
        helpToLogInPage.completeKey(true,false);
        helpToLogInPage.goToContinue(true,false);
        preguntasSeguridad.completeSecurityQuestion(false);

    }

    public void changeKeyCurrent2(){
        helpToLogInPage.validateMessageKey(true,true);
        helpToLogInPage.completeKey(true,false);
        helpToLogInPage.goToContinue(true,false);
        loginPage.validateDashboardPage(true,true);
    }

    /**
     * Método para validar que se muestre el mensaje de confirmacion
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean restoreUser(Boolean report, Boolean takeScreenShot){
        loginPage.carousel();
        loginPage.goToLoginCarousel(report,takeScreenShot);
        loginPage.goToLoginPage(report,takeScreenShot);
        loginPage.btnX(false,false);

        helpToLogInPage.goToHelpLogin(true,false);
        helpToLogInPage.validateHelpToLogInPage(true,true);
        helpToLogInPage.completeDocumentIdentity(report,takeScreenShot);

        preguntasSeguridad.completeSecurityQuestion(false);
        changeKeyCurrent2();
        keyCardLogic.completeKeyTC();

        return helpToLogInPage.validateMessageKey(true,true);
    }

    /**
     * Método para validar que se muestre el mensaje de confirmacion
     *
     * @params String, String, Boolean
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean validateMessage(){
        return helpToLogInPage.validateMessageConfirmed(true,true);
    }

}
