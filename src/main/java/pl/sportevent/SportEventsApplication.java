package pl.justmedia;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import pl.justmedia.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.justmedia.service.OrganizerEventService;
import pl.justmedia.service.PlayerSubscriptionService;
import pl.justmedia.service.UserRegistrationService;
import pl.justmedia.service.dto.AddEventForm;
import pl.justmedia.service.dto.AddSubscriptionForm;
import pl.justmedia.service.dto.RegisterOrganizerForm;
import pl.justmedia.service.dto.RegisterPlayerForm;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SportEventsApplication {

    @Autowired
    private UserRegistrationService service;
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    OrganizerEventService organizerEventService;
    @Autowired
    PlayerSubscriptionService playerSubscriptionService;

    @Autowired UserRepository userRepository;

        public static void main(String[] args) {
            SpringApplication.run(SportEventsApplication.class, args);
        }

        @Bean
        InitializingBean sendDatabase() {
            return () -> {
                // INITIALIZE

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
                final var registeredUserId = service.registerPlayer(user1);

                final var user2 = new RegisterOrganizerForm("123",
                        "Organizer",
                        "orgnaizer@player.com",
                        "PlayerCity",
                        "PlayerStreet",
                        "Poland",
                        "00000",
                        "PlayerName"
                        );
                final var registeredOrganizerId = service.registerOrganizer(user2);
                final var registeredEventId = organizerEventService.addEvent(new AddEventForm(
                        registeredOrganizerId.getUserId(),
                        "Title",
                        LocalDateTime.now(),
                        10,
                        0
                ));
                final var registeredSubscriptionId = playerSubscriptionService.addSubscripton(
                        new AddSubscriptionForm(
                        registeredUserId.getUserId(),
                                true,
                                LocalDateTime.now(),
                                true,
                                eventsRepository.getById(registeredEventId.getEventId())
                ));
                //Player player = (Player) userRepository.getById(registeredUserId.getUserId());
               // Organizer organizer = (Organizer) userRepository.getById(registeredOrganizerId.getUserId());
               // Event event = new Event("test",LocalDateTime.now(),10,0);
               // organizer.addEvent(event);
               // userRepository.save(organizer);
              //  Subscription subscription1 = new Subscription(true, LocalDateTime.of(2021,1,10,10,0),
               //         true,event);
              // player.addSubscription(subscription1);
              //  userRepository.save(player);



            };
        }
}
