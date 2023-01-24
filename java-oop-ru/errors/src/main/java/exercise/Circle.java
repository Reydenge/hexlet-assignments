package exercise;

// BEGIN
public class Circle {
    private final int radius;
    private Point circleCenter;

    public Circle(Point center, int radius) {
        this.radius = radius;
        this.circleCenter = center;
    }
    public int getRadius() {
        return radius;
    }
    public double getSquare() throws NegativeRadiusException {
        if (this.radius < 0) {
            throw new NegativeRadiusException("Circle's radius is less then zero");
        }
        return radius * radius * Math.PI;
    }
}
// END
