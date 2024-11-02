package com.kamirru.invoice.resovlers;

import com.kamirru.invoice.controller.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class SimpleInvoiceResolver implements DocumentResolver {

    @Override
    public boolean supports(DocumentType documentType) {
        return documentType == DocumentType.SIMPLE_INVOICE;
    }

    @Override
    public String resolve(DocumentType documentType) {
        return "Processing SIMPLE_INVOICE document";
    }
}