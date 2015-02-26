package models

import com.mongodb.casbah.Imports._
import com.novus.salat.dao.{SalatDAO, ModelCompanion}
import play.api.libs.json.Json
import salatcontext._

/**
 * Created by ozo on 26/02/2015.
 */
case class User (username:String, full_name:String, profile_picture_url:String, rank:String)

object User extends ModelCompanion[User, String] {

  implicit val userWrites = Json.writes[User]

  val collection = DB.initialise("users")
  val dao = new SalatDAO[User, String](collection) {}


}

