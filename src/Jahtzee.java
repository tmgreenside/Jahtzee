import javax.swing.*;

public class Jahtzee {

	public static void main(String[] args) {
		JFrame testFrame = new JFrame("Test");
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setSize(200, 200);
		Die theDie = new Die(6);
		testFrame.add(theDie);
		
		testFrame.setVisible(true);
		System.out.println("Guys, I think it works.");
	}

}
