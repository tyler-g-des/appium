package page.mbp.transaction.owntransaction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.dashboard.transaction.POtransactionLogic;
import page.mbp.keycard.POtarjetaDeClaveLogica;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.tothirds.POtercerosLogica;
import page.mbp.transaction.tothirds.POtercerosPagina;
import page.mbp.transaction.transactionconfirm.POconfirmarTransaccionLogica;
import page.mbp.transaction.transactionsummary.POresumenTransaccionLogica;

public class POpropiaLogica {
    POpropiaPagina pOpropiaPagina;
    POtransactionLogic trasaccionPagina;
    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPagina;
    AndroidDriver<AndroidElement> driver;
    POconfirmarTransaccionLogica confirmTransaction;
    POresumenTransaccionLogica resumenTransaction;
    POtarjetaDeClaveLogica tarjetaDeClaveLogica;

    public POpropiaLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        pOpropiaPagina = new POpropiaPagina(driver);
        trasaccionPagina = new POtransactionLogic(driver);
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPagina = new POdashboardPagina(driver);
        confirmTransaction = new POconfirmarTransaccionLogica(driver);
        resumenTransaction = new POresumenTransaccionLogica(driver);
        tarjetaDeClaveLogica = new POtarjetaDeClaveLogica(driver);
    }
    public static POpropiaLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POpropiaLogica(driver);
    }

    public boolean transferToAccount(String user, String pass, String accountOrigin,String currencyOrigin, String accountDestiny, String currencyDestiny){
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionPagina.validatePageTransaction();
        trasaccionPagina.goToOwn();

        pOpropiaPagina.validateTransactionOwnPage(true,true);
        pOpropiaPagina.selectAccountOrigin(accountOrigin,true,false);
        pOpropiaPagina.validateTransactionDestiny(true,true);
        pOpropiaPagina.goToDestiny(true,false);
        pOpropiaPagina.validateProductDestiny(true,true);
        pOpropiaPagina.selectAccountDestiny(accountDestiny,true,false);
        pOpropiaPagina.validateForm(currencyOrigin,currencyDestiny,true,false);
        pOpropiaPagina.completeFormAccount("100",true,true);
        pOpropiaPagina.goToContinue(true,false);

        confirmTransaction.validateSummaryPage();
        confirmTransaction.goToValidateTransaction();

        tarjetaDeClaveLogica.completeKeyOptional();
        return  resumenTransaction.validateSummaryPage();
    }

    public boolean paymentToLoad(String user, String pass, String accountOrigin, String accountDestiny, String paymentType){
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionPagina.validatePageTransaction();
        trasaccionPagina.goToOwn();

        pOpropiaPagina.validateTransactionOwnPage(true,true);
        pOpropiaPagina.selectAccountOrigin(accountOrigin,true,false);
        pOpropiaPagina.validateTransactionDestiny(true,true);
        pOpropiaPagina.goToDestiny(true,false);
        pOpropiaPagina.validateProductDestiny(true,true);
        pOpropiaPagina.selectAccountDestiny(accountDestiny,true,false);
        pOpropiaPagina.completeFormPayLoan(paymentType,"10",true,false);
        pOpropiaPagina.goToContinueLoad(true,false);

        return confirmTransaction.validateSummaryPage();
    }

    public void salirOwnToTransfer(String account){
        pOpropiaPagina.validateProductOriginSelect(account,true,true);
        pOpropiaPagina.btnBack(true,false);
        pOpropiaPagina.validateMessage(true,true);
        pOpropiaPagina.goToCancel(true,false);
    }
}


