package other_array_problems;

import java.util.Stack;

public class StackAsQueue {

	// solution represents for the queue

	// stack to save data as queue
	Stack<Integer> stack = new Stack<>();

	// get the first element
	public int peek() {

		int res = stack.pop();
		stack.push(res);
		return res;

	}

	public int poll() {

		int res = stack.pop();
		return res;

	}

	/**
	 * 
	 * add to the end of the queue
	 * 
	 * add to the top of the stack
	 * 
	 * since we are using stack to save data, we need to add the new number to
	 * the bottom of the stack
	 * 
	 * 
	 * 
	 * @param num
	 */
	public void offer(int num) {

		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty()) {
			temp.push(stack.pop());
		}

		temp.push(num);

		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}

	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		StackAsQueue s = new StackAsQueue();

		// test offer()
		s.offer(17);
		s.offer(22);
		s.offer(34);
		s.offer(76);
		s.offer(88);

		// test empty()
		while (!s.isEmpty()) {
			// test peek()
			System.out.println(s.peek());
			// test poll()
			System.out.println(s.poll());
		}

	}
}
