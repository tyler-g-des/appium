package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.helptologin.POayudaLoginLogica;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.login.contact.POcontactosLogica;


public class TEiniciarSesion extends BaseTestAppium {

    @Test(description = "Login")
    public void login(){Assert.assertTrue(POiniciarSesionLogica.getInstance(getDriver()).login("03102674383","1111",false,true,true));}

    //@Test(description = "Recordar Usuario")
    public void rememberLoginUser(){Assert.assertTrue(POiniciarSesionLogica.getInstance(getDriver()).rememberUser());}

    //@Test(description = "Login fallido")
    public void failureLogin(){Assert.assertTrue(POiniciarSesionLogica.getInstance(getDriver()).failureLogin("00111435384","1112"));}

    //@Test(description = "Validar pagina ayuda")
    public void validateHelpLogin(){Assert.assertTrue(POayudaLoginLogica.getInstance(getDriver()).validateHelpToLogInLogic());}

    //@Test(description = "Validar opciones de inicio de sesion")
    public void validateHomeScreenOptions(){Assert.assertTrue(POiniciarSesionLogica.getInstance(getDriver()).validateHomeScreenOptions());}

    //@Test(description = "Restaurar clave usuario")
    public void restoreUser(){Assert.assertTrue(POayudaLoginLogica.getInstance(getDriver()).restoreUser(true,false));}

    //@Test(description = "Validar carta de derechos y deberes")
    public void validateRightsAndDuties(){Assert.assertTrue(POiniciarSesionLogica.getInstance(getDriver()).validateRightsAndDutiesPage());}

    //@Test(description = "LLamar al centro de contactos")
    public void validateCallContactCenter(){Assert.assertTrue(POcontactosLogica.getInstance(getDriver()).callTheContactCenter());}

   // @Test(description = "LLamar al centro de contactos desde el exterior sin cargos")
    public void validateCallFromInsideWithout(){Assert.assertTrue(POcontactosLogica.getInstance(getDriver()).callFromInsideWithoutCharges());}

    //@Test(description = "Validar contrato termino y condiciones")
    public void validateTermsConditions(){Assert.assertTrue(POiniciarSesionLogica.getInstance(getDriver()).validateContract("22400116673","1111"));}

    //@Test(description = "Acceptar contracto termino y condiciones",dependsOnMethods = {"validateTermsConditions"})
    public void contractAcceptTermAndConditions(){Assert.assertTrue(POiniciarSesionLogica.getInstance(getDriver()).acceptTermAndConditions("22400116673","1111"));}

}
