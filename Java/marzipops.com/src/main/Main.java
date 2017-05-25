package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import main.helpers.Constants;
import main.helpers.Utility;
import main.interfaces.Item;
import main.pages.Category;
import main.pages.Index;

public class Main {
	
	public static void main(String[] args){
		Utility.clearDirectory(new File(Constants.WEB_LOCATION + "Categories"), false);	
		Utility.clearDirectory(new File(Constants.WEB_LOCATION + "Products"), false);
		List<Category> categories = makeListOfCategories();		
	}

	
	public static List<Category> makeListOfCategories(){		
		List<Category> listOfCategories = new ArrayList<Category>();
		
		//Create the Shop Category and fill it with categories.
		Category index = new Index("index");
		fillCategory(index, Constants.LIST_OF_CATEGORIES);
		listOfCategories.add(index);

		for(Item item : index.getListOfAllChildCategories()){
			if(item.getRawName().equals(Utility.sortHolidays()[0])){
				index.addToList((Category) item);
			}
		}
		
		String[] otherHomePageNames = {"indexSignedUp", "Shop", "ShopSignedUp"};
		for(String pageName : otherHomePageNames){
			Category otherHomePage = new Index(pageName);
			listOfCategories.add(otherHomePage);
			for(Item item : index.getListOfItems()){
				otherHomePage.addToList(item);
			}
		}
		
		listOfCategories.addAll(index.getListOfAllChildCategories());
		return listOfCategories;
	}
	
	public static Category fillCategory(Category target, String[] listOfCategoryNames){
		for(int i=0; i<listOfCategoryNames.length; i++){
			Category newCategory = new Category(listOfCategoryNames[i], target);
			for(String[][] infoList : Constants.LIST_OF_SPECIAL_CATEGORIES){
				if(infoList[0][0].equals(newCategory.getRawName())){
					fillCategory(newCategory, infoList[0]);
				}
			}
			target.addToList(newCategory);
		}
	}
	
}
