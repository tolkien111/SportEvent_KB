package pl.justmedia.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class EventTest extends EntityTest {
        @Test
        void souldSaveEvent() {
        //given
       final var event = new Event("Test", LocalDateTime.of(2021,1,10,10,0),10,0.0d);
        //when
        persist(event);
        //then
        final var readEvent = em.find(Event.class, event.getEventId());
       assertEquals(event,readEvent);
    }

}