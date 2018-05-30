public class Cube {
    private Rectangle face;

    public Cube(Rectangle rectangle) {
        this.face = rectangle;
    }


    public Rectangle getFace() {
        return face;
    }

    public int getVolume() {
        int height = face.getHeight();
        return (int) Math.pow(height, 3);
    }

    public int getSurfaceArea() {
        return face.calculateArea() * 6;
    }

}
