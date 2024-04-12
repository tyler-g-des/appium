package page.mbp.dashboard.detailsproduct;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.dashboard.POdashboardLogica;
import page.mbp.dashboard.POdashboardPagina;
import page.mbp.login.POiniciarSesionLogica;
import page.mbp.transaction.owntransaction.POpropiaLogica;
import page.mbp.transaction.paymenservice.POpaymentServiceLogic;
import page.mbp.transaction.tothirds.POtercerosLogica;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de dashboard
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POdetailProductLogica {

    POiniciarSesionLogica loginLogic;
    POdashboardLogica dashboardLogic;
    POdetailProductPagina detailProductPage;
    POtercerosLogica pOtercerosLogica;
    POpaymentServiceLogic pOpaymentServiceLogic;
    POpropiaLogica pOpropiaLogica;
    AndroidDriver<AndroidElement> driver;

    public POdetailProductLogica(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        loginLogic = new POiniciarSesionLogica(driver);
        dashboardLogic = new POdashboardLogica(driver);
        detailProductPage = new POdetailProductPagina(driver);
        pOtercerosLogica = new POtercerosLogica(driver);
        pOpaymentServiceLogic = new POpaymentServiceLogic(driver);
        pOpropiaLogica = new POpropiaLogica(driver);

    }

    public static POdetailProductLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POdetailProductLogica(driver);
    }


    public boolean  validateProductDetail(String user, String pass, String session, String account, String typeAccount, String currency){
        loginLogic.login(user,pass,false,false,false);
        dashboardLogic.validateProductDetail(session,account);

        detailProductPage.validateProductDetail(true,true);

        if(typeAccount.equalsIgnoreCase("Corriente") || typeAccount.equalsIgnoreCase("Ahorro") && currency.equalsIgnoreCase("RD")){
            detailProductPage.goToTransferToThird(true,false);
            pOtercerosLogica.salirTransferToThird(account);
            detailProductPage.validateProductDetail(true,true);

            detailProductPage.goToPayTC(true,false);
            pOtercerosLogica.salirTransferToThird(account);
            detailProductPage.validateProductDetail(true,true);

            detailProductPage.goToPayService(true,false);
            pOpaymentServiceLogic.exitPayService();

        } else if (typeAccount.equalsIgnoreCase("Ahorro") && currency.equalsIgnoreCase("US")) {
            detailProductPage.goToTransferToThird(true,false);
            pOtercerosLogica.salirTransferToThird(account);
            detailProductPage.validateProductDetail(true,true);

            detailProductPage.goToPayTC(true,false);
            pOtercerosLogica.salirTransferToThird(account);
            detailProductPage.validateProductDetail(true,true);

        }else if (typeAccount.equalsIgnoreCase("Ahorro") && currency.equalsIgnoreCase("EU")){
            detailProductPage.goToCurrencyExchange(true,false);
            pOpropiaLogica.salirOwnToTransfer(account);
            detailProductPage.validateProductDetail(true,true);

            detailProductPage.goToTransfer(true,false);
            pOpropiaLogica.salirOwnToTransfer(account);

        }
        return detailProductPage.validateProductDetail(true,true);
    }


}
