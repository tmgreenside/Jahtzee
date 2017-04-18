package goupproject;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * class responsible for displaying the UX for the final game
 * @author Harvey Hartwell
 *
 */
public class GameWindow extends JFrame{
	private static int WIDTH = 800;
	private static int HIGHT = 600;
	private static Hand hand;
	public GameWindow() {
		// TODO Auto-generated constructor stub
		hand = new Hand();
		HandPanel hp = new HandPanel(hand);
		this.setSize(WIDTH, HIGHT);
		
		this.add(hp);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}
	public void diplayBonusDieRule(){
		
	}
	public void updateHandPanel(){
		
	}
	public void updateScoreCard(){
		
	}
	
	public static void main(String []args){
		EventQueue.invokeLater(new Runnable(){
			

			@Override
			public void run() {
				// TODO Auto-generated method stub
				GameWindow w = new GameWindow();
			}
		});
		
	}
	
}

