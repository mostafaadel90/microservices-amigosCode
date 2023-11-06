package com.mostafa.customer;

import com.mostafa.clients.fraud.FraudCheckResponse;
import com.mostafa.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudster = fraudClient.isFraudster(customer.getId());
        assert fraudster != null;
        if (Boolean.TRUE.equals(fraudster.isFraudster())) {
            throw new IllegalStateException(("isFraudster"));

        }
    }
}
