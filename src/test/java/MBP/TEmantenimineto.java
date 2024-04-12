package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.dashboard.transaction.registeredbeneficiarypage.PObeneficiaryLogic;

public class TEmantenimineto extends BaseTestAppium {

    @Test(description = "Validar pagina de mantenimiento")
    public void validateBeneficiaryPage(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).validateBeneficiaryPage()); }


    @Test(description = "Agregar beneficiario BHD Cuenta CA-RD")
    public void addBeneficiaryBHD_CARD(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("BHD","01289910057","BHD","Ahorro")); }
    @Test(description = "Agregar beneficiario BHD Cuenta CC-RD")
    public void addBeneficiaryBHD_CCRD(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("BHD","01289910022","BHD","Corriente")); }
    @Test(description = "Agregar beneficiario BHD Cuenta CA-US")
    public void addBeneficiaryBHD_CAUS(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("BHD","01891170013","BHD", "Ahorro")); }
    @Test(description = "Agregar beneficiario BHD Cuenta CA-EU")
    public void addBeneficiaryBHD_CAEU(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("BHD","01891170064","BHD","Ahorro")); }
    @Test(description = "Agregar beneficiario BHD Super Cuenta RD")
    public void addBeneficiaryBHD_SCA(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("BHD","06810100034","BHD","Ahorro")); }
    @Test(description = "Agregar beneficiario BHD TC")
    public void addBeneficiaryBHD_TC(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("BHD","4517009975186916","BHD","Tarjetas")); }
    @Test(description = "Agregar beneficiario BHD Prestamo")
    public void addBeneficiaryBHD_PR(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("BHD","3695297","BHD","Pr")); }


    @Test(description = "Agregar beneficiario Otro banco Cuenta de Ahorro")
    public void addBeneficiaryOtherBankCA_RD(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("Otros Bancos","5429075452708799","APAP","Ahorro")); }
    @Test(description = "Agregar beneficiario Otro banco Cuenta Corriente")
    public void addBeneficiaryOtherBankCC_RD(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("Otros Bancos","5429075452708799","APAP","Corriente")); }
    @Test(description = "Agregar beneficiario Otro banco Tarjeta de Credito")
    public void addBeneficiaryOtherBankTC_RD(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("Otros Bancos","4517009975186916","APAP","Tarjetas")); }
    @Test(description = "Agregar beneficiario Otro banco Prestamo")
    public void addBeneficiaryOtherBankPR_RD(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("Otros Bancos","5429075452708799","APAP","Pr")); }


    @Test(description = "Ver detalle de beneficiario registrado")
    public void seeBeneficiaryDetail(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).seeBeneficiary("5513634")); }
    @Test(description = "Ver detalle de beneficiario registrado TC")
    public void seeBeneficiaryDetailTC(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).seeBeneficiary("4517004464601673")); }
    @Test(description = "Ver detalle de beneficiario registrado PR")
    public void seeBeneficiaryDetailPR(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).seeBeneficiary("4517004464601673")); }


    @Test(description = "Eliminar beneficiario")
    public void deleteBeneficiaryDetailPR(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).deleteBeneficiary("6130698")); }


    @Test(description = "Pin Pesos")
    public void addBeneficiaryPinPesos(){ Assert.assertTrue(PObeneficiaryLogic.getInstance(getDriver()).addNewBeneficiary("Pin Pesos","8095551010","Pin Pesos","Pin Pesos")); }
}
