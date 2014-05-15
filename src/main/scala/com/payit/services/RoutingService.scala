package com.payit.services

import akka.actor.Actor
import spray.routing.HttpService
import spray.http.MediaTypes.{ `text/html` }
import com.payit.models.Invoice

class RoutingServiceActor extends Actor with RoutingService {

  def actorRefFactory = context

  def receive = runRoute(route)

}

trait RoutingService extends HttpService {
  self: InvoiceServiceModule =>

  val route = {
    get {
      pathSingleSlash {
        respondWithMediaType(`text/html`) {
          complete(views.html.index().toString)
        }
      }
    } ~
    path("invoices") {
      get {
        respondWithMediaType(`text/html`) {
          complete(views.html.invoices.index(      List(
            Invoice(Some(1), "INV1000", BigDecimal(234.55)),
            Invoice(Some(2), "INV3000", BigDecimal(50000.00)),
            Invoice(Some(3), "INV4500", BigDecimal(34.96))
          )).toString)
//          complete(invoices.html.index(invoiceService.all).toString)
        }
      }
    }
  }

}
