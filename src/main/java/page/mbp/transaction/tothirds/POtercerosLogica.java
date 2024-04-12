package page.mbp.transaction.tothirds;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.dashboard.transaction.POtransactionLogic;
import page.mbp.keycard.POtarjetaDeClaveLogica;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.transactionconfirm.POconfirmarTransaccionLogica;
import page.mbp.transaction.transactionsummary.POresumenTransaccionLogica;

public class POtercerosLogica {

    POtercerosPagina pOtercerosPagina;
    POtransactionLogic trasaccionPagina;
    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPagina;
    AndroidDriver<AndroidElement> driver;
    POconfirmarTransaccionLogica confirmTransaction;
    POresumenTransaccionLogica resumenTransaction;
    POtarjetaDeClaveLogica tarjetaDeClaveLogica;

    public POtercerosLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        pOtercerosPagina = new POtercerosPagina(driver);
        trasaccionPagina = new POtransactionLogic(driver);
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPagina = new POdashboardPagina(driver);
        confirmTransaction = new POconfirmarTransaccionLogica(driver);
        resumenTransaction = new POresumenTransaccionLogica(driver);
        tarjetaDeClaveLogica = new POtarjetaDeClaveLogica(driver);
    }
    public static POtercerosLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POtercerosLogica(driver);
    }

    public boolean transferToRegisteredThirdPartiesBHD(String user, String pass, String accountOrigin, String accountDestiny, String bank){
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionPagina.validatePageTransaction();
        trasaccionPagina.goToThird();

        pOtercerosPagina.validateTransactionThirdPage(true,true);
        pOtercerosPagina.selectAccountOrigin(accountOrigin,true,false);
        pOtercerosPagina.validateTransactionDestiny(true,true);
        pOtercerosPagina.goToDestiny(true,false);
        pOtercerosPagina.validateProductDestiny(true,true);
        pOtercerosPagina.selectAccountDestiny(bank,accountDestiny,true,false);
        pOtercerosPagina.validateForm(true,true);
        pOtercerosPagina.completeFormAccount("100",true,true);
        pOtercerosPagina.goToContinue(true,false);

        return confirmTransaction.validateSummaryPage();
    }

    public boolean transferToThirdRegisteredBeneficiaryOutsideBHD(String user, String pass, String accountOrigin, String accountDestiny, String bank, String type){
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionPagina.validatePageTransaction();
        trasaccionPagina.goToThird();

        pOtercerosPagina.validateTransactionThirdPage(true,true);
        pOtercerosPagina.selectAccountOrigin(accountOrigin,true,false);
        pOtercerosPagina.validateTransactionDestiny(true,true);
        pOtercerosPagina.goToDestiny(true,false);
        pOtercerosPagina.validateProductDestiny(true,true);
        pOtercerosPagina.selectAccountDestiny(bank,accountDestiny,true,false);
        pOtercerosPagina.validateForm(true,true);
        pOtercerosPagina.completeFormAccount("100",true,true);
        pOtercerosPagina.selectType(type,true,false);
        pOtercerosPagina.goToContinue(true,false);

        confirmTransaction.validateSummaryPage();
        confirmTransaction.goToValidateTransaction();

        tarjetaDeClaveLogica.completeKeyTC();
        return  resumenTransaction.validateSummaryPage();

    }

    public boolean transferToThirdRegisteredNewBeneficiaryOutsideBHD(String user, String pass, String accountOrigin,  String bank,String TypeProduct, String productNumber, String type) {
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionPagina.validatePageTransaction();
        trasaccionPagina.goToThird();

        pOtercerosPagina.validateTransactionThirdPage(true,true);
        pOtercerosPagina.selectAccountOrigin(accountOrigin,true,false);
        pOtercerosPagina.validateTransactionDestiny(true,true);
        pOtercerosPagina.goToDestiny(true,false);
        pOtercerosPagina.validateProductDestiny(true,true);
        pOtercerosPagina.selectNewBeneficary(true,false);
        pOtercerosPagina.validateFormNewBeneficiary(true,true);
        pOtercerosPagina.completeFormNewBeneficiaryOutsideBHD("10",bank,TypeProduct,productNumber,true,false);
        pOtercerosPagina.selectType(type,true,false);
        pOtercerosPagina.goToContinue(true,false);

        return confirmTransaction.validateSummaryPage();
    }

    public boolean transferToThirdNewBeneficiaryBHD(String user, String pass, String accountOrigin,  String productDestiny) {
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionPagina.validatePageTransaction();
        trasaccionPagina.goToThird();

        pOtercerosPagina.validateTransactionThirdPage(true,true);
        pOtercerosPagina.selectAccountOrigin(accountOrigin,true,false);
        pOtercerosPagina.validateTransactionDestiny(true,true);
        pOtercerosPagina.goToDestiny(true,false);
        pOtercerosPagina.validateProductDestiny(true,true);
        pOtercerosPagina.selectNewBeneficary(true,false);
        pOtercerosPagina.validateFormNewBeneficiary(true,true);
        pOtercerosPagina.completeFormNewBeneficiaryBHD("10",productDestiny,true,false);
        pOtercerosPagina.goToContinue(true,false);

        return confirmTransaction.validateSummaryPage();
    }

    public void salirTransferToThird(String account){
        pOtercerosPagina.validateProductOriginSelect(account,true,true);
        pOtercerosPagina.btnBack(true,false);
        pOtercerosPagina.validateMessage(true,true);
        pOtercerosPagina.goToCancel(true,false);
    }

}
