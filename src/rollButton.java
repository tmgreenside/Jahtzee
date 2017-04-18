package goupproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class rollButton extends JButton{
	private int clicked;
	private Hand hand;
	public rollButton(Hand h) {
		// TODO Auto-generated constructor stub
		clicked = 0;
		hand = h;
		this.setText("roll");
	}
	

}
