package other_array_problems;

public class RemoveDuplicatesII {
	public static int removeDuplicates(int[] A) {
		// remove element if it appears more than twice
		// a = {1,2,3,3,3} --> {1,2,3,3} return 4
		if (A.length <= 2)
			return A.length;
 
		int prev = 1; // point to previous
		int curr = 2; // point to current
 
		while (curr < A.length) {
			if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
				curr++;
			} else {
				prev++;
				A[prev] = A[curr];
				curr++;
			}
		}
 
		return prev + 1;
	}
	
	public static void main(String[] args){
		int[] a = {5,5,6,6,6,6,6,6,7,8,9,9};
		int result = removeDuplicates(a);
		System.out.println(result);
	}

}
