package main.pages.specials;

import main.helpers.Constants;
import main.pages.Special;

public class Custom extends Special{

	/**
	 * Constructor for an Custom object.
	 */
	public Custom (){
		super("Custom");
	}
	
	/**
	 * Abstract method of Page.java
	 * @return The part of the HTML file that contains the main content of the page.
	 */
	public String buildContent(){		
		
		//The main text of the page.
		String text = "Give someone special a gift or celebrate a "
				+ "wedding, birthday, baby shower or corporate "
				+ "event with delicious marzipops!<br><br>"
				+ "We can create custom designs and "
				+ "personalized packaging to make your gift, "
				+ "party or event truly stand out.<br><br>"
				+ "To request a custom order, email us at info@marzipops.com or fill out the form below.";
		
		//Build the page.
		String write = "<div class='row'>"
						+ "<div class='small-3 columns'>"
							+ "<div class='row'><div class='small-12 columns'><img src='Images/Special/Custom/SQB Custom1 Marzipan Lollipops Marzipops.jpg'></img></div></div><br>"
							+ "<div class='row'><div class='small-12 columns'><img src='Images/Special/Custom/SQB Custom2 Marzipan Lollipops Marzipops.jpg'></img></div></div><br>"
							+ "<div class='row'><div class='small-12 columns'><img src='Images/Special/Custom/SQB Custom3 Marzipan Lollipops Marzipops.jpg'></img></div></div>"
						+ "</div>"
						
						+ "<div class='small-6 columns'><div class='row'>"
							+ "<div class='small-12 columns'><p>" + text + "</p></div>"
							+ buildForm("Custom.html")
						+ "</div></div>"
				
						+ "<div class='small-3 columns'>"
							+ "<div class='row'><div class='small-12 columns'><img src='Images/Special/Custom/SQB Custom4 Marzipan Lollipops Marzipops.jpg'></img></div></div><br>"
							+ "<div class='row'><div class='small-12 columns'><img src='Images/Special/Custom/SQB Custom5 Marzipan Lollipops Marzipops.jpg'></img></div></div><br>"
							+ "<div class='row'><div class='small-12 columns'><img src='Images/Special/Custom/SQB Custom6 Marzipan Lollipops Marzipops.jpg'></img></div></div>"
						+ "</div>"
					+ "</div>";
		
		write += Constants.BLANK;
		
		return write;
	}
}
