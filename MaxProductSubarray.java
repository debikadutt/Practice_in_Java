package wayfair;

public class MaxProductSubarray {
	public static int maxProduct(int arr[])
	{
		// Time Complexity: O(n)
		// Auxiliary Space: O(1)
		int n = arr.length;
	    // Initialize maximum products in forward and
	    // backward directions
	    int max_fwd = Integer.MIN_VALUE, max_bkd = Integer.MIN_VALUE;
	 
	    // Initialize current product
	    int max_till_now = 1;
	 
	    // max_fwd for maximum contiguous product in
	    // forward direction
	    // max_bkd for maximum contiguous product in
	    // backward direction
	    // iterating within forward direction in array
	    for (int i=0; i<n; i++)
	    {
	        // if arr[i]==0, it is breaking condition
	        // for contiguos subarray
	        max_till_now = max_till_now*arr[i];
	        if (max_till_now == 0)
	        {
	             max_till_now = 1;
	            continue;
	        }
	        if (max_fwd < max_till_now) // update max_fwd
	            max_fwd = max_till_now;
	    }
	 
	     max_till_now = 1;
	 
	    // iterating within backward direction in array
	    for (int i=n-1; i>=0; i--)
	    {
	        max_till_now = max_till_now * arr[i];
	        if (max_till_now == 0)
	        {
	            max_till_now = 1;
	            continue;
	        }
	 
	        // update max_bkd
	        if (max_bkd < max_till_now)
	            max_bkd = max_till_now;
	    }
	 
	    // return max of max_fwd and max_bkd
	    int res =  Math.max(max_fwd, max_bkd);
	 
	    // Product should not be nagative.
	    // (Product of an empty subarray is
	    // considered as 0)
	    return Math.max(res, 0);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, -6, 5, 1, 9, 7, -1, 5 };
		System.out.println(maxProduct(arr));
	}
}
