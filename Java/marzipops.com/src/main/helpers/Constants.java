package main.helpers;

public class Constants {

	/**
	 * A blank row of HTML.
	 */
	public final static String BLANK = "<div class='row'>&nbsp</div>";
	
	/**
	 * The email that forums should direct to.
	 */
	public final static String EMAIL = "dahlia@marzipops.com";
	
	/**
	 * The excel file that should be read from.
	 */
	public final static String EXCEL_FILE = "../Marzipops Descriptions xls.xls";
	
	/**
	 * The location of the actual website. 
	 */
	public final static String WEB_LOCATION = "../../Build/";
		
	/**
	 * List of social media sites that are referenced on the website.
	 */
	public final static String[] LIST_OF_MEDIA = {"Facebook", "Twitter", "Instagram", "Pinterest"};
	
	/**
	 * List of special pages that appear in the header.
	 */
	public final static String[] LIST_OF_SPECIALS = {"Shop", "Custom", "About", "FAQ", "Contact"};
		
	/**
	 * List of holidays.
	 */
	public final static String[] LIST_OF_HOLIDAYS = {"valentine's day", "purim", "passover", "easter", "mother's day", "father's day", "july 4th", "rosh hashanah", "halloween", "thanksgiving", "hanukkah", "christmas"};
	
	/**
	 * List of dates that the holidays occur on.
	 */
	public final static int[] LIST_OF_HOLIDAY_DATES = {210, 			211, 		410, 		515, 	516, 			619, 			704, 		930, 			1031, 			1120, 			1224, 		1225};

	/**
	 * List of Categories.
	 */
	public final static String[] LIST_OF_CATEGORIES = {"new", "featured", "holidays", "three dimensional", "candy bites", "animals", "sports", "candy tiles", "emoji", "baby", "flowers", "food designs", "winter break", "summer fun", "themes", "2-in-1", "everything"};

	/**
	 * List of Categories with child Categories.
	 */
	public final static String[][][] LIST_OF_MIDDLE_CATEGORIES = {{{"holidays"}, Utility.sortHolidays()}};





}
