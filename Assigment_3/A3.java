public class A3{
	public static void main(String[] args) {
		int nrOfMatches = Integer.parseInt(args[0]);
		double betHome = Double.parseDouble(args[1]);
		double betAway = Double.parseDouble(args[2]);
		int awayWins = 0;
		int awayTies = 0;
		int awayLoses = 0;
		int homeWins = 0;
		int homeTies = 0;
		int homeLoses = 0;
		int probability = 0;
		double balance = 0;

		// Your code here...


		// WARNING! Do not change these lines. Use exactly these strings as your output.

		System.out.println("Home:" + homeWins + " wins, " + homeTies + " ties, " + homeLoses + " loses");
		System.out.println("Away: " + awayWins + " wins, " + awayTies + " ties, " + awayLoses + " loses");
		System.out.println("Balance: " + balance);
	}
}
