package wayfair;

public class DutchNatFlagProblem {
	// Time complexity O(n)
	// Dutch National Flag Problem.

	// Sort the input array, the array is assumed to
	// have values in {0, 1, 2}
	static void DutchflagProblem(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) { // continue until mid <= hi
			switch (a[mid]) {
			
			// Examine a[Mid]. There are three possibilities: 
			// a[Mid] is (0) red, (1) white or (2) blue.
			// Case (0) a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++
			case 0: {
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				
				// Case (1) a[Mid] is white(1), Mid++
				mid++;
				break;
			case 2: {
				
				// Case (1) a[Mid] is white, Mid++
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 1, 0, 0, 2, 1, 1, 0, 2, 1, 1, 1, 1, 0 };
		DutchflagProblem(arr, arr.length);
		System.out.println();
	}

}
