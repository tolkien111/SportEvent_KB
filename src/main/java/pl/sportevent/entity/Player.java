package pl.sportevent.entity;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("PLAYER")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Player extends User {
    private String playerFirstName;
    private String playerLastName;
    private LocalDate playerDOB;
    private String playerTeamName;
    private double playerWeight;
    private String playerAdditionalInfo;
    private String playerLicence;
    private String playerPhone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private List<Subscription> playerSubscriptions;

    public Player(@NonNull String userPassword,
                  @NonNull String userLogin,
                  @NonNull String userEmail,
                  String userCity,
                  String userStreet,
                  String userCountry,
                  String userZipCode,
                  @NotNull String playerFirstName,
                  @NotNull String playerLastName,
                  @NotNull LocalDate playerDOB,
                  String playerTeamName,
                  double playerWeight,
                  String playerAdditionalInfo,
                  String playerLicence,
                  @NotNull String playerPhone) {
        super(userPassword, userLogin, userEmail, userCity, userStreet, userCountry, userZipCode);
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerDOB = playerDOB;
        this.playerTeamName = playerTeamName;
        this.playerWeight = playerWeight;
        this.playerAdditionalInfo = playerAdditionalInfo;
        this.playerLicence = playerLicence;
        this.playerPhone = playerPhone;
    }

    @Override
    public String getName() {
        return playerFirstName + " " + playerLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return playerFirstName.equals(player.playerFirstName)
                && playerLastName.equals(player.playerLastName)
                && playerDOB.equals(player.playerDOB)
                && playerPhone.equals(player.playerPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), playerFirstName, playerLastName, playerDOB, playerPhone);
    }
}
