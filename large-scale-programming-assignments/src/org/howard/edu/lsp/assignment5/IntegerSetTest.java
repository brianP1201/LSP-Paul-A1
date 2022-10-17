/**
 * 
 */
package org.howard.edu.lsp.assignment5;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @author Brian Paul
 *
 */
public class IntegerSetTest extends junit.framework.TestCase {

	IntegerSet set1;

	/**
	 * Default constructor for IntegerSetTest object.
	 */
	public IntegerSetTest() {
	}

	/**
	 * Instantiation method for IntegerSet object, that is used across all testing
	 * methods.
	 */
	protected void setUp() {
		set1 = new IntegerSet();
	}

	/**
	 * Test method for IntegerSet() equals() method, which checks if two IntegerSet
	 * objects are equal.
	 */
	@Test
	@DisplayName("Test case for equals method")
	public void testEquals() {
		// JUnit test case(s) for equals
		IntegerSet set2 = new IntegerSet();

		set1.add(5);
		set1.add(1);
		set1.add(11); // Set1 = [5, 1, 11]

		set2.add(5);
		set2.add(1);
		set2.add(11); // Set2 = [5, 1, 11]

		assertTrue(set1.equals(set2)); // Result of equals call should be true
		set2.remove(5); // Removing 5 from set2; set2 now = [1, 11]

		assertFalse(set1.equals(set2)); // Result of equals call should be false

		set2.add(2); // Adding 2 to set2; set2 now = [1, 11, 2]
		assertFalse(set1.equals(set2)); // Result of equals call should be false

		set2.clear(); // Cleared set2; set2 now = []
		assertFalse(set1.equals(set2)); // Result of equals call should be false

		set1.clear(); // Cleared set1; set1 now = []
		assertTrue(set1.equals(set2));

		set1.add(7);
		set1.add(3); // Set1 = [7,3]

		set2.add(3);
		set2.add(7); // Set2 = [3, 7]

		assertTrue(set1.equals(set2)); // Result of equals call should be true

	}

	/**
	 * Test method for IntegerSet() clear() method, which removes all elements from
	 * an IntegerSet object.
	 */
	@Test
	@DisplayName("Test case for clear method")
	public void testClear() {
		set1.add(0);
		set1.add(4);
		set1.add(3); // Set1 = [0, 4, 3]

		set1.clear(); // Clearing set1

		assertEquals(set1.length(), 0); // If set is cleared correctly, set should be empty, and have a length of .
		assertTrue(set1.isEmpty());

	}

	/**
	 * Test case for IntegerSet() length() method, which returns the number of
	 * elements in the set. (no duplicates)
	 *
	 */
	@Test
	@DisplayName("Test case for length method")
	public void testLength() {
		assertEquals(set1.length(), 0); // Set1 is empty ([]), length should be 0

		set1.add(5);
		set1.add(2);
		set1.add(3); // Set1 = [5, 2, 3]

		assertEquals(set1.length(), 3); // Length of set1 should return 3

		set1.add(5); // Set1 should remain unchanged [5, 2, 3]
		assertEquals(set1.length(), 3); // Length should return 3 as 5 should not be added to set, as it would be a
										// duplicate

		set1.remove(2); // Removing element 2 from set1; set1 = [5, 3]

		assertEquals(set1.length(), 2); // Length should return 2 after an element has been removed
	}

