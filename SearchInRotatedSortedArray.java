package wayfair;

public class SearchInRotatedSortedArray {
	/*
	 * 
	 * The idea is that when rotating the array, there must be one half of the array that is still in sorted order.
	For example, 6 7 1 2 3 4 5, the order is disrupted from the point between 7 and 1. So when doing binary search, 
	we can make a judgement that which part is ordered and whether the target is in that range, 
	if yes, continue the search in that half, if not continue in the other half.
	 */

		public int search(int[] nums, int target) {
	        int start = 0;
	        int end = nums.length - 1;
	        while (start <= end){
	            int mid = (start + end) / 2;
	            if (nums[mid] == target)
	                return mid;
	        
	            if (nums[start] <= nums[mid]){
	                 if (target < nums[mid] && target >= nums[start]) 
	                    end = mid - 1;
	                 else
	                    start = mid + 1;
	            } 
	        
	            if (nums[mid] <= nums[end]){
	                if (target > nums[mid] && target <= nums[end])
	                    start = mid + 1;
	                 else
	                    end = mid - 1;
	            }
	        }
	        return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 29, 31, 39, 40, 43, 55, 89, 86, 78, 66 };
		int target = 55;
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		System.out.println("Element found at index: " + obj.search(arr, target));
	}

}
