
import java.awt.Color;

public class A1 {

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

        // Implement the complement method
        // Remember to do to the file what is expected (show, save)
    }
    public static void blackAndWhite(Picture pic) {
      Picture newPic = new Picture(pic);
      System.out.println("Make it gray scale");
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
      
      // Implement the rotate method
      // Remember to do to the file what is expected (show, save)
    }
    
    public static void flip(Picture pic) {
      // Implement the flip method
      // Remember to do to the file what is expected (show, save)
    }

    public static void main(String[] args) {
      String filename = args[0];
      Picture input = new Picture(filename);
      System.out.println(filename);
      StdDraw.setScale(0,input.width());
      StdDraw.picture(input.width()/2,input.height()/2,filename);
      //StdDraw.show();


        // Read a picture file from the command line
        // Test EACH and ALL of the methods 
        blackAndWhite(input);
        complement(input);
        
        //StdDraw.save("pic1.jpg");


    }
}
