public class A4{
	public static void main(String[] args) {
		int base10 = Integer.parseInt(args[0]);
		int base = Integer.parseInt(args[1]);
		if (base10 > 0) {
			String num = "";
			String res = "";
			int counter = base10;
			int temp = 0;
			
			// Your code here...

			for (int i = 0; i < num.length(); i++) {
				res = num.charAt(i) + res;
			}

			// WARNING! Do not change these lines. Use exactly these strings as your output.

			System.out.println(base10 + " in base-10 is " + res + " in base-" + base);
		}
	}
}
