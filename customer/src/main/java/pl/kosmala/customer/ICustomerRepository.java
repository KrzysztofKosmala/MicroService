package pl.kosmala.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>
{
    @Query
            (
                    value = "SELECT CAST(CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS BIT)\n" +
                            "FROM customer WHERE email = :email",
                    nativeQuery = true
            )
    boolean customerExistsByEmail(@Param("email") String email);
}
