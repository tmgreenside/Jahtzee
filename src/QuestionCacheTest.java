import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.IIOException;

import org.junit.*;

public class QuestionCacheTest {

	@Test
	public void testQuestionCache() {
		String cat1 = "Music";
		String cat2 = "Entertainment";
		QuestionCache cache = new QuestionCache(cat1, cat2);
		String categoryOne = cat1 + ".txt";
		String categoryTwo = cat2 + ".txt";
		assertTrue(categoryOne.equals("Music.txt") && categoryTwo.equals("Entertainment.txt"));
	}

	@Test
	public void testCreateCategoryOneArray() throws IOException {
		String cat1 = "Music";
		FileReader fr = new FileReader(cat1 + ".txt");
		BufferedReader textReader = new BufferedReader(fr);
		ArrayList<String> CategoryOneArray = new ArrayList<>();
		for (String line = textReader.readLine(); line != null; line = textReader.readLine()){
			CategoryOneArray.add(cat1);
		}
		textReader.close();
		assertTrue(CategoryOneArray.get(0).equals(cat1));
	}

	@Test
	public void testCreateCategoryTwoArray() throws IOException {
		String cat2 = "Entertainment";
		FileReader fr = new FileReader(cat2 + ".txt");
		BufferedReader textReader = new BufferedReader(fr);
		ArrayList<String> CategoryTwoArray = new ArrayList<>();
		for (String line = textReader.readLine(); line != null; line = textReader.readLine()){
			CategoryTwoArray.add(cat2);
		}
		textReader.close();
		assertTrue(CategoryTwoArray.get(0).equals(cat2));
	}

	@Test
	public void testSetQuestion() {
		ArrayList<String> category2Array = new ArrayList<>();
		String Question = "Which of the following authors wrote The Hunt for Red October?";
		category2Array.add(Question);
		assertTrue(category2Array.get(0).equals(Question));
	}

	@Test
	public void testGetQuestion() {
		ArrayList<String> category2Array = new ArrayList<>();
		String Question = "Which of the following authors wrote The Hunt for Red October?";
		category2Array.add(Question);
		assertTrue(category2Array.get(0).equals(Question));
	}

	@Test
	public void testGetAnswer() {
		ArrayList<String> choiceArray = new ArrayList<>();
		String Answer = "Tom Clancy";
		String choice1 = "Tom Clancy";
		String choice2 = "Robert Ludlum";
		String choice3 = "John Grisham";
		String choice4 = "Ken Follett";
		choiceArray.add(choice1);
		choiceArray.add(choice2);
		choiceArray.add(choice3);
		choiceArray.add(choice4);
		assertTrue(choiceArray.get(0).equals(Answer));
	}

	@Test
	public void testSetChoices() {
		ArrayList<String> choiceArray = new ArrayList<>();
		String choice1 = "Tom Clancy";
		String choice2 = "Robert Ludlum";
		String choice3 = "John Grisham";
		String choice4 = "Ken Follett";
		choiceArray.add(choice1);
		choiceArray.add(choice2);
		choiceArray.add(choice3);
		choiceArray.add(choice4);
		assertTrue(choiceArray.get(0).equals(choice1) && choiceArray.get(1).equals(choice2) && choiceArray.get(2).equals(choice3) && choiceArray.get(3).equals(choice4));
	}

	@Test
	public void testGetChoices() {
		ArrayList<String> choiceArray = new ArrayList<>();
		String choice1 = "Tom Clancy";
		String choice2 = "Robert Ludlum";
		String choice3 = "John Grisham";
		String choice4 = "Ken Follett";
		choiceArray.add(choice1);
		choiceArray.add(choice2);
		choiceArray.add(choice3);
		choiceArray.add(choice4);
		assertTrue(choiceArray.get(0).equals(choice1) && choiceArray.get(1).equals(choice2) && choiceArray.get(2).equals(choice3) && choiceArray.get(3).equals(choice4));
	}

}
