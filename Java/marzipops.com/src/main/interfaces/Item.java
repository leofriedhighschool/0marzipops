package main.interfaces;

import main.pages.Category;

/**
 * <b>Type:</b> Interface
 * <br>
 * An object that implements the Item interface allows that object to be an item in a Category.
 */
public interface Item {

	/**
	 * @return The raw name of the page, as it would appear on the name of the file.
	 */
	public String getRawName();

	/**
	 * @return The name of the page as it would appear in HTML text or in the title of a webpage.
	 */
	public String getTextName();

	/**
	 * @return The name of the page as it would appear in the name of the image. (Capitalized in some cases).
	 */
	public String getImageName();

	/**
	 * @return The location of the file of the page. This does not include the name of the file.
	 */
	public String getLocation();

	/**
	 * @return The file path to get from the location of the page to the root directory.
	 */
	public String getReverseLocation();

	/**
	 * @return the default parent Category to this item. (The one that would appear in the top filepath bar.
	 */
	public Category getParent();


	/**
	 * @return The part of the HTML file that contains the top location line of the page.
	 */
	public default String buildTopLine(){

		String write = "";
		write += "<div class='row'><div class='small-12 columns'><p class='topLine'>";
		

		Category curCat = getParent();
		if(curCat != null){
			write += "<a href='" + getReverseLocation() + "Shop.html#'>shop</a>: ";
			String text = "";
			while(curCat.getParent() != null){
				text = "<a href=\"" + getReverseLocation() + curCat.getLocation() + curCat.getRawName() + ".html#\">" + curCat.getTextName() + "</a>: " + text;
				curCat = curCat.getParent();
			}
			write += text;
		}
		write += getTextName() + "</p></div></div><br>";
		
		return write;
	}


}
