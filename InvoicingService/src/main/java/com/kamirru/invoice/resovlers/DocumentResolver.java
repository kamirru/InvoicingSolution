package com.kamirru.invoice.resovlers;

import com.kamirru.invoice.controller.DocumentType;

public interface DocumentResolver {

    boolean supports(DocumentType documentType);
    String resolve(DocumentType documentType);
}
