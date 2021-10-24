package pl.justmedia.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;
import pl.justmedia.entity.Subscription;
import pl.justmedia.entity.UserType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Getter
@Value
public class PlayerDetails {
    UUID userId;
    String name;
    String email;
    UserType type;
    List<SubscriptionView> playerSubscriptions;
    String userCity;
    String userStreet;
    String userCountry;
    String userZipCode;
    String playerFirstName;
    String playerLastName;
    String playerDOB;
    String playerTeamName;
    String playerWeight;
    String playerAdditionalInfo;
    String playerLicence;
    String playerPhone;
}
