package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class Person {
    @Id
    private UUID personId;
    @Column(name = "person_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private PersonType personType;
    private String personName;
    private String personSurname;
    private LocalDate personDOB;
    private String personLogin;
    private String emailAddress;

    public Person(String personName,
                  String personSurname,
                  LocalDate personDOB,
                  String personLogin,
                  String emailAddress) {
        this.personId = UUID.randomUUID();
        this.personName = personName;
        this.personSurname = personSurname;
        this.personDOB = personDOB;
        this.personLogin = personLogin;
        this.emailAddress = emailAddress;
    }
}
