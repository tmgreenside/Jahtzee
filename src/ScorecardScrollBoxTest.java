import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class ScorecardScrollBoxTest {

	@Test
	public void testClearScoreCard() {
		ScorecardScrollBox test = new ScorecardScrollBox();
		ArrayList<Integer> upperScorecard = new ArrayList<Integer>();
		ArrayList<Integer> lowerScorecard = new ArrayList<Integer>();

		String LineOne = "0";
		String LineTwo = "0";
		String LineThree = "0";
		String LineFour = "0";
		String LineFive = "0";
		String LineSix = "0";
		String LineThreeKind = "0";
		String LineFourKind = "0";
		String LineSmallStraight = "0";
		String LineLargeStraight = "0";
		String LineFullHouse = "0";
		String LineChance = "0";
		String LineYahtzee = "0";
		
		upperScorecard.add(0, Integer.parseInt(LineOne));
		upperScorecard.add(1, Integer.parseInt(LineTwo));
		upperScorecard.add(2, Integer.parseInt(LineThree));
		upperScorecard.add(3, Integer.parseInt(LineFour));
		upperScorecard.add(4, Integer.parseInt(LineFive));
		upperScorecard.add(5, Integer.parseInt(LineSix));
		lowerScorecard.add(0, Integer.parseInt(LineThreeKind));
		lowerScorecard.add(1, Integer.parseInt(LineFourKind));
		lowerScorecard.add(2, Integer.parseInt(LineSmallStraight));
		lowerScorecard.add(3, Integer.parseInt(LineLargeStraight));
		lowerScorecard.add(4, Integer.parseInt(LineFullHouse));
		lowerScorecard.add(5, Integer.parseInt(LineChance));
		lowerScorecard.add(6, Integer.parseInt(LineYahtzee));
		
		assertTrue(upperScorecard.get(0) == 0);
		assertTrue(upperScorecard.get(1) == 0);
		assertTrue(upperScorecard.get(2) == 0);
		assertTrue(upperScorecard.get(3) == 0);
		assertTrue(upperScorecard.get(4) == 0);
		assertTrue(upperScorecard.get(5) == 0);
		assertTrue(lowerScorecard.get(0) == 0);
		assertTrue(lowerScorecard.get(1) == 0);
		assertTrue(lowerScorecard.get(2) == 0);
		assertTrue(lowerScorecard.get(3) == 0);
		assertTrue(lowerScorecard.get(4) == 0);
		assertTrue(lowerScorecard.get(5) == 0);
		assertTrue(lowerScorecard.get(6) == 0);
	}

	@Test
	public void testShowScores() {
		ScorecardScrollBox test = new ScorecardScrollBox();
		ArrayList<Integer> upperScorecard = new ArrayList<Integer>();
		ArrayList<Integer> lowerScorecard = new ArrayList<Integer>();
		test.clearScoreCard();
		int LineOne = 10;
		int LineTwo = 20;
		int LineThree = 21;
		int LineFour = 12;
		int LineFive = 20;
		int LineSix = 20;
		int LineThreeKind = 25;
		int LineFourKind = 0;
		int LineSmallStraight = 0;
		int LineLargeStraight = 0;
		int LineFullHouse = 30;
		int LineChance = 0;
		int LineYahtzee = 0;
		
		upperScorecard.add(0, LineOne);
		upperScorecard.add(1, LineTwo);
		upperScorecard.add(2, LineThree);
		upperScorecard.add(3, LineFour);
		upperScorecard.add(4, LineFive);
		upperScorecard.add(5, LineSix);
		
		lowerScorecard.add(0, LineThreeKind);
		lowerScorecard.add(1, LineFourKind);
		lowerScorecard.add(2, LineSmallStraight);
		lowerScorecard.add(3, LineLargeStraight);
		lowerScorecard.add(4, LineFullHouse);
		lowerScorecard.add(5, LineChance);
		lowerScorecard.add(6, LineYahtzee);
		
		test.showScores(upperScorecard, lowerScorecard);
		
		assertTrue(upperScorecard.get(0) == LineOne);
		assertTrue(upperScorecard.get(1) == LineTwo);
		assertTrue(upperScorecard.get(2) == LineThree);
		assertTrue(upperScorecard.get(3) == LineFour);
		assertTrue(upperScorecard.get(4) == LineFive);
		assertTrue(upperScorecard.get(5) == LineSix);
		
		assertTrue(lowerScorecard.get(0) == LineThreeKind);
		assertTrue(lowerScorecard.get(1) == LineFourKind);
		assertTrue(lowerScorecard.get(2) == LineSmallStraight);
		assertTrue(lowerScorecard.get(3) == LineLargeStraight);
		assertTrue(lowerScorecard.get(4) == LineFullHouse);
		assertTrue(lowerScorecard.get(5) == LineChance);
		assertTrue(lowerScorecard.get(6) == LineYahtzee);
	}
}