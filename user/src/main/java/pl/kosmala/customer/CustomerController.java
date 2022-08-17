package pl.kosmala.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public void registerCustomer(@Valid @RequestBody CustomerRegistrationRequest customerRegistrationRequest)
    {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }


}
