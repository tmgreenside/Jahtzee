//package goupproject;

import  java.io.*;
import java.util.*;
public class QuestionCache {
	private String categoryOne;
	private String categoryTwo;
	private String Question;
	private String Answer;
	private ArrayList<String> CategoryOneArray;
	private ArrayList<String> CategoryTwoArray;
	private ArrayList<String> choiceArray;
	public QuestionCache(String cat1, String cat2){
		categoryOne = cat1 + ".txt";
		categoryTwo = cat2 + ".txt";
		CategoryOneArray = new ArrayList();
		CategoryTwoArray = new ArrayList();
		choiceArray = new ArrayList();
	}
	public void createCategoryOneArray() throws IOException{
		FileInputStream fileInputStream = new FileInputStream(categoryOne);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8" );
		BufferedReader textReader = new BufferedReader(inputStreamReader);
		for(String line = textReader.readLine(); line != null; line = textReader.readLine()){
			CategoryOneArray.add(line);
		}
		textReader.close();
	}
	public void createCategoryTwoArray() throws IOException{
		FileInputStream fileInputStream = new FileInputStream(categoryTwo);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
		BufferedReader textReader = new BufferedReader(inputStreamReader);
		for(String line = textReader.readLine(); line != null; line = textReader.readLine()){
			CategoryTwoArray.add(line);
		}
		textReader.close();
	}
	public void setQuestion(){
		int random = 1;
		random = (int)(Math.random() * 2) + 1;
		if(random == 1){
			random = (int)(Math.random() * 20);
			Question = CategoryOneArray.get(random * 5);
			Answer = CategoryOneArray.get((random * 5) + 1);
			choiceArray.clear();
			choiceArray.add(CategoryOneArray.get((random * 5) + 1));
			choiceArray.add(CategoryOneArray.get((random * 5) + 2));
			choiceArray.add(CategoryOneArray.get((random * 5) + 3));
			choiceArray.add(CategoryOneArray.get((random * 5) + 4));
		}
		else if(random == 2){
			random = (int)(Math.random() * 20);
			Question = CategoryTwoArray.get(random * 5);
			Answer = CategoryTwoArray.get((random * 5) + 1);
			choiceArray.clear();
			choiceArray.add(CategoryTwoArray.get((random * 5) + 1));
			choiceArray.add(CategoryTwoArray.get((random * 5) + 2));
			choiceArray.add(CategoryTwoArray.get((random * 5) + 3));
			choiceArray.add(CategoryTwoArray.get((random * 5) + 4));
		}
	}
	public String getQuestion(){
		return Question;
	}
	public String getAnswer(){
		return Answer;
	}
	public void setChoices(){
		Collections.shuffle(choiceArray);
		Collections.shuffle(choiceArray);
	}
	public ArrayList getChoices(){
		return choiceArray;
	}
}
