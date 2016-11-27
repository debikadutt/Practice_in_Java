package wayfair;

public class GetPalindrome {
	// create a palindrome from a given palindrome

	public String getPalindrome(String s) {
		int[] chars = new int[52];
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'A';
			chars[c]++;
		}

		boolean hasOdd = false;
		char oddChar = ' ';

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] % 2 != 0) {
				if (hasOdd) {
					return "Wrong..";
				} else {
					hasOdd = true;
					oddChar = (char) (i + 65);
					chars[i] = 0;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		if (hasOdd) {
			sb.append(oddChar);
		}

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 0) {
				int j = 0;
				while (j < chars[i]) {
					sb.insert(0, (char) (i + 'A'));
					sb.append((char) (i + 'A'));
					j += 2;
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new GetPalindrome().getPalindrome("macbgbcam"));
	}
}
