import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * class responsible for storing the die values and rolling the dice.
 * 
 * @author Harvey Hartwell
 */
public class Hand {
	private ArrayList<Die> dieValues;
	private int handSize;
	private BonusDie bonusDie;
	private int turns;
	
	public Hand(BonusDie bd) {
		// TODO Auto-generated constructor stub
		handSize = 5;
		turns = 3;
		dieValues = new ArrayList<Die>();
		for (int i = 0; i < handSize; i++){
			Die die = new Die();
			dieValues.add(die);
		}
		bonusDie = bd;
		if (bd.getSideUp() == 1){
			setRule();
		}
	}
	
	/**
	 * returns a die at the specified index
	 * @param i index of the die
	 * @return die at index(i).
	 */
	public Die getDie(int i){
			return dieValues.get(i);		
	}
	
	/**
	 * rolls each unselected die.
	 */
	public void rollHand(){
		for (int i = 0; i < handSize; i++){
			if (!dieValues.get(i).getIsKept()){
				dieValues.get(i).rollDie();
			}
		}
	}
	/** 
	 * rolls the bonus die
	 */
	public void rollBonusDie(){
		bonusDie.rollDie();
	}
	/**
	 * returns the hand
	 * @return the hand
	 */
	public Hand getHand(){
		return this;
	}
	
	public BonusDie getBonusDie(){
		return bonusDie;
	}
	public int getHandSize(){
		return handSize;
	}
	public int getTurns(){
		return turns;
	}
	/**
	 * when this is called, a new die is placed in the hand.
	 * pertains to rule 1
	 */
	public void setRule(){
		if (bonusDie.getSideUp() == 1){
			handSize = 6;
			Die d = new Die();
			dieValues.add(d);
		}
		else if(bonusDie.getSideUp() == 4){
			turns = 4;
		}
	}
	/**
	 * when this is called, the last die is removed from the hand.
	 */
	public void resetRule(){
		if (bonusDie.getSideUp() == 1){
			handSize = 5; 
			dieValues.remove(5);
		}
		else if (bonusDie.getSideUp() == 4){
			turns = 3;
		}
	}
	
	/**
	 * This method sorts the values taken from the dice for use
	 * in creating the scoring options.
	 * @param theValuesIn
	 * @return
	 */
	private int[] sortValues(int[] theValuesIn) {
		int[] theValues = theValuesIn;
		boolean swapped;
		do {
			swapped = false;
			for (int d = 0; d < handSize - 1; d++) {
				if(theValues[d] > theValues[d + 1]) {
					int temp = theValues[d];
					theValues[d] = theValues[d + 1];
					theValues[d + 1] = temp;
					swapped = true;
				}
			}
		} while(swapped);
		return theValues;
	}
	
	/**
	 * One of the methods that score hand, that determines the max of a
	 * certain kind of dice in the players hand. The only modification to this
	 * function from assignment one is using variables in the for loops so it would 
	 * work with any size die/hand.
	 */
	public int maxOfAKind() {
		int[] theValues = new int[handSize];
		for (int i = 0; i < handSize; i++) {
			theValues[i] = this.getDie(i).getSideUp();
		}
		sortValues(theValues);
		int maxCount = 0;
		int currentCount;
		for (int dieValue = 1; dieValue <= handSize; dieValue++){
			currentCount = 0;
			for (int diePosition = 0; diePosition < handSize; diePosition++){
				if (theValues[diePosition] == dieValue)
					currentCount++;
			}
			if (currentCount > maxCount)
				maxCount = currentCount;
		}
		return maxCount;	
	}
	
	/**
	 * This method determines the maximum straight(sequence of consecutive dice), the only
	 * modifications to this method from assignment one is using variables in the for
	 * loop to allow the method to work with any amount of dice and any amount of sides
	 * on those dice.
	 */
	public int maxStraight() {
		int[] theValues = new int[handSize];
		for (int i = 0; i < handSize; i++) {
			theValues[i] = this.getDie(i).getSideUp();
		}
		sortValues(theValues);
	    int maxLength = 1;
	    int curLength = 1;
	    for(int counter = 0; counter < (handSize - 1); counter++)
	    {
	        if (theValues[counter] + 1 == theValues[counter + 1]) //jump of 1
	            curLength++;
	        else if ((theValues[counter] + 1) < theValues[counter + 1]) //jump of >= 2
	            curLength = 1;
	        if (curLength > maxLength)
	            maxLength = curLength;
	    }
	    return maxLength;
	}
	
	/**
	 * This method determines whether a full house is found using the method
	 * from the python file that plays a full game of yahtzee. The only thing different
	 * about this method from the first version is that it is modified to work with any
	 * amount of dice/ number of sides on a dice.
	 */
	public boolean fullHouse() {
		int[] theValues = new int[handSize];
		for (int i = 0; i < handSize; i++) {
			theValues[i] = this.getDie(i).getSideUp();
		}
		sortValues(theValues);
		
	    boolean foundFH = false;
	    boolean found3K = false;
	    boolean found2K = false;
	    int currentCount ;
	    int found3KValue = 1;
	    maxOfAKind();
	    if(maxOfAKind() >= 5){
	    	foundFH = true;
	    }
	    if(!foundFH){
	    	for (int dieValue = 1; dieValue <= handSize; dieValue++)
	    	{
	    		currentCount = 0;
	    		for (int diePosition = 0; diePosition < handSize; diePosition++)
	    		{
	    			if (theValues[diePosition] == dieValue)
	    				currentCount++;
	    		}
	    		if (currentCount >= 3){
	    			found3K = true;
	    			found3KValue = dieValue;
	    			break;
	    		}
	    	}
	    	for(int dieValue = 1; dieValue <= handSize; dieValue++){
	    		currentCount = 0;
	    		for(int diePosition = 0; diePosition < handSize; diePosition++){
	    			if(theValues[diePosition] == dieValue)
	    				currentCount++;
	    		}
	    		if(currentCount >= 2 && dieValue != found3KValue){
	    			found2K = true;
	    		}
	    	}
	    	if (found2K && found3K)
	    		foundFH = true;
	    }
	    
	    return foundFH;
	}
	
	/**
	 * 
	 * @param value
	 * @return the sum of all dice of a certain value
	 */
	public int sumOfValue(int value){
		// returns the total sum of passed in value contained in hand
		int sum = 0;
		for (int i = 0; i < handSize; i++){
			if (dieValues.get(i).getSideUp() == value){
				sum += value;
			}
		}
		return sum;
	}
	/**
	 * 
	 * @return total of all dice in the hand.
	 */
	public int totalAllDie(){
		int total = 0;
		for (int i = 0; i < handSize; i++){
			total += dieValues.get(i).getSideUp();
		}
		return total;
	}
	

}
