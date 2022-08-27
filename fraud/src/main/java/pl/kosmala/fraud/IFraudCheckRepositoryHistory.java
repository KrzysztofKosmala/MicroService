package pl.kosmala.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFraudCheckRepositoryHistory extends JpaRepository<FraudCheckHistory, Long>
{
}
