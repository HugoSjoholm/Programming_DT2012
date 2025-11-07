public class A1 {

	private static final int YEAR = 365;
	private static final int MONTH = 30;
	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;

	public static void main(String[] args) {
		int totalHours = Integer.parseInt(args[0]);
		double dailyEffort = Double.parseDouble(args[1]);

		double amountOfDays = totalHours / dailyEffort;

		// Modify and complete the following code

		int years = (int) ((amountOfDays / 365));
		double yearRemainder = (amountOfDays % 365);

		int months = (int) (yearRemainder / 30);
		double monthRemainder = (yearRemainder % 30);

		int days = (int) (monthRemainder / 24);
		double dayRemainder = (monthRemainder % 24);

		int hours = (int) (dayRemainder / 60);
		double hoursRemainder = (dayRemainder % 60);
		// amountOfDays = 0;

		int minutes = (int) hoursRemainder;

		// WARNING! Do not modify these outputs. Use these exact strings.
		System.out.println("amountOfDays " + amountOfDays);
		System.out.println("Hours to completion: " + totalHours);
		System.out.println("Daily dedication: " + dailyEffort);
		System.out.print("it will take you: ");

		if (true)
			System.out.print(years + " years, ");
		if (true)
			System.out.print(months + " months, ");
		if (true)
			System.out.print(days + " days, ");
		if (true)
			System.out.print(hours + " hours, ");
		if (true)
			System.out.print(minutes + " minutes, ");

		System.out.println();
	}
}