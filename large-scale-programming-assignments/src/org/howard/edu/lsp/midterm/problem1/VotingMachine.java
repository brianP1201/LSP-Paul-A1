/**
 * 
 */
package org.howard.edu.lsp.midterm.problem1;

import java.util.HashMap;

/**
 * @author Brian Paul
 *
 */
public class VotingMachine {

	HashMap<String, Integer> machine = new HashMap<>();

	/**
	 * Constructor for the voting machine object.
	 */
	public VotingMachine() {

	}

	/**
	 * Adds the name of a candidate to the machine, and initializes the number of
	 * votes to 0.
	 * 
	 * @param name - the name of the candidate to be added to the machine.
	 */
	public void addCandidate(String name) {
		machine.put(name, Integer.valueOf(0));
	}

	/**
	 * Cast votes to the candidate with the given name.
	 * 
	 * @param name  - The name of the candidate to cast votes to.
	 * @param votes - The number of votes to cast to the candidate.
	 */
	public void castVotes(String name, int votes) {
		int oldVotes = machine.get(name);

		int newVotes = oldVotes + votes;

		machine.put(name, Integer.valueOf(newVotes));
	}

	/**
	 * @param name - The name of the candidate to retrieve the number of votes.
	 * @return The number of votes for a given candidate.
	 */
	public int getVotes(String name) throws UnknownCandidateException {
		if (!machine.containsKey(name)) {
			throw new UnknownCandidateException("Candidate does not exist.");
		}

		return machine.get(name);
	}

	/**
	 * @return The total number of votes for all candidates.
	 */
	public int sum() {
		int voteSum = 0;

		for (Integer votes : machine.values()) {
			voteSum += votes;
		}

		return voteSum;
	}

}
