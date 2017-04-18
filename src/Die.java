import java.util.*;
import javax.swing.*;

/**
 * This class extends JLabel to display Yahtzee dice images
 * on the screen. Other methods return just its value as an
 * integer and also simulate rolling it to display a new
 * value.
 * @author Trevor Greenside
 * @version Last Changed: 17 April 2017
 * CPSC 224 Group Project: Jahtzee
 */
 */
public class Die extends JLabel {

	private static final long serialVersionUID = 1L;
	private int value;
	private int maxValue; 
	
	public Die(int maxValue){
		this.maxValue = maxValue;
		rollDie(); 
	}
	
	/**
	 * Overloaded constructor in case the caller fails to
	 * specify a max value. This constructor replaces a
	 * passed-in max value with the default 6.
	 */
	public Die(){
		this.maxValue = 6;
		rollDie();
	}
	
	/**
	 * This method uses the Random utility to
	 * assign a new random integer as the value of
	 * this.value.
	 */
	public void rollDie() {
		Random myRoller = new Random();
		this.value = myRoller.nextInt(maxValue) + 1;
		setImage();
	}
	
	/**
	 * Use the die's value to change the image displayed by
	 * this object as a JLabel.
	 */
	public void setImage() {
		switch(value) {
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
	 * Get the die's value as an integer
	 * @return
	 */
	public int getValue () {
		return this.value;
	}
}
