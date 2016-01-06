package arrays.strings;

import java.util.Scanner;

public class StringCompression2 {
	public static String compress(String str) {
		if (str == null) {
			return null;
		} else if (str.length() <= 2) {
			return str;
		}

		StringBuilder sb = new StringBuilder();
		char temp = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (temp == str.charAt(i)) {
				count++;
			} else {
				sb.append(temp);
				sb.append(count);
				temp = str.charAt(i);
				count = 1;
				// if the compress string length >= input string, return the
				// original string
				if (sb.length() >= str.length()) {
					return str;
				}
			}
		}
		// do not forget appending the last character and count to
		// stringBuilder!!!
		sb.append(temp).append(count);

		// Compare the string length with the original one, if greater or equal
		// to original, return original string.
		if (sb.length() >= str.length()) {
			return str;
		} else {
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a string (e to exit): ");

		while (input.hasNextLine()) {
			String inputStr = input.nextLine();
			if (inputStr.equals("e")) {
				System.out.println("exit...");
				System.exit(0);
			}

			System.out.println("The compress String is? :" + compress(inputStr));
			System.out.println();
			System.out.println("Please enter another string: ");
		}
	}
}
