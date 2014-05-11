package com.payit.services

import akka.actor.Actor
import spray.routing.HttpService
import spray.http.MediaTypes.{ `text/html` }

class RoutingServiceActor extends Actor with RoutingService {

  def actorRefFactory = context

  def receive = runRoute(route)

}

trait RoutingService extends HttpService with InvoiceServiceModule {

  val route = {
    get {
      pathSingleSlash {
        respondWithMediaType(`text/html`) {
          complete(html.index().toString)
        }
      }
    } ~
    path("invoices") {
      get {
        respondWithMediaType(`text/html`) {
          complete(invoices.html.index(invoiceService.all).toString)
        }
      }
    }
  }

}
