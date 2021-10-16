package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@DiscriminatorValue("PLAYER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player extends Person{
    private String playerTeam;

    public Player(
            String personName,
            String personSurname,
            LocalDate personDOB,
            String personLogin,
            String emailAddress,
            String playerTeam) {
        super(personName, personSurname, personDOB, personLogin, emailAddress);
        this.playerTeam = playerTeam;
    }
}
