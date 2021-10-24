package pl.justmedia.service.dto;

import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class RegisterPlayerForm {
    @NonNull
    String userPassword;
    @NonNull
    String userLogin;
    @NonNull
    String userEmail;
    String userCity;
    String userStreet;
    String userCountry;
    String userZipCode;
    @NonNull
    String playerFirstName;
    @NonNull
    String playerLastName;
    @NonNull
    String playerDOB;
    String playerTeamName;
    String playerWeight;
    String playerAdditionalInfo;
    String playerLicence;
    @NonNull
    String playerPhone;
}
