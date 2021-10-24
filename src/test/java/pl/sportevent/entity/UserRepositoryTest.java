package pl.justmedia.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository repository ;

    @Autowired
    private EntityManager em;

    @Test
    void shouldSave() {
        // given
        final var user1 = new  Player("123",
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
        final var user2 = new Organizer("123",
                "Organizer1",
                "organizer@organizer.com",
                "OrganizerCity",
                "OrganizerStreet",
                "Poland",
                "00000",
                "OranizerName"
        );

        // when
        repository.saveAllAndFlush(List.of(user1, user2));

        // then
        assertEquals(2, repository.count());
    }
    @Test
    void shouldFindUserByLastName() {
        // given
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
        final var user2 = new  Player("123",
                "player2",
                "player2@player.com",
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
        final var user3 = new Organizer("123",
                "Organizer1",
                "organizer@organizer.com",
                "OrganizerCity",
                "OrganizerStreet",
                "Poland",
                "00000",
                "OranizerName"
        );
        repository.saveAllAndFlush(List.of(user1,user2,user3));

        // when
        User user = repository.findByUserEmail("player2@player.com");

        // then
        assertTrue(List.of(user2).contains(user));
    }

    @Test
    void shouldAddPlayerSubscription(){
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
        Subscription subscription1 = new Subscription(true, LocalDateTime.of(2021,1,10,10,0),true,new Event("Event",LocalDateTime.now(),10,0));
        Subscription subscription2 = new Subscription(true, LocalDateTime.of(2021,1,10,10,0),false,new Event("Event",LocalDateTime.now(),10,0));
        user1.addSubscription(subscription1);
        user1.addSubscription(subscription2);
        repository.saveAllAndFlush(List.of(user1));
        //when
        //List<Subscription> subscriptionList = repository.findSubscriptionsForUserEmail(user1.getUserEmail());
        //then
      //assertTrue(List.of(subscription1,subscription2).containsAll(subscriptionList));
    }


}