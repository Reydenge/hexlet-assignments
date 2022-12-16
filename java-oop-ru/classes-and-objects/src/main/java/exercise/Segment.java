package exercise;

// BEGIN
public class Segment {
    private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public Point getMidPoint() {
        int x1 = point1.getX();
        int x2 = point2.getX();
        int y1 = point1.getY();
        int y2 = point2.getY();
        return new Point((x1+x2)/2, (y1+y2)/2);
    }
    public Point getBeginPoint() {
        return point1;
    }
    public Point getEndPoint() {
        return point2;
    }
}
// END
