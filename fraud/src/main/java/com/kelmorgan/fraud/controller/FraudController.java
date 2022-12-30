package com.kelmorgan.fraud.controller;

import com.kelmorgan.fraud.model.FraudCheckResponse;
import com.kelmorgan.fraud.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public record FraudController(FraudCheckService fraudCheckService) {


    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        log.info("fraud check request for customer {}",customerId);
        Boolean isFraudster = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudster);
    }


}
