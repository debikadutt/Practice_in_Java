package wayfair;

public class AnagramCheck {

	public static boolean isAnagram(String a, String b) {
		// if both strings are null, is anagram

		if (a.equals(b))
			return true;
		// if any of them is null, or length is not same, not anagram

		if ((a == null || b == null) || (a.length() != b.length()))
			return false;

		char[] aArr = a.toLowerCase().toCharArray();
		char[] bArr = b.toLowerCase().toCharArray();

		// array to hold number of occurrences

		int[] count = new int[26];

		for (int i = 0; i < aArr.length; i++) {
			count[aArr[i] - 97]++;
			count[bArr[i] - 97]--;
		}

		// if strings are anagrams count will be full of zeros

		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				return false;

		}
		return true;

	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "dab";
		System.out.println("Anagram? : " + isAnagram(s1, s2));
	}
}
