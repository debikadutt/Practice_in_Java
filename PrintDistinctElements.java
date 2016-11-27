package other_array_problems;

import java.util.Arrays;
import java.util.HashSet;

public class PrintDistinctElements {
	static void printDistinct(int arr[])
    {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
 
        // Traverse the input array
        for (int i=0; i<arr.length; i++)
        {
            // If not present, then put it in hashtable and print it
            if (!set.contains(arr[i]))
            {
                set.add(arr[i]);
                System.out.print(arr[i] + " ");
            }
        }
    }
	
	
	static void printDistinctSort(int arr[])
	{
	    // First sort the array so that all occurrences become consecutive
	    Arrays.sort(arr);
	    int n = arr.length;
	 
	    // Traverse the sorted array
	    for (int i=0; i<n; i++)
	    {
	       // Move the index ahead while there are duplicates
	       while (i < n-1 && arr[i] == arr[i+1])
	          i++;
	 
	       // print last occurrence of the current element
	       System.out.print(arr[i] + " ");
	    }
	}
	
	// Driver method to test above method
    public static void main (String[] args)
    {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        printDistinct(arr);
        System.out.println();
        printDistinctSort(arr);
    }

}
