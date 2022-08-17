package pl.kosmala.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
            (
                    name = "first_name",
                    nullable = false,
                    columnDefinition = "TEXT"
            )
    private String firstName;
    @Column
            (
                    name = "last_name",
                    nullable = false,
                    columnDefinition = "TEXT"
            )
    private String lastName;
    @Column
            (
                    name = "email",
                    nullable = false,
                    columnDefinition = "TEXT",
                    unique = true
            )
    private String email;
}
