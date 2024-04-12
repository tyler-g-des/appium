package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.transaction.pinpesos.POpinPesosLogica;

public class TEpinPesos extends BaseTestAppium {

    @Test(description = "Pin Pesos Beneficiario inscrito, desde la lista de beneficiarios")
    public void enrolledBeneficiarySelectContact(){
        Assert.assertTrue(POpinPesosLogica.getInstance(getDriver()).enrolledBeneficiarySelectContact("00111435384","1111","100"));
    }
    @Test(description = "Pin Pesos nuevo Beneficiario numero de telefono")
    public void newBeneficiaryMobileNumber() {POpinPesosLogica.getInstance(getDriver()).newBeneficiaryMobileNumber("00111435384","1111","100");}

    @Test(description = "Pin Pesos formulario incompleto")
    public void missingNameBeneficiary() {POpinPesosLogica.getInstance(getDriver()).missingNameAndBeneficiary("00111435384","1111");}

    @Test(description = "Pin Pesos formulario incompleto")
    public void missingNameBeneficiaryw() {POpinPesosLogica.getInstance(getDriver()).missingNameAndBeneficiary("00111435384","1111");}
}
