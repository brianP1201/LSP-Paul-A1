package org.howard.edu.lsp.assignment7;

import java.util.List;

/**
 * @author Brian Paul
 */
public interface AverageStrategy {
	public int compute(List<Integer> grades) throws EmptyListException;
}
