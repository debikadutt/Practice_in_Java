package wayfair;

public class LastWord {
	public static int lengthOfLastWord(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int end = s.length() - 1;
		while (end >= 0 && s.charAt(end) == ' ') {
			end--;
		}

		if (end < 0) {
			return 0;
		}

		int last = end;

		while (end > 0 && s.charAt(end - 1) != ' ') {
			end--;
		}

		return last - end + 1;

	}

	public static int lengthOfLastWordBetter(String s) {
		
		// O(n)
		if (s == null || s.length() == 0) {
			return 0;
		}

		s = s.trim();

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				return s.length() - i - 1;
			}
		}

		return s.length();
	}

	public static void main(String[] args) {
		String input = "fatherytone is angermyth";
		System.out.println(lengthOfLastWord(input));
		System.out.println(lengthOfLastWordBetter(input));

	}
}
