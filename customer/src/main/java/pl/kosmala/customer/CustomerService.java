package pl.kosmala.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kosmala.fraud.FraudCheckResponse;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService
{

    private RestTemplate restTemplate;
    ICustomerRepository iCustomerRepository;
    public void registerCustomer(CustomerRegistrationRequest userRequest)
    {
        Customer customer = Customer.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .build();
        //todo: check if froadster



        if(iCustomerRepository.customerExistsByEmail(customer.getEmail()))
            throw new CustomerAlreadyExistsInDatabaseException(String.format("Email: %s already exists in database", customer.getEmail()));
        else
            iCustomerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
        assert fraudCheckResponse != null;
        if(fraudCheckResponse.isFraudster())
            throw new FraudsterFoundException("Fraudster!");

    }
}
