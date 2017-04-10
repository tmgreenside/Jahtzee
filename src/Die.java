import java.util.*;
import javax.swing.*;

/**
 * This class extends JLabel to display Yahtzee dice images
 * on the screen. Other methods return just its value as an
 * integer and also simulate rolling it to display a new
 * value.
 * @author Trevor Greenside
 * @version Last Changed: 25 March 2017
 */
public class Die extends JLabel {

	private static final long serialVersionUID = 1L;
	private int diceValue;
	private boolean isKept; 
	
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
		setImage();
	}
	
	/**
	 * Use the die's value to change the image displayed by
	 * this object as a JLabel.
	 */
	private void setImage() {
		switch(diceValue) {
		case 1:
			this.setIcon(new ImageIcon("images/dice1.png"));
			break;
		case 2:
			this.setIcon(new ImageIcon("images/dice2.png"));
			break;
		case 3:
			this.setIcon(new ImageIcon("images/dice3.png"));
			break;
		case 4:
			this.setIcon(new ImageIcon("images/dice4.png"));
			break;
		case 5:
			this.setIcon(new ImageIcon("images/dice5.png"));
			break;
		case 6:
			this.setIcon(new ImageIcon("images/dice6.png"));
			break;
		}
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
