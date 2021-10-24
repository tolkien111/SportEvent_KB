package pl.justmedia.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.justmedia.entity.*;
import pl.justmedia.service.dto.*;
import pl.justmedia.service.exception.SubscriptionException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizerEventService {
    @NonNull
    private UserRepository userRepository;

    public RegisteredEvent addEvent(@NonNull AddEventForm form){
        if(userRepository.getById(form.getUserId()) == null){
            throw new SubscriptionException("");
        }

        if (!(userRepository.getById(form.getUserId()).getUserType().equals(UserType.ORGANIZER))) {
            throw new SubscriptionException("Given user is not a Organizer");
        }

        Organizer organizer = userRepository.getOrganizerByUserId(form.getUserId());
        Event event = new Event(
                form.getEventTitle(),
                LocalDateTime.now(),
                form.getEventPlayerLimit(),
                form.getEventFee());
        organizer.addEvent(event);
        userRepository.save(organizer);
        return new RegisteredEvent(organizer.getUserId(),event.getEventId());
    }
    public void removeEvent(@NonNull RemoveEventForm form){
        Organizer organizer = userRepository.getOrganizerByUserId(form.getUserId());
        organizer.removeEvent(form.getEvent());
        userRepository.save(organizer);
    }
}
