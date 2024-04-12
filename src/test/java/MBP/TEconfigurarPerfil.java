package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.dashboard.POdashboardLogica;
import page.mbp.dashboard.accesssetting.POconfiguracionAccesoLogica;
import page.mbp.dashboard.securityconfiguration.POconfiguracionSeguridadLogica;

public class TEconfigurarPerfil extends BaseTestAppium {

    @Test(description = "Cambiar metodo de seguridad")
    public void changePassword(){Assert.assertTrue(POconfiguracionAccesoLogica.getInstance(getDriver()).changePassword("00111435384","1111"));}

    //@Test(description = "Cambiar preguntas de seguridad")
    public void changeSecurityQuestion(){
        Assert.assertTrue(POconfiguracionSeguridadLogica.getInstance(getDriver()).changeSecurityQuestion("00111435384","1111"));
    }

    //@Test(description = "Cambio de clave")
    public void changeKey(){
        Assert.assertTrue(POconfiguracionSeguridadLogica.getInstance(getDriver()).changeKeyAccess("00111435384","1111"));
    }

    //@Test(description = "Desahabilitar Tarjeta de clave en transacciones propias")
    public void disabledTDCandTransactionOwn(){
        Assert.assertTrue(POconfiguracionSeguridadLogica.getInstance(getDriver()).disabledTDCandTrasactionOwn("00111435384","1111"));
    }
}
