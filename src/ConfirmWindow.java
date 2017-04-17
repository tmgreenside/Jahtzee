import javax.swing.*;
import java.awt.*;

public class ConfirmWindow extends JFrame {
	
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
	
	public void setPlayTrivia(boolean play) {
		playTrivia = play;
	}
	
	public boolean getPlayTrivia() {
		return playTrivia;
	}
}
