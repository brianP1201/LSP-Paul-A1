/**
 * 
 */
package org.howard.edu.lsp.midterm.problem1;

/**
 * @author Brian Paul
 *
 */
public class UnknownCandidateException extends Exception {

	private static final long serialVersionUID = 4903730975920287039L;

	/**
	 * Constructor for UnknownCandidateException object.
	 * 
	 * @param errorMessage - The error message displayed to the console by the
	 *                     Exception.
	 */
	public UnknownCandidateException(String errorMessage) {
		super(errorMessage);

	}

}
