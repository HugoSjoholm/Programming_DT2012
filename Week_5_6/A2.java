import java.awt.Color;

public class A2 {

    private static Color average(Color[] colors, int[] weights) {
        double red = 0;
        double green = 0;
        double blue = 0;
        // Your code here

        return new Color((int) red, (int) green, (int) blue);
    }

    private static Color[] neighbours(int x, int y, Picture p) {
        Color[] nine = new Color[9];
        // Your code here
        return nine;
    }

    public static void blur(Picture pic) {
        // Implement the blur method
        // Mind what you have to do with the ootput (show, save)
    }

    public static void sharpen(Picture pic) {
        // Implement the sharpen method
        // Mind what you have to do with the ootput (show, save)
    }

    public static void vignette(Picture pic) {
        // Implement the vignete method
        // Mind what you have to do with the ootput (show, save)
    }

    public static void main(String[] args) {
        //Read a filename from the command line
        // Test EACH and ALL of your methods

    }
}