package goupproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * class responsible for creating the roll button. 
 * @author Harvey
 * @version Last changed: 4 April 2017
 *
 */
public class RollButton extends JButton{
	private int clicked;
	private HandPanel hp;
	private ScorecardScrollBox scsb;
	
	public RollButton(HandPanel hp, ScorecardScrollBox scsb) {
		// TODO Auto-generated constructor stub
		clicked = 0;
		this.hp = hp;
		this.scsb = scsb;
		this.setText("Roll");
	}
	public void incrementClicked(){
		clicked++;
	}
	public int getClicked(){
		return clicked;
	}
	public void updateIsKept(){
		for (int i = 0; i < 5; i++){
			if(hp.getButtons().get(i).isSelected()){
				hp.getHand().getDie(i).setIsKept(true);
			}
			else{
				hp.getHand().getDie(i).setIsKept(false);
			}
		}
	}
}
