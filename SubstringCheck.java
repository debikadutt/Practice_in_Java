package wayfair;

public class SubstringCheck {
	static boolean IsSubstring(String s, String t) {
		for (int i = 0; i <= (s.length() - t.length()); i++) {
			boolean found = false;

			for (int j = 0; found && j < t.length(); j++) {
				if (s.charAt(i + j) != t.charAt(j))
					found = false;
			}

			if (found)
				return true;
		}

		return false;
	}
	
	public static void main(String[] args){
		System.out.println(IsSubstring("abcdefaasdabcdef" , "abcdef"));
	}
}
