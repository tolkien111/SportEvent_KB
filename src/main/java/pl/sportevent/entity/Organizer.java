package pl.sportevent.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("ORGANIZER")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Organizer extends User {
    private String organizerName;

    @OneToMany
    @JoinColumn(name = "organizer_id")
    private List<Event> organizerEventList;

    public Organizer(@NonNull String userPassword,
                     @NonNull String userLogin,
                     @NonNull String userEmail,
                     String userCity,
                     String userStreet,
                     String userCountry,
                     String userZipCode,
                     String organizerName) {
        super(userPassword, userLogin, userEmail, userCity, userStreet, userCountry, userZipCode);
        this.organizerName = organizerName;
        this.organizerEventList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return organizerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Organizer organizer = (Organizer) o;
        return organizerName.equals(organizer.organizerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), organizerName);
    }
}