package models

import com.mongodb.casbah.Imports._
import salatcontext._
import play.api.Play.current

/**
 * Created by ozo on 21/12/2014.
 */
class DB (database:String, collection:String)  {
  def connection = MongoConnection()(database)(collection)
}

object DB {
  def initialise(collection:String) = new DB("frontliners", collection).connection
}