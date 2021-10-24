package pl.justmedia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.justmedia.service.dto.PlayerDetails;
import pl.justmedia.service.dto.PlayerView;
import pl.justmedia.service.dto.RegisterOrganizerForm;
import pl.justmedia.service.dto.RegisterPlayerForm;
import pl.justmedia.service.exception.SubscriptionException;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("PLAYER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Player(String userPassword,
                  String userLogin,
                  String userEmail,
                  String userCity,
                  String userStreet,
                  String userCountry,
                  String userZipCode,
                  @NonNull String playerFirstName,
                  @NonNull String playerLastName,
                  @NonNull LocalDate playerDOB,
                  String playerTeamName,
                  double playerWeight,
                  String playerAdditionalInfo,
                  String playerLicence,
                  @NonNull String playerPhone) {
        super(userPassword, userLogin, userEmail, userCity, userStreet, userCountry, userZipCode);
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerDOB = playerDOB;
        this.playerTeamName = playerTeamName;
        this.playerWeight = playerWeight;
        this.playerAdditionalInfo = playerAdditionalInfo;
        this.playerLicence = playerLicence;
        this.playerPhone = playerPhone;
        this.playerSubscriptions = new ArrayList<>();

    }


  public static Player createWith(RegisterPlayerForm form) {
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    return new  Player(form.getUserPassword(),
            form.getUserLogin(),
            form.getUserEmail(),
            form.getUserCity(),
            form.getUserStreet(),
            form.getUserCountry(),
            form.getUserZipCode(),
            form.getPlayerFirstName(),
            form.getPlayerLastName(),
            LocalDate.parse(form.getPlayerDOB(),formatter),
            form.getPlayerTeamName(),
            Double.valueOf(form.getPlayerWeight()),
            form.getPlayerAdditionalInfo(),
            form.getPlayerLicence(),
            form.getPlayerPhone());
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

    public void addSubscription(Subscription subscription){
        if(subscription != null) {
                if( !playerSubscriptions.contains(subscription)){
                    playerSubscriptions.add(subscription);
                } else {
                    throw new SubscriptionException("Subscription for this event already exist for this Player");
                }
            }
    }
    public void removeSubscription(Event event){

        if(event != null) {
            Subscription subscription = playerSubscriptions.stream()
                    .filter(subEvent-> event.equals(subEvent.getEvent()))
                    .findFirst().orElse(null);
            if( playerSubscriptions.contains(subscription)){
                playerSubscriptions.remove(subscription);
            } else {
                throw new SubscriptionException("Subscription for this event not exist for this Player");
            }
        }
    }

    public List<Subscription> getApprovedSubscriptions(){
        return playerSubscriptions.stream()
                .filter(subEvent-> subEvent.isSubscriptionApproved())
                .collect(Collectors.toList());
    }

    public PlayerView toView(){
        return new PlayerView(getUserId(),
                getName(),
                getUserEmail(),
                getUserType());
    }
    public PlayerDetails viewDetail(){
        return new PlayerDetails(getUserId(),
                getName(),
                getUserEmail(),
                getUserType(),
                getPlayerSubscriptions().stream().map(Subscription::toView).collect(Collectors.toList()),
                getUserCity(),
                getUserStreet(),
                getUserCountry(),
                getUserZipCode(),
                getPlayerFirstName(),
                getPlayerLastName(),
                getPlayerDOB().toString(),
                getPlayerTeamName(),
                String.valueOf(getPlayerWeight()),
                getPlayerAdditionalInfo(),
                getPlayerLicence(),
                getPlayerPhone());
    }
}
