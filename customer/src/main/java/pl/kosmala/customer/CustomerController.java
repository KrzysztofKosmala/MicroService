package pl.kosmala.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController

@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController
{

    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody CustomerRegistrationRequest customerRegistrationRequest)
    {
        String email = customerRegistrationRequest.email();
        ResponseEntity<String> response = new ResponseEntity<>(String.format("user %s has been registered", email), HttpStatus.OK);
        log.info("new customer registration {}", customerRegistrationRequest);
        try
            {
                customerService.registerCustomer(customerRegistrationRequest);
            }catch (CustomerAlreadyExistsInDatabaseException alreadyExistsInDatabaseException)
                {
                    response = new ResponseEntity<>(String.format("Email: %s already exists in database", email), HttpStatus.NOT_ACCEPTABLE);

                }catch (FraudsterFoundException fraudsterFoundException)
                    {
                        response = new ResponseEntity<>(String.format("user %s is a fraudster!", email), HttpStatus.CONFLICT);
                    }
        return response;
    }


}
