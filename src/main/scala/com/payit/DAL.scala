package com.payit

import scala.slick.driver.JdbcProfile
import scala.slick.jdbc.JdbcBackend.Database
import com.payit.daos.InvoiceDAOModule

trait Profile {
  val profile: JdbcProfile
  val database: Database
}

/**
 * Data Access Layer object used as an example to create the database schema if need be.
 */
class DAL(override val profile: JdbcProfile, override val database: Database)
  extends
    InvoiceDAOModule
  with
    Profile
{
  import profile.simple._

  def createDB = {
    println("======= Creating Database!!!!")
  }

}