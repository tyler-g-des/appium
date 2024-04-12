package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.dashboard.POdashboardLogica;
import page.mbp.dashboard.detailsproduct.POdetailProductLogica;
import page.mbp.dashboard.editsummary.POeditarResumenLogica;

public class TEdashboard extends BaseTestAppium {

    @Test(description = "Validar mensaje descargar tarjeta de clave")
    public void validateMessageTC(){
        Assert.assertTrue(POdashboardLogica.getInstance(getDriver()).validateMessageTC("00111435384","1111"));
    }

    @Test(description = "Validar tasa de divisas")
    public void validateCurrencyExchange(){
        Assert.assertTrue(POdashboardLogica.getInstance(getDriver()).validateCurrencyExchange("00111435384","1111"));
    }


    //DETALLE DE PRODUCTO
    @Test(description = "Validar detalle CC")
    public void validateDetailCC(){
        Assert.assertTrue(POdetailProductLogica.getInstance(getDriver()).validateProductDetail("00107127367","1111","CUENTAS","0042","Corriente","RD"));
    }
    @Test(description = "Validar detalle CA RD")
    public void validateDetailCA_RD(){
        Assert.assertTrue(POdetailProductLogica.getInstance(getDriver()).validateProductDetail("00111435384","1111","CUENTAS","0014","Ahorro","RD"));
    }
    @Test(description = "Validar detalle CA US")
    public void validateDetailCA_US(){
        Assert.assertTrue(POdetailProductLogica.getInstance(getDriver()).validateProductDetail("00107127367","1111","CUENTAS","0026","Ahorro","US"));
    }
    @Test(description = "Validar detalle CA EU")
    public void validateDetailCA_EU(){
        Assert.assertTrue(POdetailProductLogica.getInstance(getDriver()).validateProductDetail("00107127367","1111","CUENTAS","0034","Ahorro","EU"));
    }
    //@Test(description = "Validar detalle PR")
    public void validateDetailPR(){
        Assert.assertTrue(POdetailProductLogica.getInstance(getDriver()).validateProductDetail("00111435384","1111","PRÉSTAMOS","8239","Ahorro","RD"));
    }

    //Alias
    @Test(description = "Modificar Alias - Resumen de Producto CC-RD")
    public void modifyProductAliasCC(){
        Assert.assertTrue(POeditarResumenLogica.getInstance(getDriver()).validateEditSummaryPage("00107127367","1111","Cuentas","0042"));
    }
    @Test(description = "Modificar Alias - Resumen de Producto CA-RD")
    public void modifyProductAliasCARD(){
        Assert.assertTrue(POeditarResumenLogica.getInstance(getDriver()).validateEditSummaryPage("00111435384","1111","Cuentas","0057"));
    }
    @Test(description = "Modificar Alias - Resumen de Producto CA-US")
    public void modifyProductAliasCAUS(){
        Assert.assertTrue(POeditarResumenLogica.getInstance(getDriver()).validateEditSummaryPage("00111435384","1111","Cuentas","0031"));
    }
    @Test(description = "Modificar Alias - Resumen de Producto CA-EU")
    public void modifyProductAliasCAEU(){
        Assert.assertTrue(POeditarResumenLogica.getInstance(getDriver()).validateEditSummaryPage("00107127367","1111","Cuentas","0034"));
    }
    @Test(description = "Modificar Alias - Resumen de Producto Certificado Inversion")
    public void modifyProductAliasInvestmentFundCertificate(){
        Assert.assertTrue(POeditarResumenLogica.getInstance(getDriver()).validateEditSummaryPage("00111435384","1111","Certificados","8664"));
    }
    @Test(description = "Modificar Alias - Resumen de Producto préstamo finaciamientos")
    public void modifyProductAliasLoan(){
        Assert.assertTrue(POeditarResumenLogica.getInstance(getDriver()).validateEditSummaryPage("00111435384","1111","Préstamos","7681"));
    }
    @Test(description = "Modificar Alias - Resumen de Producto TC personal")
    public void modifyProductAliasTC(){
        Assert.assertTrue(POeditarResumenLogica.getInstance(getDriver()).validateEditSummaryPage("00111435384","1111","Tarjetas","2608"));
    }
    
}
