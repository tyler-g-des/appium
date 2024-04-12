package page.mbp.login.contact;

import controladorlocal.Base;
import controladorlocal.BaseTestAppium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina de contactos
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POcontactosPagina extends Base {

    public POcontactosPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    private By btnContacts = By.xpath("//*[contains(@text,'Contactos')]");

    //-- Centro de contactos
    private By btnContactCenter = By.xpath("//*[contains(@text,'809-243-5000')]");
    private By validateContacts = By.xpath("//*[@text='Centro de contacto809-243-5000']");
    private By validateNumberCenterContact = By.xpath("//android.widget.ImageView[@resource-id='com.android.dialer:id/empty_list_view_image']");

    //-- Desde el exterior sin cargos
    private By btnFromInsideWithout = By.xpath("//*[@text='Desde el exterior sin cargos1-866-898-3300']");
    private By validateFromInsideWithout = By.xpath("//*[@resource-id='com.android.dialer:id/empty_list_view_image']");

    //-- Facebook
    //-- Twitter
    private boolean status;

    /**
     * Método para hacer click en el boton Contactos
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToContacts(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnContacts,30)) {
            click(btnContacts, 30,"Contactos",report,takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton Centro de contacto
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToCenterContact(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnContactCenter,30)) {
            click(btnContactCenter, 30,"Centro de contacto",report, takeScreenShot);
        }
    }


    /**
     * Método para hacer click en el boton Desde el exterior sin cargos
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void goToInsideWithout(boolean report, boolean takeScreenShot){
        if(isElementPresent(btnFromInsideWithout,30)) {
            click(btnFromInsideWithout, 30,"Desde el exterior sin cargos",report,takeScreenShot);
        }
    }



    /**
     * Método para validar que se muestre la pagina de contactos
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateContactPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateContacts,60)){
            crearPaso("Se observa la pagina contactos ", true,report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre el numero de telefono
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateContactNumberPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateNumberCenterContact,60)){
            crearPaso("Se observa el numero de telefono ", true, report,takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre el numero de telefono desde el exterior
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateFromInsideWithout(boolean report, boolean takeScreenShot){
        if (isElementPresent(validateFromInsideWithout,60)){
            crearPaso("Se observa el numero de telefono desde el exterior ", true, report,takeScreenShot);
            status = true;
        }
        return status;
    }
}
