package pl.kosmala.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class CustomerController
{

    CustomerService customerService;

    @PatchMapping("/register")
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest)
    {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }


}
