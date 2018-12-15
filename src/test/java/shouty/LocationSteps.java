package shouty;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class LocationSteps {

    @Autowired
    private ShoutyHelper shouty;

    @Given("{word} is at {coordinate}")
    public void name_is_at(String name, Coordinate coordinate) {
        shouty.setLocation(name, coordinate);
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> dataTable) {
        for (PersonLocation personLocation : dataTable) {
            shouty.setLocation(personLocation.getName(), personLocation.getCoordinate());
        }
    }
}
