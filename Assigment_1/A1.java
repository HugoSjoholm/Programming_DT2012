public class A1 {

	private static final int YEAR = 365;
	private static final int MONTH = 30;
	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;
	// added by student
	private static boolean overaide = false; // declaring overraid varidable used for debugging
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void main(String[] args) {
		try { // ignore this, debug mode
			if (Integer.parseInt(args[2]) == 1) {
				overaide = true;
				System.out.println(ANSI_RED + "overaide activated" + ANSI_RESET);
			}
		} catch (Exception e) { // do nothing
		}

		int totalHours = Integer.parseInt(args[0]);
		double dailyEffort = Double.parseDouble(args[1]);

		double amountOfDays = totalHours / dailyEffort; // Changed variable name to ammouf of days to better represent
														// the value stored
		if (overaide) {
			amountOfDays = Integer.parseInt(args[0]);
		}

		// Modify and complete the following code

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
		System.out.print("amountOfDays = " + amountOfDays);
		System.out.print(" - Hours to completion: " + totalHours);
		System.out.println(" - Daily dedication: " + dailyEffort);
		if (overaide) {
			if (true)
				System.out.print(ANSI_GREEN + years + " years " + "+ " + yearRemainder + " days, ");
			if (true)
				System.out.print(months + " months " + "+ " + monthRemainder + " days, ");
			if (true)
				System.out.print(days + " days " + "(" + dayRemainder + "), ");
			if (true)
				System.out.print(hours + " hours " + "(" + hoursRemainder + "), ");
			if (true)
				System.out.println(minutes + " minutes ");
		} else {
			System.out.print("it will take you: ");

			if (years > 0)
				System.out.print(ANSI_GREEN + years + " years, ");
			if (months > 0)
				System.out.print(months + " months, ");
			if (days > 0)
				System.out.print(days + " days, ");
			if (hours > 0)
				System.out.print(hours + " hours, ");
			if (minutes > 0)
				System.out.println(minutes + " minutes ");
		}

		System.out.println(ANSI_RESET + " - ");
	}
}