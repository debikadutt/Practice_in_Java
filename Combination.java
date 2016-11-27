package wayfair;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Combination {

	// my implementation

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Hello, World!");
		strings.add("Welcome to CoderPad.");
		strings.add("This pad is running Java 8.");

		Combination sol = new Combination();

		ArrayList<ArrayList<String>> lists = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("quick");
		list1.add("lazy");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("brown");
		list2.add("black");
		list2.add("grey");
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("fox");
		list3.add("dog");

		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		for (Iterator<ArrayList<String>> it = lists.iterator(); it.hasNext();) {
			if (it.next().isEmpty()) {
				it.remove();
			}
		}

		strings = sol.combinations(lists);

		for (String string : strings) {
			System.out.println(string);
		}
	}

	// Algorithm: we keep building partial combinations and store them in a
	// queue, then popping the partial
	// combinations from queue in first come first out way and combine them with
	// another list to build bigger
	// combinations by. We just keep doing this operation until we run out of
	// all the list and we get the final
	// combinations.
	// [a, b], [c, d], [e, f] => [a, b] => [b, ac, ad], [ac, ad, bc, bd] => [ad,
	// bc, bd, ace, acf] ... doing this for
	// ad, bc and bd then we get[ace, acf, ade, adf, bce, bcf, bde, bdf]
	// average length: l; Time complexity: l + l^2 + l^3 + l^4 + l^5 .... + l^n
	public ArrayList<String> combinations(ArrayList<ArrayList<String>> strings) {
		strings.remove(null);
		LinkedList<String> list = new LinkedList<>();
		list.add("");
		for (int i = 0; i < strings.size(); i++) {
			// combine each existing element of list with elements of next
			// string list
			while (list.get(0).split(" ").length == i + 1) {
				String tmp = list.remove();
				for (String str : strings.get(i)) {
					list.add((tmp + " " + str));
				}
			}
		}
		// Remove redundant heading space
		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i).trim());
		}
		return new ArrayList<String>(list);
	}
}
