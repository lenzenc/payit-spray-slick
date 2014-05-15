package com.payit.daos

import com.payit._
import com.payit.models.Invoice

trait InvoiceDAOModule { this: Profile =>
  import profile.simple._

  val invoiceDAO = new InvoiceDAOImpl

  class Invoices(tag: Tag) extends Table[Invoice](tag, "Invoices") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def invoiceNumber = column[String]("invoice_number", O.NotNull)
    def total = column[BigDecimal]("total", O.NotNull)
    def * = (id, invoiceNumber, total) <> (Invoice.tupled, Invoice.unapply _)
  }

  trait InvoiceDAO {

    // You should not normally do this but it is being done just for this demo application to make it available to a
    // database seed function.
    val invoices = TableQuery[Invoices]

    def findAll: List[Invoice]

  }

  class InvoiceDAOImpl extends InvoiceDAO {

    def findAll: List[Invoice] = {
      database withSession { implicit s: Session =>
        invoices.list
      }
    }

  }

}
