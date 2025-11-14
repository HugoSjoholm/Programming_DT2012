public class A4{
	public static void main(String[] args) {
		int base10 = Integer.parseInt(args[0]);
		int base = Integer.parseInt(args[1]);
		if (base10 > 0) {
			String num = "0123456789ABCDEFGHIJKLMNOP";
			String result = ""; //result
			int counter = base10;
			int temp = 0;
			int rest = 0;
			// Your code here...
            
            if (base > 0 && base < 26) {
                rest = 0;
                while (counter > 0) {
					rest = counter % base;
					counter = (int)(counter / base);
					result = num.charAt(rest) + result;
				
				}
            }

			/*for (int i = 0; i < num.length(); i++) {
                
				result = result + num.charAt(i);

            }*/

			// WARNING! Do not change these lines. Use exactly these strings as your output.

			System.out.println(base10 + " in base-10 is " + result + " in base-" + base);
		}
	}
}
