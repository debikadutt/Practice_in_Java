package arrays.strings;


import java.util.HashSet;

public class PalinPermutation {
	public static void main(String[] args){
		String s = "tactcopppa";
		boolean result = isPalinPerm(s);
		if (result)
			System.out.println("true");
		else
			System.out.println("false");

	}
	
	public static boolean isPalinPerm(String str){
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<str.length(); i++){
			if(!set.add(str.charAt(i)))
				set.remove(str.charAt(i));
		}
		return set.size()<=1;
	}
	

}
