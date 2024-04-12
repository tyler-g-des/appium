package MBP;

import controladorlocal.BaseTestAppium;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.mbp.transaction.paymenservice.POpaymentServiceLogic;

public class TEpagoServicio extends BaseTestAppium {
//00107127367
    //@Test(description = "Validar pagina del pago de servicio")
    public void paymentServicePage(){Assert.assertTrue(POpaymentServiceLogic.getInstance(getDriver()).validatePagePaymentServicePage("03102674383","1111"));}

    //@Test(description = "Agregar nuevo servicio CC")
    public void addNewServiceCC(){Assert.assertTrue(POpaymentServiceLogic.getInstance(getDriver()).addNewService());}

    //@Test(description = "Agregar nuevo servicio CA")
    public void addNewServiceCA(){Assert.assertTrue(POpaymentServiceLogic.getInstance(getDriver()).addNewService());}

    //@Test(description = "Pago de servicio CAASD CC RD")
    public void payServiceRegisteredCC(){Assert.assertTrue(POpaymentServiceLogic.getInstance(getDriver()).payServiceRegistered());}

    //@Test(description = "Pago de servicio CAASD CA RD")
    public void payServiceRegisteredCA(){Assert.assertTrue(POpaymentServiceLogic.getInstance(getDriver()).payServiceRegistered());}

    @Test(description = "Pago de recarga CA RD")
    public void payServiceRegisteredCACA(){Assert.assertTrue(POpaymentServiceLogic.getInstance(getDriver()).payServiceRegistered());}
}
