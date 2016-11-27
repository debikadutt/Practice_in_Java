package other_array_problems;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
	// Time complexity: O(nlog(k))
	
	// given [3,2,1,5,6,4] and k = 2, return 5.
	
	/*
	 * We can use a min heap to solve this problem. 
	 * The heap stores the top k elements. 
	 * Whenever the size is greater than k, delete the min. 
	 * Time complexity is O(nlog(k)). 
	 * Space complexity is O(k) for storing the top k numbers.
	 */
	
	public static int findKthLargest(int[] nums , int k){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for(int i: nums){
			q.offer(i);
			
			if(q.size() > k)
				q.poll();
		}
		
		return q.peek();
	}
	
	public static void main(String[] args){
		int[] arr = {3,2, 1, 5, 6, 4};
		System.out.println(findKthLargest(arr, 2));
	}

}
