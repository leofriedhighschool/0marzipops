package main.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.helpers.Constants;
import main.helpers.Utility;
import main.interfaces.Item;
import main.interfaces.Page;
import main.readers.ProductInfoReader;
import main.readers.ProductInfoReader.Info;


public class Product extends Page implements Item{

	//////////////////////////
	////INSTANCE VARIABLES////
	//////////////////////////
	
	/**
	 * The Object that information of this Product can be read off of the excel file with.
	 */
	ProductInfoReader productInfoReader;
	
	/**
	 * The id of this product. This allows the ProductInfoReader to know what Product this is.
	 */
	int id;
	
	
	////////////////////
	////CONSTRUCTORS////
	////////////////////
	
	/**
	 * The main constructor for a Product Object. It takes an id, rather than a name,
	 * so a foreign method can create a product object for each Product without knowing the name of each Product.
	 * @param id The id of this Product.
	 * @param productInfoReader The Object that information of this Product can be read off of the excel file with.
	 */
	public Product(int id, ProductInfoReader productInfoReader){
		super(productInfoReader.getInfo(Info.RAW_NAME, id), "Products/", PageType.PRODUCT);
		this.productInfoReader = productInfoReader;
		this.id = id;
	}

	
	//////////////////////
	////buildContent()////
	//////////////////////
	
	/**
	 * Allows the use of a default method to fulfill an abstract one.
	 */
	public String buildTopLine(){ return Item.super.buildTopLine();}
	
	/**
	 * Abstract method of Page.java
	 * @return The part of the HTML file that contains the main content of the page.
	 */
	public String buildContent(){

		String write = "";

		//Location Line
		write += buildTopLine();


		//Picture Text
		String picture = "<div class='small-6 columns' id='productPic'><img src='../Images/Products/SQB " + getImageName() + " Marzipan Lollipops Marzipops.jpg' id='mainPic'></img>"
				+ "<p class='text'>Click <a class='popBlue' href='../Custom.html#'>here</a> for custom&nbsp;orders.</p>"
				+ "</div>";


		//Buy Now Text
		String buyNow = "";
		if(!getSoldOut()){
			buyNow += "<div class='small-6 medium-3 large-2 columns end zeroPadding'><a href='http://www.etsy.com/listing/" + getEtsyCode() + "' target='_blank'><img src='../Images/Click Images/Buy Now.jpg'></img></a></div>";
		}
		else{
			buyNow += "<div class='small-12 columns'>"
					+ "<p class='text bold fontRed'>SOLD OUT</p>"
					+ "<p class='text'>Sorry, we are sold out of " + getTextName() + ".<br>"
					+ "Browse our <a href='../index.html' class='popBlue'>other products,</a>" +"or visit our <a href='www.etsy.com/shop/marzipops' class='popBlue'>Etsy shop.</a><br>"
					+ "You can also check back later.</p>"
					+ "</div>";
		}


		//Build Picture and Description
		write += "<div class='row' id='picDiscWrapper'>"
				+ picture
				+ "<div class='small-6 columns' id='productDescription'>"
				+ "<div class='row'><div class='small-12 columns'><p class='text bold'>" + getTextName() + "</p></div></div>"
				+ "<div class='row'><div class='small-12 columns'><p class='text'>" + getDescription() + "</p></div></div>"
				+ "<div class='row'><div class='small-12 columns'><p class='text'>" + getAvailable() + ".</p></div></div>"
				+ "<div class='row'><div class='small-12 columns'>"
				+ "<a data-pin-do='buttonPin' data-pin-count='above' href='http://www.pinterest.com/pin/create/button/?url=http://www.marzipops.com/Products/" + getRawName() + ".html&media=http://www.marzipops.com/Images/Products/SQB " + getImageName() + " Marzipan Lollipops Marzipops.jpg&description=" + getRawName() + " by marzipops.com'>"
				+ "<img src='http://assets.pinterest.com/images/pidgets/pinit_fg_en_rect_gray_20.png'/>"
				+ "</a>&nbsp;"
				+ "</div></div><br>"
				+ "<div class='row'>" + buyNow + "</div>"
				+ "</div>"
				+ "</div>" + Constants.BLANK;

		return write;
	}


	////////////////
	////GETTERS/////
	////////////////

	/**
	 * Abstract method of Item.java
	 * @return The name of the page as it would appear in the name of the image. (Capitalized in some cases).
	 */
	public String getImageName(){
		return getRawName();
	}

	/**
	 * Abstract method of Item.java
	 * @return The default parent Category to this item. (The one that would appear in the top filepath bar.
	 */
	public Category getParent(){
		return Utility.getCategory(productInfoReader.getInfo(Info.DEFAULT_CATEGORY, id), productInfoReader.getListOfCategories());
	}

	/**
	 * @return A converted-to-text version of the description of this Product.
	 */
	public String getDescription(){
		return Utility.convertToText(productInfoReader.getInfo(Info.DESCRIPTION, id));
	}

	/**
	 * @return A converted-to-text version of the availability of this Product.
	 */
	public String getAvailable(){
		return Utility.convertToText(productInfoReader.getInfo(Info.AVAILABLE, id));
	}
	
	/**
	 * @return A list of all of the categories that this Product belongs to.
	 */
	public List<Category> getCategories(){
		List<String> stringList = Arrays.asList(productInfoReader.getInfo(Info.CATEGORIES, id).split("\\s*,\\s*"));
		List<Category> returnList = new ArrayList<Category>();
		for(String str : stringList){
			returnList.add(Utility.getCategory(str, productInfoReader.getListOfCategories()));
		}
		return returnList;
	}
	
	/**
	 * @return A list of all of the keywords that should bring up this Product during a search.
	 */
	public List<String> getSearchTerms(){
		return Arrays.asList(productInfoReader.getInfo(Info.SEARCH_TERMS, id).split("\\s*,\\s*"));
	}
	
	/**
	 * @return The code for the etsy page of this Product.
	 */
	public int getEtsyCode(){
		return Integer.parseInt(productInfoReader.getInfo(Info.ETSY, id));
	}
	
	/**
	 * @return The number of extra photos this Product has.
	 */
	public int getNumberOfExtraPhotos(){
		return Integer.parseInt(productInfoReader.getInfo(Info.EXTRA_PHOTOS, id));
	}
	
	/**
	 * @return Whether this Product is sold out.
	 */
	public boolean getSoldOut(){
		return productInfoReader.getInfo(Info.SOLD_OUT, id) != "";
	}
}
