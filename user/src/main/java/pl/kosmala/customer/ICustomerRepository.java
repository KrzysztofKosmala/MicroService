package pl.kosmala.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, Long>
{
}
