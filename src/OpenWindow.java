import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class creates the Welcome screen that enables the user
 * to select the categories before starting a game.
 * @author Trevor Greenside
 * @version Last updated: 17 April 2017
 */
public class OpenWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private String firstCategory;
	private String secondCategory;
	
	// window components
	private JPanel thePanel;
	private JPanel menuPanel;
	private JPanel northPanel;
	private JPanel helpPanel;
	private JButton submitButton;
	private JComboBox<String> menu1;
	private JComboBox<String> menu2;
	private JLabel msg;
	private JLabel theLogo;
	private JLabel help;
	private RulesWindow rules;
	
	public OpenWindow() {
		this.setTitle("Jahtzee - Start");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thePanel = new JPanel(new BorderLayout());
		thePanel.setBackground(Color.GREEN);
		String[] categories = {"Entertainment","Literature","Food","Sports","Automotives","History","Music","Science"};
		
		northPanel = new JPanel(new BorderLayout());
		northPanel.setBackground(Color.GREEN);
		theLogo = new JLabel();
		theLogo.setIcon(new ImageIcon("images/Jahtzee-Logo.png"));
		northPanel.add(theLogo, BorderLayout.WEST);
		
		help = new JLabel();
		help.setIcon(new ImageIcon("images/help-icon.png"));
		help.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getRules();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// does nothing
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// does nothing
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// does nothing
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// does nothing
			}
		});
		helpPanel = new JPanel(new BorderLayout());
		helpPanel.setBackground(Color.GREEN);
		helpPanel.add(help, BorderLayout.NORTH);
		northPanel.add(new JPanel().add(helpPanel), BorderLayout.EAST);
		
		thePanel.add(northPanel, BorderLayout.NORTH);
		
		menu1 = new JComboBox<>();
		menu2 = new JComboBox<>();
		for (String category : categories) {
			menu1.addItem(category);
			menu2.addItem(category);
		}
		menu1.addActionListener(e -> {
			setFirstCategory(menu1.getItemAt(menu1.getSelectedIndex()));
		});
		menu2.addActionListener(e -> {
			setSecondCategory(menu2.getItemAt(menu2.getSelectedIndex()));
		});
		menu2.setSelectedIndex(1); // second item will be preselected instead of first
		firstCategory = menu1.getItemAt(menu1.getSelectedIndex());
		secondCategory = menu2.getItemAt(menu2.getSelectedIndex());
		msg = new JLabel("");
		menuPanel = new JPanel(new GridLayout(0,1));
		menuPanel.setBackground(Color.GREEN);
		menuPanel.add(new JLabel("Select first category:"));
		menuPanel.add(menu1);
		menuPanel.add(new JLabel("Select second category:"));
		menuPanel.add(menu2);
		menuPanel.add(msg);
		thePanel.add(menuPanel, BorderLayout.CENTER);
		
		submitButton = new JButton("Let's Play");
		submitButton.setBackground(Color.cyan);
		submitButton.addActionListener(e -> {
			startGame();
		});
		thePanel.add(submitButton, BorderLayout.SOUTH);
		this.add(thePanel);
		this.setVisible(true);
		
		rules = new RulesWindow();
	}
	
	public void startGame() {
		if (firstCategory.equals(secondCategory)) {
			msg.setText("Duplicate categories are not allowed.");
		} else {
			msg.setText("");
			this.setVisible(false);
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	public void setFirstCategory(String category) {
		firstCategory = category;
	}
	
	public void setSecondCategory(String category) {
		secondCategory = category;
	}
	
	public String getFirstCategory() {
		return firstCategory;
	}
	
	/**
	 * This method returns as a string the name of the second selected
	 * category.
	 * @return
	 */
	public String getSecondCategory() {
		return secondCategory;
	}
	
	/**
	 * This method will display a window containing an explanation for
	 * the rules of Jahtzee.
	 */
	public void getRules() {
		rules.setVisible(true);
	}
}
