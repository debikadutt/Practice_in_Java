package other_array_problems;

public class MajorityElement {
	// print the element which appears more than n/2 times in an array
	// arr = {2,3,4,4,4,4,4,4,3,3} --> 4 
	// since arr size is 10 and '4' appears 6 times which is greater than 10/2 = 5 < 6
	public static int majorityElement(int[] nums) {
	    int result = 0, count = 0;
	 
	    for(int i = 0; i<nums.length; i++ ) {
	        if(count == 0){
	            result = nums[ i ];
	            count = 1;
	        }else if(result == nums[i]){
	           count++;
	        }else{
	           count--;
	        }
	    }
	 
	    return result;
	}
	
	public static void main(String[] args){
		int[] arr = {1,1,1,1,8,9};
		System.out.println(majorityElement(arr));
	}
	

}
