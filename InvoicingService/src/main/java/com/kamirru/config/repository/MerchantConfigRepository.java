package com.kamirru.config.repository;

import com.kamirru.config.controller.MerchantConfigRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MerchantConfigRepository {

    private static Map<Integer, MerchantConfigRequest> db = new HashMap<>();

    public void save(MerchantConfigRequest merchantConfigRequest) {
        db.put(merchantConfigRequest.getMerchantId(), merchantConfigRequest);
    }
}
