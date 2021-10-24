package pl.justmedia.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubscriptionTest extends EntityTest {
        @Test
        void souldSaveSubscription() {
        //given
       final var  subscription = new Subscription(true, LocalDateTime.of(2021,1,10,10,0),true,
               new Event("Event",LocalDateTime.now(),10,0));
        //when
        persist(subscription);
        //then
        final var readEvent = em.find(Subscription.class, subscription.getSubscriptionId());
       assertEquals(subscription,readEvent);
    }

}