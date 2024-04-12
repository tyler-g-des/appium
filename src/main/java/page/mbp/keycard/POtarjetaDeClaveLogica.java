package page.mbp.keycard;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

/**
 * Esta clase define los pasos que tienen los casos de prueba de la pagina de Tarjeta de Clave
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POtarjetaDeClaveLogica {
    POtarjetaDeClavePagina keyCardPage;
    AndroidDriver<AndroidElement> driver;
    public POtarjetaDeClaveLogica(AndroidDriver<AndroidElement>  driver){
        this.driver = driver;
        keyCardPage = new POtarjetaDeClavePagina(driver);
    }

    public static POtarjetaDeClavePagina getInstance(AndroidDriver<AndroidElement> driver){
        return new POtarjetaDeClavePagina(driver);
    }


    /**
     * Método para completar tarjeta de clave
     *
     * @return boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public boolean signContract(){
        keyCardPage.goToAccept(true,false);
        keyCardPage.validateKeyCardPage(true,true);

        keyCardPage.goToNumberOne(true,false);
        keyCardPage.goToNumberOne(true,false);
        keyCardPage.goToNumberOne(true,false);
        keyCardPage.goToNumberOne(true,false);
        keyCardPage.goToNumberOne(true,false);

        keyCardPage.goToContinue(true,true);
        return true;
    }

    /**
     * Método para completar tarjeta de clave
     *
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeKeyTC(){
        keyCardPage.validateKeyCardPage(true,true);

        keyCardPage.goToNumberOne(true,false);
        keyCardPage.goToNumberOne(true,false);
        keyCardPage.goToNumberOne(true,false);
        keyCardPage.goToNumberOne(true,false);

        keyCardPage.goToContinue(true,true);
    }

    /**
     * Método para completar tarjeta de clave en caso de que salga
     *
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void completeKeyOptional(){
        keyCardPage.completeKeyOptional();
    }
}
