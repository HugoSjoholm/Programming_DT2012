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

		System.out.println(numDataPoints);
		for (int i = 0; i < numDataPoints; i++) {
			// age
				// years
				int age_year = (int) ((Math.random() * 48) + 18 + 1960);

				// month
				int[] daysInMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
				int age_month = (int) (Math.random() * 12 + 0.999); //0.999 to avoid getting 13. If Math.random returns 1 then gets mutiplied by 12 AND THEN you add 1 you get 13. but if you add 0.999 you can't get 13. 
				//age_month = 2;
				String monthOffset = "0";
				if (age_month > 9) {
					monthOffset = "";
				}
				
				// day
				int leapDay = 0;
				if ((age_year % 4 == 0 && age_year % 100 != 0) || (age_year % 400 == 0)) { //checks if it's a leap year with some math
					leapDay = 1;
				}
				int age_day = (int) (Math.random() * daysInMonth[age_month-1] + 1 + leapDay);
				String dayOffset = "0";
				if (age_day > 9) {
					dayOffset = "";
				}
			
			//telefone
				String phone = "07";
				String tmp = "" + (Math.random());
				tmp = tmp.split("\\.")[1];
				tmp = tmp.substring(0,8);
				//System.out.println("tmp is " + tmp);
				phone = phone + tmp;

			//salary
				int salaryButLocal = (int)(((Math.random() * (maxSalary - minSalary)) + minSalary)*100);
				double salaryRounded = (double)(salaryButLocal/100.0);

				String salaryOffset = "";
				if(String.valueOf(salaryRounded).substring(5).length() < 3) {
					salaryOffset = "0";
				}

			if (commaSeperated) {
				System.out.println(age_year + "-" +  monthOffset + age_month + "-" + dayOffset + age_day + "," + phone + "," + salaryRounded + salaryOffset);
			}
			else {
				System.out.println(age_year + "-" + monthOffset + age_month + "-" + dayOffset + age_day + " " + phone + " " + salaryRounded + salaryOffset);
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
