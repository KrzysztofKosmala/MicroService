package pl.kosmala.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kosmala.clients.fraud.FraudCheckResponse;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController
{

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId)
    {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
