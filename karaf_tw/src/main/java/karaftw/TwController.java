package karaftw;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

/**
* Model the twitter class
* @author Samnang Sok, Matthew Morin, Payam Khosravi
*/
public class TwController {

	  //token and key you recieve from signing up with Twitter developer
	  String accessTokenCode = "GET IT FROM 'YOUR' TWITTER DEVELOPER ACCOUNT";
	  String accessTokenSecretCode = "GET IT FROM 'YOUR' TWITTER DEVELOPER ACCOUNT";
	  String consumerKeyCode = "GET IT FROM 'YOUR' TWITTER DEVELOPER ACCOUNT";
	  String consumerSecretCode = "GET IT FROM 'YOUR' TWITTER DEVELOPER ACCOUNT";

	  OAuthConsumer consumer;
	  String messageRes;

	/**
	* set the the authorization
	*/
	public void oAuthSetter(){
		consumer = new CommonsHttpOAuthConsumer(consumerKeyCode,consumerSecretCode);
		consumer.setTokenWithSecret(accessTokenCode, accessTokenSecretCode);		
	}

	/**
	* subcription call from Twitter
	* @return the message being call
	*/
	public String followersList(){
	 oAuthSetter();
		try{
			HttpGet req = new HttpGet("https://api.twitter.com/1.1/followers/list.json");
			consumer.sign(req);

			 HttpClient httpClient = HttpClients.custom()
		                .setDefaultRequestConfig(RequestConfig.custom()
		                    .setCookieSpec(CookieSpecs.STANDARD).build())
		                .build();
		        HttpResponse response = httpClient.execute(req);

		        int statusCode = response.getStatusLine().getStatusCode();
		        String m=IOUtils.toString(response.getEntity().getContent());
		        String statusLine = response.getStatusLine().getReasonPhrase();
		        return messageRes = statusCode + ":" + statusLine + m;
		} catch (Exception x){
			System.out.println("error: " + x.getMessage());
			return "error";
		}		
	}

	/**
	* Setting call from Twitter
	* @return the message being call
	*/
	public String settings(){
	 oAuthSetter();
		try{
			HttpGet req = new HttpGet("https://api.twitter.com/1.1/account/settings.json");
			consumer.sign(req);

			 HttpClient httpClient = HttpClients.custom()
		                .setDefaultRequestConfig(RequestConfig.custom()
		                    .setCookieSpec(CookieSpecs.STANDARD).build())
		                .build();
		        HttpResponse response = httpClient.execute(req);

		        int statusCode = response.getStatusLine().getStatusCode();
		        String m=IOUtils.toString(response.getEntity().getContent());
		        String statusLine = response.getStatusLine().getReasonPhrase();
		        return messageRes = statusCode + ":" + statusLine + m;
		} catch (Exception x){
			System.out.println("error: " + x.getMessage());
			return "error";
		}		
	}

	/**
	* Blocklist call from Twitter
	* @return the message being call
	*/
	public String blockList(){
	 oAuthSetter();
		try{
			HttpGet req = new HttpGet("https://api.twitter.com/1.1/blocks/list.json");
			consumer.sign(req);

			 HttpClient httpClient = HttpClients.custom()
		                .setDefaultRequestConfig(RequestConfig.custom()
		                    .setCookieSpec(CookieSpecs.STANDARD).build())
		                .build();
		        HttpResponse response = httpClient.execute(req);

		        int statusCode = response.getStatusLine().getStatusCode();
		        String m=IOUtils.toString(response.getEntity().getContent());
		        String statusLine = response.getStatusLine().getReasonPhrase();
		        return messageRes = statusCode + ":" + statusLine + m;
		} catch (Exception x){
			System.out.println("error: " + x.getMessage());
			return "error";
		}		
	}	

