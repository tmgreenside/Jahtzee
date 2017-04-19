//package goupproject;
/**
 * The file creates the data implementation for the lower 
 * half of the score card used in a full game of one-player 
 * Jahtzee! that is responsible for storing and displaying
 * the data used by the lower score card and then determines 
 * the score at each possible line. The various operations 
 * that can be performed within the lower data include 
 * finding the max of a kind, max straight, full house, and
 * sum of the dice in hand, and setting and displaying
 * each lower score card line score.
 *
 * @author Carlos Villagomez (cvillagomez)
 * @version Last Changed: 17 April 2017
 * CPSC 224 Group Project
 */

import java.util.*;

public class LowerData extends ScorecardLineData {
	private int maxOfAKind;
	private int maxStraightFound;
	private boolean fullHouseFound;
	private int numberOfSides;
	private int numberOfDice;
	private boolean threeOfKind;
	private boolean twoOfKind;
	private ArrayList<Integer> lowerScores = new ArrayList<>();
	private Hand hand_1;
	
	
	public LowerData(Hand hand_1, BonusDie bonus) {
		super(bonus);
		maxOfAKind = 0;
		maxStraightFound = 0;
		fullHouseFound = false;
		this.hand_1 = hand_1;
		
	}
	
	/**
	 * One of the methods that score hand, that determines the max of a
	 * certain kind of dice in the players hand. The only modification to this
	 * function from assignment one is using variables in the for loops so it would 
	 * work with any size die/hand.
	 */
	public void maxOfAKind() {
		int maxCount = 0;
		int currentCount;
		for (int dieValue = 1; dieValue <= numberOfSides; dieValue++){
			currentCount = 0;
			for (int diePosition = 0; diePosition < numberOfDice; diePosition++){
				if (hand_1.getDie(diePosition).getSideUp() == dieValue)
					currentCount++;
			}
			if (currentCount > maxCount)
				maxCount = currentCount;
		}
		maxOfAKind = maxCount;	
	}
	/**
	 * This method determines the maximum straight(sequence of consecutive dice), the only
	 * modifications to this method from assignment one is using variables in the for
	 * loop to allow the method to work with any amount of dice and any amount of sides
	 * on those dice.
	 */
	public void maxStraight() {
	    int maxLength = 1;
	    int curLength = 1;
	    for(int counter = 0; counter < (numberOfDice - 1); counter++)
	    {
	        if (hand_1.getDie(counter).getSideUp() + 1 == hand_1.getDie(counter + 1).getSideUp() ) //jump of 1
	            curLength++;
	        else if (hand_1.getDie(counter).getSideUp() + 1 < hand_1.getDie(counter + 1).getSideUp()) //jump of >= 2
	            curLength = 1;
	        if (curLength > maxLength)
	            maxLength = curLength;
	    }
	    maxStraightFound = maxLength;
	}
	
	/**
	 * This method determines whether a full house is found using the method
	 * from the python file that plays a full game of yahtzee. The only thing different
	 * about this method from the first version is that it is modified to work with any
	 * amount of dice/ number of sides on a dice.
	 */
	public void fullHouse() {
	    boolean foundFH = false;
	    boolean found3K = false;
	    boolean found2K = false;
	    int currentCount ;
	    int found3KValue = 1;
	    maxOfAKind();
	    if(maxOfAKind >= 5){
	    	foundFH = true;
	    }
	    if(!foundFH){
	    	for (int dieValue = 1; dieValue <= numberOfSides; dieValue++)
	    	{
	    		currentCount = 0;
	    		for (int diePosition = 0; diePosition < numberOfDice; diePosition++)
	    		{
	    			if (hand_1.getDie(diePosition).getSideUp() == dieValue)
	    				currentCount++;
	    		}
	    		if (currentCount >= 3){
	    			found3K = true;
	    			found3KValue = dieValue;
	    			break;
	    		}
	    	}
	    	for(int dieValue = 1; dieValue <= numberOfSides; dieValue++){
	    		currentCount = 0;
	    		for(int diePosition = 0; diePosition < numberOfDice; diePosition++){
	    			if(hand_1.getDie(diePosition).getSideUp() == dieValue)
	    				currentCount++;
	    		}
	    		if(currentCount >= 2 && dieValue != found3KValue){
	    			found2K = true;
	    		}
	    	}
	    	if (found2K && found3K)
	    		foundFH = true;
	    }
	    
	    fullHouseFound = foundFH;
	}
	
	/**
     * This method adds the players score to the 3K line.
     * @param score This integer is the value that will be added to the
     * 3K line of the score card.
     */
	public void addScoreTo3K(int score) {
		lowerScores.set(0, score);
	}

	/**
     * This method adds the players score to the 4K line.
     * @param score This integer is the value that will be added to the
     * 4K line of the score card.
     */
	public void addScoreTo4K(int score) {
		lowerScores.set(1, score);
	}
	
	/**
     * This method adds the players score to the FH line.
     * @param score This integer is the value that will be added to the
     * FH line of the score card.
     */
	public void addScoreToFH(int score) {
		lowerScores.set(2, score);
	}
	
	/**
     * This method adds the players score to the SS line.
     * @param score This integer is the value that will be added to the
     * SS line of the score card.
     */
	public void addScoreToSS(int score) {
		lowerScores.set(3, score);
	}
	
	/**
     * This method adds the players score to the LS line.
     * @param score This integer is the value that will be added to the
     * LS line of the score card.
     */
	public void addScoreToLS(int score) {
		lowerScores.set(4, score);
	}
	
	/**
     * This method adds the players score to the Y line.
     * @param score This integer is the value that will be added to the
     * Y line of the score card.
     */
	public void addScoreToY(int score) {
		lowerScores.set(5, score);
	}
	
	/**
     * This method adds the players score to the C line.
     * @param score This integer is the value that will be added to the
     * C line of the score card.
     */
	public void addScoreToC(int score) {
		lowerScores.set(6, score);
	}
	
	/**
	 * This method retrieves the scores on each line of the lower score card.
	 * @return lowerScores the scores of each line on the lower score card
	 */
	public ArrayList<Integer> getLowerScores() {
		return lowerScores;
	}
}	
