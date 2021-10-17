package pl.sportevent;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@SpringBootApplication
public class SportEventsApplication {

        public static void main(String[] args) {
            SpringApplication.run(SportEventsApplication.class, args);
        }

        @Component
        @RequiredArgsConstructor
        @Profile("dev")
        static class InitOnStartup {

//           private final PersonRepository personRepository;
//           private final EventsRepository eventsRepository;

            @EventListener
            @Transactional
            public void setup(ApplicationReadyEvent event) {
//                Player player1 = new Player("Jhon","Doe", LocalDate.of(1990,01,20),"jd","jd@wp.pl","gorlickielwy");
//                Organizator organizator1 = new Organizator("David","Bovie", LocalDate.of(1995,01,20),"jd","jd@wp.pl","TEAMSPORT");
//                personRepository.saveAllAndFlush(List.of(player1));
            }
        }
}
