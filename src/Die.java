package goupproject;

import java.util.*;


/**
 * This class extends JLabel to display Yahtzee dice images
 * on the screen. Other methods return just its value as an
 * integer and also simulate rolling it to display a new
 * value.
 * @author Trevor Greenside
 * @version Last Changed: 4 April 2017
 */
public class Die {

	private static final long serialVersionUID = 1L;
	protected int diceValue;
	protected boolean isKept; 
	
	public Die() {
		rollDie(); 
		isKept = false;
	}
	
	/**
	 * This method uses the Random utility to
	 * assign a new random integer as the value of
	 * this.value.
	 */
	public void rollDie() {
		Random myRoller = new Random();
		this.diceValue = myRoller.nextInt(6) + 1;
		
	}
	
	/**
	 * Get the die's value as an integer.
	 * @return
	 */
	public int getSideUp () {
		return this.diceValue;
	}
	
	/**
	 * Get the boolean value telling whether this die will
	 * be rerolled.
	 * @return
	 */
	public boolean getIsKept() {
		return isKept;
	}
	
	/**
	 * This method changes the isKept value to the value
	 * passed in when called.
	 * @param kept
	 */
	public void setIsKept(boolean kept) {
		isKept = kept;
	}
}
