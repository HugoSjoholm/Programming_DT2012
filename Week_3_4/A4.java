import java.util.Scanner;

public class A4{
	public static void main(String[] args) {
		Scanner data = new Scanner(System.in);
		int numDataPoints = Integer.parseInt(data.nextLine());
		int[] birthYear = new int[numDataPoints];
		int[] phoneNumber = new int[numDataPoints];
		double[] salary = new double[numDataPoints];
		
		System.out.println("begin: " + numDataPoints);
		readData(data, birthYear, phoneNumber, salary, numDataPoints);
		System.out.println("Done");
		drawHistogram(birthYear);
		drawScatterPlot(salary);
		/*	
			for (int i = 0; i < salary.length; i++) {
				System.out.println(i + " - " + birthYear[i] + " " + phoneNumber[i] + " " + salary[i]);
			}
		 */
	}

	public static void readData(Scanner data, int[] birthYear, int[] phoneNumber, double[] salary, int numDataPoints) {
		String currLine = data.nextLine();
		int secondDelimPos = currLine.indexOf(" ", currLine.indexOf(" ") + 1) + 1;
		int firstDelimPos = currLine.indexOf(" ") + 1;

		for (int i = 0; i < numDataPoints; i++) {
			birthYear[i] = Integer.parseInt(currLine.substring(0, currLine.indexOf("-")));
			phoneNumber[i] = Integer.parseInt(currLine.substring(firstDelimPos, secondDelimPos - 1));
			salary[i] = Double.parseDouble(currLine.substring(secondDelimPos, currLine.length()));

			if (data.hasNextLine())
				currLine = data.nextLine();
		}
		data.close();
	}

	public static int[][] getBirthYearFreq(int[] birthYear){
		System.out.println("getBirthYearFreq() started");
		int[] sortedYears = NumericalArrays.sortArr(birthYear);
		int[][] freq = new int[NumericalArrays.uniqueItemsInArray(sortedYears, true)][2];
		//NumericalArrays.printArray(sortedYears, true);
		//NumericalArrays.printArray(sortedYears, true);
		if (true) { //used for scope so I can have int j only exist here
			int j = 0;
			freq[j][0] = sortedYears[0];
			for (int i = 0; i < sortedYears.length - 1; i++) {
				if (sortedYears[i] != sortedYears[i + 1]) {
					freq[j][0] = sortedYears[i];
					j++;
				}
			}
		}
		//NumericalArrays.printArray(freq, true);
		//System.out.println("YOOOOO");
		
		for (int i = 0; i < freq.length; i++) {
			int ammountOfCopies = 0;
			for (int j = 0; j < sortedYears.length; j++) {
				if (freq[i][0] == sortedYears[j]) {
					ammountOfCopies++;
				}
			}
			freq[i][1] = ammountOfCopies;
		}
		//NumericalArrays.printArray(freq, true);

		// Your code here
				
		return freq;
	}
	
	public static void drawHistogram(int[] birthYear){
		StdDraw.setXscale(0,birthYear.length + 10);
    	StdDraw.setYscale(0,100);
		StdDraw.show();

		//NumericalArrays.printArray(birthYear, true);

		int[][] freq = getBirthYearFreq(birthYear);
		NumericalArrays.printArray(freq, true);

		System.out.println("HELLOW?!?!??!? ---------------------- ");


		int x = 5;

		// Your code here
		StdDraw.filledRectangle(x, x, x, x);

	}

	public static void drawScatterPlot(double [] salary){
		int min = (int) NumericalArrays.min(salary);
		int max = (int) NumericalArrays.max(salary);
		int padding = 10000;
		StdDraw.setXscale(min-padding,max+padding);
    	StdDraw.setYscale(min-padding,max+padding);
		StdDraw.show();
		
		// Your code here

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(min, NumericalArrays.average(salary), max, 100);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(min, NumericalArrays.median(salary), max, 100);

	}
}
