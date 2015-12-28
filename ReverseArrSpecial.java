package practice.in.java;

//Driver program to reverse a string with special characters
public class ReverseArrSpecial {
	public static void main(String[] args) {
		System.out.println(reverseString("Ab,c,de!$"));
	}
	
	public static String reverseString(String input) {
		char[] inputArr = input.toCharArray();
		//initialize left and right pointers
		int l = 0;
		int r = input.length() - 1;
		
		//traverse string from both ends until 'l' and 'r'
		while (l < r) {
			if (!Character.isAlphabetic(inputArr[l])) {//ignore special characters
				l++;
			} else if (!Character.isAlphabetic(inputArr[r])) {
				r--;
			} else {//both inputArr[l] and inputArr[r] are not special
				char tempChar = inputArr[l];
				inputArr[l] = inputArr[r];
				inputArr[r] = tempChar;
				l++;
				r--;
			}
		}
		return new String(inputArr);
	}

}
