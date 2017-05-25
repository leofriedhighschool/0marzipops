package main.readers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import main.helpers.Utility;

public class DetailsReader {
	
	/**
	 * The first row of the sheet that contains questions.
	 */
	private static final int START = 1;
	
	/**
	 * An List containing sets of question / answer pairs.
	 */
	private List<String[]> detailsArray;
	
	/**
	 * The first row of the second section of questions.
	 */
	private int breakingPoint;
	
	/**
	 * The constructor of a DetailsReader Object.
	 * Reads the excel file and stores it into an array.
	 * @param fileLoc The location of the excel file.
	 */
	public DetailsReader(String fileLoc) throws BiffException, IOException {
		File file = new File(fileLoc);
		Workbook w = Workbook.getWorkbook(file);
		Sheet sheet = w.getSheet(1);

		detailsArray = new ArrayList<String[]>();
		
		for(int row = START; row < Integer.valueOf(sheet.getCell(0, 0).getContents()) + START; row++){
			detailsArray.set(row, new String[2]);
			detailsArray.get(row)[0] = sheet.getCell(2, row).getContents();
			detailsArray.get(row)[1] = sheet.getCell(3, row).getContents();
		}
		
		breakingPoint = Integer.valueOf(sheet.getCell(1, 0).getContents());	
	}
	
	/**
	 * @return The first row of the second section of questions.
	 */
	public int getBreakingPoint(){
		return breakingPoint;
	}
	
	/**
	 * @return The number of questions that should go onto the Details Page.
	 */
	public int getNumberOfQuestions(){ 
		return detailsArray.size();
	}
	
	/**
	 * Get a particular question.
	 * @param index The index of the question.
	 * @return The question at a certain index.
	 */
	public String getQuestion(int index){
		return Utility.convertToText(detailsArray.get(index)[0]);
	}
	
	/**
	 * Get a particular answer.
	 * @param index The index of the answer.
	 * @return The answer to the question at a certain index.
	 */
	public String getAnswer(int index){
		return Utility.convertToText(detailsArray.get(index)[1]);
	}
}