package wayfair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortedCountII {

	// Driver program
	public static void main(String[] args) {
		int arr[] = new int[] { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
		int n = arr.length;

		sortByFrequency(arr, n);

	}

	private static void sortByFrequency(int[] arr, int n) {
		// TODO Auto-generated method stub
		Map<Integer, Element> frqMap = new HashMap<Integer, Element>();

		for (int i = 0; i < n; i++) {
			if (frqMap.containsKey(arr[i])) {
				Element ele = frqMap.get(arr[i]);
				ele.freq++;
			} else {
				Element ele = new Element(1, i);
				frqMap.put(arr[i], ele);
			}
		}

		Set<Entry<Integer, Element>> sortedset = frqMap.entrySet();

		Comparator<Entry<Integer, Element>> valueComparator = new Comparator<Entry<Integer, Element>>() {

			@Override
			public int compare(Entry<Integer, Element> e1, Entry<Integer, Element> e2) {
				if (e1.getValue().freq == e2.getValue().freq) {
					return e1.getValue().index > e2.getValue().index ? 1 : -1;
				} else {
					return e1.getValue().freq < e2.getValue().freq ? -1
							: e1.getValue().freq > e2.getValue().freq ? 1 : 0;
				}
			}
		};

		// Sort method needs a List, so let's first convert Set to List in
		List<Entry<Integer, Element>> listOfEntries = new ArrayList<Entry<Integer, Element>>(sortedset); // sorting
																											// HashMap
																											// by
		Collections.sort(listOfEntries, valueComparator);
		int j = 0;
		for (Entry<Integer, Element> s : listOfEntries) {
			int i = s.getValue().freq;
			while (i > 0) {
				arr[j++] = s.getKey();
				i--;
			}
		}

		for (int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");

		}
	}

	static class Element {
		int freq;
		int index;

		public Element(int f, int i) {
			freq = f;
			index = i;
		}

	}

}
