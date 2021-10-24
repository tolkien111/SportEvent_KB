package pl.justmedia.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.justmedia.service.dto.RegisterOrganizerForm;
import pl.justmedia.service.exception.EventException;
import pl.justmedia.service.exception.SubscriptionException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("ORGANIZER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Organizer extends User {
    private String organizerName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizer_id")
    private List<Event> organizerEvents;

    public Organizer(String userPassword,
                     String userLogin,
                     String userEmail,
                     String userCity,
                     String userStreet,
                     String userCountry,
                     String userZipCode,
                     @NonNull String organizerName) {
        super(userPassword, userLogin, userEmail, userCity, userStreet, userCountry, userZipCode);
        this.organizerName = organizerName;
        this.organizerEvents = new ArrayList<>();
    }

    public static Organizer createWith(RegisterOrganizerForm form) {
        return new Organizer (form.getUserPassword(),
                form.getUserLogin(),
                form.getUserEmail(),
                form.getUserCity(),
                form.getUserStreet(),
                form.getUserCountry(),
                form.getUserZipCode(),
                form.getOrganizerName());
    }
    public void addEvent(Event event){
        if(event != null) {
            if( !organizerEvents.contains(event)){
                organizerEvents.add(event);
            } else {
                throw new EventException("Event already exist for this Organizer");
            }
        }
    }
    public void removeEvent(Event event){
        if(event != null) {
            if( organizerEvents.contains(event)){
                organizerEvents.remove(event);
            } else {
                throw new EventException("Event for this organizer not exist");
            }
        }
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
