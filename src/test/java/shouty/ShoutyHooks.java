package shouty;

import cucumber.api.java.Before;
import cucumber.api.java.After;

public class ShoutyHooks {

    @Before
    public void beforeEachScenario() {
        System.out.println("Before scenario hook");
    }

    @After
    public void afterEachScenario() {
        System.out.println("After scenario hook");
    }
}
