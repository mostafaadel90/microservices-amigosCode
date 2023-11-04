package com.mostafa.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class FraudCheckService {

    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId) {

        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder().
                customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now()).
                build();
        fraudRepository.save(fraudCheckHistory);
        return false;
    }

}
