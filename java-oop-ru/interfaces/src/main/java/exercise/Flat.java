package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }
    @Override
    public int compareTo(Home anotherBuilding) {
        Home flat = new Flat(this.area, this.balconyArea, this.floor);
        if (anotherBuilding.getArea() > flat.getArea()) {
            return -1;
        } else if (anotherBuilding.getArea() < flat.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
    public String toString() {
        Home flat = new Flat(this.area, this.balconyArea, this.floor);
        return "Квартира площадью " + flat.getArea() + " метров на " + this.floor + " этаже";
    }

}
// END
