package page.mbp.transaction.pinpesos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.dashboard.transaction.POtransactionLogic;
import page.mbp.keycard.POtarjetaDeClaveLogica;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.owntransaction.POpropiaLogica;
import page.mbp.transaction.owntransaction.POpropiaPagina;
import page.mbp.transaction.transactionconfirm.POconfirmarTransaccionLogica;
import page.mbp.transaction.transactionsummary.POresumenTransaccionLogica;

public class POpinPesosLogica {
    POpinPesosPage pOpinPesosPage;
    POtransactionLogic trasaccionLogica;
    POiniciarSesionLogica loginLogic;
    POdashboardPagina dashboardPagina;
    AndroidDriver<AndroidElement> driver;
    POconfirmarTransaccionLogica confirmTransaction;
    POresumenTransaccionLogica resumenTransaction;
    POtarjetaDeClaveLogica tarjetaDeClaveLogica;

    public POpinPesosLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        pOpinPesosPage = new POpinPesosPage(driver);
        trasaccionLogica = new POtransactionLogic(driver);
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardPagina = new POdashboardPagina(driver);
        confirmTransaction = new POconfirmarTransaccionLogica(driver);
        resumenTransaction = new POresumenTransaccionLogica(driver);
        tarjetaDeClaveLogica = new POtarjetaDeClaveLogica(driver);
    }
    public static POpinPesosLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POpinPesosLogica(driver);
    }

    public boolean enrolledBeneficiarySelectContact(String user, String pass, String amount){
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionLogica.validateModule();
        trasaccionLogica.goToPinPesos();

        pOpinPesosPage.validatePinPesosPage(true,true);
        pOpinPesosPage.selectAccountOrigin("0057",true,false);
        pOpinPesosPage.validateSelectOriginAccount(true,true);
        pOpinPesosPage.selectContact("Lista de beneficiarios",true,false);
        pOpinPesosPage.selectBeneficiaryList("Carlitos",true,false);
        pOpinPesosPage.validateSelectOriginAccount(true,true);
        pOpinPesosPage.selectDocumentType("84930285041",true,true);
        pOpinPesosPage.completeForm(amount,true,false);
        pOpinPesosPage.goToContinue(true,false);
        pOpinPesosPage.goToContinue(false,false);

        return confirmTransaction.validateSummaryPage();
    }

    public boolean newBeneficiaryMobileNumber(String user, String pass, String amount){
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionLogica.validateModule();
        trasaccionLogica.goToPinPesos();

        pOpinPesosPage.validatePinPesosPage(true,true);
        pOpinPesosPage.selectAccountOrigin("0057",true,false);
        pOpinPesosPage.validateSelectOriginAccount(true,true);
        pOpinPesosPage.completeFormEnterNumber("8092224444",true,false);
        //84930285041
        pOpinPesosPage.selectDocumentType("84930285041",true,true);
        pOpinPesosPage.completeForm(amount,true,false);
        pOpinPesosPage.goToContinue(true,false);
        pOpinPesosPage.goToContinue(false,false);

        return confirmTransaction.validateSummaryPage();
    }

    public boolean missingNameAndBeneficiary(String user, String pass){
        loginLogic.login(user,pass,false,false,false);
        dashboardPagina.goToTransaction(true,false);

        trasaccionLogica.validateModule();
        trasaccionLogica.goToPinPesos();

        pOpinPesosPage.validatePinPesosPage(true,true);
        pOpinPesosPage.selectAccountOrigin("0057",true,false);
        pOpinPesosPage.validateSelectOriginAccount(true,true);
        pOpinPesosPage.completeFormEnterNumber("8092224444",true,false);

        pOpinPesosPage.selectDocumentType("84930285041",true,true);
        pOpinPesosPage.goToContinue(true,false);
        return pOpinPesosPage.validateFormNoComplete(true,true);
    }

}
