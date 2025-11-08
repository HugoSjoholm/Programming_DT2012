public class A2{

	public static void main(String[] args) {
		String firstName = args[0].toLowerCase().replace('ö', 'o').replace('ä', 'a').replace('å', 'a');
		String lastName = args[1].toLowerCase().replace('ö', 'o').replace('ä', 'a').replace('å', 'a');
		String admissionYear = args[2].toLowerCase();

		// Modify and complete the following code

		String userName = "";
		String email = userName + "@student.hh.se";

		// WARNING! Do not change these lines. Use exactly these strings as your output.

		System.out.println("Username: " + userName);
		System.out.println("E-mail: " + email);
	}
}
