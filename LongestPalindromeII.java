package wayfair;

public class LongestPalindromeII {

	public static String longestPalindrome(String s) {

		String longest = s.substring(0, 1);

		// One by one consider every character as center point of
		// even and length palindromes
		for (int i = 0; i < s.length(); i++) {

			// Find the longest even length palindrome with center points
			// as i and i.
			String temp = helper(s, i, i);
			if (temp.length() > longest.length())
				longest = temp;

			// Find the longest odd length palindrome with center points
			// as i and i+1.
			temp = helper(s, i, i + 1);
			if (temp.length() > longest.length())
				longest = temp;

		}
		return longest;
	}

	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

	public static void main(String[] args) {
		String input = "asdfghssddffggggffddssloinhy";
		System.out.println("The longest palindrome in string is " + longestPalindrome(input));
	}
}
