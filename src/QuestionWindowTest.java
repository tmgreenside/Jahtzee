import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.*;

public class QuestionWindowTest {

	@Test
	public void testGenerateComboxString() throws IOException {
		int Score = 20;
		String cat1 =  "Music";
		String cat2 = "Entertainment";
		ScorecardScrollBox S = new ScorecardScrollBox(); 
		BonusDie die = new BonusDie();
		Hand h = new Hand(die);
		HandPanel hp = new HandPanel(h);
		RollButton rb = new RollButton(hp, S);
		QuestionWindow window = new QuestionWindow(Score, cat1, cat2, S, die, rb);
		String[] comboBoxArray;
		  if(die.getRule() == "Double or Nothing"){
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

	@Test
	public void testSetCorrectScore() throws IOException {
		int Score = 20;
		String cat1 =  "Music";
		String cat2 = "Entertainment";
		ScorecardScrollBox S = new ScorecardScrollBox(); 
		BonusDie die = new BonusDie();
		Hand h = new Hand(die);
		HandPanel hp = new HandPanel(h);
		RollButton rb = new RollButton(hp, S);
		QuestionWindow window = new QuestionWindow(Score, cat1, cat2, S, die, rb);
		window.setCorrectScore();
		assertTrue(window.getScore() == Score);
	}

	@Test
	public void testSetIncorrectScore() throws IOException {
		int Score = 0;
		String cat1 =  "Music";
		String cat2 = "Entertainment";
		ScorecardScrollBox S = new ScorecardScrollBox(); 
		BonusDie die = new BonusDie();
		Hand h = new Hand(die);
		HandPanel hp = new HandPanel(h);
		RollButton rb = new RollButton(hp, S);
		QuestionWindow window = new QuestionWindow(Score, cat1, cat2, S, die, rb);
		window.setIncorrectScore();
		assertTrue(window.getScore() == Score);
	}

	@Test
	public void testGetScore() throws IOException {
		int Score = 20;
		String cat1 =  "Music";
		String cat2 = "Entertainment";
		ScorecardScrollBox S = new ScorecardScrollBox(); 
		BonusDie die = new BonusDie();
		Hand h = new Hand(die);
		HandPanel hp = new HandPanel(h);
		RollButton rb = new RollButton(hp, S);
		QuestionWindow window = new QuestionWindow(Score, cat1, cat2, S, die, rb);
		window.setCorrectScore();
		assertTrue(window.getScore() == Score);
	}
}