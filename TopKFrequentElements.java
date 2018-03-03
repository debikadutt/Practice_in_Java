package other_array_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer>[] bucket = new List[(nums.length) + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6,
				6, 6, 6 };
		List<Integer> list = topKFrequent(nums, 3);
		for (int d : list)
			System.out.print(d + " ");

	}
}