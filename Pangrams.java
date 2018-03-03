package wayfair;

public class Pangrams {

	public static void main(String[] args) {

		// Scanner sc = new Scanner(System.in);
		String pangramStr = "We promptly judge antique ivory buckles for the next rize  ";

		isPangram(pangramStr);

	}
	// main program

	public static void isPangram(String s) {
		String[] lowerAlpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };
		String[] upperAlpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

		boolean pangram = false;
		int pangramCount = 0;
		for (String lower : lowerAlpha) {
			pangram = s.contains(lower);
			if (!pangram) {
				String upper = upperAlpha[pangramCount];
				pangram = s.contains(upper);
			}
			if (pangram) {
				pangramCount++;
			}
			pangram = false;
		}

		System.out.println("pangramCount : " + pangramCount);

		if (pangramCount == 26) {
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}

	}

}
