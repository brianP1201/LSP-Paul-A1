package org.howard.edu.lsp.assignment7;

public class EmptyListException extends Exception {

	private static final long serialVersionUID = -2568545212858570574L;

	/**
	 * Constructor for EmptyListException object.
	 * 
	 * @param errorMessage - The error message displayed to the console by the
	 *                     Exception.
	 */
	public EmptyListException(String errorMessage) {
		super(errorMessage);
	}
}
