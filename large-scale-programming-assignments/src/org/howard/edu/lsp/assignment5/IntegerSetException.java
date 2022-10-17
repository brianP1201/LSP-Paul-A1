package org.howard.edu.lsp.assignment5;

/**
 * Represents the class used to instantiate the IntegerSetException object,
 * which extends the base Exception class.
 *
 */
public class IntegerSetException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for IntegerSetException object.
	 * 
	 * @param errorMessage - The error message displayed to the console by the
	 *                     Exception.
	 */
	public IntegerSetException(String errorMessage) {

		super(errorMessage);

	}

}