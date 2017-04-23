import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * class responsible for displaying the dice values and the bonus Die rule
 * 
 * @author Harvey Hartwell
 *
 */
public class HandPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Hand hand;
	private ArrayList<DieButton> buttons;
	private JLabel bonusRule;
	private BonusDie bd;
	private JPanel hndPnl;
	
	public HandPanel(Hand h) {
		// TODO Auto-generated constructor stub
		hndPnl = new JPanel();
		hndPnl.setBackground(Color.GREEN);
		buttons = new ArrayList<DieButton>();
		hand = h;
		bd = hand.getBonusDie();
		this.setLayout(new BorderLayout());
		for (int i = 0; i < 5; i++){
			DieButton db = new DieButton(h.getDie(i));
			db.setButtonIcon();
			buttons.add(db);
			hndPnl.add(buttons.get(i));
			this.add(hndPnl, BorderLayout.CENTER);
		}
		hand.getBonusDie().updateRule();
		if(bd.getSideUp() == 1){
			setRule();
		}
		bonusRule = new JLabel();
		bonusRule.setIcon(new ImageIcon("images/dice" + bd.getSideUp() + ".png"));
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		JLabel lbl1 = new JLabel();
		lbl1.setText("Bonus");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lbl2 = new JLabel();
		lbl2.setText(" ");
		JLabel lbl3 = new JLabel();
		lbl3.setText("  ");
		JLabel lbl4 = new JLabel();
		lbl4.setText("  ");
		jp.add(bonusRule);
		jp.add(lbl1, BorderLayout.NORTH);
		jp.add(lbl2, BorderLayout.SOUTH);
		jp.add(lbl3, BorderLayout.WEST);
		jp.add(lbl4, BorderLayout.EAST);
		jp.setBackground(Color.YELLOW);
		
		this.setBackground(Color.GREEN);
		JPanel jpnl = new JPanel();
		jpnl.setLayout(new GridLayout(7, 1));
		JLabel lb = new JLabel();
		lb.setText("Bonus Rules");
		JLabel lb1 = new JLabel();
		lb1.setText("1. Extra Die");
		JLabel lb2 = new JLabel();
		lb2.setText("2. Double Your Score");
		JLabel lb3 = new JLabel();
		lb3.setText("3. Double or Nothing");
		JLabel lb4 = new JLabel();
		lb4.setText("4. Extra Roll");
		JLabel lb5 = new JLabel();
		lb5.setText("5. Forced Trivia Question");
		JLabel lb6 = new JLabel();
		lb6.setText("6. Triple Your Score");
		jpnl.add(lb);
		jpnl.add(lb1);
		jpnl.add(lb2);
		jpnl.add(lb3);
		jpnl.add(lb4);
		jpnl.add(lb5);
		jpnl.add(lb6);
		jpnl.setBackground(Color.orange);
		JPanel jpnl2 = new JPanel();
		jpnl2.setLayout(new FlowLayout());
		jpnl2.add(jp);
		jpnl2.add(jpnl);
		jpnl2.setBackground(Color.GREEN);
		JPanel jpnl1 = new JPanel();
		jpnl1.setLayout(new BorderLayout());
		jpnl1.add(jpnl2, BorderLayout.CENTER);
		jpnl1.setBackground(Color.GREEN);
		this.add(jpnl1, BorderLayout.EAST);
		
	}
	public void updateRule(){
		bd.updateRule();
		bonusRule.setIcon(new ImageIcon("images/dice" + bd.getSideUp() + ".png"));	
	}
	
	public void scoreHand(){
		
	}
	public void keepHand(){
		
	}
	public Hand getHand(){
		return hand;
	}
	public ArrayList<DieButton> getButtons(){
		return buttons;
	}
	public void setRule(){
		DieButton db = new DieButton(hand.getDie(5));
		db.setButtonIcon();
		buttons.add(db);
		hndPnl.add(buttons.get(5));
		this.add(hndPnl);
		
	}
	public void resetRule(){
		hndPnl.remove(buttons.get(5));
		buttons.remove(5);
	}
}
