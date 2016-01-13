package stacks.queues;

public class StringReverserThroughStack {
	private String input;
	private static String output;
	
	public StringReverserThroughStack(String input){
		this.input =input;
	}
	
	public String doReverse(){
		int stackSize = input.length();
		Stack theStack = new Stack(stackSize);
		for(int i=0; i<input.length();i++){
			char ch= input.charAt(i);
			theStack.push(ch);
		}
		output = "";
		while(!theStack.isEmpty()){
			char ch = theStack.pop();
			output = output + ch;
		}
		return output;
	}
	
	public static void main(String[] args){
		String input = "String is being reversed";
		StringReverserThroughStack theReverser = new StringReverserThroughStack(input);
		output = theReverser.doReverse();
		System.out.println(input);
		System.out.println(output);
	}
	
	class Stack{
		int maxsize;
		int top;
		char[] stackArr;
		
		public Stack(int max){
			maxsize = max;
			top=-1;
			stackArr = new char[maxsize];
		}
		
		public void push(char p){
			stackArr[++top]=p;
		}
		
		public char pop(){
			return stackArr[top--];
		}
		
		public char peek(){
			return stackArr[top];
		}
		
		public boolean isEmpty(){
			return top==-1;
		}
	}
	

}
