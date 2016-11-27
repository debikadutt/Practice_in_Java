package wayfair;

public class LongestPalindrome {
// Dynamic progamming approach which requires O(n^2) time and O(n^2) space
	public static String isPalindrome(String s){
		int n = s.length();
		char[] arr = s.toCharArray();
		int start = 0;
		int maxLen = 1;
		boolean table[][] = new boolean[n][n];
		// all substrings of length 1 are palindromes
		for(int i = 0; i<n; i++){
			table[i][i] = true;
		}
		
		// check for substrings of length 2
		for(int i =0; i< n-1; i++){
			if(arr[i] == arr[i+1]){
				table[i][i+1] = true;
				start = i;
				maxLen = 2;
			}
		}
		
		// check for lengths greater than 2. len is length of substring
		
		for(int len = 3; len <=n; len++){
			// fix the starting index
			for(int i = 0; i < n-len-1; i++){
				int j = i+len-1;
				if(arr[i] == arr[j] && table[i+1][j-1]){
					table[i][j] = true;
					start = i;
					maxLen = len;
				}
			}
		}
		return s.substring(start, start+maxLen);
		
	}
	
	public static void main(String[] args){
		String input = "asdfghssddffggggffddssloinhy";
		System.out.println("The longest palindrome in string is " + isPalindrome(input));
	}
}
