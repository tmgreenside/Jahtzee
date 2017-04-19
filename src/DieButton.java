//package goupproject;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
/**
 * class responsible for creating the die buttons and 
 * determining if a button has been checked.
 *
 * @author Harvey Hartwell
 * @version Last Changed: 4/19/2017
 *
 */
public class DieButton extends JCheckBox implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Die die;
	private int clicked = 0;
	private JLabel keep;
	
	public DieButton(Die d) {
		// TODO Auto-generated constructor stub
		die = d;
		keep = new JLabel("Keep!");
	}
	
	public void setButtonIcon(){
		for (int i = 1; i <= 6; i++){
			if (i == die.getSideUp()){
				this.setIcon(new ImageIcon("images/dice" + i + ".png"));
				this.setSelectedIcon(new ImageIcon("images/" + i + "keep.png"));
			}
		}	
	}
	public void updateIsKept(){
		if (this.isSelected()){
			die.setIsKept(true);
		}
		else{
			die.setIsKept(false);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateIsKept();
		setButtonIcon();
		System.out.println("selected something");
	}
}
