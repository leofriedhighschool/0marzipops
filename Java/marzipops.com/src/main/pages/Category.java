package main.pages;

import java.util.ArrayList;

import main.interfaces.Item;
import main.interfaces.Page;

public class Category extends Page implements Item {

	private Category parent;
	private ArrayList<Item> listOfItems;
	
	
	////////////////////
	////CONSTRUCTORS////
	////////////////////
	
	public Category(String name, Category parent){
		super(name, parent.getChildLocation(), Type.CATEGORY);
		this.parent = parent;
		listOfItems = new ArrayList<Item>();
	}
	
	public String getChildLocation(){
		return getLocation() + getRawName() + "/";
	}
	
	public void addToList(Item item){
		listOfItems.add(item);
	}
	
	
	////////////////////////////////
	//buildContent() AND HELPERS////
	////////////////////////////////
	
	public String buildContent(){
		String write = "";

		//Location line and Slideshow 
		write += buildTopLine();		
		
		//Grid
		write += "<div class='row'>";
		for(int i=0; i<listOfItems.size(); i++){
			Item item = listOfItems.get(i);

			write += "<div class='small-6 medium-4 large-3 columns end'><div class='row'><div class='small-12 columns'>";
			write += "<a href=\"" + getReverseLocation() + item.getLocation() + item.getHTMLName() + ".html#\"><img src=\"" + getReverseLocation() + "Images/" + item.getLocation() + "SQB " + item.getImageName() + " Marzipan Lollipops Marzipops.jpg\"></img></a>";
			write += "<p class='center'>" + item.getHTMLName() + "</p>";
			write += "</div></div></div>";

			//Space between rows
			
			if((i + 1) % 2 == 0){
				write += "<div class='small-12 show-for-small-only columns'>&nbsp;</div>";
			}
			if((i + 1) % 3 == 0){
				write += "<div class='small-12 show-for-medium-only columns'>&nbsp;</div>";
			}
			if((i + 1) % 4 == 0){
				write += "<div class='small-12 show-for-large-up columns'>&nbsp;</div>";
			}
		}
		write += "</div>";


		//Bottom Forum
		buildBottomForum();

		return write;
	}
	
	public String buildBottomForum(){
		return "";
	}
	
	
	////////////////
	////GETTERS/////
	////////////////
	
	/**
	 * @return The name of the page as it would appear in the name of the image. (Capitalized in some cases).
	 */
	public String getImageName(){
		return getRawName().toUpperCase();
	}
	
	/**
	 * @return the default parent Category to this item. (The one that would appear in the top filepath bar.
	 */
	public Category getParent(){
		return parent;
	}
}
