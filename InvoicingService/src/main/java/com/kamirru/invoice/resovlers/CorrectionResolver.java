package com.kamirru.invoice.resovlers;

import com.kamirru.invoice.controller.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class CorrectionResolver implements DocumentResolver {

    @Override
    public boolean supports(DocumentType documentType) {
        return documentType == DocumentType.CORRECTION;
    }

    @Override
    public String resolve(DocumentType documentType) {
        return "Processing CORRECTION document";
    }
}