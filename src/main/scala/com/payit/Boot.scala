package com.payit

import akka.actor.{Props, ActorSystem}
import com.payit.services.RoutingServiceActor
import spray.can.Http
import akka.io.IO
import scala.slick.jdbc.JdbcBackend.{ Database, Session }
import scala.slick.driver.MySQLDriver
import scala.slick.jdbc.meta.MTable

object Boot extends App {

  implicit  val system = ActorSystem("payit")
  val routingService = system.actorOf(Props[RoutingServiceActor], "payit-router")

  val db = Database.forURL(
    "jdbc:mysql://localhost:3306/payit?characterEncoding=UTF-8",
    driver="com.mysql.jdbc.Driver",
    user="root",
    password="root")
  val dal = new DAL(MySQLDriver, db)
  dal.createDB
//  db withSession { implicit s: Session =>
//    MTable.getTables().list().foreach(t =>
//      println("=========== " + t.name.name)
//    )
//  }

  IO(Http) ! Http.Bind(routingService, "localhost", port = 9000)

}
