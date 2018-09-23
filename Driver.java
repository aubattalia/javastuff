import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterFactory;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import twitter4j.Query.ResultType;

public final class Driver
{
    public static void main(String[] args) throws TwitterException
    {
       ConfigurationBuilder cb = new ConfigurationBuilder();
      
       cb.setDebugEnabled(true)
		.setOAuthConsumerKey("kpCanm1cmyXon9RwDUJZSmY4h")
		.setOAuthConsumerSecret("zFEWcwkWuhZpRj9yLDgd5Q20DPHVbPGitc7niw1iTrgts4eCJf")
		.setOAuthAccessToken("1043557458113904641-X0df93DXGNbmLbtRRlyh4IPpvOABTi")
		.setOAuthAccessTokenSecret("qZlXVKGBtGuSHRubrFwwwz2mRYRMcD3xTG2NlzNN5l32C");
      
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        
        String hashtag = "Hurricane Florence";
        Query query = new Query(hashtag);
        query.setCount(100);
        query.resultType(ResultType.popular);
        QueryResult result = twitter.search(query);
        
        String tempString = "#" + hashtag + "\n";
        for (Status status : result.getTweets())
        {
        	StringBuilder rtStringBuilder = new StringBuilder().append(status.getText().charAt(0)).append(status.getText().charAt(1));
        	String rtString = rtStringBuilder.toString();
        	String cat = "";
        	String tweet = status.getText();
        	String url = "";
        	
        	if (!(rtString.equals("RT")))
        	{
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
            	
        	tempString += "@" + status.getUser().getScreenName() + "\n" +
        			status.getText() + "\n" +
        			status.getId() + "\n" +
        			url + "\n" + cat + "\n";
        	}
        }
        System.out.println(tempString);
    }
}