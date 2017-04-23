//package goupproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * class responsible for creating the roll button. 
 * @author Harvey Hartwell
 * @version Last changed: 4 April 2017
 *
 */
public class RollButton extends JButton{
	private int clicked;
	private int turns;
	private int allKept;
	private HandPanel hp;
	private ScorecardScrollBox scsb;
	
	public RollButton(HandPanel hp, ScorecardScrollBox scsb) {
		// TODO Auto-generated constructor stub
		clicked = 0;
		turns = 3;
		allKept = 0;
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
				allKept++;
			}
			else{
				hp.getHand().getDie(i).setIsKept(false);
			}
		}
	}
	public int getTurns(){
		return turns;
	}
	public void setRule(){
		turns = 4;
	}
	public void resetRule(){
		turns = 3;
	}
	public int getAllKept(){
		return allKept;
	}
}
