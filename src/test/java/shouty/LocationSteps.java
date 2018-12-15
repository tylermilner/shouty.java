package shouty;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class LocationSteps {

    @Autowired
    private Shouty shouty;

    @Given("{word} is at {int}, {int}")
    public void name_is_at(String name, int xCoord, int yCoord) {
        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> dataTable) {
        for (PersonLocation personLocation : dataTable) {
            shouty.setLocation(personLocation.getName(), personLocation.getCoordinate());
        }
    }
}
