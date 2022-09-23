/**
 * 
 */
package org.howard.edu.assignment2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Brian Paul
 *
 */
public class Combinations {

	private boolean[][] sums; // will store true in [i][j] if sum (j) is possible
								// with array elements from 0 to i

	/**
	 * Recursive method to find all valid combinations adding to target sum.
	 * 
	 * @param input      - input array
	 * @param i          - length of input minus 1; represents number of elements
	 * @param target_sum - target sum from original compute function call
	 * @param result     - arrayList to be returned, contains combinations of valid
	 *                   indices
	 */
	public void compute_recursive(int[] input, int i, int target_sum, ArrayList<Integer> result) {

		// End of array reach and sum is not zero. Print only if boolean matrix is true
		// or first element in array is equal to sum.
		if (i == 0 && target_sum != 0 && sums[0][target_sum]) {
			result.add(i);
			Collections.sort(result);
			System.out.println(result);
			result.clear();
			return;
		}
		// If the sum ever becomes 0
		if (i == 0 && target_sum == 0) {
			Collections.sort(result);
			System.out.println(result);
			result.clear();
			return;
		}
		// If the target sum can be reached after ignoring current element
		if (sums[i - 1][target_sum]) {
			ArrayList<Integer> n = new ArrayList<>(); // new arrayList to store path
			n.addAll(result);
			compute_recursive(input, i - 1, target_sum, n);
		}
		// If the target sum can be reached with current array element
		if (target_sum >= input[i] && sums[i][target_sum - input[i]]) {
			result.add(i);
			compute_recursive(input, i - 1, target_sum - input[i], result);
		}

	}

	public void compute(int[] input, int target_sum) {
		if (input.length == 0 || target_sum <= 0)
			return;

		sums = new boolean[input.length][target_sum + 1];
		for (int i = 0; i < input.length; i++) {
			sums[i][0] = true; // Sum of 0; can always be reached with empty array
		}

		if (input[0] <= target_sum) // If sum input[0] can be reached with single element
			sums[0][input[0]] = true;

		// Fill rest of boolean matrix
		for (int i = 1; i < input.length; i++)
			for (int j = 0; j < target_sum + 1; j++) {
				if (input[i] <= j) {
					sums[i][j] = (sums[i - 1][j] || sums[i - 1][j - input[i]]);
				} else {
					sums[i][j] = sums[i - 1][j];
				}
			}
		if (sums[input.length - 1][target_sum] == false) {
			System.out.println("[]"); // No combinations adding to sum
			return;
		}
		// Recursion of boolean matrix to find all paths from sums[input length -
		// 1][target_sum]
		ArrayList<Integer> k = new ArrayList<>();
		compute_recursive(input, input.length - 1, target_sum, k);
	}
}
