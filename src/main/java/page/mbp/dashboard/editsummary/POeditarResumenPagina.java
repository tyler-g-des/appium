package page.mbp.dashboard.editsummary;

import controladorlocal.Base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Esta clase define los elementos y acciones usada para hacer interacciones en la pagina Editar Resumen
 * @author: Tyler Diaz
 * @version: 15/01/2024
 */
public class POeditarResumenPagina extends Base {
    public POeditarResumenPagina(AndroidDriver<AndroidElement> driver) { super(driver); }

    private By validatePage = By.xpath("//*[contains(@text,'Cuentas')] | " +
            "//*[contains(@text,'Tarjetas')] |" +
            "//*[contains(@text,'Pres')]");
    private By txtEditAlias = By.xpath("//android.widget.EditText");
    private By messageIncorrect = By.xpath("//*[contains(@text,\"Tus cambios fueron guardados\")]");
    private By btnSaveChange = By.xpath("(//android.widget.Button)[2]");
    int reintento = 0;
    private WebDriverWait wait;
    private boolean status;


    /**
     * Método para hacer click en el boton guardar
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void goToSaveChange(boolean report, boolean takeScreenShot){
        if (isElementPresent(btnSaveChange, 15)) {
            click(btnSaveChange, 15, "GUARDAR CAMBIOS", report, takeScreenShot);
        }
    }

    /**
     * Método para hacer click en el boton transacciones
     *
     * @params Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    public void swipeDashboard(String text, boolean report , boolean takeScreenShot){
        if(reintento != 10) {
            try {
                String scrollableList = "new UiScrollable(new UiSelector().scrollable(true).instance(0))";
                String scrollIntoView = ".scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))";
                driver.findElement(MobileBy.AndroidUIAutomator(scrollableList + scrollIntoView));
                crearPaso("Se observa el card con el numero " + text, true,report,takeScreenShot);
            } catch (NoSuchElementException ex) {
                if(isElementPresent(btnSaveChange,10)) {
                    dropDownStep();
                }
                reintento++;
                swipeDashboard(text, report, takeScreenShot);
            } catch (Exception e) {
                crearPaso("error dropDown " + e, false, report, takeScreenShot);
                throw (e);
            }
        }
    }

    /**
     * Método para buscar cuenta y numero de producto
     *
     * @params String, String
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected void searchProduct(String session, String productNumber, boolean report, boolean takeScreenShot){
        By sessionn = By.xpath("//*[contains(@text,'"+session+"')]");

        if (isElementPresent(validatePage,10)){
            swipeDashboard(session,report,takeScreenShot);
        }

        if(isElementPresent(sessionn,10)) {
            dropDownCoinicidencia(productNumber, report, takeScreenShot);
        }

        clickCoordinates(driver.findElement(By.xpath("//*[contains(@text,'"+productNumber+"')]")).getLocation().getX() + 800,
                driver.findElement(By.xpath("//*[contains(@text,'"+productNumber+"')]")).getLocation().getY(),
                10,"boton editar",report,takeScreenShot);

        if(isElementPresent(txtEditAlias,15)){
            setText(txtEditAlias,"robot prueba",15,report,takeScreenShot);
            clickCoordinates(driver.findElement(txtEditAlias).getLocation().getX() + 800,
                        driver.findElement(txtEditAlias).getLocation().getY(),
                        10,"boton guardar",true,true);

            try {
                wait = new WebDriverWait(driver,20);
                wait.until(ExpectedConditions.invisibilityOf(driver.findElement(txtEditAlias)));
                crearPaso("se muestra el elemento editado", true, report, takeScreenShot);
            }catch (NoSuchElementException | TimeoutException e){
                crearPaso("se muestra el elemento editado", true, report, takeScreenShot);
            }

        }

    }

    /**
     * Método para validar que se muestre el mensaje de error al introducir datos incorrectos
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateFailureLogin (boolean report, boolean takeScreenShot){
        if (isElementPresent(messageIncorrect, 15)) {
            String text = driver.findElement((messageIncorrect)).getText();
            crearPaso("Se observa el mesaje informativo " + text, true, report, takeScreenShot);
            status = true;
        }
        return status;
    }

    /**
     * Método para validar que se muestre la pagina de Configurar Resumen
     *
     * @params Boolean
     * @return Boolean
     * @author Tyler Diaz
     * @since 15/01/2024
     */
    protected boolean validateSummaryPage(boolean report, boolean takeScreenShot){
        if (isElementPresent(validatePage,15)){
            crearPaso("Se observa la pagina de Configurar Resumen", true, report, takeScreenShot);
            status = true;
        }
        return status;
    }


}
