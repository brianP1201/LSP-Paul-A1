package org.howard.edu.lsp.assignment7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class AverageGradeTest extends junit.framework.TestCase {

	ComputeAverageGrade computeRegular;
	ComputeAverageGradeDropTwoLowest computeDropTwoLowest;

	public AverageGradeTest() {

	}

	protected void setUp() {
		computeRegular = new ComputeAverageGrade();
		computeDropTwoLowest = new ComputeAverageGradeDropTwoLowest();
	}

	@Test
	@DisplayName("Test case for ComputeAverageGrade compute method")
	public void testComputeRegular() {
		List<Integer> test = new ArrayList<>();
		Collections.addAll(test, 99, 70, 90, 95, 87);
		// Expected average of 88.2, should round to and return 88
		try {
			assertEquals(computeRegular.compute(test), 88);
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.clear(); // Grade list is now empty, should throw an Empty List Exception
		Assert.assertThrows(EmptyListException.class, () -> computeRegular.compute(test));

		test.add(89);
		// Expected average of 89
		try {
			assertEquals(computeRegular.compute(test), 89);
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Collections.addAll(test, 88, 100, 62, 66, 83);
		// Grade list is [89, 88, 100, 62, 66, 83]; average of 81.3, should round to and
		// return 81
		try {
			assertEquals(computeRegular.compute(test), 81);
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("Test case for ComputeAverageGradeDropTwoLowest compute method")
	public void testComputeAverageDropTwoLowest() {

		List<Integer> test = new ArrayList<>();
		Collections.addAll(test, 81, 68, 80, 93, 89, 64);

		// Should disregard two lowest marks of 64 and 68; average of 85.75 which should
		// round to and return 86
		try {
			assertEquals(computeDropTwoLowest.compute(test), 86);
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.clear(); // List is now empty, should throw EmptyListException
		Assert.assertThrows(EmptyListException.class, () -> computeDropTwoLowest.compute(test));

		Collections.addAll(test, 88, 87); // List contains less than 3 elements, so if 2 are dropped list will be empty.
											// Should throw an EmptyListException
		Assert.assertThrows(EmptyListException.class, () -> computeDropTwoLowest.compute(test));
		
		Collections.addAll(test, 79, 70, 70, 70, 78);
		// Should disregard 2 lowest marks of 70; average of 80.4 which should return 80
		try {
			assertEquals(computeDropTwoLowest.compute(test), 80);
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
