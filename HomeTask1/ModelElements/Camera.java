package HomeTask1.ModelElements;

public class Camera {

    /**
     * Point3D location - точка размещения камеры в 3D пространстве
     * Angle3D angle - угол поворота/наклона камеры в 3D пространстве
     */
    private Point3D location;
    private Angle3D angle;

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public Point3D getLocation() {
        return this.location;
    }

    public Angle3D getAngle() {
        return this.angle;
    }

    public void move(Point3D location) {
        this.location = location;
    }

    public void rotate(Angle3D angle) {
        this.angle = angle;
    }

}
