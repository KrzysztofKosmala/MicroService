package pl.kosmala.customer;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.then;


@DataJpaTest
class CustomerServiceTest
{



    @Autowired
    ICustomerRepository repository;

    @Autowired
    Faker faker;

    @Autowired
    CustomerService underTest;

    @Test
    void itShouldThrowExceptionWhenEmailAlreadyExists()
    {
        //Given
        Customer customer = new Customer();
        String firstName = faker.name().lastName();
        String lastName = faker.name().lastName();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        String emailToTest = firstName + lastName + "@gmail.com";
        customer.setEmail(emailToTest);

        repository.save(customer);

        CustomerRegistrationRequest customerThatShoudntBeSaved = new CustomerRegistrationRequest
                (
                        faker.name().lastName(),
                        faker.name().lastName(),
                        emailToTest
                );

        //When
        //Then
        assertThatThrownBy(
                () -> underTest.registerCustomer(customerThatShoudntBeSaved))
                .isInstanceOf(CustomerAlreadyExistsInDatabaseException.class)
                .hasMessageContaining(String.format("Email: %s already exists in database", emailToTest));

        then(repository).shouldHaveNoInteractions();
        then(underTest).shouldHaveNoInteractions();

    }
}