package other_array_problems;

import java.util.Stack;

public class ValidParenthesisII {
	// determine the length of the longest valid parenthesis
	// O(n)
	// input = ")()())" output = 4
	public static int longestValidParentheses(String s) {
		Stack<int[]> stack = new Stack<int[]>();
		int result = 0;

		for (int i = 0; i <= s.length() - 1; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				int[] a = { i, 0 };
				stack.push(a);
			} else {
				if (stack.empty() || stack.peek()[1] == 1) {
					int[] a = { i, 1 };
					stack.push(a);
				} else {
					stack.pop();
					int currentLen = 0;
					if (stack.empty()) {
						currentLen = i + 1;
					} else {
						currentLen = i - stack.peek()[0];
					}
					result = Math.max(result, currentLen);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String str = ")()())";
		int result = longestValidParentheses(str);
		System.out.println("Longest Valid Parentheses length is : " + result);
	}

}
