package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.transaction.tothirds.POtercerosLogica;

public class TEtransferenciaTerceros extends BaseTestAppium {

    // REGISTRADO BHD
    @Test(description = "Transferencia a terceros BHD, beneficiario inscritos CA RD -- CA RD")
    public void transferToRegisteredThirdPartiesBHD_CAR_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToRegisteredThirdPartiesBHD("00108644469","1111","0015","0075","Banco BHD"));
    }
    //@Test(description = "Transferencia a terceros BHD, beneficiario inscritos CA RD -- CC RD")
    public void transferToRegisteredThirdPartiesBHD_CARD_CCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0014","Banco BHD"));
    }
    //@Test(description = "Transferencia a terceros BHD, beneficiario inscritos CA US -- CA RD")
    public void transferToRegisteredThirdPartiesBHD_CAUS_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToRegisteredThirdPartiesBHD("00111435384","1111","0031","0022","Banco BHD"));
    }
    //@Test(description = "Transferencia a terceros BHD, beneficiario inscritos CA US -- CA US")
    public void transferToRegisteredThirdPartiesBHD_CAUS_CAUS() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToRegisteredThirdPartiesBHD("00111435384","1111","0031","0015","Banco BHD"));
    }
    //@Test(description = "Transferencia a terceros BHD, beneficiario inscritos CC RD -- CC RD")
    public void transferToRegisteredThirdPartiesBHD_CCRD_CCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToRegisteredThirdPartiesBHD("00107127367","1111","0042","0024","Banco BHD"));
    }
    //@Test(description = "Transferencia a terceros BHD, beneficiario inscritos CC RD -- CA RD")
    public void transferToRegisteredThirdPartiesBHD_CCRD_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToRegisteredThirdPartiesBHD("00107127367","1111","0042","0059","Banco BHD"));
    }


    // ---- TERCERO INCRITO FUERA DEL BHD
    //ACH
    @Test(description = "Transferencia a terceros fuera del BHD, beneficiario inscritos CA RD -- CA RD ACH")
    public void transferToThirdRegisteredBeneficiaryOutsideBHDCARD_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00108644469","1111","0015","0042","BANESCO","ACH"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD, beneficiario inscritos CA RD -- CC RD ACH")
    public void transferToThirdRegisteredBeneficiaryOutsideBHDCARD_CCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","ACH"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD, beneficiario inscritos CC RD -- CC RD ACH")
    public void transferToThirdRegisteredBeneficiaryOutsideBHDCCRD_CCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","ACH"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD, beneficiario inscritos CC RD -- CC RD ACH")
    public void transferToThirdRegisteredBeneficiaryOutsideBHDCCRD_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","ACH"));
    }


    //---- TERCERO INCRITO FUERA DEL BHD
    //BCRD
    @Test(description = "Transferencia a terceros fuera del BHD, beneficiario inscritos CA RD -- CA RD BCRD")
    public void transferToThirdRegisteredBeneficiaryOutsideBHD_CARD_CARD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00108644469","1111","0015","0042","BANESCO","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD, beneficiario inscritos CA RD -- CC RD ACH BCRD")
    public void transferToThirdRegisteredBeneficiaryOutsideBHD_CARD_CCRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD, beneficiario inscritos CC RD -- CC RD ACH BCRD")
    public void transferToThirdRegisteredBeneficiaryOutsideBHD_CCRD_CCRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD, beneficiario inscritos CC RD -- CC RD ACH BCRD")
    public void transferToThirdRegisteredBeneficiaryOutsideBHD_CCRD_CARD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }


    //TERCERO NUEVO BENEFICIARIO FUERA DE BHD
    //UMMMMMMM
    @Test(description = "Transferencia a terceros fuera del BHD no Inscrito ACH CA RD -- CA RD")
    public void transferToNewBeneficiaryOutsideBHD_CARD_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00108644469","1111","0015","BANCO MULTIPLE ADEMI, S.A.","Ahorro","12121212121","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD no Inscrito ACH CA RD -- CC RD")
    public void transferToNewBeneficiaryOutsideBHD_CARD_CCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Ahorro","1234567891","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD no Inscrito ACH CC -- CC")
    public void transferToNewBeneficiaryOutsideBHD_CCRD_CCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Corrientes","1234567891","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD no Inscrito ACH CC -- CA RD")
    public void transferToNewBeneficiaryOutsideBHD_CC_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Ahorro","12121212121","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD no Inscrito ACH CA RD -- TC RD")
    public void transferToNewBeneficiaryOutsideBHD_CARD_TCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","9045435940354322","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD no Inscrito ACH CC -- TC RD")
    public void transferToNewBeneficiaryOutsideBHD_CC_TCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","9045435940354322","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD no Inscrito ACH CA RD -- PR")
    public void transferToNewBeneficiaryOutsideBHD_CARD_PRRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","8643223","BCRD"));
    }
    //@Test(description = "Transferencia a terceros fuera del BHD no Inscrito ACH CC -- PR")
    public void transferToNewBeneficiaryOutsideBHD_CC_PRRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","8643223","BCRD"));
    }


    // --- TERCERO NUEVO BENEFICIARIO BHD
    @Test(description = "Transferencia a terceros dentro del BHD, nuevo beneficiario CA RD -- CA RD")
    public void transferToThirdNewBeneficiaryBHD_CARD_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Transferencia a terceros dentro del BHD, nuevo beneficiario CA RD -- CC RD")
    public void transferToThirdNewBeneficiaryBHD_CARD_CCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","03186440021"));
    }
    //@Test(description = "Transferencia a terceros dentro del BHD, nuevo beneficiario CA US -- CA US")
    public void transferToThirdNewBeneficiaryBHD_CAUS_CAUS() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","01507570026"));
    }
    //@Test(description = "Transferencia a terceros dentro del BHD, nuevo beneficiario CC -- CC")
    public void transferToThirdNewBeneficiaryBHD_CCRD_CCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","03186440021"));
    }
    //@Test(description = "Transferencia a terceros dentro del BHD, nuevo beneficiario CC RD -- CA RD")
    public void transferToThirdNewBeneficiaryBHD_CCRD_CARD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }

    //-----------------------------------------PRESTAMOS
    //Registrado BHD
    @Test(description = "Pago prestamos terceros BHD, beneficiario inscritos CA RD -- PR RD")
    public void loadPaymentToRegisteredThirdPartiesBHD_CARD_PRRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00108644469","1111","0015","5557","Banco BHD"));
    }
    //@Test(description = "Pago prestamos terceros BHD, beneficiario inscritos CA US -- PR US")
    public void loadPaymentToRegisteredThirdPartiesBHD_CARD_PRUS() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0022","Banco BHD"));
    }
    //@Test(description = "Pago prestamos terceros BHD, beneficiario inscritos CA US -- PR US")
    public void loadPaymentToRegisteredThirdPartiesBHD_CAUS_PRUS() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0022","Banco BHD"));
    }
    //@Test(description = "Pago prestamos terceros BHD, beneficiario inscritos CA RD -- PR RD")
    public void loadPaymentToRegisteredThirdPartiesBHD_CARD_PRR() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0022","Banco BHD"));
    }
    //@Test(description = "Pago prestamos terceros BHD, beneficiario inscritos CC RD -- PR RD")
    public void loadPaymentToRegisteredThirdPartiesBHD_CCRD_PRR() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0022","Banco BHD"));
    }

    //NUEVO BENEFICIARIO BHD
    @Test(description = "Pago prestamos terceros dentro del BHD, nuevo beneficiario CA RD -- PR RD")
    public void loadPaymentToThirdNewBeneficiaryBHD_CARD_PRRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Pago prestamos terceros dentro del BHD, nuevo beneficiario CA US -- PR US")
    public void loadPaymentToThirdNewBeneficiaryBHD_CAUS_PRUS() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Pago prestamos terceros dentro del BHD, nuevo beneficiario CA RD -- PR RD")
    public void loadPaymentToThirdNewBeneficiaryBHD_CAR_PRRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Pago prestamos terceros dentro del BHD, nuevo beneficiario CA RD -- PR RD")
    public void loadPaymentToThirdNewBeneficiaryBHD_CARD_PRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Pago prestamos terceros dentro del BHD, nuevo beneficiario CA US -- PR US")
    public void loadPaymentToThirdNewBeneficiaryBHD_CAUS_PRU() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }

    //Registrado fuera del BHD ACH - BCRD
    @Test(description = "Pago prestamos terceros fuera del BHD, beneficiario inscritos CA RD -- PR RD ACH")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CARD_PRRD_ACH() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00108644469","1111","0014","0545","BANESCO","ACH"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD, beneficiario inscritos CC RD -- PR RD ACH")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CCRD_PRRD_ACH() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","ACH"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD, beneficiario inscritos CA RD -- PR RD BCRD")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CARD_PRRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD, beneficiario inscritos CC RD -- PR RD ACH")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CCRD_PRRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD, beneficiario inscritos CA US -- PR RD BCRD")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CAUS_PRRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD, beneficiario inscritos CA US -- PR US BCRD")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CAUS_PRUS_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD, beneficiario inscritos CC RD -- PR US BCRD")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CCUS_PRUS_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }

    //NUEVO BENEFICIARIO FUERA DEL BHD
    @Test(description = "Pago prestamos terceros fuera del BHD no Inscrito CA RD -- PR RD ACH")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CARD_PRRD_ACH() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","12121212121","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD no Inscrito CC RD -- PR RD ACH")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CCRD_PRRD_ACH() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","12121212121","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD no Inscrito CA RD -- PR RD BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CARD_PRRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","12121212121","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD no Inscrito CC RD -- PR RD BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CCRD_PRRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","12121212121","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD no Inscrito CA EU -- PR EU BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CAEU_PREU_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","12121212121","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD no Inscrito CA US -- PR RD BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CAUS_PRRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","12121212121","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD no Inscrito CA US -- PR US BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CAUS_PRUS_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","12121212121","BCRD"));
    }
    //@Test(description = "Pago prestamos terceros fuera del BHD no Inscrito CC RD -- PR US BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CCRD_PRUS_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Préstamos","12121212121","BCRD"));
    }

    //-----------------------------------------TC
    //Registrado BHD
    @Test(description = "Pago TCestamos terceros BHD, beneficiario inscritos CA RD -- TC RD")
    public void loadPaymentToRegisteredThirdPartiesBHD_CARD_TCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00108644469","1111","0015","9602","Banco BHD"));
    }
    //@Test(description = "Pago TCestamos terceros BHD, beneficiario inscritos CA US -- TC US")
    public void loadPaymentToRegisteredThirdPartiesBHD_CARD_TCUS() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0022","Banco BHD"));
    }
    //@Test(description = "Pago TCestamos terceros BHD, beneficiario inscritos CA US -- TC US")
    public void loadPaymentToRegisteredThirdPartiesBHD_CAUS_TCUS() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0022","Banco BHD"));
    }
    //@Test(description = "Pago TCestamos terceros BHD, beneficiario inscritos CA RD -- TC RD")
    public void loadPaymentToRegisteredThirdPartiesBHD_CARD_TCR() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0022","Banco BHD"));
    }
    //@Test(description = "Pago TCestamos terceros BHD, beneficiario inscritos CC RD -- TC RD")
    public void loadPaymentToRegisteredThirdPartiesBHD_CCRD_TCR() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToRegisteredThirdPartiesBHD("00111435384","1111","0014","0022","Banco BHD"));
    }

    //NUEVO BENEFICIARIO BHD
    @Test(description = "Pago TCestamos terceros dentro del BHD, nuevo beneficiario CA RD -- TC RD")
    public void loadPaymentToThirdNewBeneficiaryBHD_CARD_TCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Pago TCestamos terceros dentro del BHD, nuevo beneficiario CA US -- TC US")
    public void loadPaymentToThirdNewBeneficiaryBHD_CAUS_TCUS() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Pago TCestamos terceros dentro del BHD, nuevo beneficiario CA RD -- TC RD")
    public void loadPaymentToThirdNewBeneficiaryBHD_CAR_TCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Pago TCestamos terceros dentro del BHD, nuevo beneficiario CA RD -- TC RD")
    public void loadPaymentToThirdNewBeneficiaryBHD_CARD_TCD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }
    //@Test(description = "Pago TCestamos terceros dentro del BHD, nuevo beneficiario CA US -- TC US")
    public void loadPaymentToThirdNewBeneficiaryBHD_CAUS_TCU() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver()).transferToThirdNewBeneficiaryBHD("00111435384","1111","0014","09090040020"));
    }

    //Registrado fuera del BHD ACH - BCRD
    @Test(description = "Pago TCestamos terceros fuera del BHD, beneficiario inscritos CA RD -- TC RD ACH")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CARD_TCRD_ACH() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00108644469","1111","0015","0183","Promerica","ACH"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD, beneficiario inscritos CC RD -- TC RD ACH")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CCRD_TCRD_ACH() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","ACH"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD, beneficiario inscritos CA RD -- TC RD BCRD")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CARD_TCRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD, beneficiario inscritos CC RD -- TC RD ACH")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CCRD_TCRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD, beneficiario inscritos CA US -- TC RD BCRD")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CAUS_TCRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD, beneficiario inscritos CA US -- TC US BCRD")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CAUS_TCUS_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD, beneficiario inscritos CC RD -- TC US BCRD")
    public void loadPaymentToThirdRegisteredBeneficiaryOutsideBHD_CCUS_TCUS_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredBeneficiaryOutsideBHD("00111435384","1111","0014","6786","ADEMI","BCRD"));
    }

    //NUEVO BENEFICIARIO FUERA DEL BHD
    @Test(description = "Pago TCestamos terceros fuera del BHD no Inscrito CA RD -- TC RD ACH")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CARD_TCRD_ACH() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","12121212121","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD no Inscrito CC RD -- TC RD ACH")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CCRD_TCRD_ACH() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","12121212121","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD no Inscrito CA RD -- TC RD BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CARD_TCRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","12121212121","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD no Inscrito CC RD -- TC RD BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CCRD_TCRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","12121212121","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD no Inscrito CA EU -- TC EU BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CAEU_TCEU_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","12121212121","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD no Inscrito CA US -- TC RD BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CAUS_TCRD_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","12121212121","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD no Inscrito CA US -- TC US BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CAUS_TCUS_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","12121212121","BCRD"));
    }
    //@Test(description = "Pago TCestamos terceros fuera del BHD no Inscrito CC RD -- TC US BCRD")
    public void loadPaymentToNewBeneficiaryOutsideBHD_CCRD_TCUS_BCRD() {
        Assert.assertTrue(POtercerosLogica.getInstance(getDriver())
                .transferToThirdRegisteredNewBeneficiaryOutsideBHD("00111435384","1111","0014","BANCO MULTIPLE ADEMI, S.A.","Tarjetas","12121212121","BCRD"));
    }
}
