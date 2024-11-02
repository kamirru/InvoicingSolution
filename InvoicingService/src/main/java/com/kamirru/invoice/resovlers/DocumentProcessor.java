package com.kamirru.invoice.resovlers;

import com.kamirru.invoice.controller.DocumentType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentProcessor {

    private final List<DocumentResolver> resolvers;

    public DocumentProcessor(List<DocumentResolver> resolvers) {
        this.resolvers = resolvers;
    }

    public String process(DocumentType documentType) {
        return resolvers.stream()
                .filter(resolver -> resolver.supports(documentType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No resolver found for " + documentType))
                .resolve(documentType);
    }
}