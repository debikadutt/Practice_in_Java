package wayfair;

import java.util.Random;

public class ReservoirSampling {
	
	/*
	 *  1. Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
		2. Now one by one consider all items from (k+1)th item to nth item.
					a) Generate a random number from 0 to i where i is index of current item in stream[]. Let the generated random number is j.
					b) If j is in range 0 to k-1, replace reservoir[j] with stream[i]
	 * 
	 */

	// A function to randomly select k items from stream[0..n-1].
	public static int[] reservoirSampling(int stream[], int k) {
		Random rand = new Random();
		if (stream.length < k) // if you need a sample more than all the
								// elements
			return stream;

		int[] reservoir = new int[k];
		int n = 1;
		for (int i : stream) { // reservoir[] is the output array. Initialize it with
		    					// first k elements from stream[]
			if (n <= k) {
				reservoir[n - 1] = i;
			} else {
				int r = rand.nextInt(n); //  Pick a random index from 0 to i from n.
				if (r < k)					 // If the randomly  picked index is smaller than k, then replace
					reservoir[r] = i;		// the element present at the index with new element from stream
			}
			n++;
		}
		return reservoir;
	}

	public static void main(String args[]) {

		int[] a1 = { 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 11, 12 };
		int[] res = reservoirSampling(a1, 5);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");

	}

}
