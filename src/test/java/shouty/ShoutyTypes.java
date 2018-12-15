package shouty;

import cucumber.api.TypeRegistry;
import io.cucumber.cucumberexpressions.CaptureGroupTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import java.util.Map;

import java.util.Locale;

import static java.lang.Integer.parseInt;

public class ShoutyTypes implements cucumber.api.TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(PersonLocation.class, (Map<String, String> row) -> {
            String name = row.get("name");
            int xCoord = new Integer(row.get("x")).intValue();
            int yCoord = new Integer(row.get("y")).intValue();

            return new PersonLocation(name, xCoord, yCoord);
        }));
    }

}
