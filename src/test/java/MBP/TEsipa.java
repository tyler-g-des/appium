package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.sipatransfer.POsipaLogica;

public class TEsipa extends BaseTestAppium {

    @Test(description = "Validar pagina SIPA")
    public void validatePageSIPA() {
        Assert.assertTrue(POsipaLogica.getInstance(getDriver()).validatePageSIPA());
    }

    @Test(description = "Pagar nuevo beneficiario SIPA")
    public void transfer() {
        Assert.assertTrue(POsipaLogica.getInstance(getDriver()).paymentInternationalCAUS_CAUS());
    }
}
