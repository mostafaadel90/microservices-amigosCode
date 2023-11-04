package com.mostafa.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        Boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(fraudulentCustomer);

    }
}
