package steps;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import poms.RegisterPOM;

public class SDFHooks {

    @BeforeAll
    public static void setUp () {
        RegisterPOM registerPOM = new RegisterPOM (DriverSingleton.getInstance ());

        DriverSingleton.getInstance().get("http://localhost:4200/register");

        registerPOM.enterFirstName("Selenium");
        registerPOM.enterLastName("Test");
        registerPOM.enterEmail("s@email.com");
        registerPOM.enterUsername("selly");
        registerPOM.enterPassword("password");

        registerPOM.clickBtn();

        if(registerPOM.getErrorMessage()){
            DriverSingleton.quitInstance();
        } else {
            registerPOM.waitForSuccessfulRedirect();
            DriverSingleton.quitInstance();
        }



    }

    @After
    public void tearDown () {
        DriverSingleton.quitInstance ();
    }
}
