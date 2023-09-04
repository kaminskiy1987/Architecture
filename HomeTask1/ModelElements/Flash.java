package HomeTask1.ModelElements;

public class Flash {

    /**
     * Point3D location - точка размещения источника света в 3D пространстве
     * Angle3D angle - угол поворота/наклона источника света в 3D пространстве
     * Color color - цвет источника света
     * Float power - мощность источника света
     */
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private Float power;

    public Flash(Point3D location, Angle3D angle, Color color, Float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Point3D getLocation() {
        return this.location;
    }

    public Angle3D getAngle() {
        return this.angle;
    }

    public Color getColor() {
        return this.color;
    }

    public Float getPower() {
        return this.power;
    }

    public void move(Point3D location) {
        this.location = location;
    }

    public void rotate(Angle3D angle) {
        this.angle = angle;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPower(Float power) {
        this.power = power;
    }

}
