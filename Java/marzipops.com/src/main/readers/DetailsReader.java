package main.readers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DetailsReader {
	
	private static final int START = 1;			//The starting row of the sheet
	
	private List<String[]> detailsArray;
	
	private int breakingPoint;					//The point in which the questions get separated into different groups
	
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
	 * @return the point in which the questions get separated into different groups
	 */
	public int getBreakingPoint(){
		return breakingPoint;
	}
}
