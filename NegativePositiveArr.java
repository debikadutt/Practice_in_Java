package wayfair;

// Time complexity of this solution is O(n log n), O(Log n) space for recursive calls, 
// and no additional data structure.
public class NegativePositiveArr {

	static int[] arrA;

	public NegativePositiveArr(int[] arrA) {
		NegativePositiveArr.arrA = arrA;
	}

	// Function to rearrange positive and negative numbers in an array
	public void divideGroups(int low, int high) {
		if (low >= high)
			return;
		// int mid = (low + high) / 2;
		// same but avoids overflow
		int mid = low + (high - low) / 2;

		// Sort first and second halves
		divideGroups(low, mid);
		divideGroups(mid + 1, high);

		merge(low, mid, high);

	}

	// Merge two subarrays of arr[]
	// First subarray is arr[low... mid]
	// Second subarray is arr[mid+1... high]
	public void merge(int low, int mid, int high) {
		int i = low; // Initial index of 1st subarray
		int j = mid + 1; // Initial index of 2nd subarray
		// arr[i...mid] is positive
		while (i <= mid && arrA[i] >= 0) // ++++----- //while (l <= mid &&
											// arrA[l] <= 0) // -----++++
			i++;

		// arr[j.. high] is positive
		while (j <= high && arrA[j] >= 0) // while (k <= high && arrA[k] <= 0)
			j++;

		

		// reverse positive part of left sub-array (arr[i..mid])
		reverse(i, mid);

		// reverse negative part of right sub-array (arr[mid+1...j-1])
		reverse(mid + 1, j - 1);

		// reverse arr[i..j-1]
		reverse(i, j - 1);
	}

	// function to reverse an array. An array can be reversed in O(n)
	// time and O(1) space
	public void reverse(int x, int y) {
		while (x < y) {
			int temp = arrA[x];
			arrA[x] = arrA[y];
			arrA[y] = temp;
			++x;
			--y;
		}
	}

	// function to print an array
	public void display() {
		for (int i = 0; i < arrA.length; i++) {
			System.out.print(" " + arrA[i]);
		}
	}

	public static void main(String[] args) {
		arrA = new int[] { 5, -2, -3, 0, 1, -6, 7, -8, 9, -10, -11, -12, 20 };
		NegativePositiveArr r = new NegativePositiveArr(arrA);
		System.out.print("Input : ");
		r.display();
		r.divideGroups(0, arrA.length - 1);
		System.out.println("");
		System.out.print("ReArranged Output : ");
		r.display();
	}
}