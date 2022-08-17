package pl.kosmala.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService
{

    ICustomerRepository iCustomerRepository;
    public void registerCustomer(CustomerRegistrationRequest userRequest)
    {
        Customer user = Customer.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .build();
        //todo:
        if(!iCustomerRepository.customerExistsByEmail(user.getEmail()))
            iCustomerRepository.save(user);
        else
            throw new CustomerAlreadyExistsInDatabaseException(String.format("Email: %s already exists in database", user.getEmail()));
    }
}
