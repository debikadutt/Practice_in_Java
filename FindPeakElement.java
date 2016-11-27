package wayfair;

public class FindPeakElement {
	// time: O(logn)

	public static int findPeakElement(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int l = 0;
		int r = nums.length - 1;

		while (l < r) {
			// find index of middle element
			int mid = l + (r - l) / 2;
			if (nums[mid] > nums[mid + 1]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		// finally l always equals r
		System.out.println("Peak element: " + nums[l]);
		return l;
	}
	
	public static void main(String[] args){
		int[] arr = {2, 66, 5, 8, 10, 55, 7};
		System.out.println("Index: "+findPeakElement(arr));
		
	}

}