	/**
	 * Test case for IntegerSet() largest() method, which returns the largest
	 * element in a set.
	 */
	@Test
	@DisplayName("Test case for largest method")
	public void testLargest() {
		set1.add(3);
		set1.add(9);
		set1.add(44); // Set1 = [3, 9, 44]

		try {
			assertEquals(set1.largest(), 44); // Largest should return 44
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		set1.add(99); // Set1 = [3, 9, 44, 99]
		try {
			assertEquals(set1.largest(), 99); // Largest should return 44
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		set1.clear(); // Set1 now cleared []
		Assert.assertThrows(IntegerSetException.class, () -> set1.largest()); // Set is empty, IntegerSetException
																				// should be thrown
	}

	/**
	 * Test case for smallest method, which returns the smallest element in an
	 * IntegerSet.
	 */
	@Test
	@DisplayName("Test case for smallest method")
	public void testSmallest() {
		set1.add(7);
		set1.add(21);
		set1.add(12);
		set1.add(14); // Set1 = [7, 21, 12, 14]

		try {
			assertEquals(set1.smallest(), 7); // Smallest should return 7
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		set1.remove(7); // Removing element 7 from set1; set1 now = [21, 12, 14]
		try {
			assertEquals(set1.smallest(), 12); // Smallest should return 12
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		set1.add(-5); // Added element -5; set1 now = [21, 12, 14, -5]
		try {
			assertEquals(set1.smallest(), -5); // Smallest should return -5
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		set1.clear(); // Set1 now cleared []
		Assert.assertThrows(IntegerSetException.class, () -> set1.smallest()); // Set is empty, IntegerSetException
																				// should be thrown
	}

	/**
	 * Test case for contains methods, which checks if an IntegerSet contains a
	 * specified element.
	 */
	@Test
	@DisplayName("Test case for contains method")
	public void testContains() {
		set1.add(5);
		set1.add(11);
		set1.add(26);
		set1.add(24);
		set1.add(45);

		assertTrue(set1.contains(45)); // 45 is an element in the set; should return True
		assertFalse(set1.contains(99)); // 99 is NOT an element in the set; should return False

		set1.clear(); // set1 is cleared now empty
		assertFalse(set1.contains(22)); // 22 is NOT an element; set is Empty should return False

	}

	/**
	 * Test case for add method, which adds an element to the IntegerSet, unless it
	 * is already in the set.
	 */
	@Test
	@DisplayName("Test case for add method")
	public void testAdd() {
		set1.add(1);
		set1.add(2);
		set1.add(3); // Set1 = [1, 2, 3]

		assertTrue(set1.toString().equals("[1, 2, 3]")); // to test, check if string representation is correct
		set1.add(2); // 2 should NOT be added as this would result in duplicate values
		assertTrue(set1.toString().equals("[1, 2, 3]")); // to test, check if string representation is correct

		set1.add(5); // Added element 5; set1 now = [1, 2, 3, 5]
		assertTrue(set1.toString().equals("[1, 2, 3, 5]"));
	}

	/**
	 * Test case for remove method, which removes an element from the IntegerSet,
	 * unless the element is not in the set.
	 */
	@Test
	@DisplayName("Test case for remove method")
	public void testRemove() {
		set1.add(0);
		set1.add(2);
		set1.add(4);

		set1.remove(2); // removing element 2; set1 now = [0, 4]
		assertTrue(set1.toString().equals("[0, 4]"));
		set1.remove(0);
		set1.remove(4); // remove elements 0 and 4; set1 is now empty
		assertTrue(set1.toString().equals("[]")); // test if String representation is an empty set

		set1.remove(22); // Attempting to remove from Empty set; nothing should occur
		assertTrue(set1.toString().equals("[]")); // test if String representation is an empty set

	}

	/**
	 * Test case for isEmpty method, which checks if an IntegerSet is empty.
	 */
	@Test
	@DisplayName("Test case for isEmpty method")
	public void testIsEmpty() {
		assertTrue(set1.isEmpty()); // Set1 is currently empty; isEmpty should return True

		set1.add(-4);
		set1.add(4);

		assertFalse(set1.isEmpty()); // Set1 = [-4, 4]; isEmpty should return False
		set1.clear();

		assertTrue(set1.isEmpty()); // Set1 is cleared, now empty; isEmpty should return False

	}

	/**
	 * Test case for union method, which calculates the union set of two
	 * IntegerSets.
	 */
	@Test
	@DisplayName("Test case for union method")
	public void testUnion() {
		final PrintStream standardOut = System.out; // Keep track of default output PrintStream to avoid clashing with
		// other testing methods
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); // Define new output PrintStream
		// that holds printLn from
		// IntegerSet void methods

		System.setOut(new PrintStream(outputStreamCaptor)); // Change output stream from default for void method testing
		// purposes

		set1.add(0);
		set1.add(3);
		set1.add(9); // Set1 = [0, 3, 9]

		IntegerSet set2 = new IntegerSet();
		set1.union(set2); // Union with empty set should result in [0, 3, 9]
		assertEquals("[0, 3, 9]", outputStreamCaptor.toString().trim());
		outputStreamCaptor.reset(); // Clear testing output stream

		set2.add(4);
		set2.add(6);
		set2.add(3); // Should not be in union twice; would result in duplicate items
		set1.union(set2);
		assertEquals("[0, 3, 4, 6, 9]", outputStreamCaptor.toString().trim());

		System.setOut(standardOut); // Set output stream back to default to avoid errors with other testing methods
	}

	/**
	 * Tests the intersect method, which prints the intersection set of two
	 * IntegerSets.
	 */
	@Test
	@DisplayName("Test case for Intersect method")
	public void testIntersect() {
		final PrintStream standardOut = System.out; // Keep track of default output PrintStream to avoid clashing with
													// other testing methods
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); // Define new output PrintStream
																						// that holds printLn from
																						// IntegerSet void methods

		System.setOut(new PrintStream(outputStreamCaptor)); // Change output stream from default for void method testing
															// purposes

		set1.add(0);
		set1.add(3);
		set1.add(9); // Set1 = [0, 3, 9]

		IntegerSet set2 = new IntegerSet();
		set1.intersect(set2); // Intersection with empty set should result in []
		assertEquals("[]", outputStreamCaptor.toString().trim());
		outputStreamCaptor.reset(); // Clear testing output stream

		set2.add(9);
		set2.add(3); // Set2 = [9, 3]
		set1.intersect(set2); // Intersection set should be [3, 9]
		assertEquals("[3, 9]", outputStreamCaptor.toString().trim());

		System.setOut(standardOut); // Set output stream back to default to avoid errors with other testing methods
	}

	/**
	 * Tests the difference method, which calculates the difference of two
	 * IntegerSets.
	 */
	@Test
	@DisplayName("Test case for Diff method")
	public void testDiff() {
		final PrintStream standardOut = System.out; // Keep track of default output PrintStream to avoid clashing with
		// other testing methods
		final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); // Define new output PrintStream
		// that holds printLn from
		// IntegerSet void methods

		System.setOut(new PrintStream(outputStreamCaptor)); // Change output stream from default for void method testing
		// purposes

		set1.add(0);
		set1.add(3);
		set1.add(9); // Set1 = [0, 3, 9]

		IntegerSet set2 = new IntegerSet();
		set1.diff(set2); // Difference with empty set should result in [0, 3, 9]
		assertEquals("[0, 3, 9]", outputStreamCaptor.toString().trim());
		outputStreamCaptor.reset(); // Clear testing output stream

		set2.add(3);
		set2.add(0); // Set2 = [3, 0]; Difference with set1 should be [9]
		set1.diff(set2);
		assertEquals("[9]", outputStreamCaptor.toString().trim());

		System.setOut(standardOut); // Set output stream back to default to avoid errors with other testing methods
	}

	/**
	 * Test the toString method, which prints the String representation of an
	 * IntegerSet object.
	 */
	@Test
	@DisplayName("Test case for toString method")
	public void testToString() {
		set1.add(4);
		set1.add(44);
		set1.add(444);

		assertEquals(set1.toString(), ("[4, 44, 444]")); // Check if the String returned by toString matches the expected output

		set1.clear();
		assertEquals(set1.toString(), ("[]")); // Set1 now empty, check if the empty set notation is returned correctly by ToString.
	}

}
