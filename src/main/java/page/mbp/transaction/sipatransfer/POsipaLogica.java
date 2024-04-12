package page.mbp.transaction.sipatransfer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.dashboard.transaction.POtransactionLogic;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.transactionconfirm.POconfirmarTransaccionLogica;
import page.mbp.transaction.transactionconfirm.POconfirmarTransaccionPagina;
import page.mbp.transaction.transactionsummary.POresumenTransaccionLogica;

public class POsipaLogica {

    AndroidDriver<AndroidElement> driver;
    POiniciarSesionLogica iniciarSesionLogica;
    POdashboardPagina dashboardPagina;
    POtransactionLogic trasaccionPagina;
    POsipaPagina sipaPage;
    POconfirmarTransaccionLogica confirmTransaction;
    POresumenTransaccionLogica resumTransaction;

    public POsipaLogica(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        iniciarSesionLogica = new POiniciarSesionLogica(driver);
        dashboardPagina = new POdashboardPagina(driver);
        trasaccionPagina = new POtransactionLogic(driver);
        sipaPage = new POsipaPagina(driver);
        confirmTransaction = new POconfirmarTransaccionLogica(driver);
        resumTransaction = new POresumenTransaccionLogica(driver);
    }

    public static POsipaLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POsipaLogica(driver);
    }

    public boolean validatePageSIPA(){
        iniciarSesionLogica.login("00107127367","1111",false,false,false);

        dashboardPagina.goToTransaction(true,false);

        trasaccionPagina.validatePageTransaction();
        trasaccionPagina.validateModule();
        trasaccionPagina.goToSIPA();

        return sipaPage.validateSipaPage(true,true);
    }

    public boolean paymentInternationalCAUS_CAUS(){
        //00107127367
        iniciarSesionLogica.login("00111435384","1111",false,false,false);

        dashboardPagina.goToTransaction(true,false);

        trasaccionPagina.validatePageTransaction();
        trasaccionPagina.validateModule();
        trasaccionPagina.goToSIPA();

        //0026
        sipaPage.validateSipaPage(true,true);
        sipaPage.selectAccount("0031",true,true);
        sipaPage.validateForm(true,true);
        sipaPage.completeFormSIPA(true,true);
        sipaPage.goToContinue(true,false);

        return confirmTransaction.validateSummaryPage();
    }
}
