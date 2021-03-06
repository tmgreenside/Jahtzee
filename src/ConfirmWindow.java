import javax.swing.*;
import java.awt.*;

/**
 * This class displays a prompt for the user to select whether
 * or not to play a Trivia question. The user is prevented from
 * closing the window. Making a selection closes the window.
 * @author Trevor Greenside
 * @version Last Changed: 17 April 2017
 * CPSC 224 Group Project: Jahtzee
 */
public class ConfirmWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private boolean playTrivia;
	private JLabel message;
	private JPanel messagePanel;
	private JPanel buttons;
	private JPanel centerFill;
	private JButton yesButton;
	private JButton noButton;
	
	public ConfirmWindow() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(500, 125);
		this.setTitle("Jahtzee - Trivia Option");
		this.setBackground(Color.BLUE);
		message = new JLabel("Would you like to increase your score with a Trivia question?");
		message.setForeground(Color.WHITE);
		message.setBackground(Color.BLUE);
		messagePanel = new JPanel();
		messagePanel.setBackground(Color.BLUE);
		messagePanel.add(message);
		
		buttons = new JPanel();
		buttons.setBackground(Color.BLUE);
		yesButton = new JButton("Yes");
		yesButton.addActionListener(e -> {
			setPlayTrivia(true);
			this.setVisible(false);
		});
		noButton = new JButton("No");
		noButton.addActionListener(e -> {
			setPlayTrivia(false);
			this.setVisible(false);
		});
		buttons.add(yesButton);
		buttons.add(noButton);
		
		this.add(buttons, BorderLayout.SOUTH);
		this.add(messagePanel, BorderLayout.NORTH);
		
		centerFill = new JPanel();
		centerFill.setBackground(Color.BLUE);
		this.add(centerFill, BorderLayout.CENTER);
		
		playTrivia = true;
		
		this.setBackground(Color.BLUE);
		this.setVisible(true);
	}
	
	/**
	 * This method takes as a parameter a boolean value to set whether or
	 * not a Trivia question will be played.
	 * @param play
	 */
	public void setPlayTrivia(boolean play) {
		playTrivia = play;
	}
	public void disableNo(){
		noButton.setEnabled(false);
	}
	/**
	 * This method returns the boolean value determining whether or not
	 * a Trivia question will be played.
	 * @return
	 */
	public boolean getPlayTrivia() {
		return playTrivia;
	}
}
