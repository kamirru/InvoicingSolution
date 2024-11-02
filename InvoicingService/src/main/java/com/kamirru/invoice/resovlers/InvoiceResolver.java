package com.kamirru.invoice.resovlers;

import com.kamirru.invoice.controller.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class InvoiceResolver implements DocumentResolver {

    @Override
    public boolean supports(DocumentType documentType) {
        return documentType == DocumentType.INVOICE;
    }

    @Override
    public String resolve(DocumentType documentType) {
        return "Processing INVOICE document";
    }
}
