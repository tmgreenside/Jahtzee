package goupproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RollButton extends JButton implements ActionListener{
	private int clicked;
	private HandPanel hp;
	private ScorecardScrollBox scsb;
	
	public RollButton(HandPanel hp, ScorecardScrollBox scsb) {
		// TODO Auto-generated constructor stub
		clicked = 0;
		this.hp = hp;
		this.scsb = scsb;
		this.setText("roll");
	}
		
		@Override
		public void actionPerformed(ActionEvent e){
			clicked++;
			int turn = clicked % 3;
			
			if (turn == 0){
				hp.getHand().rollHand();
				updateButtonIcons();
				this.setText("Roll");
			}
			else if (turn == 1){
				hp.getHand().rollHand();
				updateButtonIcons();
				this.setText("Roll Again!");
			}
			else {
				hp.getHand().rollHand();
				updateButtonIcons();
				this.setText("Set Score");
				this.setEnabled(false);
			}
		}
		/**
		 * used to update the button icon image
		 */
		private void updateButtonIcons(){
			for (int i = 0; i < 5; i++){
				hp.getButtons().get(i).setButtonIcon();
			}
		}
	
	
}
