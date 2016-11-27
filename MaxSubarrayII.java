package wayfair;

public class MaxSubarrayII {
	public static int maxSubArr(int[] nums) {

		int size = nums.length;
		int[] subarray = new int[size];

		subarray[0] = nums[0];
		int max = subarray[0];

		for (int i = 1; i < size; i++) {
			if (subarray[i - 1] > 0) {
				subarray[i] = subarray[i - 1] + nums[i];
			} else {
				subarray[i] = nums[i];
			}
			if (subarray[i] > max) {
				max = subarray[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {

		int[] test = { -11, -2, -3, 14, 5, 6, -7, -8, -9 };

		// int[] res = new MaxSubarray().maxSubArr(test);

		// for(int i=0; i< res.length; i++)
		// System.out.println(res[i]);
		int output = maxSubArr(test);
		System.out.println(output);

	}
}
