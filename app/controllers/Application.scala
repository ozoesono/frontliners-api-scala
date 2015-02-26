package controllers

import models._
import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("FRONTLINERS API"))
  }

  def users = Action {
    Ok(Json.toJson(User.findAll().toList))
  }

  def postTweet(challengeId:String) = Action { request =>
    val usersStr: Option[String] = request.getQueryString("users")
    val challenger: String = request.getQueryString("challenger").getOrElse("")

    val users = usersStr.getOrElse("").split(",")

    val challenge = challengeId match {
      case "1" => "to feed a refuge in South Sudan for 1 month. http://donate.oxfam.org.uk/"
      case "2" => "to help provide shelter for Syrian refugees. http://donate.unhcr.org/gbr/syria"
      case "3" => "to give a mosquito net to a child exposed to malaria. http://nothingbutnets.net/"
      case _ => "to retweet this message and create awareness about #unfrontliners"
    }

    users.foreach(user => Tweepy().postTweet(s"@$user @$challenger has challenged you $challenge"))

    Ok(Json.toJson("ok"))



  }
}