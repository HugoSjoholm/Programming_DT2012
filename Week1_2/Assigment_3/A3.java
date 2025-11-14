public class A3{
	public static void main(String[] args) {
		int nMatches = Integer.parseInt(args[0]);
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
		//i is the index for the current match.
		for(int i=1; i < nMatches; i++) {
			//determine if home or away. 
			double winTieLossChance = Math.random();
			if (i % 2 == 0) {
				//even. away
				//System.out.println("Match nmr " + i + " is away!");
				if (winTieLossChance <= 0.30) {
					awayWins ++;
					balance = balance + (betAway * 3.25);
				}
				else if (winTieLossChance > 0.30 && winTieLossChance < 0.60) {
					awayTies ++;
					balance = balance - betAway;
				}
				else if (winTieLossChance > 0.60) {
					// loss
					awayLoses ++;
					balance = balance - betAway;
				}
				else {
					System.out.println("something went wrong!");
				}
			}
			else {
				//odd. home.
				//System.out.println("Match nmr " + i + " is home!");
				if (winTieLossChance <= 0.66) {
					homeWins ++;
					balance = balance + (betHome * 1.5);
				}
				else if (winTieLossChance > 0.66 && winTieLossChance < 0.90) {
					homeTies ++;
					balance = balance - betHome;
				}
				else if (winTieLossChance > 0.90) {
					homeLoses ++;
					balance = balance - betHome;
				}
				else {
					System.out.println("something went wrong!");
				}
			}
		}
		

		// WARNING! Do not change these lines. Use exactly these strings as your output.

		System.out.println("Home:" + homeWins + " wins, " + homeTies + " ties, " + homeLoses + " loses");
		System.out.println("Away: " + awayWins + " wins, " + awayTies + " ties, " + awayLoses + " loses");
		System.out.println("Balance: " + balance);
	}
}
