import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class ScorecardScrollBoxTest {

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