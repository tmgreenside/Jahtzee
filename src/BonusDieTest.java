import static org.junit.Assert.*;

import org.junit.Test;

public class BonusDieTest {

	@Test
	public void testGetSideUp() {
		BonusDie test = new BonusDie();
		test.diceValue = 1;
		assertEquals(1, test.getSideUp());
	}

	@Test
	public void testUpdateRule() {
		BonusDie test = new BonusDie();
		for(int i = 1; i < 7; i++){
			test.diceValue = i;
			test.updateRule();
			if(test.diceValue == 1)
				assertEquals("Extra Die", test.getRule());
			if(test.diceValue == 2)
				assertEquals("Double Score", test.getRule());
			if(test.diceValue == 3)
				assertEquals("Double or Nothing", test.getRule());
			if(test.diceValue == 4)
				assertEquals("Extra roll", test.getRule());
			if(test.diceValue == 5)
				assertEquals("Forced Trivia", test.getRule());
			if(test.diceValue == 6)
				assertEquals("Triple Score", test.getRule());
		}
	}

	@Test
	public void testGetRule() {
		BonusDie test = new BonusDie();
		for(int i = 1; i < 7; i++){
			test.diceValue = i;
			test.updateRule();
			if(test.getSideUp() == 1)
				assertEquals("Extra Die", test.getRule());
			else if(test.getSideUp() == 2)
				assertEquals("Double Score", test.getRule());
			else if(test.getSideUp() == 3)
				assertEquals("Double or Nothing", test.getRule());
			else if(test.getSideUp() == 4)
				assertEquals("Extra roll", test.getRule());
			else if(test.getSideUp() == 5)
				assertEquals("Forced Trivia", test.getRule());
			else if(test.getSideUp() == 6)
				assertEquals("Triple Score", test.getRule());
		}
	}

	@Test
	public void testBonusDie() {
		BonusDie test = new BonusDie();
		test.getSideUp();
		if(test.getSideUp() == 1)
			assertEquals("Extra Die", test.getRule());
		else if(test.getSideUp() == 2)
			assertEquals("Double Score", test.getRule());
		else if(test.getSideUp() == 3)
			assertEquals("Double or Nothing", test.getRule());
		else if(test.getSideUp() == 4)
			assertEquals("Extra roll", test.getRule());
		else if(test.getSideUp() == 5)
			assertEquals("Forced Trivia", test.getRule());
		else if(test.getSideUp() == 6)
			assertEquals("Triple Score", test.getRule());
	}
}