	/**
	* Ownership call from Twitter
	* @return the message being call
	**/
	public String muteUsers(){
	 oAuthSetter();
		try{
			HttpGet req = new HttpGet("https://api.twitter.com/1.1/mutes/users/list.json");
			consumer.sign(req);

			HttpClient httpClient = HttpClients.custom()
		                .setDefaultRequestConfig(RequestConfig.custom()
		                    .setCookieSpec(CookieSpecs.STANDARD).build())
		                .build();
		        HttpResponse response = httpClient.execute(req);

		        int statusCode = response.getStatusLine().getStatusCode();
		        String m=IOUtils.toString(response.getEntity().getContent());
		        String statusLine = response.getStatusLine().getReasonPhrase();
		        return messageRes = statusCode + ":" + statusLine + m;
		} catch (Exception x){
			System.out.println("error: " + x.getMessage());
			return "error";
		}		
	}	

	/**
	* Help language call from Twitter
	* @return the message being call
	**/
	public String helpLanguage(){
	 oAuthSetter();
		try{
			HttpGet req = new HttpGet("https://api.twitter.com/1.1/help/languages.json");
			consumer.sign(req);

			HttpClient httpClient = HttpClients.custom()
		                .setDefaultRequestConfig(RequestConfig.custom()
		                    .setCookieSpec(CookieSpecs.STANDARD).build())
		                .build();
		        HttpResponse response = httpClient.execute(req);

		        int statusCode = response.getStatusLine().getStatusCode();
		        String m=IOUtils.toString(response.getEntity().getContent());
		        String statusLine = response.getStatusLine().getReasonPhrase();
		        return messageRes = statusCode + ":" + statusLine + m;
		} catch (Exception x){
			System.out.println("error: " + x.getMessage());
			return "error";
		}		
	}

	/**
	* Timeline Mention call from Twitter
	* @return the message being call
	**/
	public String timelineMention(){
	 oAuthSetter();
		try{
			HttpGet req = new HttpGet("https://api.twitter.com/1.1/statuses/mentions_timeline.json");
			consumer.sign(req);

			HttpClient httpClient = HttpClients.custom()
		                .setDefaultRequestConfig(RequestConfig.custom()
		                    .setCookieSpec(CookieSpecs.STANDARD).build())
		                .build();
		        HttpResponse response = httpClient.execute(req);

		        int statusCode = response.getStatusLine().getStatusCode();
		        String m=IOUtils.toString(response.getEntity().getContent());
		        String statusLine = response.getStatusLine().getReasonPhrase();
		        return messageRes = statusCode + ":" + statusLine + m;
		} catch (Exception x){
			System.out.println("error: " + x.getMessage());
			return "error";
		}		
	}

	/**
	* Memberships call from Twitter
	* @return the message being call
	**/
	public String helpPrivacy(){
	 oAuthSetter();
		try{
			HttpGet req = new HttpGet("https://api.twitter.com/1.1/help/privacy.json");
			consumer.sign(req);

			HttpClient httpClient = HttpClients.custom()
		                .setDefaultRequestConfig(RequestConfig.custom()
		                    .setCookieSpec(CookieSpecs.STANDARD).build())
		                .build();
		        HttpResponse response = httpClient.execute(req);

		        int statusCode = response.getStatusLine().getStatusCode();
		        String m=IOUtils.toString(response.getEntity().getContent());
		        String statusLine = response.getStatusLine().getReasonPhrase();
		        return messageRes = statusCode + ":" + statusLine + m;
		} catch (Exception x){
			System.out.println("error: " + x.getMessage());
			return "error";
		}		
	}

	/**
	* suggestions call from Twitter
	* @return the message being call
	**/
	public String suggestions(){
	 oAuthSetter();
		try{
			HttpGet req = new HttpGet("https://api.twitter.com/1.1/users/suggestions.json");
			consumer.sign(req);

			HttpClient httpClient = HttpClients.custom()
		                .setDefaultRequestConfig(RequestConfig.custom()
		                    .setCookieSpec(CookieSpecs.STANDARD).build())
		                .build();
		        HttpResponse response = httpClient.execute(req);

		        int statusCode = response.getStatusLine().getStatusCode();
		        String m=IOUtils.toString(response.getEntity().getContent());
		        String statusLine = response.getStatusLine().getReasonPhrase();
		        return messageRes = statusCode + ":" + statusLine + m;
		} catch (Exception x){
			System.out.println("error: " + x.getMessage());
			return "error";
		}		
	}


}