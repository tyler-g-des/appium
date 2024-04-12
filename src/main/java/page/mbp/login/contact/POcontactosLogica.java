package page.mbp.login.contact;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.login.POiniciarSesionPagina;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de contactos
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POcontactosLogica {
    POcontactosPagina contactPage;
    POiniciarSesionPagina loginPage;
    AndroidDriver<AndroidElement> driver;
    public POcontactosLogica(AndroidDriver<AndroidElement>  driver){
        this.driver = driver;
        contactPage = new POcontactosPagina(driver);
        loginPage = new POiniciarSesionPagina(driver);
    }

    public static POcontactosLogica getInstance(AndroidDriver driver){
        return new POcontactosLogica(driver);
    }

    /**
     * Método para validar que se permita llamar al numero de contactos
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean callTheContactCenter(){
        loginPage.carousel();
        loginPage.goToLoginCarousel(false,false);
        loginPage.goToLoginPage(true,false);
        loginPage.openMenu(true,false);
        loginPage.openMenu(true,false);

        contactPage.goToContacts(true,false);
        contactPage.validateContactPage(true,true);
        contactPage.goToCenterContact(true,false);
        contactPage.validateContactNumberPage(true,true);

        contactPage.nativeButtonBack(true,true);
        contactPage.nativeButtonBack(true,true);
        contactPage.nativeButtonBack(true,true);

        return  contactPage.validateContactPage(true,true);
    }

    /**
     * Método para validar que se permita llamar al numero de contactos exterior
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean callFromInsideWithoutCharges(){
        loginPage.carousel();
        loginPage.goToLoginCarousel(false,false);
        loginPage.goToLoginPage(true,false);
        loginPage.openMenu(true,false);
        loginPage.openMenu(true,false);

        contactPage.goToContacts(true,false);
        contactPage.validateContactPage(true,true);
        contactPage.goToInsideWithout(true,false);
        contactPage.validateFromInsideWithout(true,true);

        contactPage.nativeButtonBack(true,true);
        contactPage.nativeButtonBack(true,true);
        contactPage.nativeButtonBack(true,true);

        return  contactPage.validateContactPage(true,true);
    }
}
