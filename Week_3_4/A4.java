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
		StdDraw.save("histogram.png");
		StdDraw.clear(); //clears before next plot, otherwise the scarretplot draws ontop the histrogram. StdDraw can only handle one canvas for some dumb reasons.
		drawScatterPlot(salary);
		StdDraw.save("scatterplot.png");
		
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
		int[][] freq = new int[NumericalArrays.uniqueItemsInArray(sortedYears, false)][2]; //uniqueItemsInArray() assumes a sorted array. I think, I don't remeber lmao

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
		//NumericalArrays.printArray(birthYear, true);
		int recWidth = 3; //this is related to the width. this is just a value I chose


		int[][] freq = getBirthYearFreq(birthYear);
		StdDraw.setXscale(0,(5 + (freq.length* (recWidth + 1)))); //black magic, idk how I did this. 
		//System.out.println("max is: " + NumericalArrays.max(NumericalArrays.To1DArray(freq, 1)));
		int peakValue = (NumericalArrays.max(NumericalArrays.To1DArray(freq, 1))*2);
    	StdDraw.setYscale(0 , 1.4 * peakValue); //1.4 to have 20% of padding above and below
	
		// Your code here
		
		double verticalOffset = peakValue * 0.2; //an ofset to make space for the text. 20% of padding

		for (int i = 0; i < freq.length; i++) { //draws the acutal histogram
			int x = 5 + (i* (recWidth + 1));
			StdDraw.filledRectangle(x, (freq[i][1]) + verticalOffset, recWidth/2, freq[i][1]); //draws the rectables
			StdDraw.text((double)x, verticalOffset/2, String.valueOf(freq[i][0]), 90.0); //draws the years in text, rotates 90 degress so they fit under the recatngles
		}
		StdDraw.show();
		

	}

	public static void drawScatterPlot(double [] salary){
		double min = NumericalArrays.min(salary);
		double max = NumericalArrays.max(salary);
		int padding = 10000;
		StdDraw.setXscale(0, salary.length * 1.2); //use 1.2 so I can 10% padding on both sides of the diagram
    	StdDraw.setYscale(min-(padding * 0.1),max + (padding * 0.1)); //black magic, I don't remeber how I did this

		//draw median, it's a constant line acros all points so a rectangle should be fine. no need for a line
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle((salary.length * 1.2)/2, NumericalArrays.average(salary), (salary.length * 1)/2, 20);
		
		//draw standard deviation, it's a constant line acros all points so a rectangle should be fine. no need for a line
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledRectangle(
			(salary.length * 1.2) / 2, 
			NumericalArrays.average(salary) + NumericalArrays.standardDeviation(salary), 
			(salary.length * 1) / 2,
			20
		);
		StdDraw.filledRectangle(
			(salary.length * 1.2) / 2,
			NumericalArrays.average(salary) - NumericalArrays.standardDeviation(salary),
			(salary.length * 1) / 2,
			20
		);
		
		double radius = 1 / ((Math.pow(salary.length, (1 / 1.6)) + 90)); //radius calculated to scale with the ammount of data points. Dunno how it works, I played around with desmos and got something that works
		StdDraw.setPenRadius(radius);
		StdDraw.setPenColor(StdDraw.BLUE);

		//System.out.println("foor loop min and max respectivley is " + min + " " + max);

		for (int i = 0; i < salary.length; i++) { //Print the data points
			//System.out.println(salary[i]);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.setPenRadius(radius);
			//System.out.println(salary[i] + " against " + max + " and " + min);
			if (salary[i] == max || salary[i] == min) { //draw as RED if the current point is max or min
				StdDraw.setPenRadius(radius * 2);
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.point(i + salary.length * 0.1, salary[i]);
			}
			else {
				//otherwise just draw it normally
				StdDraw.point(i + salary.length * 0.1, salary[i]);
			}

		}
		//StdDraw.point(i + salary.length * 0.1, salary[i]);



		StdDraw.show();
	}
}
