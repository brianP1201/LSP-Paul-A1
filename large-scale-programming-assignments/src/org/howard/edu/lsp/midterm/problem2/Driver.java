/**
 * 
 */
package org.howard.edu.lsp.midterm.problem2;

/**
 * @author BNP12
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person("name1", 21, "111-11-1111");
		Person p2 = new Person("name2", 22, "111-11-1111");
		Person p3 = new Person("name3", 23, "222-22-2222");

		if (p1.equals(p2)) {
			System.out.println("Person objects p1 and p2 are the same!"); // in this case, they would be the same
		} else {
			System.out.println("Person objects p1 and p2 are NOT the same!");
		}

		if (p1.equals(p3)) {
			System.out.println("Person objects p1 and p3 are the same!"); // in this case, they would NOT be the same
		} else {
			System.out.println("Person objects p1 and p3 are NOT the same!");
		}

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());

	}

}
