import java.util.Scanner;

public class A2 {

	public static void main(String[] args) {

		// We setup a scanner to read the data
		Scanner data = new Scanner(System.in);

		// Our first line tell us the size of the arrays we have to prepare
		int numDataPoints = Integer.parseInt(data.nextLine());

		// Modify this to declare the arrays correctly
		String[] yearAndPhone = new String[numDataPoints];
		int[] salary = new int[numDataPoints];

		// Read data line by line
		String currLine = data.nextLine();
		// Analize: what does this line do?
		int cutPosition = currLine.indexOf(" ", currLine.indexOf(" ") + 1) + 1;

		// TASK:
		// Go line by line and fill up the two arrays
			// For each iteration, put the data in the correct index for BOTH arrays

		// Close the Scanner
		data.close();

		// Sorting value by value
		
		// 1: You will need variables to keep values temporarily, one for the
		//    salary and one for the date and telephone
		int swap = 0;
		String swapString = "";

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