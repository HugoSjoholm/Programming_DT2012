public class A1 {

	private static final int YEAR = 365;
	private static final int MONTH = 30;
	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;
	// added by student
	private static boolean overaide = false; // declaring overraid varidable used for debugging, cus I can't make this
												// crap work.
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) {
		if (Integer.parseInt(args[2]) == 1) {
			overaide = true;
			System.out.println(ANSI_RED + "overaide activated" + ANSI_RESET);
		}

		int totalHours = Integer.parseInt(args[0]);
		double dailyEffort = Double.parseDouble(args[1]);

		double amountOfDays = totalHours / dailyEffort;
		if (overaide) {
			amountOfDays = Integer.parseInt(args[0]);
		}

		// Modify and complete the following code

		int years = (int) ((amountOfDays / 365));
		int yearRemainder = (int) (amountOfDays % 365);

		int months = (int) (yearRemainder / 30);
		int monthRemainder = (int) (yearRemainder % 30);

		int days = (int) (monthRemainder / 24);
		int dayRemainder = (int) (monthRemainder % 24);

		int hours = (int) (dayRemainder / 60);
		int hoursRemainder = (int) (dayRemainder % 60);
		// amountOfDays = 0;

		int minutes = (int) hoursRemainder;

		// WARNING! Do not modify these outputs. Use these exact strings.
		System.out.print("amountOfDays " + amountOfDays);
		System.out.print(" - Hours to completion: " + totalHours);
		System.out.println(" - Daily dedication: " + dailyEffort);
		System.out.print("it will take you: ");

		if (true)
			System.out.print(years + " years " + "(" + yearRemainder + "), ");
		if (true)
			System.out.print(months + " months " + "(" + monthRemainder + "), ");
		if (true)
			System.out.print(days + " days " + "(" + dayRemainder + "), ");
		if (true)
			System.out.print(hours + " hours " + "(" + hoursRemainder + "), ");
		if (true)
			System.out.print(minutes + " minutes ");

		System.out.println();
	}
}