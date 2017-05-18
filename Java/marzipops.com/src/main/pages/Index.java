package main.pages;

import main.helpers.Constants;

public class Index extends Category {
	
	
	public Index(String rawName){
		super("", null);
	}
	
	public String getHTMLName(){
		return getRawName().replaceAll("SignedUp", "");
	}

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
	}
	
}