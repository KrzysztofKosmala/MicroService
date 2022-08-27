package pl.kosmala.customer;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ICustomerRepositoryTest
{

    @Autowired
    ICustomerRepository underTest;


    Faker faker = new Faker();



    String EMAIL_REGEX = "@gmail.com";
    @Test
    void itShouldCheckIfCustomerExistsByEmail()
    {
        Customer customer = new Customer();
        String firstName = faker.name().lastName();
        String lastName = faker.name().lastName();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        String emailToTest = firstName + lastName + EMAIL_REGEX;
        customer.setEmail(emailToTest);

        underTest.save(customer);

        boolean b = underTest.customerExistsByEmail(emailToTest);

        assertTrue(b);
    }


}