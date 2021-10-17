package pl.sportevent.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest extends EntityTest {

    @Test
    void shouldSavePlayer() {
        //Given
        final var player = new Player("6665",
                "adam6665",
                "adam55@o2.pl",
                "Poznań",
                "Warszawska",
                "Poland",
                "88-222",
                "Adam",
                "Kowalski",
                LocalDate.of(1988, 11, 23),
                "Chicago Pulls",
                102.33,
                "",
                "",
                "+48798524999");

        //When
        persist(player);

        //Then
        final var readPlayer = entityManager.find(Player.class, player.getUserId());
        assertEquals(player, readPlayer);
    }

    @Test
    void shouldSaveOrganizer(){
        //Given
        final var organizer = new Organizer("222",
                "sa",
                "sa@sa.com",
                "Warszawa",
                "Aleje Jerozolimskie",
                "Poland",
                "20-222",
                "SA S.A");

        // When
        persist(organizer);

        //Then
        final var readOrganizer = entityManager.find(Organizer.class, organizer.getUserId());
        assertEquals(organizer, readOrganizer);

    }

}