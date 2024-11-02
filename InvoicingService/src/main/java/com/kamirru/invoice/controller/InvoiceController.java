package com.kamirru.invoice.controller;


import com.kamirru.invoice.resovlers.DocumentProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InvoiceController {

    private final DocumentProcessor documentProcessor;


    @GetMapping("/hello")
    public String getBasicResponse() {
        return getClass().toString();
    }

    @GetMapping("/{documentType}")
    public String getBasicResponse(@PathVariable DocumentType documentType) {
        return documentProcessor.process(documentType);
    }

    @PostMapping("/{documentType}")
    public String basicResponse(@PathVariable DocumentType documentType) {
        return documentType.name();
    }

}
