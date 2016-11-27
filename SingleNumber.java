package wayfair;

import java.util.HashSet;
import java.util.Iterator;


public class SingleNumber {
	
		
		public int singleNumber(int[] nums) {

			if (nums == null || nums.length == 0) {
				return 0;
			}

			int res = 0;

			for(int i=0; i<nums.length; i++){
				res ^= nums[i];
				//System.out.println(res);
			}

			return res;

		}
		
		public int singleNumberIII(int[] A) {
		    int ones = 0, twos = 0, threes = 0;
		    for (int i = 0; i < A.length; i++) {
		        twos |= ones & A[i];
		        ones ^= A[i];
		        threes = ones & twos;
		        ones &= ~threes;
		        twos &= ~threes;
		    }
		    return ones;
		}

		public int singleNumberSet(int[] nums) {

			if (nums == null || nums.length == 0) {
				return 0;
			}

			HashSet<Integer> set = new HashSet<Integer>();
			for (int n : nums) {
				if (!set.add(n))
					set.remove(n);
			}
			Iterator<Integer> it = set.iterator();
			return it.next();
		}
	
		
		public static void main(String[] args){
			int[] arr = {21, 12, 34, 45, 66, 98, 98, 34, 45, 66, 12, 12};
			
			SingleNumber number = new SingleNumber();
			System.out.println(number.singleNumber(arr));
			System.out.println(number.singleNumberSet(arr));
		}
	}


