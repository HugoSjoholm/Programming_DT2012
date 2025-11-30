import javax.swing.text.html.HTMLDocument.BlockElement;

public class NumericalArrays {
  
  //Returns the smallest value in the array of doubles it gets as argument.
  public static double min(double[] numarray) {
    double min = numarray[0];
    
    for (int i = 0; i < numarray.length; i++) {
      if (numarray[i] < min) {
        min = numarray[i];
      }
    }



    // Compare every value in numarray to max, if the value is smaller
    // than min, replace min!
    
    return min;
  }

  
  //Returns the largest value in in the array of doubles it gets as argument.
  public static double max(double[] numarray) {
    double max = numarray[0]; //why was this set to Double.MIN_VALUE???? this is useless, just set it to something???. 
    
    for (int i = 0; i < numarray.length; i++) {
      if (numarray[i] > max) {
        max = numarray[i];
      }
    }

    // Compare every value in numarray to max, if the value is greater
    // than max, replace max!

    return max;
  }

  
  //Returns the smallest value in in the array of ints it gets as argument.
  public static int min(int[] numarray) {
    int min = numarray[0];
    
    for (int i = 0; i < numarray.length; i++) {
      if (numarray[i] < min) {
        min = numarray[i];
      }
    }

    return min;
  }

  
  //Returns the largest value in in the array of ints it gets as argument.
  
  public static int max(int[] numarray) {
    int max = Integer.MIN_VALUE;
    
    // Compare every value in numarray to max, if the value is greater
    // than max, replace max!

    return max;
  }

  
  //Returns the addition of all the values in he array of doubles it gets as argument.
  
  public static double sum(double[] numarray) {
    double sum = 0;
    
    for (int i = 0; i < numarray.length; i++) {
      sum = sum + numarray[i];
    }


    // Go through every element in the array and add it to sum

    return sum;
  }

  
  //Returns the addition of all the values in the array of ints it gets as argument.
  
  public static int sum(int[] numarray) {
    int sum = 0;
    
    // Go through every element in the array and add it to sum
    
    return sum;
  }

  
  //Returns the median of all the values in the array of ints it gets as argument.
  public static double median(double[] numarray) {
    double median = 0;
    double swap = 0;

    numarray = sortArr(numarray);

    if ((numarray.length % 2) != 0) {
      median = numarray[(int)(numarray.length/2)];
    }
    else {
      double tmp = numarray[(int)(numarray.length / 2) - 1] +  numarray[(int)(numarray.length / 2)];
      median = tmp / 2;
    }

    // Your code here

    return median;
  }



public static double[] sortArr(double[] numarray) {
  double swap = 0;
  for (int j = 0; j < numarray.length; j++) {
    for (int i = 0; i < numarray.length - 1; i++) {
      // System.out.println(i + " has a value of " + salary[i] + ". next in line is "
      // + salary[i+1]);

      if (numarray[i] > numarray[i + 1]) {
        // System.out.println("swap");
        // System.out.println("swapped " + salary[i] + " and " + salary[i + 1] + " at
        // index " + i + " - " + j);
        swap = numarray[i];
        numarray[i] = numarray[i + 1];
        numarray[i + 1] = swap;

        
      }
    }
    // System.out.println("j - " + j);
  }
  return numarray;
}
public static int[] sortArr(int[] numarray) {
  int swap = 0;
  for (int j = 0; j < numarray.length; j++) {
    for (int i = 0; i < numarray.length - 1; i++) {
      // System.out.println(i + " has a value of " + salary[i] + ". next in line is "
      // + salary[i+1]);

      if (numarray[i] > numarray[i + 1]) {
        // System.out.println("swap");
        // System.out.println("swapped " + salary[i] + " and " + salary[i + 1] + " at
        // index " + i + " - " + j);
        swap = numarray[i];
        numarray[i] = numarray[i + 1];
        numarray[i + 1] = swap;

        
      }
    }
    // System.out.println("j - " + j);
  }
  return numarray;
}
  
  //Returns the mode of the values in the array of ints it gets as argument. //wtf is a mode???? why is there no explenation
  public static int mode(int[] numarray) {
    int mode = 0;
    int maxCopies = 0;

    for (int i = 0; i < numarray.length; i++) {
      int copies = 0;
      for (int j = 0; j < numarray.length; j++) {
        if (numarray[i] == numarray[j]) {
          copies++;
        }
      }
      if (copies > maxCopies) {
        maxCopies = copies;
        mode = numarray[i];
      }
    }

    // Your code here

    return mode;
  }

  
  //Returns the average of the values in the array of doubles it gets as argument.
  
