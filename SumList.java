/*Following example demonstrates how to add first n natural numbers by using the concept of stack. */

package linkedList;

import java.io.IOException;

public class SumList {
	static int num;
	static int ans;
	static Stack theStack;

	public static void main(String[] args) throws IOException {
		num = 10;
		stackAddition();
		System.out.println("Sum=" + ans);
	}

	public static void stackAddition() {
		theStack = new Stack(100);
		ans = 0;
		while (num > 0) {
			theStack.push(num);
			num--;
		}
		while (!theStack.isEmpty()) {
			int n = theStack.pop();
			ans += n;
		}

	}
}

class Stack {
	private int top;
	private int maxsize;
	private int data[];

	public Stack(int s) {
		top = -1;
		maxsize = s;
		data = new int[maxsize];
	}

	public void push(int p) {
		data[++top] = p;
	}

	public int pop() {
		return data[top--];
	}

	public int peek() {
		return data[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}
