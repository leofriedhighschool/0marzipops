package main;

import java.io.File;
import java.util.List;

import main.helpers.Constants;
import main.helpers.Utility;
import main.pages.Category;
import main.pages.Index;

public class Main {

	public static void main(String[] args){
		Utility.clearDirectory(new File(Constants.WEB_LOCATION + "Categories"), false);	
		Utility.clearDirectory(new File(Constants.WEB_LOCATION + "Products"), false);
		List<Category> categories = makeListOfCategories();		
	}

	
	public static List<Category> makeListOfCategories(){
		//Create the Shop Category and fill it with categories.
		Category shop = new Index("Shop");
	}
	
	
}
