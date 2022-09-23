package org.howard.edu.assignment2;

/**
 * @author Brian Paul
 *
 */
public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Combinations test = new Combinations();

		System.out.print("Test 1 (correct case): \n");
		test.compute(new int[] { 1, 2, 3, 4, 5, 6 }, 6);
		System.out.print("Test 2 (empty input array): \n");
		test.compute(new int[] {}, 15);
		System.out.print("Test 3 (invalid sum): \n");
		test.compute(new int[] { 1, 2, 3, 4, 5 }, 16);
		System.out.print("Test 4 (correct case): \n");
		test.compute(new int[] { 5, 5, 15, 10 }, 15);
	}
}
