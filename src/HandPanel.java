package goupproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * class responsible for displaying the die values.
 * 
 * @author Harvey Hartwell
 *
 */
public class HandPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hand hand;
	private ArrayList<DieButton> buttons;
	
	
	public HandPanel(Hand h) {
		// TODO Auto-generated constructor stub
		buttons = new ArrayList<DieButton>();
		hand = h;
		for (int i = 0; i < 5; i++){
			DieButton db = new DieButton(h.getDie(i));
			db.setButtonIcon();
			buttons.add(db);
			this.add(buttons.get(i));
		}
		this.setBackground(Color.GREEN);
		
	}
	public void scoreHand(){
		
	}
	public void keepHand(){
		
	}
	public Hand getHand(){
		return hand;
	}
	public ArrayList<DieButton> getButtons(){
		return buttons;
	}
	
}
