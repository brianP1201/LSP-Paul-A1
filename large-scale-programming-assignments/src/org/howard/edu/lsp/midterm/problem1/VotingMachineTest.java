package org.howard.edu.lsp.midterm.problem1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class VotingMachineTest extends junit.framework.TestCase {

	VotingMachine machine;

	/**
	 * Constructor for VotingMachineTest object.
	 */
	public VotingMachineTest() {

	}

	/**
	 * Instantiation method for VotingMachine object, used across all testing
	 * methods.
	 */
	protected void setUp() {
		machine = new VotingMachine();
	}

	/**
	 * Test case for getVotes method, which returns the number of votes for a
	 * specified candidate.
	 */
	@Test
	@DisplayName("Test case for getVotes Method")
	public void testGetVotes() {
		machine.addCandidate("Bob");

		// Candidates: [Bob, 0 votes]

		try {
			assertEquals(machine.getVotes("Bob"), 0);
		} catch (UnknownCandidateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		machine.addCandidate("Jim");
		machine.castVotes("Jim", 40);

		// Candidates [Bob, 0], [Jim, 40]
		try {
			assertEquals(machine.getVotes("Jim"), 40);
		} catch (UnknownCandidateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Check to see if the UnknownCandidateException is handled properly
		Assert.assertThrows(UnknownCandidateException.class, () -> machine.getVotes("Joe"));

	}

	/**
	 * Test case for sum() method, which returns the total number of votes for all
	 * candidates.
	 */
	@Test
	@DisplayName("Test case for sum method")
	public void testSum() {
		machine.addCandidate("Joe");
		machine.castVotes("Joe", 80);

		assertEquals(machine.sum(), 80); // Total votes should be 80

		machine.addCandidate("Adam");
		machine.castVotes("Adam", 8);

		assertEquals(machine.sum(), 88); // Total votes should be 88

		machine.addCandidate("Ray");
		machine.castVotes("Ray", 52);

		assertEquals(machine.sum(), 140); // Total votes should be 140
	}

}
