package page.mbp.login;

import controladorlocal.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class POpreguntaSeguridadPagina extends Base {

    public POpreguntaSeguridadPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    WebDriverWait waits = new WebDriverWait(driver, 20);
    HashMap<String, String> preguntasRespuestas = new HashMap<>();

    private String pregunta1 = "¿Cuál es el personaje de su libro favorito?";
    private String pregunta2 = "¿Cuál es su color favorito?";
    private String pregunta3 = "¿Cuál es el nombre de su abuela materna?";
    private String pregunta4 = "¿Cuál es la marca de su primer carro?";
    private String pregunta5 = "¿Cuál es el nombre del colegio donde cursó la primaria?";

    private String respuesta1 = "libro";
    private String respuesta2 = "color";
    private String respuesta3 = "abuela";
    private String respuesta4 = "carro";
    private String respuesta5 = "colegio";
    private By labelPantallaInicio = By.xpath("//*[@text='Preguntas de seguridad']");
    private By buttonContinuar = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button");


    protected void llenarPreguntas(boolean deslizar) {
        try {
            waits.until(ExpectedConditions.presenceOfElementLocated(labelPantallaInicio));
            preguntasRespuestas.put(pregunta1, respuesta1);
            preguntasRespuestas.put(pregunta2, respuesta2);
            preguntasRespuestas.put(pregunta3, respuesta3);
            preguntasRespuestas.put(pregunta4, respuesta4);
            preguntasRespuestas.put(pregunta5, respuesta5);

            List<AndroidElement> questions = driver.findElementsByXPath("//android.widget.TextView[contains(@text,'¿')]");
            List<AndroidElement> inputs = driver.findElementsByXPath("//android.widget.EditText");


            for (int i = 0; i < questions.size(); i++) {

                MobileElement question = questions.get(i);
                String questionText = question.getText();

                // Encontrar el input correspondiente
                MobileElement input = inputs.get(i);

                if(deslizar && i==3){
                    dropDownCoinicidencia("colegio",false,false);
                }

                input.sendKeys(preguntasRespuestas.get(questionText));
            }
            crearPaso("Se completo las preguntas de seguridad",true,true,true);
            click(buttonContinuar, 15, "CONTINUAR", true, false);

        } catch (NoSuchElementException e) {
            System.out.println("No salio pero sigo");
        } catch (TimeoutException e) {
            System.out.println("No salio pero sigo");
        } catch (Exception e) {
            throw (e);
        }
    }
}
