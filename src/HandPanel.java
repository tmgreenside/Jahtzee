//package goupproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * class responsible for displaying the dice values and the bonus Die rule
 * 
 * @author Harvey Hartwell
 *
 */
public class HandPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Hand hand;
	private ArrayList<DieButton> buttons;
	private JLabel bonusRule;
	private BonusDie bd;
	
	
	public HandPanel(Hand h) {
		// TODO Auto-generated constructor stub
		
		buttons = new ArrayList<DieButton>();
		hand = h;
		bd = hand.getBonusDie();
		for (int i = 0; i < 5; i++){
			DieButton db = new DieButton(h.getDie(i));
			db.setButtonIcon();
			buttons.add(db);
			this.add(buttons.get(i));
		}
		hand.getBonusDie().updateRule();
		bonusRule = new JLabel();
		bonusRule.setText("Bonus Rule: " + bd.getRule());
		this.add(bonusRule);
		this.setBackground(Color.GREEN);
		
	}
	public void updateRule(){
		bonusRule.setText("Bonus Rule: " + bd.getRule());
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
