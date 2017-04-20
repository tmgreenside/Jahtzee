//package goupproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	private BonusDie bonus_die;
	private String cat1;
	private String cat2;
	
	private UpperData ud;
	private LowerData ld;
	
	private JLabel frstCat;
	private JLabel scndCat;
	
	private ScorecardScrollBox scsb;
	private RollButton rb;
	private HandPanel hp;
	private DieButton db;
	
	
	private ConfirmWindow confirmWin;
	private QuestionWindow questWin;
	
	/**
	 * the constructor creates each component, and then adds each one to a seperate jpanel called container.
	 * after all the components have been added to the container, the container is then added to the GameWindow.
	 */
	
	public GameWindow(String frstCat, String scndCat) {
		// TODO Auto-generated constructor stub
		JPanel container = new JPanel();
		container.setBackground(Color.GREEN);
		
		//private fields are initialized
		bonus_die = new BonusDie();
		hand = new Hand(bonus_die);
		cat1 = frstCat;
		cat2 = scndCat;
		ud = new UpperData(hand, bonus_die);
		ld = new LowerData(hand, bonus_die);
		
		
		// components are created
		this.frstCat = new JLabel(frstCat);
		this.scndCat = new JLabel(scndCat);
		
		
		
		hp = new HandPanel(hand);
		scsb = new ScorecardScrollBox();
		rb = new RollButton(hp, scsb);
		JButton rules = new JButton("display rules");
		
		RulesWindow ruleWin = new RulesWindow();
		
		scsb.showScores(ud.getPossibleScores(), ld.getPossibleScores());
		
		
		// listeners for components are created
		createScorecardButtonActionListeners();
		createRollButtonActionListener();
		rules.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ruleWin.setVisible(true);
			}
			
		});
		
		// components are added to the gameWindow
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
					scsb.disableAllButSelected();
					ConfirmWindow cw = new ConfirmWindow(scsb.getSelectedScore(), cat1, cat2, scsb, bonus_die, rb);
					
				}
			});
		}
	}
	
	/**
	 * this function gives control of the die buttons and the score card to the roll button.
	 * it also disables the roll button and the dieButtons after the third roll.
	 * When the user selects a line to score, the buttons should become enabled again.
	 * 
	 * this roll button is how each turn is controlled.
	 */
	private void createRollButtonActionListener(){
		rb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				rb.incrementClicked();
				int turn = rb.getClicked() % hand.getTurns();
				
				if (turn == 0){
					resetRules();
					unselectAllButtons();
					rb.updateIsKept();
					hp.getHand().rollHand();
					hp.getHand().rollBonusDie();
					hp.updateRule();
					hp.getHand().getBonusDie().updateRule();
					setRule();
					enableAllButtons();
					scsb.unselectAllButtons();
					updateButtonIcons();
					rb.setText("Roll");
					scsb.showScores(ud.getPossibleScores(), ld.getPossibleScores());
				}
				else if (turn < hand.getTurns() - 1){
					rb.updateIsKept();
					hp.getHand().rollHand();
					updateButtonIcons();
					rb.setText("Roll Again!");
					unselectAllButtons();
					scsb.showScores(ud.getPossibleScores(), ld.getPossibleScores());
				}
				else {
					rb.updateIsKept();
					hp.getHand().rollHand();
					updateButtonIcons();
					rb.setText("Set Score");
					rb.setEnabled(false);
					unselectAllButtons();
					disableAllButtons();
					scsb.showScores(ud.getPossibleScores(), ld.getPossibleScores());
				}
			}
			/**
			 * used to update the button icon image.
			 * called each turn
			 */
			private void updateButtonIcons(){
				for (int i = 0; i < hp.getButtons().size(); i++){
					hp.getButtons().get(i).setButtonIcon();
				}
			}
			/**
			 * used to unselect all the die buttons and set
			 * the all dice to unkept
			 */
			private void unselectAllButtons(){
				for (int i = 0; i < hp.getButtons().size(); i++){
					hp.getButtons().get(i).setSelected(false);
					hand.getDie(i).setIsKept(false);
				}
			}
			/**
			 * disables all the die buttons
			 */
			private void disableAllButtons(){
				for (int i = 0; i < hp.getButtons().size(); i++){
					hp.getButtons().get(i).setEnabled(false);
				}
			}
			/**
			 * enables all the die buttons
			 */
			private void enableAllButtons(){
				for (int i = 0; i < hp.getButtons().size(); i++){
					hp.getButtons().get(i).setEnabled(true);
				}
			}
			
		});
	}
	/**
	 * this function will be called at the start of each turn, and
	 * will enable the bonus rule in play
	 */
	
	// if your class deals with any of these rules, I need a setRule funtion, and a resetRule function
	public void setRule(){
		switch(hand.getBonusDie().getSideUp()){
		case 1:
			// the user gets an extra die
			hand.setRule();
			hp.setRule();
			
			break;
		case 2:
			// the score is doubled
			
			break;
		case 3:
			// the user must answer a trivia question, and must bet the whole score
			
			break;
		case 4:
			// the user recieves an extra roll
			hand.setRule();
			
			break;
		case 5:
			// the user must answer a trivia question
			
			break;
		case 6:
			// the user's score is tripled
			
			break;
		}
	}
	/**
	 * this function will be called at the start of each turn,
	 * and will reset all the rules.
	 */
	// if your classes deal with any of these rules, I need a setRule function, and a resetRule function.
	public void resetRules(){
		switch(hand.getBonusDie().getSideUp()){
		case 1:
			// delete the extra die
			hand.resetRule();
			hp.resetRule();
			break;
		case 2:
			// stop the game from doubling the score
			
			break;
		case 3:
			// stop the game from forcing a trivia question and a "double or nothing" bet
			
			break;
		case 4: 
			// set the number of rolls back to 3
			hand.resetRule();
			break;
		case 5:
			// stop the game from forcing a trivia question
			
			break;
		case 6:
			// stop the game from tripling the score
			
			break;
		}
	}
	
	public void diplayBonusDieRule(){
		
	}
	public void updateHandPanel(){
		
	}
	public void updateScoreCard(){
		
	}
}

