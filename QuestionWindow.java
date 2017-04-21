//package goupproject;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.*;

public class QuestionWindow extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String[] comboBoxArray;
	private int Score;
    JButton Submit;
    JRadioButton choiceFour;
	JRadioButton choiceThree;
    JRadioButton choiceTwo;
	JRadioButton choiceOne;
	JComboBox comboBox;
	QuestionCache Q1;
	ScorecardScrollBox S1;
    private BonusDie B;
    private RollButton rb;
	
	public QuestionWindow(int score, String cat1, String cat2, ScorecardScrollBox S, BonusDie die, RollButton rb) throws IOException {
        B = die;
        this.rb = rb;
		S1 = S;
		
		Score = score;
	    Q1 = new QuestionCache(cat1, cat2);
		Q1.createCategoryOneArray();
		Q1.createCategoryTwoArray();
		Q1.setQuestion();
		Q1.setChoices();
		setTitle("Trivia!");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Focus.color"));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Focus.color"));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		ButtonGroup group = new ButtonGroup();
		choiceOne = new JRadioButton((String)Q1.getChoices().get(0));
		choiceOne.addActionListener(this);
		group.add(choiceOne);
		panel_1.add(choiceOne);
		
		choiceTwo = new JRadioButton((String)Q1.getChoices().get(1));
		
		choiceTwo.addActionListener(this);
		group.add(choiceTwo);
		panel_1.add(choiceTwo);
		
		choiceThree = new JRadioButton((String)Q1.getChoices().get(2));
		choiceThree.addActionListener(this);
		group.add(choiceThree);
		panel_1.add(choiceThree);
		
		choiceFour = new JRadioButton((String)Q1.getChoices().get(3));
		choiceFour.addActionListener(this);
		group.add(choiceFour);
		panel_1.add(choiceFour);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setText(Q1.getQuestion());
		textArea.setOpaque(false);
		
		contentPane.add(textArea, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Focus.color"));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.generateComboxString();
		comboBox = new JComboBox(comboBoxArray);
		comboBox.setEnabled(false);
		panel_2.add(comboBox);
		
		Submit = new JButton("Submit");
		Submit.addActionListener(this);
		Submit.setEnabled(false);
		panel_2.add(Submit);
	}
	public void generateComboxString(){
        if(B.getRule() == "Double or Nothing"){
            comboBoxArray = new String[1];
            comboBoxArray[0] = Integer.toString(Score);
        }
        else{
            comboBoxArray = new String[(Score / 5) + 1];
            for(int i = 0; i < (Score / 5) + 1; i++){
                comboBoxArray[i] = Integer.toString(i * 5);
            }
        }
	}
	
	public void setCorrectScore(){
		Score = Score + Integer.parseInt(comboBoxArray[comboBox.getSelectedIndex()]);
		S1.setSelectedScore(Score);
	}
	public void setIncorrectScore(){
		Score = Score - Integer.parseInt(comboBoxArray[comboBox.getSelectedIndex()]);
		S1.setSelectedScore(Score);
	}
	public int getScore(){
		return Score;
	}
	public void actionPerformed(ActionEvent e){
		Object src = e.getSource();
		if(src.equals(Submit)){
			if(choiceFour.isSelected()){
				if(Q1.getAnswer() == Q1.getChoices().get(3)){
					JOptionPane.showMessageDialog(this, "Correct you increased your score by " + comboBoxArray[comboBox.getSelectedIndex()], "Result", JOptionPane.PLAIN_MESSAGE );
					this.setCorrectScore();
				}
				else{
					JOptionPane.showMessageDialog(this, "Wrong you decreased your score by " + comboBoxArray[comboBox.getSelectedIndex()], "Result", JOptionPane.PLAIN_MESSAGE );
					this.setIncorrectScore();
				}
			}
			if(choiceThree.isSelected()){
				if(Q1.getAnswer() == Q1.getChoices().get(2)){
					JOptionPane.showMessageDialog(this, "Correct you increased your score by " + comboBoxArray[comboBox.getSelectedIndex()], "Result", JOptionPane.PLAIN_MESSAGE );this.dispose();
					this.setCorrectScore();
				}
				else{
					JOptionPane.showMessageDialog(this, "Wrong you decreased your score by " + comboBoxArray[comboBox.getSelectedIndex()], "Result", JOptionPane.PLAIN_MESSAGE );
					this.setIncorrectScore();
				}
			}
			if(choiceTwo.isSelected()){
				if(Q1.getAnswer() == Q1.getChoices().get(1)){
					JOptionPane.showMessageDialog(this, "Correct you increased your score by " + comboBoxArray[comboBox.getSelectedIndex()], "Result", JOptionPane.PLAIN_MESSAGE );
					this.setCorrectScore();
				}
				else{
					JOptionPane.showMessageDialog(this, "Wrong you decreased your score by " + comboBoxArray[comboBox.getSelectedIndex()], "Result", JOptionPane.PLAIN_MESSAGE );
					this.setIncorrectScore();
				}
			}
			if(choiceOne.isSelected()){
				if(Q1.getAnswer() == Q1.getChoices().get(0)){
					JOptionPane.showMessageDialog(this, "Correct you increased your score by " + comboBoxArray[comboBox.getSelectedIndex()], "Result", JOptionPane.PLAIN_MESSAGE );
					this.setCorrectScore();
				}
				else{
					JOptionPane.showMessageDialog(this, "Wrong you decreased your score by " + comboBoxArray[comboBox.getSelectedIndex()], "Result", JOptionPane.PLAIN_MESSAGE );
					this.setIncorrectScore();
				}
			}
			S1.enableAllButtons();
			rb.setEnabled(true);
			this.dispose();
		}
		if(src.equals(choiceFour)){
			Submit.setEnabled(true);
			comboBox.setEnabled(true);
		}
		if(src.equals(choiceThree)){
			Submit.setEnabled(true);
			comboBox.setEnabled(true);
		}
		if(src.equals(choiceTwo)){
			Submit.setEnabled(true);
			comboBox.setEnabled(true);
		}
		if(src.equals(choiceOne)){
			Submit.setEnabled(true);
			comboBox.setEnabled(true);
		}
	}
}