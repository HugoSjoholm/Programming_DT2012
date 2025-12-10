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

        //printArray(cords);
        StdDraw.setXscale(minX - 5, maxX + 5);
        StdDraw.setYscale(minY - 5, maxY + 5);

        //StdDraw.setXscale(-1, 1);
        //StdDraw.setYscale(-1, 1);

        System.out.println("min max for x: " + minX + " " + maxX + "\nmin max for y: " + minY + " " + maxY);

        StdDraw.setPenRadius(0.02);

        
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.point(cords[0].getLongitude(), cords[0].getLatitude());
        
        
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 1; i < cords.length; i++) { //draw points
            StdDraw.point(cords[i].getLongitude(), cords[i].getLatitude());
            //System.out.println(cords[i].getLongitude() + " " + cords[i].getLatitude());
        }

        StdDraw.setPenRadius(0.002);
        //printArray(cordsLeft);
        
        Coordinate[] cordsLeft = clone(cords);
        
        Coordinate tmp = cords[0];
        double minDistance = 9999999;
        int closestsIndex = -1;
 
        for (int j = 1; j < cordsLeft.length; j++) {
            double d = tmp.distanceTo(cordsLeft[j]);
            if (d < minDistance) {
                minDistance = d;
                closestsIndex = j;
                System.out.println("Distance is now: " + d);
            }
        }
        StdDraw.line(
            tmp.getLongitude(), tmp.getLatitude(),
            cordsLeft[closestsIndex].getLongitude(), cordsLeft[closestsIndex].getLatitude()
        );
        cordsLeft = removeAt(cordsLeft, closestsIndex);
        
        


        
        /*
        
        cordsLeft = removeAt(cordsLeft, 0);
        for (int i = 0; i < cords.length; i++) {
            Coordinate tmp = cords[i];
            double minDistance = 9999;
            int closestsIndex = -1;
            for (int j = 0; j < cordsLeft.length; j++) {
                double d = tmp.distanceTo(cordsLeft[i]);
                if (d < minDistance) {
                    minDistance = d;
                    closestsIndex = j;
                }
            }
            StdDraw.line(
                tmp.getLongitude(), tmp.getLatitude(),
                cordsLeft[closestsIndex].getLongitude(), cordsLeft[closestsIndex].getLatitude()
            );
 
            cordsLeft = removeAt(cordsLeft, closestsIndex);
 
        }
        
        */
        
        




        StdDraw.show();

        // Read the file with coordinates of EU capitals

        // Store them in an array with coordinates

        // Your code here!
        
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