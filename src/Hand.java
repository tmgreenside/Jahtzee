package goupproject;

import java.util.ArrayList;

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
	
	public Hand() {
		// TODO Auto-generated constructor stub
		handSize = 5;
		dieValues = new ArrayList<Die>();
		for (int i = 0; i < handSize; i++){
			Die die = new Die();
			dieValues.add(die);
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
				System.out.println(dieValues.get(i).getSideUp());
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
}
