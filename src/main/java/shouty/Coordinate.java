package shouty;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int distanceFrom(Coordinate other) {
        double xsq = (this.x - other.x) * (this.x - other.x);
        double ysq = (this.y - other.y) * (this.y - other.y);
        double sq = Math.sqrt(xsq + ysq);
        return (int)sq;
    }
}
