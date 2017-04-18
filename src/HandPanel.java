package goupproject;

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
		
		rollButton rb = new rollButton(h);
		rb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				hand.rollHand();
				for (int i = 0; i < 5; i++){
					buttons.get(i).setButtonIcon();
				}
				
			}
		});
		
		this.add(rb);
		
	}
	public void scoreHand(){
		
	}
	public void keepHand(){
		
	}
	
	
}
