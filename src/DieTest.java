import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class DieTest {


	@Test
	public void testRollDie() {
		Die test = new Die();
		for(int i = 0; i < 100; i++)
			assert(test.getSideUp() <=6 && test.getSideUp() >= 1);
	}

	@Test
	public void testGetSideUp() {
		Die test = new Die();
		Random myRoller = new Random();
		int dice = myRoller.nextInt(6) + 1;
		test.diceValue = dice;
		assertEquals(dice, test.getSideUp());
	}

	@Test
	public void testGetIsKept() {
		Die test = new Die();
		test.setIsKept(false);
		assertEquals(false, test.getIsKept());
		test.setIsKept(true);
		assertEquals(true, test.getIsKept());
	}

	@Test
	public void testSetIsKept() {
		Die test = new Die();
		test.setIsKept(false);
		assertEquals(false, test.getIsKept());
		test.setIsKept(true);
		assertEquals(true, test.getIsKept());
	}

}
