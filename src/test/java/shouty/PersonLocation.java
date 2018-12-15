package shouty;

public class PersonLocation {
    private final String name;
    private final int x;
    private final int y;

    public PersonLocation(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return new Coordinate(x, y);
    }
}
