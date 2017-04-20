//package goupproject;

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
	private ArrayList<Integer> nsTotal;
	private int diceTotal;
	private int numberOfSides;
	private int numberOfDice;
	private int upperScoreCardSize;
	private ArrayList<Integer> upperScores;
	private ArrayList<Integer> possibleScores;
	private Hand hand_1;
	
	public UpperData(Hand hand_1, BonusDie bonus) {
		super(bonus);
		upperScores = new ArrayList<Integer>();
		nsTotal = new ArrayList<Integer>();
		possibleScores = new ArrayList<Integer>();
		
		this.hand_1 = hand_1;
		for (int i = 0; i < 6; i++){
			upperScores.add(0);
			nsTotal.add(0);
			possibleScores.add(0);
		}
		
	}
	
	public ArrayList<Integer> getPossibleScores(){
		clearPossibleScores();
		for (int i = 0; i < 6; i++){
			possibleScores.add(i, getPossibleScoresPrime(i));
			
		}
		return possibleScores;
	}
	private int getPossibleScoresPrime(int index){
		int score = 0;
		for (int i = 0; i < hand_1.getHandSize(); i++){
			if (hand_1.getDie(i).getSideUp() == index+1){
				score += (index+1);
			}
		}
		//bonus rules
		if (hand_1.getBonusDie().getSideUp() == 2){
			score = score *2;
		}
		if (hand_1.getBonusDie().getSideUp() == 6){
			score = score *3;
		}
		return score;
	}
	
	private void clearPossibleScores(){
		for (int i = 0; i < 6; i++){
			possibleScores.add(i, 0);
		}
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
			for (int diePosition = 0; diePosition < hand_1.getHandSize(); diePosition++) {
				if (hand_1.getDie(diePosition).getSideUp() == i) {
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
	public ArrayList<Integer> getNsTotal() {
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
