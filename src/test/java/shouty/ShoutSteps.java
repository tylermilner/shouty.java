package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("{word} is at {int}, {int}")
    public void name_is_at(String name, int xCoord, int yCoord) {
        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
    }

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

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> dataTable) {
        for (PersonLocation personLocation : dataTable) {
            shouty.setLocation(personLocation.getName(), personLocation.getCoordinate());
        }
    }

    @Then("Lucy should hear {int} shouts from Sean")
    public void lucyShouldHearShoutsFromSean(Integer int1) {
        assertEquals(int1.intValue(), shouty.getShoutsHeardBy("Lucy").get("Sean").size());
    }
}
