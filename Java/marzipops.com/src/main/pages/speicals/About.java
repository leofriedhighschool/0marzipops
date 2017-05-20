package main.pages.speicals;

import main.pages.Special;

public class About extends Special{

	/**
	 * Constructor for an About object.
	 */
	public About (){
		super("About");
	}
	
	/**
	 * Abstract method of Page.java
	 * @return The part of the HTML file that contains the main content of the page.
	 */
	public String buildContent(){
		//The main text of the page.
		String marzipops = "<span class='popBlue bold'>marzipops</span>";
		
		String mainText = "What do you get when you combine an MBA from Harvard, ten years as a "
				+ "cake designer, a love of food and sense of whimsy? " + marzipops + "!<br><br>"
				+ "As a cake designer, my cakes received many accolades, including an "
				+ "Editor&rsquo;s Choice from Brides Magazine in Michigan. After falling in love "
				+ "with marzipan while making cake toppers, I decided to evolve my "
				+ "business to make marzipan lollipops and treats. My " + marzipops + " combine "
				+ "whimsy, design and deliciousness into an amazing collection of treats.<br><br>"
				+ "I hope you enjoy my marzipan sweets as much as I enjoy creating them!<br><br>"
				+ "-- Dahlia (dahlia@marzipops.com)";
		
		//The reviews that are cited on the page.
		String[] reviewText = {"Thanks SOOOO much for the awesome treats",
						"Truly exemplar customer service and wonderful product. Thanks so much!",
						"A-dorable!!! Looks exactly like the&nbsp;pic.",
						"Love love love the pops, the good communication, and overall yummy product and professionalism."};
		
		//Adding the main text to the page.
		String write = "<div class='row'>"
							+ "<div class='small-6 medium-4 small-centered medium-uncentered columns'>"
								+ "<img src='Images/Special/About/Mom Pic.jpg'></img>"
							+ "</div><br class='show-for-small-only'><div class='small-12 medium-8 columns'>"
								+ "<p>" + mainText + "</p>"
							+ "</div>"
						+ "</div>";
		
		//Adding the reviews to the page.
		write += "<div class='row'><div class='small-12 columns'>";
		write += "<p class='center'>Our clients and customers love " + marzipops + "! Here are some things they say:</p>";
		for(int i=0; i<reviewText.length; i++){
			write += "<p class='center italic'>&ldquo;" + reviewText[i] + "&rdquo;</p>";
		}
		write += "</div></div>";
		
		return write;
	}
}
