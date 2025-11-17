public class A2 {

	public static void main(String[] args) {
		String firstName = args[0].toLowerCase().replace('ö', 'o').replace('ä', 'a').replace('å', 'a');
		String lastName = args[1].toLowerCase().replace('ö', 'o').replace('ä', 'a').replace('å', 'a');
		String admissionYear = args[2].toLowerCase();

		// Modify and complete the following code

		// reduces name and lastname to 3 charakters, but only if above three charackters. Thanks to a Math.min based on the ammount of chatakters in the string (.lenght)
		firstName = firstName.substring(0, Math.min(firstName.length(), 3));
		lastName = lastName.substring(0, Math.min(lastName.length(), 3));

		if (admissionYear.length() > 2) {
			admissionYear = admissionYear.substring(admissionYear.length() - 2); // discards all charakters in strin exepct the last two,.
		}

		String userName = firstName + lastName + admissionYear;
		String email = userName + "@student.hh.se";

		// WARNING! Do not change these lines. Use exactly these strings as your output.

		System.out.println("Username: " + userName);
		System.out.println("E-mail: " + email);
	}
}
