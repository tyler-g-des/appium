package page.mbp.transaction.paymenservice;

import controladorlocal.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de pago de servicios
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POpaymentServicePage extends Base {

    private By validatePage = By.xpath("(//android.widget.Image[@text=\"arrow forward\"])[1] | //*[contains(@text,\"Aún no tienes\")]");
    private By btnNewService = By.xpath("//android.widget.Button[@text=\"NUEVO SERVICIO\"]");
    private By txtConfirmFormAdd = By.xpath("//android.widget.TextView[@text=\"Proveedor:\"]");
    private By selectSupplier = By.xpath("//android.widget.Button[@resource-id=\"ion-sel-0\"]");
    private By selectService = By.xpath("//android.widget.Button[@resource-id=\"ion-sel-1\"]");
    private By supplierAltice = By.xpath("//android.widget.Button[@text=\"Altice Dominicana\"]");
    private By services = By.xpath("//android.app.Dialog[@resource-id=\"ion-overlay-5\"]/android.app.Dialog");
    private By txtNoContract = By.xpath("(//*[contains(@class,'android.widget.EditText')])[3]");
    private By btnConsult = By.xpath("//android.widget.Button[@text=\"CONSULTAR\"]");
    private By selectProduct = By.xpath("//*[contains(@text,\"Selecciona un producto\")]");
    private By firstElement = By.xpath("//android.view.View[@resource-id=\"private-menu\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]");
    private By rbOtherMount = By.xpath("(//*[@class='android.widget.RadioButton'])[3]");
    private By txtOtherAmount = By.xpath("//android.widget.TextView[@text=\"RD $\"]//parent::android.view.View/android.view.View/android.widget.EditText");
    private By btnContinue = By.xpath("//android.view.View[@resource-id=\"private-menu\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button");
    private By txtEmail = By.xpath("//android.view.View[@resource-id=\"private-menu\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[4]/android.widget.EditText");
    private By txtDescription = By.xpath("//android.view.View[@resource-id=\"private-menu\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[5]/android.widget.EditText");
    private By btnDetailService = By.xpath("//android.widget.Button[@text=\"eye outline\"]");
    private boolean status;

    public POpaymentServicePage(AndroidDriver<AndroidElement> driver) { super(driver); }


    /**
     * Método para hacer click en el boton CONSULTAR
     *
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToConsult(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnConsult,30)) {
            click(btnConsult, 30,"CONSULTAR", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton CONTINUAR
     *
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToContinue(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnContinue,30)) {
            click(btnContinue, 30,"CONTINUAR", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton NUEVO SERVICIO
     *
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToNewService(boolean report, boolean takeScreenShot){
        //550,2050
        //click(btnNewService, 30,"NUEVO SERVICIO", report, takeScreenShot);
        clickCoordinates(550,2050,15,"NUEVO SERVICO",report,takeScreenShot);

    }

    /**
     * Método para hacer click en el boton para RETROCEDER
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void btnBack(boolean report, boolean takeScreenShot){
        clickCoordinates(106,182,15,"back",report,takeScreenShot);
    }

    /**
     * Método para escribir en el campo No. de contracto recibido por parametro
     *
     * @params String, Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void writeTextOnContract(String text,boolean report, boolean takeScreenShot){
        if(isElementPresent(txtNoContract,15)){
            setText(txtNoContract,text,15,report,takeScreenShot);
        }
    }



    /**
     * Método para hacer seleccionar el pago
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void searchServiceRegistered(AndroidDriver<AndroidElement> driver, String service, boolean report, boolean takeScreenShot){
        By services = By.xpath("//android.widget.TextView[@text=\"Servicio FavoritoCAASD\"]");
        scrollAndFindElement(driver,services);
    }

    /**
     * Método para hacer seleccionar el Proveedor
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectProduct(String account, boolean report, boolean takeScreenShot){
        By supplierService = By.xpath("//*[contains(@text,"+account+")]");

        if(isElementPresent(selectProduct,15)){
            click(selectProduct,15,"Seleccionar Producto",report,takeScreenShot);

            if (isElementPresent(firstElement,15)){
                //dropDown(account,report,takeScreenShot);

                if (isElementPresent(supplierService,15)){
                    click(supplierService,15,account,report, takeScreenShot);
                }
            }
        }
    }

    /**
     * Método para hacer seleccionar el Proveedor
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectSupplier(String supplier, boolean report, boolean takeScreenShot){
        By supplierService = By.xpath("//android.widget.Button[@text=\""+supplier+"\"]");

        if(isElementPresent(selectSupplier,30)) {
            click(selectSupplier, 15,"Selecciona un proveedor", report, takeScreenShot);

            if(isElementPresent(supplierAltice,15)) {
                dropDown(supplier,report,takeScreenShot);

                if(isElementPresent(supplierService,15)) {
                    click(supplierService, 15, supplier, report, takeScreenShot);
                }
            }
        }
    }

    /**
     * Método para hacer seleccionar el Servicio
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectService(String typeServices, boolean report, boolean takeScreenShot){
        By typeService = By.xpath("//android.widget.Button[@text=\""+typeServices+"\"]");

        if(isElementPresent(selectService,30)) {
            click(selectService, 15,"Selecciona un proveedor", report, takeScreenShot);
            dropDown(typeServices,report,takeScreenShot);

            if(isElementPresent(typeService,15)) {
                click(typeService, 15, typeServices, report, takeScreenShot);
            }
        }
    }

    /**
     * Método para hacer seleccionar el pago
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeTypePay(String typePay, String mount, boolean report, boolean takeScreenShot){

        dropDown("Fecha:",report,takeScreenShot);
        if(typePay.equalsIgnoreCase("Otro monto")){
            click(rbOtherMount,15,typePay,report,takeScreenShot);

            click(txtOtherAmount,15,typePay,report,takeScreenShot);
            setText(txtOtherAmount,mount,15,report,takeScreenShot);
        }
        goToContinue(report,takeScreenShot);

    }

    /**
     * Método para hacer seleccionar pago de servicio
     *
     * @params String
     * @params Boolean
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void selectServicePay(String service, boolean report, boolean takeScreenShot){
        By serviceRegistered = By.xpath("//android.widget.TextView[@text='"+service+"']//following-sibling::android.widget.Image");

        if (isElementPresent(serviceRegistered,15)){
            click(serviceRegistered,15,"Click en el servicio",report,false);

            if (isElementPresent(btnDetailService,15)){
                click(btnDetailService,15,"boton detalle servicio",report,false);
            }
        }

    }




    /**
     * Método para validar que se muestre la pagina de pago de servicio
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validatePaymentServicePage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validatePage,15)){
            crearPaso("Se muestra la pagina de pago de servicio",true,report,takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pagina de pago de servicio
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateAddPaymentServicePage(boolean report, boolean takeScreenShot){
        if (isElementPresent(txtConfirmFormAdd,15)){
            crearPaso("Se muestra el formulario para agregar servicios nuevo",true,report,takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pagina pagar servicio
     *
     * @params Boolean
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validatePayment(boolean report, boolean takeScreenShot){
        if (isElementPresent(selectProduct,15)){
            crearPaso("Se muestra la pagina de pago de servicio",true,report,takeScreenShot);
            status = true;
        }
        return status;
    }

}
