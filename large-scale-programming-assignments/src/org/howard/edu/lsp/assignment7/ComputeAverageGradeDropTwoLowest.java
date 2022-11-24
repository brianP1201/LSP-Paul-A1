package org.howard.edu.lsp.assignment7;

import java.util.Collections;
import java.util.List;

public class ComputeAverageGradeDropTwoLowest implements AverageStrategy {

	/**
	 * Calculates the average grade for a list of integer numbers, while dropping
	 * the 2 lowest scores.
	 * 
	 * @return The average grade for a list of integer numbers, with the 2 lowest
	 *         scores dropped.
	 */
	@Override
	public int compute(List<Integer> grades) throws EmptyListException {
		if (grades.size() <= 2) {
			throw new EmptyListException("The list is either empty or does not contain at least 3 grades.");
		}
		int sum = 0;
		Collections.sort(grades); // Sort list of grades from least to greatest

		for (int i = 0; i < 2; i++) { // Loop through list of grades and remove least 2 elements
			grades.remove(0);
		}
		for (int grade : grades) {
			sum += grade; // Calculate the sum of all remaining grades
		}
		return (int) Math.round((double) sum / grades.size()); // Calculate and return the average of all remaining
																// grades
	}

}
