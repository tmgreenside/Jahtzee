import static org.junit.Assert.*;

import org.junit.*;

public class OpenWindowTest {
	
	@Test
	public void testStartGame() {
		OpenWindow window = new OpenWindow();
		window.startGame();
		assertFalse(window.getFirstCategory().equals(window.getSecondCategory()));
	}

	@Test
	public void testSetFirstCategory() {
		OpenWindow window = new OpenWindow();
		String category = "Sports";
		window.setFirstCategory(category);
		assertTrue(window.getFirstCategory().equals(category));
	}

	@Test
	public void testSetSecondCategory() {
		OpenWindow window = new OpenWindow();
		String category = "Entertainment";
		window.setSecondCategory(category);
		assertTrue(window.getSecondCategory().equals(category));
	}

	@Test
	public void testGetFirstCategory() {
		OpenWindow window = new OpenWindow();
		String category = "Sports";
		window.setFirstCategory(category);
		assertTrue(window.getFirstCategory().equals(category));
	}

	@Test
	public void testGetSecondCategory() {
		OpenWindow window = new OpenWindow();
		String category = "Entertainment";
		window.setSecondCategory(category);
		assertTrue(window.getSecondCategory().equals(category));
	}
}