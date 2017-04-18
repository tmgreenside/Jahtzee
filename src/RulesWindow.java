import javax.swing.*;
import java.awt.*;

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
