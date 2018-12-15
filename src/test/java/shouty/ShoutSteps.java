package shouty;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;

public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";

    @Autowired
    private Shouty shouty;

    @When("{word} shouts")
    public void name_shouts(String name) {
        shouty.shout(name, ARBITRARY_MESSAGE);
    }

    @Then("Lucy should hear Sean")
    public void lucy_should_hear_sean() {
        assertEquals(1, shouty.getShoutsHeardBy("Lucy").size());
    }

    @Then("{word} should hear nothing")
    public void name_should_hear_nothing(String name) {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy(name));
    }

    @Then("Lucy should not hear Oscar")
    public void lucyShouldNotHearOscar() {
        assertEquals(shouty.getShoutsHeardBy("Lucy").toString(), "{Sean=[Hello, world]}");
    }

    @Then("Lucy should hear {int} shouts from Sean")
    public void lucyShouldHearShoutsFromSean(Integer int1) {
        assertEquals(int1.intValue(), shouty.getShoutsHeardBy("Lucy").get("Sean").size());
    }
}
