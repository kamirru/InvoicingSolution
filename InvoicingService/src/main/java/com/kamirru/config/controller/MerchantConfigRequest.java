package com.kamirru.config.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class MerchantConfigRequest {

    @JsonProperty("merchantId")
    private int merchantId;
    private List<Integer> storeIda;
    private boolean enableSimpleInvoice;
    private boolean enableNonFiscalItemsOnInvoice;
    private boolean combineItemsOnInvoice;
    private boolean forceCollectiveInvoice;
    private int invoiceTemplateId;
    private String invoiceNumberFormat; // {NO}{MONTH}{YEAR}, {NO}{YEAR}, {NO}{MONTH}{YEAR}
    private List<String> automatedTags;


}
