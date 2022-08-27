package pl.kosmala.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService
{
    private final IFraudCheckRepositoryHistory fraudCheckRepositoryHistory;

    public boolean isFraudulentCustomer(Long customerId)
    {
        fraudCheckRepositoryHistory.save(FraudCheckHistory
                .builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
