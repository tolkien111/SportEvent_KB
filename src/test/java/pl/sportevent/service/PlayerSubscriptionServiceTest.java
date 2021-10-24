package pl.justmedia.service;

import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.record.RecordMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.justmedia.entity.Event;
import pl.justmedia.entity.Player;
import pl.justmedia.entity.Subscription;
import pl.justmedia.entity.UserRepository;
import pl.justmedia.service.dto.AddSubscriptionForm;
import pl.justmedia.service.dto.RegisterPlayerForm;
import pl.justmedia.service.dto.RemoveSubscriptionForm;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class PlayerSubscriptionServiceTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlayerSubscriptionService playerSubscriptionService;

    @Test
    void shouldAddSubscriptionToPlayer(){
        final var user1 = new Player("123",
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
                "123123123");
        userRepository.save(user1);

        Player player1 = (Player) userRepository.getById(user1.getUserId());
        final var subscriptionForm = new AddSubscriptionForm(
                player1.getUserId(),
                true,
                LocalDateTime.now(),
                true,
                new Event("Test",LocalDateTime.now(),10,0));
        final var addedSubscription = playerSubscriptionService.addSubscripton(subscriptionForm);
        assertNotNull(addedSubscription);
        assertEquals(player1.getPlayerSubscriptions().size(),1);
        assertEquals(player1.getPlayerSubscriptions().get(0).getSubscriptionId(),addedSubscription.getSubscriptionId());

    }
    @Test
    void shouldAddSubscriptionToPlayerAndRemoveIt(){
        final var user1 = new Player("123",
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
                "123123123");
        userRepository.save(user1);

        Player player1 = (Player) userRepository.getById(user1.getUserId());
        Event event = new Event("Test",LocalDateTime.now(),10,0);
        final var subscriptionForm = new AddSubscriptionForm(
                player1.getUserId(),
                true,
                LocalDateTime.now(),
                true,
                event);
        final var removeSubscriptionForm = new RemoveSubscriptionForm(
                player1.getUserId(),
                event);
        final var addedSubscription = playerSubscriptionService.addSubscripton(subscriptionForm);
        assertNotNull(addedSubscription);
        assertEquals(player1.getPlayerSubscriptions().size(),1);
        assertEquals(player1.getPlayerSubscriptions().get(0).getSubscriptionId(),addedSubscription.getSubscriptionId());
        playerSubscriptionService.removeSubscription(removeSubscriptionForm);
        assertEquals(player1.getPlayerSubscriptions().size(),0);
    }

}