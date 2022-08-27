package pl.kosmala.customer;

import org.springframework.stereotype.Service;

@Service
public interface ICustomerService
{
    void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
}
