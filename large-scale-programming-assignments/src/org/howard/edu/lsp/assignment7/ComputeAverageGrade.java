package org.howard.edu.lsp.assignment7;

import java.util.List;

public class ComputeAverageGrade implements AverageStrategy {

	/**
	 * Calculates the average grade for a list of integer numbers.
	 * 
	 * @return The average grade for a list of integer numbers.
	 */
	@Override
	public int compute(List<Integer> grades) throws EmptyListException {

		if (grades.isEmpty()) {
			throw new EmptyListException("This list does not contain any grades.");
		} else if (grades.size() == 1)
			return grades.get(0); // Average of list with 1 element is just the value of the element

		else {
			int sum = 0;
			for (int grade : grades) {
				sum += grade; // Calculate the total sum of all grades
			}
			return (int) Math.round((double) sum / grades.size()); // Calculate and return the average of all grades
		}
	}

}
