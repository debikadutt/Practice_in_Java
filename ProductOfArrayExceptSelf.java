package other_array_problems;

public class ProductOfArrayExceptSelf {
	/**
	 * 
	 * Brute force way TLE
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int left = 1;
			int right = 1;

			for (int l = 0; l < i; l++) {
				left *= nums[l];
			}

			for (int r = i + 1; r < nums.length; r++) {
				right *= nums[r];
			}

			nums[i] = left * right;
		}

		return nums;
	}

	public int[] productExceptSelfInplace(int[] nums) {

		if (nums == null || nums.length == 0) {
			return nums;
		}

		int[] res = new int[nums.length];
		res[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		int temp = 1;
		for (int i = nums.length - 1; i >= 0; i--) {

			res[i] = res[i] * temp;
			temp = temp * nums[i];
		}

		return res;

	}

	public int[] productExceptSelfGeniues(int[] nums) {

		if (nums == null || nums.length == 0) {
			return nums;
		}
		int[] leftPro = new int[nums.length];

		leftPro[0] = 1;

		int temp = 1;

		for (int i = 1; i < nums.length; i++) {

			leftPro[i] = nums[i - 1] * temp;

			temp = leftPro[i];
		}

		int rightPro = 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			temp = nums[i];
			nums[i] = leftPro[i] * rightPro;
			rightPro *= temp;
		}

		return nums;

	}

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 4, 5 };
		int[] res = new ProductOfArrayExceptSelf().productExceptSelfGeniues(test);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");

	}

}
