/**
 * The file creates the data implementation for the upper 
 * half of the score card used in a full game of one-player 
 * Jahtzee! that is responsible for storing and displaying
 * the data used by the upper score card and then determines 
 * the score at each possible line. The various operations 
 * that can be performed within the upper data include scoring 
 * each row of the upper score card based on the number of sides
 * on the die, generating each line of the upper score card,
 * adding a score to specific line on the upper score card,
 * and displaying each upper score card line score.
 *
 * @author Carlos Villagomez (cvillagomez)
 * @version Last Changed: 17 April 2017
 * CPSC 224 Group Project
 */

import java.util.ArrayList;

public class UpperData extends ScorecardLineData {
	private ArrayList<Integer> nsTotal = new ArrayList<>();
	private int diceTotal;
	private int numberOfSides;
	private int numberOfDice;
	private int upperScoreCardSize;
	private ArrayList<Integer> upperScores = new ArrayList<>();
	private Hand hand_1;
	
	public UpperData(Hand hand_1) {
		this.hand_1 = hand_1;
	}
	
	/**
	 * This method is used to score the upper half of the score card, it scores
	 * each row of the upper score card based on the number of sides on a die, it
	 * then adds those values to the array list nsTotal to later on be used by the score
	 * card lines class.
	 * 
	 * @param numberOfSides integer value that corresponds to the number of sides on 
	 * the dice currently being used.
	 * @param numberOfDice integer value that corresponds to the number of dice currently
	 * being played with.
	 */
	public void nsTotal (int numberOfSides, int numberOfDice) {
		for (int i = 1; i < numberOfSides + 1; i++) {
			int currentCount = 0;
			for (int diePosition = 0; diePosition < numberOfDice; diePosition++) {
				if (hand_1.get(diePosition) == i) {
					currentCount++;
				}
			}
			nsTotal.add(currentCount * i);
		}
	}
	
	/**
	 * This method is the getter for nsTotal, it gets the array list holding the scores
	 * for each line of the upper score card.
	 * 
	 * @return Returns an array list of integers that contains all the scores
	 * for the upper score card.
	 */
	public ArrayList getNsTotal() {
		return nsTotal;
	}
	
	/**
	 * This method adds a score to a certain line of the upper score card.
	 * 
	 * @param line This parameter corresponds to the line that the score
	 * needs to be added to.
	 * @param score This parameter corresponds to the score that needs to be
	 * added to the that line of the score card. 
	 */
	public void addScoreToLineN(int line, int score) {
		upperScores.set(line - 1, score);
	}
	
	/**
	 * This method retrieves the scores on each line of the lower score card.
	 * 
	 * @return lowerScores the scores of each line on the lower score card
	 */
	public ArrayList<Integer> getUpperScores() {
		return upperScores;
	}
	
	
}