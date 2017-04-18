package Jahtzee;

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
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSeparator;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

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
	private JLabel LineOne, LineTwo, LineThree, LineFour, LineFive, LineSix, LineThreeKind, LineFourKind, LineSmallStraight, LineLargeStraight, LineFullHouse, LineYahtzee, LineChance;
	public ScorecardScrollBox() {
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
		ButtonGroup group = new ButtonGroup();
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
		add(LineButtonOne);
		
		JLabel Twos = new JLabel("Twos");
		add(Twos);
		
		LineTwo = new JLabel("0");
		LineTwo.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineTwo);
		
		LineButtonTwo = new JRadioButton("");
		LineButtonTwo.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonTwo.addActionListener(this);
		add(LineButtonTwo);
		
		JLabel Threes = new JLabel("Threes");
		add(Threes);
		
		LineThree = new JLabel("0");
		LineThree.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineThree);
		
	    LineButtonThree = new JRadioButton("");
		LineButtonThree.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonThree.addActionListener(this);
		add(LineButtonThree);
		
		JLabel Fours = new JLabel("Fours");
		add(Fours);
		
		LineFour = new JLabel("0");
		LineFour.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineFour);
		
	    LineButtonFour = new JRadioButton("");
		LineButtonFour.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonFour.addActionListener(this);
		add(LineButtonFour);
		
		JLabel Fives = new JLabel("Fives");
		add(Fives);
		
		LineFive = new JLabel("0");
		LineFive.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineFive);
		
		LineButtonFive = new JRadioButton("");
		LineButtonFive.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonFive.addActionListener(this);
		add(LineButtonFive);
		
		JLabel Sixes = new JLabel("Sixes");
		add(Sixes);
		
		LineSix = new JLabel("0");
		LineSix.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineSix);
		
		LineButtonSix = new JRadioButton("");
		LineButtonSix.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonSix.addActionListener(this);
		add(LineButtonSix);
		
		JLabel SubTotal = new JLabel("Sub-Total");
		add(SubTotal);
		
		JLabel LineSubTotal = new JLabel("0");
		LineSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineSubTotal);
		
		LineButtonSubTotal = new JRadioButton("");
		LineButtonSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonSubTotal.addActionListener(this);
		add(LineButtonSubTotal);
		LineButtonSubTotal.setVisible(false);
		JLabel Bonus = new JLabel("Bonus");
		add(Bonus);
		
		JLabel LineBonus = new JLabel("0");
		LineBonus.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineBonus);
		
		LineButtonBonus = new JRadioButton("");
		LineButtonBonus.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineButtonBonus);
		LineButtonBonus.setVisible(false);
		JLabel UpperTotal = new JLabel("Upper-Total");
		add(UpperTotal);
		
		JLabel LineUpperTotal = new JLabel("0");
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
		add(LineButtonThreeKind);
		
		JLabel FourKind = new JLabel("Four of a kind");
		add(FourKind);
		
		LineFourKind = new JLabel("0");
		LineFourKind.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineFourKind);
		
		LineButtonFourKind = new JRadioButton("");
		LineButtonFourKind.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonFourKind.addActionListener(this);
		add(LineButtonFourKind);
		
		JLabel FullHouse = new JLabel("Full House");
		add(FullHouse);
		
		LineFullHouse = new JLabel("0");
		LineFullHouse.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineFullHouse);
		
		LineButtonFullHouse = new JRadioButton("");
		LineButtonFullHouse.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonFullHouse.addActionListener(this);
		add(LineButtonFullHouse);
		
		JLabel SmallStraight = new JLabel("Small Straight");
		add(SmallStraight);
		
		LineSmallStraight = new JLabel("0");
		LineSmallStraight.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineSmallStraight);
		
		LineButtonSmallStraight = new JRadioButton("");
		LineButtonSmallStraight.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonSmallStraight.addActionListener(this);
		add(LineButtonSmallStraight);
		
		JLabel LargeStraight = new JLabel("Large Straight");
		add(LargeStraight);
		
		LineLargeStraight = new JLabel("0");
		LineLargeStraight.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineLargeStraight);
		
		LineButtonLargeStraight = new JRadioButton("");
		LineButtonLargeStraight.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonLargeStraight.addActionListener(this);
		add(LineButtonLargeStraight);
		
		JLabel Chance = new JLabel("Chance");
		add(Chance);
		
		LineChance = new JLabel("0");
		LineChance.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineChance);
		
		LineButtonChance = new JRadioButton("");
		LineButtonChance.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonChance.addActionListener(this);
		add(LineButtonChance);
		
		JLabel Yahtzee = new JLabel("Yahtzee");
		add(Yahtzee);
		
		LineYahtzee = new JLabel("0");
		LineYahtzee.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineYahtzee);
		
		LineButtonYahtzee = new JRadioButton("");
		LineButtonYahtzee.setHorizontalAlignment(SwingConstants.CENTER);
		LineButtonYahtzee.addActionListener(this);
		add(LineButtonYahtzee);
		
		JLabel LowerTotal = new JLabel("Lower Total");
		add(LowerTotal);
		
		JLabel LineLowerTotal = new JLabel("0");
		LineLowerTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineLowerTotal);
		
		LineButtonLowerTotal = new JRadioButton("");
		LineButtonLowerTotal.setHorizontalAlignment(SwingConstants.CENTER);
		add(LineButtonLowerTotal);
		LineButtonLowerTotal.setVisible(false);
		
		JLabel GrandTotal = new JLabel("Grand Total");
		add(GrandTotal);
		
		JLabel LineGrandTotal = new JLabel("0");
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

	}
	public void actionPerformed(ActionEvent e){
		Object src = e.getSource();
		if(src.equals(LineButtonOne)){
			OneUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonTwo)){
			TwoUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonThree)){
			ThreeUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonFour)){
			FourUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonFive)){
			FiveUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonSix)){
			SixUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonSmallStraight)){
			SmallStraightUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonLargeStraight)){
			LargeStraightUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonChance)){
			ChanceUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonThreeKind)){
			ThreeKindUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonFourKind)){
			FourKindUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonYahtzee)){
			YahtzeeUsed = true;
			this.clearScoreCard();
		}
		if(src.equals(LineButtonFullHouse)){
			FullHouseUsed = true;
			this.clearScoreCard();
		}
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
}