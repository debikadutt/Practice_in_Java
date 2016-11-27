package wayfair;

public class MaxSubarray {
	public int[] maxSubArr(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}

		int[] res = new int[2];
		// current max
		int local = nums[0];
		// max
		int global = nums[0];
		// temp start
		int tempStart = 0;

		int curr = 1;

		while (curr < nums.length) {
			if (nums[curr] > local + nums[curr]) {
				tempStart = curr;
				local = nums[curr];
			} else {
				local = local + nums[curr];
			}
			if (local > global) {
				global = local;
				res[0] = tempStart;
				res[1] = curr;
			}

			curr++;
		}

		int sum = 0;
		for (int i = res[0]; i <= res[1]; i++) {
			sum += nums[i];
		}
		System.out.println("Max Sum: " + sum);
		return res;
	}
	
	/*
	 * Simple idea of the Kadane's algorithm is to look for all positive 
	 * contiguous segments of the array (max_ending_here is used for this)
	 * And keep track of maximum sum contiguous segment among all positive
	 * segments (max_so_far is used for this). Each time we get a positive 
	 * sum compare it with max_so_far 
	 * and update max_so_far if it is greater than max_so_far
	 * O(n)
	 */
	
	
	public static int maxSubArraySum(int a[])
	{
		int size = a.length;
	   int max_so_far = 0, max_ending_here = 0;
	   for (int i = 0; i < size; i++)
	   {
	       max_ending_here = max_ending_here + a[i];
	       if (max_ending_here < 0)
	           max_ending_here = 0;
	 
	       /* Do not compare for all elements. Compare only   
	          when  max_ending_here > 0 */
	       else if (max_so_far < max_ending_here)
	           max_so_far = max_ending_here;
	   }
	   return max_so_far;
	}

	public static void main(String[] args) {
		int[] test = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] res = new MaxSubarray().maxSubArr(test);
		System.out.println("Kadane’s Algorithm: " + maxSubArraySum(test));
		System.out.println("Starting index: " + res[0]);
		System.out.println("Ending index: " + res[1]);
	}
}
