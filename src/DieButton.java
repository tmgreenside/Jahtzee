package goupproject;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
/**
 * class responsible for creating the die buttons and 
 * determining if a button has been checked.
 *
 * @author Harvey Hartwell
 *
 */
public class DieButton extends JCheckBox implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Die die;
	private int clicked = 0;
	
	public DieButton(Die d) {
		// TODO Auto-generated constructor stub
		die = d;
	}
	public void setButtonIcon(){
		for (int i = 1; i <= 6; i++){
			if (i == die.getSideUp()){
				this.setIcon(new ImageIcon("dice" + i + ".png"));
			}
		}	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (clicked % 2 == 0){
			die.setIsKept(false);
		}
		else {
			die.setIsKept(true);
		}
		
	}
}
