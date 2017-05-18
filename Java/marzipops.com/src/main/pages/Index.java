package main.pages;

import main.helpers.Constants;

public class Index extends Category {
	
	/**
	 * The main constructor for an Index object
	 * @param rawName The name of the page as it would appear on the name of the file. 
	 */
	public Index(String rawName){
		super(rawName, null);
	}
	
	/**
	 * @return The name of the page as it would appear in HTML text or in the title of a webpage.
	 */
	public String getHTMLName(){
		return getRawName().replaceAll("SignedUp", "");
	}

	/**
	 * @return The part of the HTML file that contains the forum at the bottom of the page.
	 */
	public String buildBottomForum(){
		String write = "";

		if(getRawName().contains("SignedUp")){				
			write += "<div class='row'>" +
				 "<div class='small-12 medium-6 large-4 small-centered columns'><form action='//formspree.io/" + Constants.EMAIL + "' method='POST' name='emailList1' onSubmit='return emailList(true)'>" +
					 "<p>Stay up to date: Sign up for our email!</p>" +
					 "<span class='inlineBlock'><input type='text' name='email' placeholder='Email'>" +
					 "<input type='hidden' name='_subject' value='For Email List'>" +
					 "<input type='hidden' name='_next' value='" + getRawName() + "signedup.html#signedUp'>" +
					 "</span>&nbsp;&nbsp;&nbsp" +
					 "<button type='submit' id='shopButton' class='backBlue'><p class='fontWhite'>Send</p></button></form>" +
				 "</div>" +
			 "</div>";
		}else{
			write += "<div class='row' id='signedUp'>" +
				 "<div class='small-12 medium-6 large-4 small-centered columns'>" +
					 "<p class='center'>Sweet, you're on the list!</p>" +
				 "</div>" +
			 "</div>";
		}
		
		return write;
	}
	
}
