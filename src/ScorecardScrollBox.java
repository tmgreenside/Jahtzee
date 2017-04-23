import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JSeparator;
/*
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
*/
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
/**
 * 
 * class responsible for updating and displaying the score card
 * 
 * @author Scott Kopczynski
 * @Version Last Changed: 19 April 2017
 * 
 *
 */
public class ScorecardScrollBox extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	private Object rowData [][] = {{"Ones", 0}, {"Twos", 0}, {"Threes", 0}};
	private String[] columnData = {"Line", "Score"};  
	private JRadioButton LineButtonOne, LineButtonTwo, LineButtonThree, LineButtonFour, LineButtonFive, LineButtonSix, 
	LineButtonSubTotal, LineButtonBonus, LineButtonUpperTotal, LineButtonThreeKind, LineButtonFourKind, LineButtonSmallStraight,
	LineButtonLargeStraight, LineButtonFullHouse, LineButtonChance, LineButtonYahtzee, LineButtonLowerTotal, LineButtonGrandTotal;
	private boolean OneUsed, TwoUsed, ThreeUsed, FourUsed, FiveUsed, SixUsed, ThreeKindUsed, FourKindUsed, SmallStraightUsed, LargeStraightUsed, FullHouseUsed, ChanceUsed, YahtzeeUsed;
	private JLabel LineOne, LineTwo, LineThree, LineFour, LineFive, LineSix, LineThreeKind, LineFourKind, LineSmallStraight, LineLargeStraight, LineFullHouse, LineYahtzee, LineChance,
	LineSubTotal, LineBonus, LineUpperTotal, LineLowerTotal, LineGrandTotal;
	private String LineScored;
	private int upperTotal, lowerTotal, grandTotal, Bonus;
	
	private ButtonGroup group;
	private ArrayList<JRadioButton> scoreButtons;
	
	String cat1;
	String cat2;
	BonusDie bd;
	
	
	public ScorecardScrollBox() {
		
		
		upperTotal = 0;
		lowerTotal = 0;
		grandTotal = 0;
		Bonus = 0;
		LineScored = "";
		OneUsed = false;
		TwoUsed = false;
		ThreeUsed = false;
		FourUsed = false;
		FiveUsed = false;
		SixUsed = false;
		ThreeKindUsed = false;
		FourKindUsed = false;
		SmallStraightUsed = false;
		LargeStraightUsed = false;
		FullHouseUsed = false;
		ChanceUsed = false;
		YahtzeeUsed = false;
		setLayout(new GridLayout(19, 3, 0, 0));
		group = new ButtonGroup();
		scoreButtons = new ArrayList<JRadioButton>();
		
		JLabel Line = new JLabel("Line");
		Line.setHorizontalAlignment(SwingConstants.CENTER);
		add(Line);
		
		JLabel Score = new JLabel("Score");
		Score.setHorizontalAlignment(SwingConstants.CENTER);
		add(Score);
		
		JLabel Select = new JLabel("Select");
		Select.setHorizontalAlignment(SwingConstants.CENTER);
		add(Select);
		
		JLabel Ones = new JLabel("Ones");
		add(Ones);
		
		LineOne = new JLabel("0");
		LineOne.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineOne);
		LineButtonOne = new JRadioButton("");
		LineButtonOne.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonOne.addActionListener(this);
		scoreButtons.add(LineButtonOne);
		add(LineButtonOne);
		
		JLabel Twos = new JLabel("Twos");
		add(Twos);
		
		LineTwo = new JLabel("0");
		LineTwo.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineTwo);
		
		LineButtonTwo = new JRadioButton("");
		LineButtonTwo.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonTwo.addActionListener(this);
		scoreButtons.add(LineButtonTwo);
		add(LineButtonTwo);
		
		JLabel Threes = new JLabel("Threes");
		add(Threes);
		
		LineThree = new JLabel("0");
		LineThree.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineThree);
		
	    LineButtonThree = new JRadioButton("");
		LineButtonThree.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonThree.addActionListener(this);
		scoreButtons.add(LineButtonThree);
		add(LineButtonThree);
		
		JLabel Fours = new JLabel("Fours");
		add(Fours);
		
		LineFour = new JLabel("0");
		LineFour.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineFour);
		
	    LineButtonFour = new JRadioButton("");
		LineButtonFour.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonFour.addActionListener(this);
		scoreButtons.add(LineButtonFour);
		add(LineButtonFour);
		
		JLabel Fives = new JLabel("Fives");
		add(Fives);
		
		LineFive = new JLabel("0");
		LineFive.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineFive);
		
		LineButtonFive = new JRadioButton("");
		LineButtonFive.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonFive.addActionListener(this);
		scoreButtons.add(LineButtonFive);
		add(LineButtonFive);
		
		JLabel Sixes = new JLabel("Sixes");
		add(Sixes);
		
		LineSix = new JLabel("0");
		LineSix.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineSix);
		
		LineButtonSix = new JRadioButton("");
		LineButtonSix.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonSix.addActionListener(this);
		scoreButtons.add(LineButtonSix);
		add(LineButtonSix);
		
		JLabel SubTotal = new JLabel("Sub-Total");
		add(SubTotal);
		
		LineSubTotal = new JLabel("0");
		LineSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineSubTotal);
		
		LineButtonSubTotal = new JRadioButton("");
		LineButtonSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonSubTotal.addActionListener(this);
		add(LineButtonSubTotal);
		LineButtonSubTotal.setVisible(false);
		JLabel Bonus = new JLabel("Bonus");
		add(Bonus);
		
		LineBonus = new JLabel("0");
		LineBonus.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineBonus);
		
		LineButtonBonus = new JRadioButton("");
		LineButtonBonus.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineButtonBonus);
		LineButtonBonus.setVisible(false);
		JLabel UpperTotal = new JLabel("Upper-Total");
		add(UpperTotal);
		
		LineUpperTotal = new JLabel("0");
		LineUpperTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineUpperTotal);
		
		LineButtonUpperTotal = new JRadioButton("");
		LineButtonUpperTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineButtonUpperTotal);
		LineButtonUpperTotal.setVisible(false);
		JLabel ThreeKind = new JLabel("Three of a kind");
		add(ThreeKind);
		
		LineThreeKind = new JLabel("0");
		LineThreeKind.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineThreeKind);
		
		LineButtonThreeKind = new JRadioButton("");
		LineButtonThreeKind.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonThreeKind.addActionListener(this);
		scoreButtons.add(LineButtonThreeKind);
		add(LineButtonThreeKind);
		
		JLabel FourKind = new JLabel("Four of a kind");
		add(FourKind);
		
		LineFourKind = new JLabel("0");
		LineFourKind.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineFourKind);
		
		LineButtonFourKind = new JRadioButton("");
		LineButtonFourKind.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonFourKind.addActionListener(this);
		scoreButtons.add(LineButtonFourKind);
		add(LineButtonFourKind);
		
		JLabel FullHouse = new JLabel("Full House");
		add(FullHouse);
		
		LineFullHouse = new JLabel("0");
		LineFullHouse.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineFullHouse);
		
		LineButtonFullHouse = new JRadioButton("");
		LineButtonFullHouse.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonFullHouse.addActionListener(this);
		scoreButtons.add(LineButtonFullHouse);
		add(LineButtonFullHouse);
		
		JLabel SmallStraight = new JLabel("Small Straight");
		add(SmallStraight);
		
		LineSmallStraight = new JLabel("0");
		LineSmallStraight.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineSmallStraight);
		
		LineButtonSmallStraight = new JRadioButton("");
		LineButtonSmallStraight.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonSmallStraight.addActionListener(this);
		scoreButtons.add(LineButtonSmallStraight);
		add(LineButtonSmallStraight);
		
		JLabel LargeStraight = new JLabel("Large Straight");
		add(LargeStraight);
		
		LineLargeStraight = new JLabel("0");
		LineLargeStraight.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineLargeStraight);
		
		LineButtonLargeStraight = new JRadioButton("");
		LineButtonLargeStraight.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonLargeStraight.addActionListener(this);
		scoreButtons.add(LineButtonLargeStraight);
		add(LineButtonLargeStraight);
		
		JLabel Chance = new JLabel("Chance");
		add(Chance);
		
		LineChance = new JLabel("0");
		LineChance.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineChance);
		
		LineButtonChance = new JRadioButton("");
		LineButtonChance.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonChance.addActionListener(this);
		scoreButtons.add(LineButtonChance);
		add(LineButtonChance);
		
		JLabel Yahtzee = new JLabel("Yahtzee");
		add(Yahtzee);
		
		LineYahtzee = new JLabel("0");
		LineYahtzee.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineYahtzee);
		
		LineButtonYahtzee = new JRadioButton("");
		LineButtonYahtzee.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonYahtzee.addActionListener(this);
		scoreButtons.add(LineButtonYahtzee);
		add(LineButtonYahtzee);
		
		JLabel LowerTotal = new JLabel("Lower Total");
		add(LowerTotal);
		
		LineLowerTotal = new JLabel("0");
		LineLowerTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineLowerTotal);
		
		LineButtonLowerTotal = new JRadioButton("");
		LineButtonLowerTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineButtonLowerTotal);
		LineButtonLowerTotal.setVisible(false);
		
		JLabel GrandTotal = new JLabel("Grand Total");
		add(GrandTotal);
		
		LineGrandTotal = new JLabel("0");
		LineGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineGrandTotal);
		
		LineButtonGrandTotal = new JRadioButton("");
		LineButtonGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineButtonGrandTotal);
		LineButtonGrandTotal.setVisible(false);
		DefaultTableModel myModel = new DefaultTableModel(rowData, columnData);
		group.add(LineButtonOne);
		group.add(LineButtonTwo);
		group.add(LineButtonThree);
		group.add(LineButtonFour);
		group.add(LineButtonFive);
		group.add(LineButtonSubTotal);
		group.add(LineButtonSmallStraight);
		group.add(LineButtonSix);
		group.add(LineButtonLargeStraight);
		group.add(LineButtonBonus);
		group.add(LineButtonChance);
		group.add(LineButtonThreeKind);
		group.add(LineButtonFourKind);
		group.add(LineButtonFullHouse);
		group.add(LineButtonYahtzee);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
	/*	Object src = e.getSource();
		if(src.equals(LineButtonOne)){
			OneUsed = true;
			LineScored = "One";
			this.setScore(Integer.parseInt(LineOne.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonTwo)){
			TwoUsed = true;
			LineScored = "Two";
			this.setScore(Integer.parseInt(LineTwo.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonThree)){
			ThreeUsed = true;
			LineScored = "Three";
			this.setScore(Integer.parseInt(LineThree.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonFour)){
			FourUsed = true;
			LineScored = "Four";
			this.setScore(Integer.parseInt(LineFour.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonFive)){
			FiveUsed = true;
			LineScored = "Five";
			this.setScore(Integer.parseInt(LineFive.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonSix)){
			SixUsed = true;
			LineScored = "Six";
			this.setScore(Integer.parseInt(LineSix.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonSmallStraight)){
			SmallStraightUsed = true;
			LineScored = "SS";
			this.setScore(Integer.parseInt(LineSmallStraight.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonLargeStraight)){
			LargeStraightUsed = true;
			LineScored = "LS";
			this.setScore(Integer.parseInt(LineLargeStraight.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonChance)){
			ChanceUsed = true;
			LineScored = "C";
			this.setScore(Integer.parseInt(LineChance.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonThreeKind)){
			ThreeKindUsed = true;
			LineScored = "3K";
			this.setScore(Integer.parseInt(LineThreeKind.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonFourKind)){
			FourKindUsed = true;
			LineScored = "4K";
			this.setScore(Integer.parseInt(LineFourKind.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonYahtzee)){
			YahtzeeUsed = true;
			LineScored = "Y";
			this.setScore(Integer.parseInt(LineYahtzee.getText()));
			this.clearScoreCard();
		}
		if(src.equals(LineButtonFullHouse)){
			FullHouseUsed = true;
			LineScored = "FH";
			this.setScore(Integer.parseInt(LineFullHouse.getText()));
			this.clearScoreCard();
		}*/
	}
	public void clearScoreCard(){
		if(OneUsed == false){
			LineOne.setText("0");
		}
		if(TwoUsed == false){
			LineTwo.setText("0");
		}
		if(ThreeUsed == false){
			LineThree.setText("0");
		}
		if(FourUsed == false){
			LineFour.setText("0");
		}
		if(FiveUsed == false){
			LineFive.setText("0");
		}
		if(SixUsed == false){
			LineSix.setText("0");
		}
		if(ThreeKindUsed == false){
			LineThreeKind.setText("0");
		}
		if(FourKindUsed == false){
			LineFourKind.setText("0");
		}
		if(SmallStraightUsed == false){
			LineSmallStraight.setText("0");
		}
		if(LargeStraightUsed == false){
			LineLargeStraight.setText("0");
		}
		if(FullHouseUsed == false){
			LineFullHouse.setText("0");
		}
		if(ChanceUsed == false){
			LineChance.setText("0");
		}
		if(YahtzeeUsed == false){
			LineYahtzee.setText("0");
		}
	}
	public void showScores(ArrayList<Integer> upperScorecard, ArrayList<Integer> lowerScorecard){
		if(OneUsed == false)
			LineOne.setText(Integer.toString(upperScorecard.get(0)));
		if(TwoUsed == false)
			LineTwo.setText(Integer.toString(upperScorecard.get(1)));
		if(ThreeUsed == false)
			LineThree.setText(Integer.toString(upperScorecard.get(2)));
		if(FourUsed == false)
			LineFour.setText(Integer.toString(upperScorecard.get(3)));
		if(FiveUsed == false)
			LineFive.setText(Integer.toString(upperScorecard.get(4)));
		if(SixUsed == false)
			LineSix.setText(Integer.toString(upperScorecard.get(5)));
		if(ThreeKindUsed == false)
			LineThreeKind.setText(Integer.toString(lowerScorecard.get(0)));
		if(FourKindUsed == false)
			LineFourKind.setText(Integer.toString(lowerScorecard.get(1)));
		if(FullHouseUsed == false)
			LineFullHouse.setText(Integer.toString(lowerScorecard.get(2)));
		if(SmallStraightUsed == false)
			LineSmallStraight.setText(Integer.toString(lowerScorecard.get(3)));
		if(LargeStraightUsed == false)
			LineLargeStraight.setText(Integer.toString(lowerScorecard.get(4)));
		if(YahtzeeUsed == false)
			LineYahtzee.setText(Integer.toString(lowerScorecard.get(5)));
		if(ChanceUsed == false)
			LineChance.setText(Integer.toString(lowerScorecard.get(6)));
	}
	
	public void setUpper(){
		LineSubTotal.setText(Integer.toString(upperTotal));
	}
	public void setBonus(){
		
		if(upperTotal >= 63){
			Bonus = 35;
			LineBonus.setText("35");
			LineUpperTotal.setText(Integer.toString(35 + upperTotal));
		}
		else{
			Bonus = 0;
			LineUpperTotal.setText(Integer.toString(upperTotal));
		}
	}
	public void setLowerTotal(){
		
		LineLowerTotal.setText(Integer.toString(lowerTotal));
	}
	public void setGrandTotal(){
		LineGrandTotal.setText(Integer.toString(lowerTotal + upperTotal + Bonus));
	}
	public ButtonGroup getGroup(){
		return group;
	}
	public ArrayList<JRadioButton> getRadioButtons(){
		return scoreButtons;
	}
	public void unselectAllButtons(){
		group.clearSelection();
	}
	public void hideAllButtons(){
		for(int i = 0; i < scoreButtons.size(); i ++){
			scoreButtons.get(i).setVisible(false);
		}
	}
	
	public int getSelectedScore(){
		if(LineButtonOne.isSelected()){
			return Integer.parseInt(LineOne.getText());
		}
		if(LineButtonTwo.isSelected()){
			return Integer.parseInt(LineTwo.getText());
		}
		if(LineButtonThree.isSelected()){
			return Integer.parseInt(LineThree.getText());
		}
		if(LineButtonFour.isSelected()){
			return Integer.parseInt(LineFour.getText());
		}
		if(LineButtonFive.isSelected()){
			return Integer.parseInt(LineFive.getText());
		}
		if(LineButtonSix.isSelected()){
			return Integer.parseInt(LineSix.getText());
		}
		if(LineButtonThreeKind.isSelected()){
			return Integer.parseInt(LineThreeKind.getText());
		}
		if(LineButtonFourKind.isSelected()){
			return Integer.parseInt(LineFourKind.getText());
		}
		if(LineButtonSmallStraight.isSelected()){
			return Integer.parseInt(LineSmallStraight.getText());
		}
		if(LineButtonLargeStraight.isSelected()){
			return Integer.parseInt(LineLargeStraight.getText());
		}
		if(LineButtonFullHouse.isSelected()){
			return Integer.parseInt(LineFullHouse.getText());
		}
		if(LineButtonChance.isSelected()){
			return Integer.parseInt(LineChance.getText());
		}
		if(LineButtonYahtzee.isSelected()){
			return Integer.parseInt(LineYahtzee.getText());
		}
		return 0;
	}
	/**
	 * sets the score in the selected radio button in the scorecard
	 * @param score this is the score that is entered into the scoreCard 
	 */
	public void setSelectedScore(int score){
		if(LineButtonOne.isSelected()){
			OneUsed = true;
			LineOne.setText(Integer.toString(score));
			upperTotal = upperTotal + score;
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
			
		}
		if(LineButtonTwo.isSelected()){
			TwoUsed = true;
			upperTotal = upperTotal + score;
			LineTwo.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
			
		}
		if(LineButtonThree.isSelected()){
			ThreeUsed = true;
			upperTotal = upperTotal + score;
			LineThree.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
			
		}
		if(LineButtonFour.isSelected()){
			FourUsed = true;
			upperTotal = upperTotal + score;
			LineFour.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
			
		}
		if(LineButtonFive.isSelected()){
			FiveUsed = true;
			upperTotal = upperTotal + score;
			LineFive.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
			
		}
		if(LineButtonSix.isSelected()){
			SixUsed = true;
			upperTotal = upperTotal + score;
			LineSix.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
			
		}
		if(LineButtonThreeKind.isSelected()){
			ThreeKindUsed = true;
			lowerTotal = lowerTotal + score;
			LineThreeKind.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
		}
		if(LineButtonFourKind.isSelected()){
			FourKindUsed = true;
			lowerTotal = lowerTotal + score;
			LineFourKind.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
		}
		if(LineButtonSmallStraight.isSelected()){
			SmallStraightUsed = true;
			lowerTotal = lowerTotal + score;
			LineSmallStraight.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
		}
		if(LineButtonLargeStraight.isSelected()){
			LargeStraightUsed = true;
			lowerTotal = lowerTotal + score;
			LineLargeStraight.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
		}
		if(LineButtonFullHouse.isSelected()){
			FullHouseUsed = true;
			lowerTotal = lowerTotal + score;
			LineFullHouse.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
		}
		if(LineButtonChance.isSelected()){
			ChanceUsed = true;
			lowerTotal = lowerTotal + score;
			LineChance.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
		}
		else if(LineButtonYahtzee.isSelected()){
			YahtzeeUsed = true;
			lowerTotal = lowerTotal + score;
			LineYahtzee.setText(Integer.toString(score));
			this.setUpper();
			this.setBonus();
			this.setLowerTotal();
			this.setGrandTotal();
		}
		
		clearScoreCard();
	}
	/**
	 * disables all radio buttons except for the selected button in the scorecard
	 */
	public void disableAllButSelected(){
		for (int i = 0; i < scoreButtons.size(); i++){
			if (!scoreButtons.get(i).isSelected())
				scoreButtons.get(i).setEnabled(false);
			else
				scoreButtons.get(i).setVisible(false);
		}
	}
	/**
	 * enables all the radio buttons in the scorecard
	 */
	public void enableAllButtons(){
		for (int i =0; i < scoreButtons.size(); i++){
			if(!scoreButtons.get(i).isSelected())
				scoreButtons.get(i).setEnabled(true);
		}
	}
}