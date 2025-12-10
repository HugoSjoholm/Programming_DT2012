import java.io.File;
import java.nio.charset.CoderResult;
import java.util.Scanner;

public class Trajectory {

    public static void main(String[] args) {
        
        Scanner data = new Scanner(System.in); // Create a Scanner object
        int dataPoints = Integer.parseInt(data.nextLine());
        
        double minX = 999;
        double minY = 999;
        double maxX = -999;
        double maxY = -999;

        Coordinate[] cords = new Coordinate[dataPoints];
        for (int i = 0; i < cords.length; i++) {
            String dataRow = data.nextLine();
            double latitude = Double.parseDouble(dataRow.substring(0, dataRow.indexOf(' ')));
            double longitude = Double.parseDouble(dataRow.substring(dataRow.indexOf(' '), dataRow.length()));

            Coordinate tmp = new Coordinate(latitude, longitude);
            cords[i] = tmp;
            
            
            if (latitude < minY) {minY = latitude;}
            if (latitude > maxY) {maxY = latitude;}

            if (longitude < minX) {minX = longitude;}
            if (longitude > maxX) {maxX = longitude;}

        }
        data.close();


        StdDraw.setCanvasSize(1000, 1000);
        //sets the scale to the min and max of each axists, and then some padding between the edges and points.
        int padding = 5;
        StdDraw.setXscale(minX - padding, maxX + padding);
        StdDraw.setYscale(minY - padding, maxY + padding);
        //System.out.println("min max for x: " + minX + " " + maxX + "\nmin max for y: " + minY + " " + maxY);

        //draws the first points of the array (halmstad)
        StdDraw.setPenRadius(0.02); //pretend this has a radius of 10 :)
        StdDraw.setPenColor(StdDraw.YELLOW); 
        StdDraw.point(cords[0].getLongitude(), cords[0].getLatitude());
        
        //Draws all other cities
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 1; i < cords.length; i++) {
            StdDraw.point(cords[i].getLongitude(), cords[i].getLatitude());
            //System.out.println(cords[i].getLongitude() + " " + cords[i].getLatitude());
        }

        
        //Draw lines
        StdDraw.setPenRadius(0.002);
        Coordinate[] cordsLeft = clone(cords); //clones all cords into a seperate array which we then remove from when we've drawn a line to that cordinate. 
        Coordinate currentCord = cords[0];  //sets starting cordinate to halmstad cords[] and then
        cordsLeft = removeAt(cordsLeft, 0); //removes the current cord from the pool of possible ones. don't wanna find the closest between the current cordinate and itself
        for (int i = 0; i < cords.length - 1; i++) {
            double minDistance = 9999999; //sets a max distance. we want to find the smalles so we need to compare agsint something big to start with
            int closestsIndex = -1;

            for (int j = 0; j < cordsLeft.length; j++) {
                double d = currentCord.distanceTo(cordsLeft[j]);
                if (d < minDistance) {
                    minDistance = d;
                    closestsIndex = j;
                    //System.out.println("Distance is now: " + d);
                }
            }
            StdDraw.line(
                currentCord.getLongitude(), //current cord x 
                currentCord.getLatitude(), // current cord y
                cordsLeft[closestsIndex].getLongitude(), // closest cord x 
                cordsLeft[closestsIndex].getLatitude() //   closest cord y
            );

            //System.out.println("Draw between" + tmp.getLongitude() + " " + tmp.getLatitude() + " and "
            //        + cordsLeft[closestsIndex].getLongitude() + " " + cordsLeft[closestsIndex].getLatitude());

            currentCord = cordsLeft[closestsIndex]; //sets up next itteration 
            cordsLeft = removeAt(cordsLeft, closestsIndex); //removes the line we just drew to from the pool of possibilites
 
        }
        
        StdDraw.save("trajectory.jpg");
        System.out.println("num of data points: " + dataPoints);

         
    }

    public static void printArray(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(i + " - " + input[i]);
        }
    }
    
    public static void printArray(Coordinate[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(i + " - " + input[i].toString());
        }
    }
    public static Coordinate[] removeAt(Coordinate[] arr, int index) {
        Coordinate[] b = new Coordinate[arr.length - 1];

        for (int i = 0; i < index; i++) {
            b[i] = arr[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            b[i - 1] = arr[i];
        }
        return b;
    }
    public static Coordinate[] clone(Coordinate[] a) {
        Coordinate[] b = a;
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;

    }

}