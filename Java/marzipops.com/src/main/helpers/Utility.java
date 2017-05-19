package main.helpers;

import java.util.List;

import main.pages.Category;

public class Utility {
	
	/**
	 * Convert a String into HTML language by adding &lsquo;, etc.
	 * @param text The string to convert into HTML.
	 * @return The converted String.
	 */
	public static String convertToText(String text){
		return text.replaceAll("1", "&lsquo;")
				.replaceAll("2", "&rsquo;")
				.replaceAll("3", "&ldquo;")
				.replaceAll("4", "&rdquo;")
				.replaceAll("-", "&dash;")
				.replaceAll("6", "&ntilde")
				.replaceAll("7", "&hellip;")
				.replaceAll("9", "<br>")
				.replaceAll("�", "&hellip;")

				.replaceAll("~&lsquo;", "1")
				.replaceAll("~&rsquo;", "2")
				.replaceAll("~&ldquo;", "3")
				.replaceAll("~&rdquo;", "4")
				.replaceAll("~5", "5")
				.replaceAll("~&ntilde", "6")
				.replaceAll("~&hellip;", "7")
				.replaceAll("~8", "8")
				.replaceAll("~<br>", "9")
				.replaceAll("~0", "0");
	}
	
	
	/**
	 * Find the Category with a certain name given a list of Categories.
	 * @param rawName The name of Category to search for.
	 * @param listOfCategories The list of Categories to search through.
	 * @return The Category with the name rawName.
	 */
	public static Category getCategory(String rawName, List<Category> listOfCategories){
		for(Category c : listOfCategories){
			if(rawName.equals(c.getRawName())){
				return c;
			}
		}

		return null;
	}
}
