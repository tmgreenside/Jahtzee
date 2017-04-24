import static org.junit.Assert.*;

import org.junit.Test;

public class ConfirmWindowTest {

	@Test
	public void testSetPlayTrivia() {
		ConfirmWindow test = new ConfirmWindow();
		test.setPlayTrivia(false);
		assertEquals(false, test.getPlayTrivia());
		test.setPlayTrivia(true);
		assertEquals(true, test.getPlayTrivia());
	}

	@Test
	public void testGetPlayTrivia() {
		ConfirmWindow test = new ConfirmWindow();
		test.setPlayTrivia(false);
		assertEquals(false, test.getPlayTrivia());
		test.setPlayTrivia(true);
		assertEquals(true, test.getPlayTrivia());
	}

}
