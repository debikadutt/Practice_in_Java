package arrays.strings;

public class StringRotation {
	public static void main(String[] args) {
		String[][] pairs = { { "apple", "pleap" }, { "waterbottle", "erbottlewat" }, { "camera", "macera" } };
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean rotation = rotateNow(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + rotation);
		}

	}

	public static boolean rotateNow(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() > 0) {

			return isSubstring(s1 + s1, s2);
		}
		return false;
	}

	public static boolean isSubstring(String s1, String s2) {
		if (s1.indexOf(s2) >= 0)
			return true;
		else
			return false;
	}
}
