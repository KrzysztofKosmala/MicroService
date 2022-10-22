package pl.kosmala.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kosmala.clients.fraud.FraudCheckResponse;
import pl.kosmala.clients.fraud.FraudClient;
import pl.kosmala.clients.notification.NotificationClient;
import pl.kosmala.clients.notification.NotificationRequest;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService
{

    ICustomerRepository iCustomerRepository;

    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

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

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        assert fraudCheckResponse != null;
        if(fraudCheckResponse.isFraudster())
        {
            throw new FraudsterFoundException("Fraudster!");
        }

        //todo: send notification

        notificationClient.sendNotification(new NotificationRequest(customer.getId(), customer.getEmail(), "test"));

    }
}
