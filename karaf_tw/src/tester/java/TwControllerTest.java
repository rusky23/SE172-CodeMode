package karaftw;

import org.junit.Assert.assertEquals;
import org.junit.Test;

/**
* Model the Tester for TwController Calls
* @author Samnang Sok, Matthew Morin, Payam Khosravi
*/
public class TwControllerTest {
	TwController tc = new TwController();
	String resp = " ";
	
	/**
	* Check Subcription call from Twitter
	*/	
	public void checkFollowers() {
		resp = tc.followers();
		assertEquals("200",resp.substring(0,3));
	}
	/**
	* Check Settings call from Twitter
	*/
	public void checkSettings(){
		resp = tc.settings();
		assertEquals("200",resp.substring(0,3));
	}
	/**
	* Check blocklist call from Twitter
	*/
	public void checkBlockList(){
	    resp = tc.blockList();
		assertEquals("200",resp.substring(0,3));		
	}
	/**
	* Check ownership call from Twitter
	*/
	public void checkMuteUsers(){
		resp = tc.muteUsers();
		assertEquals("200",resp.substring(0,3));
	}
	/**
	* Check help language call from Twitter
	*/
	public void checkHelpLanguage(){
	    resp = tc.helpLanguage();
		assertEquals("200",resp.substring(0,3));
	}
	/**
	* Check timeline mention call from Twitter
	*/
	public void checkTimelineMention(){
	    resp = tc.timelineMention();
		assertEquals("200",resp.substring(0,3));
	}
	/**
	* Check help privacy call from Twitter
	*/
	public void checkHelpPrivacy(){
		resp = tc.helpPrivacy();
		assertEquals("200",resp.substring(0,3));
	}
	/**
	* Check suggestions call from Twitter
	*/
	public void checkSuggestions(){
		resp = tc.suggestions();
		assertEquals("200",resp.substring(0,3));
	}		

}