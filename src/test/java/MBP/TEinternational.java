package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.transaction.international.POinternationalLogica;

public class TEinternational extends BaseTestAppium {
    @Test(description = "Transferencia a transacciones Internacionales CA RD - CA US")
    public void paymentInternationalCARD_CAUS() {
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0018","8567","RD","US"));}

    @Test(description = "Transferencia a transacciones Internacionales CC - CA US")
    public void paymentInternationalCC_CAUS(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0018","8567","RD","US"));}

    @Test(description = "Transferencia a transacciones Internacionales CA RD - CA EU")
    public void paymentInternationalCARD_CAEU(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0018","3444","RD","EU"));}

    @Test(description = "Transferencia a transacciones Internacionales CC - CA EU")
    public void paymentInternationalCC_CAEU(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0018","3444","RD","EU"));}

    @Test(description = "Transferencia a transacciones Internacionales CA US - CA US")
    public void paymentInternationalCAUS_CAUS(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0026","5678","US","US"));}

    @Test(description = "Transferencia a transacciones Internacionales CA EU - CA EU")
    public void paymentInternationalCAEU_CAEU(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0037","3444","EU","EU"));}

    @Test(description = "Transferencia a transacciones Internacionales CA RD - CA US ABA")
    public void paymentInternationalCARD_CAUS_ABA(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0018","2628","RD","US"));}

    @Test(description = "Transferencia a transacciones Internacionales CC - CA US SWIFT")
    public void paymentInternationalCARD_CAUS_SWIFT(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0018","5678","RD","US"));}

    @Test(description = "Transferencia a transacciones Internacionales CA RD - CA EU ABA")
    public void paymentInternationalCARD_CAEU_ABA(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0018","1546","RD","EU"));}

    @Test(description = "Transferencia a transacciones Internacionales CC - CA EU SWIFT")
    public void paymentInternationalCARD_CAEU_SWIFT(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0018","3444","RD","EU"));}

    @Test(description = "Transferencia a transacciones Internacionales CA US - CA US ABA")
    public void paymentInternationalCAUS_CAUS_ABA(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0026","2628","US","US"));}

    @Test(description = "Transferencia a transacciones Internacionales CA EU - CA EU ABA")
    public void paymentInternationalCAEU_CAUS_ABA(){
        Assert.assertTrue(POinternationalLogica.getInstance(getDriver()).paymentInternationalAccount("00107127367","1111","0037","1546","EU","EU"));}

}
