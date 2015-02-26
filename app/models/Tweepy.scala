package models

import twitter4j.{Twitter, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by ozo on 26/02/2015.
 */
class Tweepy {

  val cb = new ConfigurationBuilder();
  cb.setDebugEnabled(true)
    .setOAuthConsumerKey("F4j9eLEs4mO8sTPArfTW3cnrU")
    .setOAuthConsumerSecret("uoPtCr1ddiJejYntDZjnKB4A7utTnxkkyW1ddJPjPnyezrVq2b")
    .setOAuthAccessToken("1415007979-0MUFxHogba1Roqnct7BkqxMwuU0JOvpj9NK1LDO")
    .setOAuthAccessTokenSecret("xZr8jzpcxhlkjdsvDMcyJphI371Wl8vIa1Yiq1SjYrZQe");
  val tf = new TwitterFactory(cb.build());
  val twitter = tf.getInstance();

  def postTweet(tweet:String) = {
    twitter updateStatus tweet
  }
}

object Tweepy {

  def apply() = {
    new Tweepy
  }
}
