package shouty;

import cucumber.api.java.Before;
import cucumber.api.java.After;

public class ShoutyHooks {

    // Before hooks executed in ascending order
    @Before(order = 1)
    public void beforeEachScenario() {
        System.out.println("Before scenario hook");
    }

    // After hooks executed in descending order
    @After(order = 2)
    public void afterEachScenario() {
        System.out.println("After scenario hook");
    }

    @Before(order = 2)
    public void beforeEachScenarioHookTwo() {
        System.out.println("Before scenario hook 2");
    }

    @After(order = 1)
    public void afterEachScenarioHookTwo() {
        System.out.println("After scenario hook 2");
    }

    @Before("@wip, @wip2")
    public void beforeWIP() {
        System.out.println("Before WIP hook");
    }

    @After("@wip, @wip2")
    public void afterWIP() {
        System.out.println("After WIP hook");
    }
}
