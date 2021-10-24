package pl.justmedia.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.justmedia.entity.Organizer;
import pl.justmedia.entity.Player;
import pl.justmedia.entity.UserRepository;
import pl.justmedia.service.dto.RegisterOrganizerForm;
import pl.justmedia.service.dto.RegisterPlayerForm;
import pl.justmedia.service.exception.EmailAlreadyExistException;

import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRegistrationServiceTest {
    @Autowired
    private UserRegistrationService userRegistrationService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void ShouldRegisterPlayer() {

        final var user1 = new RegisterPlayerForm("123",
                "player1",
                "player@player.com",
                "PlayerCity",
                "PlayerStreet",
                "Poland",
                "00000",
                "PlayerName",
                "PlayerLastName",
                "1990-01-01",
                "",
                "0",
                "",
                "",
                "123123123");
        final var registeredUserId = userRegistrationService.registerPlayer(user1);
        assertNotNull(registeredUserId);
        assertTrue(userRepository.existsById(registeredUserId.getUserId()));
    }

    @Test
    void ShouldRegisterOrganizer() {
        final var organizer1 = new RegisterOrganizerForm(
                "organizer1",
                "organizer1",
                "organizer@organizer.com",
                "OrganizerCity",
                "OrganizerStreet",
                "Poland",
                "00000",
                "OrganizerName");
        final var registeredOrganizerId = userRegistrationService.registerOrganizer(organizer1);
        assertNotNull(registeredOrganizerId);
        assertTrue(userRepository.existsById(registeredOrganizerId.getUserId()));
    }
    @Test
    void ShouldNotRegisterPlayer() {

       userRepository.save(new Player("123",
                "player1",
                "player@player.com",
                "PlayerCity",
                "PlayerStreet",
                "Poland",
                "00000",
                "PlayerName",
                "PlayerLastName",
               LocalDate.of(1990,1,1),
                "",
                0,
                "",
                "",
                "123123123"));

        final var user1 = new RegisterPlayerForm("123",
                "player1",
                "player@player.com",
                "PlayerCity",
                "PlayerStreet",
                "Poland",
                "00000",
                "PlayerName",
                "PlayerLastName",
                "1990-01-01",
                "",
                "0",
                "",
                "",
                "123123123");
       assertThrows(EmailAlreadyExistException.class,() -> userRegistrationService.registerPlayer(user1));
    }

    @Test
    void ShouldNotRegisterOrganizer() {
        userRepository.save(new Organizer(
                "organizer1",
                "organizer1",
                "organizer@organizer.com",
                "OrganizerCity",
                "OrganizerStreet",
                "Poland",
                "00000",
                "OrganizerName"));

        final var organizer1 = new RegisterOrganizerForm(
                "organizer1",
                "organizer1",
                "organizer@organizer.com",
                "OrganizerCity",
                "OrganizerStreet",
                "Poland",
                "00000",
                "OrganizerName");
        assertThrows(EmailAlreadyExistException.class,() -> userRegistrationService.registerOrganizer(organizer1));
    }

}