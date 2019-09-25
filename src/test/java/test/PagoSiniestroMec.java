package test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.TestObject;
import com.amaris.project.Constants;
import com.amaris.project.steps.ActionSteps;
public class PagoSiniestroMec extends TestObject{
    protected SuiteManager suiteM = new SuiteManager(Constants.MEC_SINIESTROS);

    // PRUEBA MEC_SINIESTROS
    @DataProvider(parallel = true)
    public String[][] dataProviderSiniestrosMec01() {
        String testCase = Constants.MEC_SINIESTROS + "01";
        String[][] casesMatrix = suiteM.initializeTestObjects(testCase, "datosTestSiniestrosMec.csv");

        return casesMatrix;
    }


    @Test(dataProvider = "dataProviderSiniestrosMec01")

    public void pagoSimple01(String testCase, String id) throws Exception {
        UserStory userS = suiteM.createUserStory(testCase, id);
        ActionSteps steps = new ActionSteps(userS);

        userS.testActions(() -> {
            steps.login("Innova", "Eperez");
            steps.realizo_pago_simple();


            return null;
        }).run();
    }


    @Test(dataProvider = "dataProviderSiniestrosMec01")

    public void pagoSimple02(String testCase, String id) throws Exception {
        UserStory userS = suiteM.createUserStory(testCase, id);
        ActionSteps steps = new ActionSteps(userS);

        userS.testActions(() -> {
            steps.login("Innova", "Eperez");
            steps.realizo_pago_simple();


            return null;
        }).run();
    }

}
