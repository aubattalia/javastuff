import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;;
public class Classifier {

	public static void main(String[] args) throws Exception {
		//for each tweet
		String tweet = "This gift is the best burrito I've eaten nomnomnom, https://ramhacks2018.slack.com/messages/";
		String cat = "";
		String url = "";
		String 
		//Make regex expression to get urls
		String pattern = "(http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
		
		Pattern r =  Pattern.compile(pattern);
		
		//Matcher		
		Matcher m = r.matcher(tweet);
	
		
		if(m.find( )) {
			url = m.group();
		}
		
		if(tweet.toLowerCase().contains("gift") || tweet.toLowerCase().contains("gifts") || tweet.toLowerCase().contains("donate") || tweet.toLowerCase().contains("donation")) {
			cat = "donations, ";
		}
		else if(tweet.toLowerCase().contains("volunteer") || tweet.toLowerCase().contains("volunteering") || tweet.toLowerCase().contains("help") || tweet.toLowerCase().contains("helping")) {
			cat += "volunteer, ";
		}
		if(tweet.toLowerCase().contains("rescue") || tweet.toLowerCase().contains("rescuing")) {
			cat += "rescue";
		}
		else {
			cat = "news";
		}
		
		//System.out.print(url);
	}

}
