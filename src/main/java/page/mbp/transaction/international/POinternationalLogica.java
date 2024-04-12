package page.mbp.transaction.international;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.dashboard.transaction.POtransactionLogic;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.transactionconfirm.POconfirmarTransaccionLogica;

public class POinternationalLogica {

    AndroidDriver<AndroidElement> driver;
    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPagina;
    POtransactionLogic trasaccionLogica;
    POinternationalPagina internationalPage;

    POconfirmarTransaccionLogica confirmTransaction;

    public POinternationalLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPagina = new POdashboardPagina(driver);
        trasaccionLogica = new POtransactionLogic(driver);
        internationalPage = new POinternationalPagina(driver);
        confirmTransaction = new POconfirmarTransaccionLogica(driver);
    }

    public static POinternationalLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POinternationalLogica(driver);
    }

    public boolean paymentInternationalAccount(String user, String pass, String accountOrigin, String accountDestiny, String currencyOrigin, String currencyDestiny){
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionLogica.validateModule();
        trasaccionLogica.goToInternational();

        internationalPage.validateTransactionInternationalPage(true,true);
        internationalPage.selectAccountOrigin(accountOrigin,true,false);
        internationalPage.validateTransactionDestiny(true,true);
        internationalPage.goToDestiny(true,false);
        internationalPage.validateProductDestiny(true,true);
        internationalPage.selectAccountDestiny(accountDestiny,true,false);
        internationalPage.completeFormInternational("10",currencyOrigin,currencyDestiny,true,true);
        internationalPage.goToContinue(true,false);

        return confirmTransaction.validateSummaryPage();
    }
}
