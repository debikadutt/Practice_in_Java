package arrays.strings;

import java.util.HashSet;

public class UniqueChecker {

	public static void main(String[] args) {

		String str = "dEdika";
		UniqueChecker uc = new UniqueChecker();
		boolean result = uc.isUnique2(str);
		if (result)
			System.out.println("The string has all unique characters");
		else
			System.out.println("The string does not have all all unique characters");

	}

	public boolean isUnique(String str) {
		HashSet<Character> set = new HashSet<Character>(str.length());
		for (char c : str.toCharArray()) { // iterate through the character
											// array
			if (!set.add(Character.toUpperCase(c)))// try to add char to HashSet
				return false;//if unable to add to HashSet return false
		}
		return true;//the array has unique chars
	}

	public boolean isUnique2(String str) {
		boolean[] strSet = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);//assigning each char to an int to store its ASCII value
			if (strSet[val])//if its already true
				return false;//we have a duplicate

			strSet[val] = true;//else set the char value to true	
		}
		return true;//no duplicates found
	}
}
