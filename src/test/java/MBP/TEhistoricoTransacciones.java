package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.dashboard.transaction.historicaltransactions.POhistoricalLogic;

public class TEhistoricoTransacciones extends BaseTestAppium {

    @Test(description = "Validar pagina historico de transacciones")
    public void validateHistoricalPage(){Assert.assertTrue(POhistoricalLogic.getInstance(getDriver()).validateHistoricalPage());}

    @Test(description = "Validar resumen historial COMPLETADO")
    public void validateTransactionComplete(){Assert.assertTrue(POhistoricalLogic.getInstance(getDriver()).validateSummaryHistorical("COMPLETADO"));}

    @Test(description = "Validar resumen historial SOMETIDO")
    public void validateTransactionSubjected(){Assert.assertTrue(POhistoricalLogic.getInstance(getDriver()).validateSummaryHistorical("SOMETIDO"));}

    @Test(description = "Validar resumen historial RECHAZADO")
    public void validateTransactionRefused(){Assert.assertTrue(POhistoricalLogic.getInstance(getDriver()).validateSummaryHistorical("RECHAZADO"));}


    //INTERNATIONAL
    @Test(description = "Validar pagina historico de transacciones internacionales")
    public void validateHistoricalInternationalPage(){Assert.assertTrue(POhistoricalLogic.getInstance(getDriver()).validateHistoricalInternationalPage());}
    @Test(description = "Validar resumen historial SOMETIDO internacional")
    public void validateTransactionInternationalSubjected(){Assert.assertTrue(POhistoricalLogic.getInstance(getDriver()).validateSummaryHistoricalInternational("SOMETIDO"));}
}
