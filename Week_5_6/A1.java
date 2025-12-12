
import java.awt.Color;

public class A1 {
  // defines special color codes that can later be used in prints for cool effects
  // and visual enthasis.
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  // public so it can be ascces across the file. final so the variables cannot be
  // changed
  // idk what static does tbh. but it is needed here because we're not inside a
  // class definition for a object.


    public static void complement(Picture pic) {
      Picture newPic = new Picture(pic);
      for (int x = 0; x < newPic.width(); x++) {
        for (int y = 0; y < newPic.height(); y++) {
          Color tmp = newPic.get(x, y);
          newPic.set(x, y, new Color(
            255 - tmp.getRed(), 
            255 - tmp.getBlue(), 
            255 - tmp.getGreen()
          )
          );
        }
      }
        newPic.show();
        newPic.save("pic2.jpg");
        // Implement the complement method
        // Remember to do to the file what is expected (show, save)
    }
    public static void blackAndWhite(Picture pic) {
      Picture newPic = new Picture(pic);
      //System.out.println("Make it gray scale");
      for (int x = 0; x < newPic.width(); x++) {
        for (int y = 0; y < newPic.height(); y++) {
          Color tmp = newPic.get(x, y);
          tmp = Luminance.toGray(tmp);
          newPic.set(x, y, tmp);
        }
      }
      
      newPic.show();
      pic.save("pic1.jpg");
        // Implement the black and white method
        // Remember to do to the file what is expected (show, save)
    }

    public static void rotate(Picture pic) {
      Picture newPicR = new Picture(pic);
      for (int x = 0; x < newPicR.width(); x++) {
        for (int y = 0; y < newPicR.height(); y++) {
          newPicR.set(pic.height() - 1 - y, x, pic.get(x,y));
        }
      }

      newPicR.show();
      newPicR.save("pic3.jpg");
      // Implement the rotate method
      // Remember to do to the file what is expected (show, save)
    }
    
    public static void flip(Picture pic) {
      Picture newPic = new Picture(pic);
      for (int x = 0; x < pic.width(); x++) {
        for (int y = 0; y < pic.width(); y++) {
          Color tmp = pic.get(x, y);
          newPic.set(pic.width() - 1 - x, y, tmp);
        }
      }
      newPic.show();
      newPic.save("pic4.jpg");
      // Implement the flip method
      // Remember to do to the file what is expected (show, save)
    }

    public static void main(String[] args) {
      String firstArg = "";
      Picture input;
      try {
        firstArg = args[0];
        // System.out.println("First argument: " + firstArg);
        input = new Picture(firstArg);
      } catch (ArrayIndexOutOfBoundsException e) {
        input = new Picture(funError(new Picture(500, 500)));
        System.out.println(
            ANSI_RED + "No argument provided!" + ANSI_RESET + " Please provide inpuut in this format" + ANSI_RESET);
        System.out.println("Example: " + ANSI_GREEN + "java A2.java baboon.jpg" + ANSI_RESET);
      }


      String filename = firstArg;
      //System.out.println(filename);
      //StdDraw.setScale(0,input.width());
      //StdDraw.picture(input.width()/2,input.height()/2,filename);
      //StdDraw.show();


        // Read a picture file from the command line
        // Test EACH and ALL of the methods 
        blackAndWhite(input);
        complement(input);
        rotate(input);
        flip(input);
        
        //StdDraw.save("pic1.jpg");


    }
    
    public static Picture funError(Picture pic) { // this function is for fun. It generates a grid of black and magenta squares, similar to a error exture from Gmod.
      
      
      
      Picture tmp = new Picture(pic);
      for (int x = 0; x < pic.width(); x++) {
        for (int y = 0; y < pic.height(); y++) {
          if (((x / 20) + (y / 20)) % 2 == 0) { // 20 is the seize of the squares
            tmp.set(x, y, Color.BLACK);
          } else {
            tmp.set(x, y, Color.MAGENTA);
          }
        }
      }

      return tmp;
    }
}
