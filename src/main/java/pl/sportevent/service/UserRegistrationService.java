package pl.sportevent.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sportevent.entity.Organizer;
import pl.sportevent.entity.Player;
import pl.sportevent.entity.UserRepository;
import pl.sportevent.service.dto.RegisterOrganizerForm;
import pl.sportevent.service.dto.RegisterPlayerForm;
import pl.sportevent.service.dto.RegisteredUserId;
import pl.sportevent.service.exception.EmailAlreadyExistException;



@Service
@Transactional
@RequiredArgsConstructor
public class UserRegistrationService {
    @NonNull
    private final UserRepository userRepository;

    public RegisteredUserId registerPlayer(@NonNull RegisterPlayerForm form) throws EmailAlreadyExistException {
        if (userRepository.emailExists(form.getUserEmail()))
        {
            throw new EmailAlreadyExistException("Account with email exist: "+form.getUserEmail());
        }
        Player player = Player.createWith(form);
        userRepository.save(player);
        return new RegisteredUserId(player.getUserId());
    }

    public RegisteredUserId registerOrganizer(@NonNull RegisterOrganizerForm form) throws EmailAlreadyExistException {
        if (userRepository.emailExists(form.getUserEmail()))
        {
            throw new EmailAlreadyExistException("Account with email exist: "+form.getUserEmail());
        }
        Organizer organizer = Organizer.createWith(form);
        userRepository.save(organizer);
        return new RegisteredUserId(organizer.getUserId());
    }
}
