package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@DiscriminatorValue("ORAGANIZATOR")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Organizator extends Person {
    private String organizatorName;

    public Organizator(
            String personName,
            String personSurname,
            LocalDate personDOB,
            String personLogin,
            String emailAddress,
            String organizatorName) {
        super(personName, personSurname, personDOB, personLogin, emailAddress);
        this.organizatorName = organizatorName;
    }
}
