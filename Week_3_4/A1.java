public class A1 {

	public static void main(String[] args) {
		int numDataPoints = Integer.parseInt(args[0]);
		String dateOfBirth = "";
		int phoneNumber = 0;
		int salary = 0;

		int minYear = 0;
		int maxYear = 0;
		int maxSalary = 39000;
		int minSalary = 28800;

		//fun stuff. ignore this if you're grading
		boolean commaSeperated = false;
		try {
			commaSeperated = args[1].equals("c");
		}
		catch (Exception e) {
			//System.out.println("normal seperator");
		}

		System.out.println("Number of data points " + numDataPoints);
		for (int i = 0; i < numDataPoints; i++) {
			// age
				// years
				int age_year = (int) ((Math.random() * 48) + 18 + 1960);

				// month
				int[] daysInMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
				int age_month = (int) (Math.random() * 12 + 1);
				age_month = 2;
				// day
				int leapDay = 0;
				if ((age_year % 4 == 0 && age_year % 100 != 0) || (age_year % 400 == 0)) { //checks if it's a leap year with some math
					leapDay = 1;
				}
				int age_day = (int) (Math.random() * daysInMonth[age_month-1] + 1 + leapDay);
			
			//telefone
				String phone = "07";
				phone = phone + (int)(Math.random() * Math.pow(10, 8));

			//salary
				int salaryButLocal = (int)(((Math.random() * (maxSalary - minSalary)) + minSalary)*100);
				double salaryRounded = (double)(salaryButLocal/100.0);

			if (commaSeperated) {
				System.out.println(age_year + "-" + age_month + "-" + age_day + "," + phone + "," + salaryRounded);
			}
			else {
				System.out.println(age_year + "-" + age_month + "-" + age_day + " " + phone + " " + salaryRounded);
			}
		}

		// Print the number of data points
		// System.out.println(numDataPoints);

		// Generate and print all the data points
		// For each datapoint:
		// Print the birthdate and a space

		// On the same line, print the telephone number and a space

		// On the same line, print the random salary in SEK without öre and break the
		// line

	}
}
