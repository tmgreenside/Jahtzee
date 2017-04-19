//package goupproject;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates a window displaying the document containing the 
 * rules of Jahtzee. 
 * @author Trevor Greenside
 * @version Last Changed: 17 April 2017
 * CPSC 224 Group Project: Jahtzee
 */
public class RulesWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JScrollPane scroller;
	private JLabel rules1;
	private JLabel rules2;
	private JPanel rulesPanel;
	
	public RulesWindow() {
		rules1 = new JLabel();
		rules1.setIcon(new ImageIcon("images/Jahtzee_rules.png"));
		rules2 = new JLabel();
		rules2.setIcon(new ImageIcon("images/Jahtzee_rules_part2.png"));
		
		rulesPanel = new JPanel(new BorderLayout());
		rulesPanel.add(rules1, BorderLayout.NORTH);
		rulesPanel.add(rules2, BorderLayout.SOUTH);
		scroller = new JScrollPane(rulesPanel);
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(400, 600);
		this.setTitle("Rules of Jahtzee");
		this.add(scroller);
	}
}
