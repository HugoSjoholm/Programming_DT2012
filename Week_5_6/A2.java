import java.awt.Color;

public class A2 {
    //defines special color codes that can later be used in prints for cool effects and visual enthasis. 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    //public so it can be ascces across the file. final so the variables cannot be changed
    //idk what static does tbh. but it is needed here because we're not inside a class definition for a object. 


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

    public static void blur(final Picture input) {
        Picture pic = new Picture(input);
        
        //Box blur (normalized)
        // https://en.wikipedia.org/wiki/Kernel_(image_processing)#Details
        int[][] kernel = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };

        double normalFactor = 9; //devide by this later on to normalize the matrix(?) so the avrage values/brighness of the images does not unexpectadly increase.

        for (int x = 1; x < input.width() - 1; x++) {
            for (int y = 1; y < input.height() - 1; y++) { 
                int acumulatorR = 0;
                int acumulatorG = 0;
                int acumulatorB = 0;

                for (int kx = 0; kx < kernel.length; kx++) {
                    for (int ky = 0; ky < kernel[kx].length; ky++) {
                        Color tmp = input.get(x + kx - 1, y + ky - 1);
                        acumulatorR += kernel[kx][ky] * tmp.getRed();
                        acumulatorG += kernel[kx][ky] * tmp.getGreen();
                        acumulatorB += kernel[kx][ky] * tmp.getBlue();

                    }
                }

                //for future. optamize this using a vector3 for each channel value. so instead of three version of each variable you only have a vector3. 
                double totalR = acumulatorR / normalFactor;
                double totalG = acumulatorG / normalFactor;
                double totalB = acumulatorB / normalFactor;


                pic.set(x, y, new Color(
                    clamp((int)totalR, 0, 255),
                    clamp((int)totalG, 0, 255),
                    clamp((int)totalB, 0, 255))
                );
 
            }
        }
        pic.show();
        pic.save("pic5.jpg");

        // Implement the blur method
        // Mind what you have to do with the ootput (show, save)
    }

    public static void sharpen(Picture input) {

        Picture pic = new Picture(input);

        
        //whack ass kernel
        int[][] kernel = {
                { -1, -1, -1 },
                { -1, 16, -1 },
                { -1, -1, -1 }
        };

        double normalFactor = 8; // why is this 1 for sharpening????

        for (int x = 1; x < input.width() - 1; x++) {
            for (int y = 1; y < input.height() - 1; y++) {
                int acumulatorR = 0;
                int acumulatorG = 0;
                int acumulatorB = 0;

                for (int kx = 0; kx < kernel.length; kx++) {
                    for (int ky = 0; ky < kernel[kx].length; ky++) {
                        Color tmp = input.get(x + kx - 1, y + ky - 1);
                        acumulatorR += kernel[kx][ky] * tmp.getRed();
                        acumulatorG += kernel[kx][ky] * tmp.getGreen();
                        acumulatorB += kernel[kx][ky] * tmp.getBlue();

                    }
                }

                // for future. optamize this using a vector3 for each channel value. so instead
                // of three version of each variable you only have a vector3.
                double totalR = acumulatorR / normalFactor;
                double totalG = acumulatorG / normalFactor;
                double totalB = acumulatorB / normalFactor;
                //System.out.println(totalR);
                
                pic.set(x, y, new Color(
                        clamp((int)totalR,0,255),
                        clamp((int)totalG,0,255),
                        clamp((int)totalB,0,255)
                    ));

            }
        }
        pic.show();
        pic.save("pic6.jpg");


        // Implement the sharpen method
        // Mind what you have to do with the ootput (show, save)
    }

    public static void vignette(Picture input) {
        Picture pic = new Picture(input);
        int centerX = input.width() / 2;
        int centery = input.height() / 2;
        
        for (int x = 0; x < input.width() - 1; x++) {
            for (int y = 0; y < input.height() - 1; y++) {
                //math formula d = sqrt((x_2 - x_1 )^2 + (y_2 - y_1)^2)
                double distance = Math.sqrt(Math.pow((x - centerX),2) + Math.pow(y - centery, 2));
                distance = (255 - distance)/255;
                Color tmp = input.get(x, y);
                
                //System.out.println(tmp.getBlue() + " * " + distance);
                tmp = new Color(
                    (int)(tmp.getRed() * distance), 
                    (int)(tmp.getGreen() * distance), 
                    (int)(tmp.getBlue() * distance)
                );
                
                
                //tmp = new Color((int)distance, (int)distance, (int)distance);

                //System.out.println(distance);
                pic.set(x, y, tmp);

            }
        }

        pic.show();
        pic.save("pic7.jpg");


        // Implement the vignete method
        // Mind what you have to do with the ootput (show, save)
    }

    public static void main(String[] args) {
        String firstArg = "";
        Picture input;
        try {
            firstArg = args[0];
            //System.out.println("First argument: " + firstArg);
            input = new Picture(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            input = new Picture(funError(new Picture(500,500)));
            System.out.println(ANSI_RED + "No argument provided!" + ANSI_RESET + " Please provide inpuut in this format" + ANSI_RESET);
            System.out.println("Example: " + ANSI_GREEN + "java A2.java baboon.jpg" + ANSI_RESET);
        }
        input.show();
        blur(input);
        sharpen(input);
        vignette(input);




        //Read a filename from the command line
        // Test EACH and ALL of your methods

    }
    public static Picture funError(Picture pic) { //this function is for fun. It generates a grid of black and magenta squares, similar to a error exture from Gmod.
        Picture tmp = new Picture(pic);
        for (int x = 0; x < pic.width(); x++) {
            for (int y = 0; y < pic.height(); y++) {
                if (((x / 20) + (y / 20)) % 2 == 0) { //20 is the seize of the squares
                    tmp.set(x, y, Color.BLACK);
                }
                else {
                    tmp.set(x, y, Color.MAGENTA);
                }
            }   
        }

        return tmp;
    }
    public static int clamp(int num, int min, int max) {
        if (num > min && num < max) {
            return num;
        }
        if (num <= min) {
            return min;
        }
        if (num >= max) {
            return max;
        }
        else {
            return -1; //Error
        }
    }
}