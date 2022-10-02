package org.howard.edu.lsp.assignment4.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Brian Paul
 *
 */

public class IntegerSet {

	private List<Integer> set = new ArrayList<>();

	/**
	 * Helper method to return the set element at the specified index.
	 * 
	 * @param index - The set index corresponding to the set element to be
	 *              retrieved.
	 * @return
	 */
	private Integer get(int index) {
		return set.get(index);
	}

	/**
	 * Default constructor for IntegerSet object.
	 */
	public IntegerSet() {

	}

	/**
	 * Clears the internal representation of the set.
	 */
	public void clear() {
		set.clear();
	}

	/**
	 * @return The length of the set.
	 */
	public int length() {
		return set.size();
	}

	/**
	 * @param b - the IntegerSet to be used for comparison.
	 * @return True if the 2 sets are equal, false otherwise.
	 */
	public boolean equals(IntegerSet b) {

		Map<Integer, Boolean> elements = new HashMap<>();
		if (set.size() != b.length())
			return false;

		else {
			for (int num : set)
				elements.put(num, false);

			for (int i = 0; i < b.length(); i++) {
				if (!elements.containsKey(b.get(i))) {
					return false;
				} else {
					elements.replace(b.get(i), true);
				}
			}
			for (boolean val : elements.values()) {
				if (!val)
					return false;
			}
			return true;
		}

	}

	/**
	 * @return The largest item in the set. Throws a IntegerSetException if the set
	 *         is Empty.
	 */
	public int largest() throws IntegerSetException {
		if (set.isEmpty()) {
			throw new IntegerSetException("Set is empty.");
		}
		Collections.sort(set, Collections.reverseOrder());
		return set.get(0);
	}

	/**
	 * @return The smallest item in the set. Throws a IntegerSetException if the set
	 *         is empty.
	 */
	public int smallest() throws IntegerSetException {
		if (set.isEmpty()) {
			throw new IntegerSetException("Set is empty.");
		}
		Collections.sort(set);
		return set.get(0);
	}

	/**
	 * @return True if the set if the set is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}

	/**
	 * Adds an item to the set, or does nothing if it is already in set.
	 * 
	 * @param item - The item to be added to the set.
	 */
	public void add(int item) {
		if (set.contains(item))
			return;
		else
			set.add(item);
	}

	/**
	 * Removes an item from the set, or does nothing if it is not in set.
	 * 
	 * @param item - The item to be removed from the set.
	 */
	public void remove(int item) {
		if (!set.contains(item))
			return;
		else
			set.remove(item);
	}

	/**
	 * @param val - The value to be searched for in the set.
	 * @return True if the set contains the value, otherwise false
	 */
	public boolean contains(int val) {
		return set.contains(val);
	}

	/**
	 * Prints out the set resulting from the union of 2 sets.
	 * 
	 * @param intSetb - The IntegerSet to use in calculation of set union.
	 */
	public void union(IntegerSet intSetb) {
		List<Integer> result = set;
		for (int i = 0; i < intSetb.length(); i++) {
			if (result.contains(intSetb.get(i)))
				continue;
			else
				result.add(intSetb.get(i));
		}
		Collections.sort(result);
		System.out.println(result.toString());
	}

	/**
	 * Prints out the set resulting from the intersection of 2 sets.
	 * 
	 * @param intSetb - The IntegerSet to use in calculation of set intersection.
	 */
	public void intersect(IntegerSet intSetb) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < intSetb.length(); i++) {
			if (set.contains(intSetb.get(i)))
				result.add(intSetb.get(i));
		}
		Collections.sort(result);
		System.out.println(result.toString());
	}

	/**
	 * Prints out the set resulting from the difference of 2 sets.
	 * 
	 * @param intSetb - The IntegerSet to use in calculation of set difference.
	 */
	public void diff(IntegerSet intSetb) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < set.size(); i++) {
			if (!intSetb.contains(set.get(i)))
				result.add(set.get(i));
		}
		Collections.sort(result);
		System.out.println(result.toString());
	}

	/**
	 * Returns the string representation of an IntegerSet.
	 */
	public String toString() {
		return set.toString();
	}

}
