/**
 * 
 */
package org.howard.edu.lsp.midterm.problem2;

/**
 * @author Brian Paul
 *
 */
public class Person {

	private String name;
	private int age;
	private String socialSecurityNumber;

	/**
	 * The constructor for the Person object.
	 * 
	 * @param pName - the person's name.
	 * @param pAge  - the person's age.
	 * @param ssn   - the person's SSN.
	 */
	public Person(String pName, int pAge, String ssn) {
		name = pName;
		age = pAge;
		socialSecurityNumber = ssn;
	}

	/**
	 * String representation of the Person object. Overridden from Object class.
	 */
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", SSN: " + socialSecurityNumber;
	}

	/**
	 * Checks to see if 2 Person objects are equal, by comparing the SSN value.
	 * 
	 * @param other - The Person object to be used as comparison.
	 * @return True if the SSN value of both objects are equal, False otherwise.
	 */
	public boolean equals(Person other) {
		return socialSecurityNumber.equals(other.socialSecurityNumber);
	}

}
