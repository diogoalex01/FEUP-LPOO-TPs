public class Triangle implements AreaShape {

    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getArea() {
        return (base * height) / 2;
    }

    public void draw(){
        System.out.println("Triangle");
    }
}
