package other_array_problems;

import java.util.HashMap;

//Java implementation using Hashing

public class TwoSum
{
 private static final int MAX = 100000; // Max size of Hashmap

 static void printpairs(int arr[],int sum)
 {
     // Declares and initializes the whole array as false
     boolean[] binmap = new boolean[MAX];

     for (int i=0; i<arr.length; ++i)
     {
         int temp = sum-arr[i];

         // checking for condition
         if (temp>=0 && binmap[temp])
         {
             System.out.println("Pair with given sum " +
                                 sum + " is (" + arr[i] +
                                 ", "+temp+")");
         }
         binmap[arr[i]] = true;
     }
 }
 
 public static int[] twoSum(int[] numbers, int target) {
	 /*
	  * Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.

Space complexity : O(n)O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
	  */
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int[] result = new int[2];
 
	for (int i = 0; i < numbers.length; i++) {
		if (map.containsKey(numbers[i])) {
			int index = map.get(numbers[i]);
			result[0] = index ;
			result[1] = i;
			break;
		} else {
			map.put(target - numbers[i], i);
		}
	}
 
	return result;
    }

 // Main to test the above function
 public static void main (String[] args)
 {
     int A[] = {1, 4, 45, 6, 10, 8};
     int n = 16;
     printpairs(A,  n);
     int[] arr = twoSum(A, n);
     System.out.println("First index: " + arr[0] + " Second index: " + arr[1]);
 }
}