  public static double average(double[] numarray) {
    
    double tmp = 0;

    /*for (int i = 0; i < numarray.length; i++) {
      tmp = tmp + numarray[i];
    }
    tmp = tmp / numarray.length;
    */
    tmp = sum(numarray) / numarray.length;
    // Hint: use the sum() method and the size of the array
    // and return the sum of the values of numarray divided
    // by numarray.length

    return tmp;
  }

  
  //Returns the number of equal elements of the values in the array of ints it gets as argument.
  public static int numEqualElements(int[] numarray) {
    int same = 0;
    
    // Your code here
    for (int i = 0; i < numarray.length; i++) {
      for (int j = i + 1; j < numarray.length; j++) {
        if (numarray[i] == numarray[j] && numarray[i] > 0) {
          //System.out.println(numarray[i] + " " + numarray[j]);
          same++;
          numarray[j] = 0;
        }
      }
    }



    return same;
  }

  
  //Returns the standard deviation of the values in the array of doubles it gets as argument. 
  public static double standardDeviation(double[] numarray) {
    double avrg = average(numarray);
    double variance = 0;
    
    for (int i = 0; i < numarray.length; i++) {
      double tmp = numarray[i] - avrg;
      variance += tmp * tmp;
    }
    variance = variance / (numarray.length - 1);
    // Your code here

    return Math.sqrt(variance);
  }

  
  //Returns the dot product between two arrays of doubles of the same length.
  //The arguments are two arrays of doubles, a and b, that have the same number of elements.
  //The result is the dot product: a0*b0 + a1*b1 + ... + an*bn
  public static double dotproduct(double[] a, double[] b) {
    double sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum = sum + a[i] * b[i];
    }
    return sum;
  }

  /*
    Plots the elements of the array as points using the course books StdDraw.
    For each element in the array we draw a point with the position in the array
    as x-value and the value in that position as y-value.
    The scale is set to: on the x-dimension [-1, length] and on the
    y-dimension [minimum in array - 0.1, maximum in array + 0.1].
    The pen colour and the pen radius are set by the program that uses this
    method,
    they should not be set in the method.
   */
  public static void plot(double[] numarray) {
    double min = min(numarray);
    double max = max(numarray);
    StdDraw.setXscale(-1, numarray.length);
    StdDraw.setYscale(min - 0.1, max + 0.1);
    for (int i = 0; i < numarray.length; i++) {
      StdDraw.point(i, numarray[i]);
    }
  }

  /*
    Plots the elements of the array as points using the course books StdDraw.
    For each element in the array we draw a point with the position in the array
    as x-value and the value in that position as y-value.
    The scale is set to: on the x-dimension [-1, length] and on the
    y-dimension [minimum in array - 1, maximum in array + 1].
    The pen colour and the pen radius are set by the program that uses this
    method,
    they should not be set in the method.
   */
  public static void plot(int[] numarray) {
    int min = min(numarray);
    int max = max(numarray);
    StdDraw.setXscale(-1, numarray.length);
    StdDraw.setYscale(min - 1, max + 1);
    for (int i = 0; i < numarray.length; i++) {
      StdDraw.point(i, numarray[i]);
    }
  }
  public static double roundToTwoDeciaml(double num) {
    int tmp = (int)(num * 100.0);
    double rounded = tmp / 100.0;
    return rounded;
  }
  public static void printArray(int[] arr, boolean newLine) {
    if (newLine) {
      for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
      }
    }
    else {
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]);
      }
    }
  }
  public static void printArray(int[][] arr, boolean newLine, int y) {
    if (newLine) {
      for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i][y]);
      }
    } else {
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i][y]);
      }
    }
  }
  public static void printArray(int[][] arr, boolean newLine) {
    if (newLine) {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
          System.out.print(arr[i][j] + " ");
        }
        System.out.print("\n");
      }
    } else {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
          System.out.print(arr[i][j] + " ");
        }
      }
    }
  }
  public static int uniqueItemsInArray(int[] arr, boolean printResult) {
    int uniqueCount = 0;

    if (arr.length == 0) {
      return 0;
    }
    int previous = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[i - 1]) {
        
        uniqueCount++;
      }
    }
    if (printResult) {System.out.println(uniqueCount);}

    return uniqueCount;
  }
}


