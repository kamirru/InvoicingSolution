package com.kamirru.invoice.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class DocumentTypeConverter implements Converter<String, DocumentType> {

    @Override
    public DocumentType convert(String source) {
        try {
            if (StringUtils.hasText(source) && source.contains("-")) {
                source = source.replace("-", "_");
            }
            return DocumentType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid document type: " + source);
        }
    }
}
