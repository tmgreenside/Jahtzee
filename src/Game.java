import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * This class passes information between the OpenWindow and the
 * GameWindow, and uses a loop so that the user can start a new
 * game when desired.
 * @author Trevor Greenside
 * @version Last Changed: 17 April 2017
 * CPSC 224 Group Project: Jahtzee
 */
public class Game {

	public static OpenWindow start;
	
	public static void main(String[] args) {
		start = new OpenWindow();
		start.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				//do nothing
			}

			@Override
			public void windowClosing(WindowEvent e) {
				GameWindow game = new GameWindow(start.getFirstCategory(),start.getSecondCategory());
			}

			@Override
			public void windowClosed(WindowEvent e) {
				//do nothing
			}

			@Override
			public void windowIconified(WindowEvent e) {
				//do nothing
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				//do nothing
			}

			@Override
			public void windowActivated(WindowEvent e) {
				//do nothing
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				//do nothing
			}
			
		});
	}

}