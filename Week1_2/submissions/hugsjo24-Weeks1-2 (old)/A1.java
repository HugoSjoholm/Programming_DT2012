public class A1 {

	private static final int YEAR = 365;
	private static final int MONTH = 30;
	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;

	public static void main(String[] args) {
		int totalHours = Integer.parseInt(args[0]);
		double dailyEffort = Double.parseDouble(args[1]);

		double timeToComplete = totalHours / dailyEffort;

		// Modify and complete the following code
		double amountOfDays = timeToComplete; // Changed variable name to ammouf of days to better represent the value stored

		int years = (int) ((amountOfDays / 365));
		double yearRemainder = (amountOfDays % 365);

		int months = (int) (yearRemainder / 30);
		double monthRemainder = (yearRemainder % 30);

		int days = (int) (monthRemainder);
		double dayRemainder = (monthRemainder - days);

		int hours = (int) (dayRemainder * 24);
		double hoursRemainder = ((dayRemainder * 24) - hours);
		// amountOfDays = 0;

		int minutes = (int) (hoursRemainder * 60);

		// WARNING! Do not modify these outputs. Use these exact strings.
		//System.out.print("amountOfDays = " + amountOfDays);
		System.out.println("Hours to completion: " + totalHours);
		System.out.println("Daily dedication: " + dailyEffort);
		System.out.print("it will take you: ");

		if (years > 0)
			System.out.print(years + " years, ");
		if (months > 0)
			System.out.print(months + " months, ");
		if (days > 0)
			System.out.print(days + " days, ");
		if (hours > 0)
			System.out.print(hours + " hours, ");
		if (minutes > 0)
			System.out.print(minutes + " minutes, ");

		System.out.println();
	}
}