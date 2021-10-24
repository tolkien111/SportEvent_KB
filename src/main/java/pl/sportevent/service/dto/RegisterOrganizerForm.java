package pl.justmedia.service.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class RegisterOrganizerForm {

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
    String organizerName;

}
