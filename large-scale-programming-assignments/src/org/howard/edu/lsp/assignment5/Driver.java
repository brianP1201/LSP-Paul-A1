/**
 * 
 */
package org.howard.edu.lsp.assignment5;

import org.howard.edu.lsp.assignment4.implementation.IntegerSet;
import org.howard.edu.lsp.assignment4.implementation.IntegerSetException;

/**
 * @author Brian Paul
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntegerSet set1 = new IntegerSet();

		set1.add(22);
		set1.add(3);
		set1.add(33);
		set1.add(8);
		set1.add(6);

		IntegerSet set2 = new IntegerSet();
		set2.add(30);
		set2.add(3);
		set2.add(23);
		set2.add(5);
		set2.add(22);

		IntegerSet set3 = new IntegerSet();
		set3.add(7);
		set3.add(89);
		set3.add(8);

		IntegerSet set4 = new IntegerSet();
		set4.add(8);
		set4.add(7);
		set4.add(89);

		System.out.println("Value of set1 is: " + set1.toString());
		System.out.println("Value of set2 is: " + set2.toString());
		System.out.println("Value of set3 is: " + set3.toString());
		System.out.println("Value of set4 is: " + set4.toString());

		System.out.println("Adding value 33 to set 1");
		set1.add(33);
		System.out.println("Value of set1 is: " + set1.toString());

		System.out.println("Attempting to remove value 23 from set2");
		set2.remove(23);
		System.out.println("Value of set2 is: " + set2.toString());

		System.out.println("Length of set1 is: " + set1.length());
		System.out.println("Length of set3: " + set3.length());
		System.out.println("Length of set4: " + set4.length());

		System.out.println("Equality check of set1 and set2: " + set1.equals(set2));
		System.out.println("Equality check of set3 and set4: " + set3.equals(set4));

		try {
			System.out.println("Largest value in set2 is: " + set2.largest());
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("Smallest value in set1 is: " + set1.smallest());
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Checking if set1 contains the value 44: " + set1.contains(44));
		System.out.println("Checking if set2 contains the value 30: " + set2.contains(30));

		set4.clear();
		System.out.println("Set4 has been cleared.");

		System.out.println("Empty check of set4: " + set4.isEmpty());
		try {
			System.out.println("Largest value in set4: " + set4.largest());
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("Smallest value in set4: " + set4.smallest());
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Empty status of set1 is: " + set1.isEmpty());

		System.out.println("Difference of set1-set2: ");
		set1.diff(set2);

		System.out.println("Intersection of set1 and set2: ");
		set1.intersect(set2);

		System.out.println("Result of Union of set 1 and set 2: ");
		set1.union(set2);

	}

}
