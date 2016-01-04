package arrays.strings;

public class OneAway {
	public static void main(String[] args){
		String s1 = "pale";
		String s2 = "bal";
		boolean result = checkDistance(s1, s2);
		System.out.println(result);
	}
	
	
	public static boolean checkDistance(String s1, String s2){
		if(Math.abs(s1.length()-s2.length())>1)//if the diff is greater than one char return false
			return false;
		int[] s1_count = new int[256];//assuminng ASCII values
		int[] s2_count = new int[256];
		
		int diff=0;
		
		for(int i=0; i<s1.length(); i++){//compute the int value of the first string
			int val = s1.charAt(i);
			s1_count[val]++;
		}
		
		for(int i=0; i<s2.length(); i++){//compute the int value of the second string
			int val =s2.charAt(i);
			s2_count[val]++;
		}
		
		for(int i=0; i< 256; i++){
			
			diff += Math.abs(s1_count[i]- s2_count[i]);//if the difference between two strings is greater than 2 return false
		}
		return diff<=2;	
	}

}
