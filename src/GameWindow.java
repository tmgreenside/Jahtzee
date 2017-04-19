package goupproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * class responsible for displaying the UX for the final game
 * @author Harvey Hartwell
 * @Version Last Changed: 4 April 2017
 * 
 */
public class GameWindow extends JFrame{
	private static int WIDTH = 800;
	private static int HIGHT = 600;
	private static Hand hand;
	
	private JLabel rule_one;
	private JLabel rule_two;
	private String bonusRule;
	
	private JLabel frstCat;
	private JLabel scndCat;
	
	private ScorecardScrollBox scsb;
	private RollButton rb;
	private HandPanel hp;
	private DieButton db;
	private BonusDie bonus_die;
	
	/**
	 * the constructor creates each component, and then adds each one to a seperate jpanel called container.
	 * after all the components have been added to the container, the container is then added to the GameWindow.
	 */
	
	public GameWindow(String frstCat, String scndCat) {
		// TODO Auto-generated constructor stub
		JPanel container = new JPanel();
		container.setBackground(Color.GREEN);
		
		this.frstCat = new JLabel(frstCat);
		this.scndCat = new JLabel(scndCat);
		
		bonus_die = new BonusDie();
		hand = new Hand(bonus_die);
		
		hp = new HandPanel(hand);
		scsb = new ScorecardScrollBox();
		rb = new RollButton(hp, scsb);
		RulesWindow ruleWin = new RulesWindow();
		JButton rules = new JButton("display rules");
		createScorecardButtonActionListeners();
		createRollButtonActionListener();
		rules.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ruleWin.setVisible(true);
			}
			
		});
		scsb.getGroup();
		
		container.add(hp, BorderLayout.NORTH);
		container.add(rb, BorderLayout.CENTER);
		container.add(scsb, BorderLayout.SOUTH);
		container.add(this.frstCat, BorderLayout.EAST);
		container.add(this.scndCat, BorderLayout.EAST);
		container.add(rules, BorderLayout.EAST);
		
		this.add(container);
		this.setSize(WIDTH, HIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	/**
	 * this funtion creates an action listener on each radio button in the score card
	 * so that when a button is selected, the roll button is clickable. this helps prevent the 
	 * user from scoring without selecting a line.
	 */
	private void createScorecardButtonActionListeners(){
		for (int i = 0; i < scsb.getRadioButtons().size(); i++){
			scsb.getRadioButtons().get(i).addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					rb.setEnabled(true);
					enableAllButtons();
				}
				private void enableAllButtons(){
					for (int i = 0; i < 5; i++){
						hp.getButtons().get(i).setEnabled(true);
					}
				}
				
			});
		}
	}
	/**
	 * this function gives control of the die buttons and the score card to the roll button.
	 * it also disables the roll button and the dieButtons after the third roll.
	 * When the user selects a line to score, the buttons should become enabled again.
	 */
	private void createRollButtonActionListener(){
		rb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				rb.incrementClicked();
				int turn = rb.getClicked() % 3;
				
				if (turn == 0){
					unselectAllButtons();
					rb.updateIsKept();
					hp.getHand().rollHand();
					hp.getHand().rollBonusDie();
					hp.updateRule();
					hp.getHand().getBonusDie().updateRule();
					scsb.unselectAllButtons();
					
					updateButtonIcons();
					rb.setText("Roll");
				}
				else if (turn == 1){
					rb.updateIsKept();
					hp.getHand().rollHand();
					updateButtonIcons();
					rb.setText("Roll Again!");
					unselectAllButtons();
				}
				else {
					rb.updateIsKept();
					hp.getHand().rollHand();
					updateButtonIcons();
					rb.setText("Set Score");
					rb.setEnabled(false);
					unselectAllButtons();
					disableAllButtons();
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
			/**
			 * used to unselect all the die buttons and set
			 * the all dice to unkept
			 */
			private void unselectAllButtons(){
				for (int i = 0; i < 5; i++){
					hp.getButtons().get(i).setSelected(false);
					hand.getDie(i).setIsKept(false);
				}
			}
			/**
			 * disables all the die buttons
			 */
			private void disableAllButtons(){
				for (int i = 0; i < 5; i++){
					hp.getButtons().get(i).setEnabled(false);
				}
			}
			
		});
	}
	
	public void diplayBonusDieRule(){
		
	}
	public void updateHandPanel(){
		
	}
	public void updateScoreCard(){
		
	}
}

