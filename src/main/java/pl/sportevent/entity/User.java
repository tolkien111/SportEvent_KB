package pl.justmedia.entity;

import lombok.*;
import pl.justmedia.service.dto.PlayerView;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class User {
    @Id
    private UUID userId;
    @Column(name = "user_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String userPassword;
    private String userLogin;
    private String userEmail;
    private String userCity;
    private String userStreet;
    private String userCountry;
    private String userZipCode;
    private boolean userActive;

    public User(@NonNull String userPassword,
                @NonNull String userLogin,
                @NonNull String userEmail,
                String userCity,
                String userStreet,
                String userCountry,
                String userZipCode) {
        this.userId = UUID.randomUUID();
        this.userPassword = userPassword;
        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.userCity = userCity;
        this.userStreet = userStreet;
        this.userCountry = userCountry;
        this.userZipCode = userZipCode;
        this.userActive = true;
    }

    public abstract String getName();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) && userEmail.equals(user.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userEmail);
    }

    public void setUserActive(boolean active){
        this.userActive =  active;
    }


}


