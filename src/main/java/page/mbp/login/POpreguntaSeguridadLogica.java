package page.mbp.login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.mbp.keycard.POtarjetaDeClaveLogica;

public class POpreguntaSeguridadLogica {
    AndroidDriver<AndroidElement> driver;
    POpreguntaSeguridadPagina pOpreguntaSeguridadPagina;
    public POpreguntaSeguridadLogica(AndroidDriver<AndroidElement>  driver){
        this.driver = driver;
        pOpreguntaSeguridadPagina = new POpreguntaSeguridadPagina(driver);
    }

    public static POpreguntaSeguridadLogica getInstance(AndroidDriver<AndroidElement> driver){
        return new POpreguntaSeguridadLogica(driver);
    }

    public void completeSecurityQuestion(boolean deslizar){
        pOpreguntaSeguridadPagina.llenarPreguntas(deslizar);
    }

}
