package arrays.strings;

public class URLify {
	public static void main(String[] args){
		String str = "Mr John Smith";
		String result = isReplace(str,13);
		System.out.println(result);
	}
	
	public static String isReplace(String s, int a){
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)== ' '){
				sb.append("%20");
			}else{
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}
	

}
