package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.transaction.owntransaction.POpropiaLogica;
import page.mbp.transaction.tothirds.POtercerosLogica;

public class TEtransferenciaPropia extends BaseTestAppium {

    //------------------- CUENTAS AHORRO RD
    @Test(description = "Transferencia a propia  CA RD -- CA RD")
    public void paymentBetweenOwnProductCARD_CARD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }
    @Test(description = "Transferencia a propia  CA RD -- CA US")
    public void paymentBetweenOwnProductCARD_CAUS() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","US"));
    }
    @Test(description = "Transferencia a propia  CA RD -- CA EU")
    public void transferToRegisteredThirdPartiesBHD_CAR_CAEU() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","EU"));
    }
    @Test(description = "Transferencia a propia  CA RD -- CC RD")
    public void paymentBetweenOwnProductCARD_CCRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }
    @Test(description = "Transferencia a propia  CA RD -- Super Cuenta RD")
    public void paymentBetweenOwnProductCARD_SCARD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }
    @Test(description = "Transferencia a propia  CA RD -- Super Cuenta US")
    public void paymentBetweenOwnProductCARD_SCAUS() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","US"));
    }

    //------------------- CUENTAS CORRIENTE
    @Test(description = "Transferencia a propia  CC RD -- CA RD")
    public void paymentBetweenOwnProductCCRD_CARD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }
    @Test(description = "Transferencia a propia  CC RD -- CC RD")
    public void paymentBetweenOwnProductCCRD_CCUS() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }
    @Test(description = "Transferencia a propia  CC RD -- CA EU")
    public void transferToRegisteredThirdPartiesBHD_CCR_CCEU() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","EU"));
    }
    @Test(description = "Transferencia a propia  CC RD -- CA US")
    public void paymentBetweenOwnProductCCRD_CAUS() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }

    //------------------- CUENTAS AHORRO US
    @Test(description = "Transferencia a propia  CA US -- CA RD")
    public void paymentBetweenOwnProductCAUS_CARD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }
    @Test(description = "Transferencia a propia  CA US -- CC RD")
    public void paymentBetweenOwnProductCAUS_CCrd() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","US"));
    }
    @Test(description = "Transferencia a propia  CA US -- CA EU")
    public void transferToRegisteredThirdPartiesBHD_CCUS_CAEU() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","EU"));
    }

    //------------------- CUENTAS AHORRO EU
    @Test(description = "Transferencia a propia  CA EU -- CA RD")
    public void paymentBetweenOwnProductCAEU_CARD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }
    @Test(description = "Transferencia a propia  CA EU -- CC RD")
    public void paymentBetweenOwnProductCAEU_CCrd() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","EU"));
    }

    //------------------- CUENTAS AHORRO SPA
    @Test(description = "Transferencia a propia Super Cuenta CA RD -- CA RD")
    public void paymentBetweenOwnProductSCARD_CARD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","RD"));
    }
    @Test(description = "Transferencia a propia Super Cuenta CA US -- CA US")
    public void paymentBetweenOwnProductSCAUS_CAUS() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .transferToAccount("00111435384","1111","0014","RD","0031","EU"));
    }
    
    
    //------ PAGO DE PRESTAMOS
    @Test(description = "Pago a prestamos CA - Pago cuota pendiente")
    public void paymentLoadCARD_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("02301358343","1111","0026","0563","Cuota pendiente"));
    }
    @Test(description = "Pago a prestamos CA - Reduccion tiempo")
    public void paymentLoadTimeReductionCARD_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("02301358343","1111","0026","5297","Disminucion de monto"));
    }
    @Test(description = "Pago a prestamos CA - Reduccion cuota")
    public void paymentLoadQuotaReductionCARD_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("02301358343","1111","0026","5297","Disminucion de cuotas"));
    }

    /*
    // CC
    @Test(description = "Pago a prestamos CC - Pago cuota pendiente")
    public void paymentLoadCCRD_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("00109129676","1111","0021","6978","Cuota pendiente"));
    }
    @Test(description = "Pago a prestamos CC - Reduccion tiempo")
    public void paymentLoadTimeReductionCCRD_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("00109129676","1111","0021","6978","Disminucion de monto"));
    }

    // CA US
    @Test(description = "Pago a prestamos CA US - Reduccion cuota")
    public void paymentLoadQuotaReductionCAUS_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("00109129676","1111","0021","6978","Disminucion de cuotas"));
    }
    @Test(description = "Pago a prestamos CA US - Pago cuota pendiente")
    public void paymentLoadCAU_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("00108644469","1111","0032","6978","Cuota pendiente"));
    }
    @Test(description = "Pago a prestamos CA US - Reduccion tiempo")
    public void paymentLoadTimeReductionCAU_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("00108644469","1111","0032","6978","Disminucion de monto"));
    }
    @Test(description = "Pago a prestamos CA US - Reduccion cuota")
    public void paymentLoadQuotaReductionCCRD_PRRD() {
        Assert.assertTrue(POpropiaLogica.getInstance(getDriver())
                .paymentToLoad("00108644469","1111","0032","6978","Disminucion de cuotas"));
    }
     */
}
