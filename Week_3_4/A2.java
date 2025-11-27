import java.util.Scanner;

public class A2 {

	public static void main(String[] args) {

		// We setup a scanner to read the data
		Scanner data = new Scanner(System.in);

		
		
		// Our first line tell us the size of the arrays we have to prepare
		int numDataPoints = Integer.parseInt(data.nextLine());

		// Modify this to declare the arrays correctly
		String[] yearAndPhone = new String[numDataPoints];

		double[] salary = new double[numDataPoints];

		// Read data line by line
		//String currLine = data.nextLine(); //this line messed everything up
		// get the position of the second space
		

		// TASK:
		// Go line by line and fill up the two arrays
			// For each iteration, put the data in the correct index for BOTH arrays
			for (int i = 0; i < numDataPoints; i++) {
				String tmp = data.nextLine();
				int cutPosition = tmp.indexOf(" ", tmp.indexOf(" ") + 1) + 1;
				yearAndPhone[i] = tmp.substring(0, cutPosition);
				salary[i] = Double.parseDouble(tmp.substring(cutPosition));
				//System.out.println("index " + i + " " + yearAndPhone[i] + " " + salary[i]);
			}
		

		// Close the Scanner
		data.close();

		// Sorting value by value
		
		// 1: You will need variables to keep values temporarily, one for the
		//    salary and one for the date and telephone
		//System.out.println(salary.length + " pay attention " + yearAndPhone[19] + salary[19]);

		double swap = 0;
		String swapString = "";
		for (int j = 0; j < salary.length; j++) {
			for (int i = 0; i < salary.length - 1; i++) {
				//System.out.println(i + " has a value of " + salary[i] + ". next in line is " + salary[i+1]);
				
				if (salary[i] > salary[i + 1]) {
					//System.out.println("swap");
				//	System.out.println("swapped " + salary[i] + " and " + salary[i + 1] + " at index " + i + " - " + j);
					swap = salary[i];
					salary[i] = salary[i + 1];
					salary[i + 1] = swap;
					
					swapString = yearAndPhone[i];
					yearAndPhone[i] = yearAndPhone[i+1];
					yearAndPhone[i+1] = swapString;
				//	if (salary[i] == 0.0) {
				//		System.out.println(" ---- " + salary[i] + " at " + i + " with swap of " + swap + ". next in line was " + );
				//	}
				}
			}
			//System.out.println("j - " + j);
		}
	 	//System.out.println("pay attention " + yearAndPhone[0] + salary[0]);

		// You will need to go through each value in the array (how do we traverse an array?)
			// For each value you go through, you go again through the array until you find a value
			// in salaries that is greater than the current one you are reading
			// If that value exists, you store it temporarily, update that index of the arrays
			// with the value that you have and then push back all the other values to higher indexes
			// For example, you are reading index 6 find that salary[5] > salary[6],
			// then you swap both values (salary[6] now has the old value of salary[5])
			// and execute the same process until all values are sorted.

		// Now, you have a set of sorted arrays

		// These lines print out the sorted arrays
		System.out.println(numDataPoints);
		for(int i = 0; i < numDataPoints; i++)
			System.out.println(yearAndPhone[i] + salary[i]);
	}
}