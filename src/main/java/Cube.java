/**
 * Created by staff on 7/10/17.
 */
public class Cube {

    private Rectangle face;

    public Cube(Rectangle rectangle) {
        face = rectangle;
    }

    public Rectangle getFace() {
        return face;
    }

    public int getVolume() {
        int height = face.getHeight();
        return height * height * height;
    }

    public int getSurfaceArea() {
        return face.area() * 6;
    }

}
