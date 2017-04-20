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
		if(bd.getSideUp() == 1){
			setRule();
		}
		bonusRule = new JLabel();
		bonusRule.setText("Bonus Rule: " + bd.getRule());
		this.add(bonusRule);
		this.setBackground(Color.GREEN);
		
	}
	public void updateRule(){
		bd.updateRule();
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
	public void setRule(){
		DieButton db = new DieButton(hand.getDie(5));
		db.setButtonIcon();
		buttons.add(db);
		this.add(buttons.get(5));
		
	}
	public void resetRule(){
		this.remove(buttons.get(5));
		buttons.remove(5);
	}
}
