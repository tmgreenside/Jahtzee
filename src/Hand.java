//package goupproject;

import java.util.ArrayList;

import javax.swing.JLabel;

/**
 * class responsible for storing the die values and rolling the dice.
 * 
 * @author Harvey Hartwell
 *
 */
public class Hand {
	private ArrayList<Die> dieValues;
	private int handSize;
	private BonusDie bonusDie;
	private boolean extraDie = false;
	
	public Hand(BonusDie bd) {
		// TODO Auto-generated constructor stub
		handSize = 5;
		dieValues = new ArrayList<Die>();
		for (int i = 0; i < handSize; i++){
			Die die = new Die();
			dieValues.add(die);
		}
		bonusDie = bd;
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
	
	
	
	/*
	 * from this point on, im not sure if any of this code will be needed, 
	 * but it is here just in case. I will delete it if we dont need it.
	 */
	

	/**
	 * @return the minimum number of dice that are the same
	 */
	public int minOfAKindFound(){
		// returns the minimum amount of numbers that are the same in the hand.
		int minCount = handSize;
		int currentCount;
		for(int val=1; val <= 5; val++){
			currentCount = 0;
			for(int i = 0; i < handSize; i++){
				if(dieValues.get(i).getSideUp() == val){
					currentCount++;
				}
			}
			if(currentCount < minCount && currentCount !=0){
				minCount = currentCount;
			}
		}
		return minCount;
	}
	
	/**
	 * 
	 * @return the maximum number of dice that are the same in the hand
	 */
	public int maxOfAKindFound(){
		// returns the maximum amount of numbers that are the same
		int maxCount = 0;
		int currentCount;
		for(int val = 1; val <= 5; val++){
			currentCount = 0;
			for (int i = 0; i< handSize; i++){
				if(dieValues.get(i).getSideUp() == val){
					currentCount++;
				}
			}
			if (currentCount > maxCount){
				maxCount = currentCount;
			}
		}
		return maxCount;
	}
	/**
	 * 
	 * @return the largest number of consecutive dice
	 */
	public int maxStraightFound(){
		// returns the maximum number of consecutive numbers in the hand.
		int maxLength = 1;
		int curLength = 1;
		for (int i = 0; i < handSize-1; i++){
			if(dieValues.get(i).getSideUp()+1 == dieValues.get(i+1).getSideUp()){
				curLength ++;	
			}
		}
		if (curLength > maxLength){
			maxLength = curLength;
		}
		return maxLength;
	}
	/**
	 * full house is defined as half the hand being the same value and the other half holding a different value.
	 * @return true if a full house is found
	 */
	public boolean fullHouseFound(){
		if (handSize % 2 == 0){
			// the handSize is an even number
			if (minOfAKindFound() == handSize/2){
				return true;
			}
		}
		else {
			if (minOfAKindFound() == handSize/2){
				return true;
			}
		}
		return false;
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
		for (int i = 0; i < 5; i++){
			total += dieValues.get(i).getSideUp();
		}
		return total;
	}

}
