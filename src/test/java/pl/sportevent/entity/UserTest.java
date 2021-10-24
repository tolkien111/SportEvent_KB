package pl.justmedia.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest extends EntityTest {

    @Test
    void shouldRegisterPalyer() {
        //given
        Player player = new Player("123",
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
        //when
        persist(player);
        //then
        final var readPlayer = em.find(Player.class, player.getUserId());
        assertEquals(player, readPlayer);
    }
    @Test
    void shouldRegisterOraganizer() {
        //given
       Organizer organizer = new Organizer("123",
                "Organizer1",
                "organizer@organizer.com",
                "OrganizerCity",
                "OrganizerStreet",
                "Poland",
                "00000",
                "OranizerName"
              );
        //when
        persist(organizer);
        //then
        final var readOrganizer = em.find(Organizer.class, organizer.getUserId());
        assertEquals(organizer, readOrganizer);
    }
}