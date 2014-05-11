package com.payit.services

import com.payit.models.Invoice

trait InvoiceServiceModule {

  val invoiceService = new InvoiceServiceImpl

  trait InvoiceService {

    def all: List[Invoice]

  }

  class InvoiceServiceImpl extends InvoiceService {

    def all: List[Invoice] = {
      List(
        Invoice(Some(1), "INV1000", BigDecimal(234.55)),
        Invoice(Some(2), "INV3000", BigDecimal(50000.00)),
        Invoice(Some(3), "INV4500", BigDecimal(34.96))
      )
    }

  }

}
