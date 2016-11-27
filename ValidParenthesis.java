package wayfair;

import java.util.Stack;

public class ValidParenthesis {
	// O(n)

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.push('(');
				break;
			case '{':
				stack.push('{');
				break;
			case '[':
				stack.push('[');
				break;
			case ')':
				if (stack.size() == 0 || stack.pop() != '(')
					return false;
				break;
			case '}':
				if (stack.size() == 0 || stack.pop() != '{')
					return false;
				break;
			case ']':
				if (stack.size() == 0 || stack.pop() != '[')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String input = "{([{(({))}])}";
		boolean answer = isValid(input);
		System.out.println(answer);
	}
}