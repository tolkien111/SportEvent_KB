package pl.sportevent.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sportevent.entity.User;
import pl.sportevent.service.UserQuery;
import pl.sportevent.service.dto.PlayerDetails;
import pl.sportevent.service.dto.PlayerView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/api/players/view",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserViewRestContoller {
    @NonNull
    private final UserQuery query;

    @GetMapping
        // default mapping
    List<PlayerView> getPlayers() {
        return query.listPlayers();
    }
    @GetMapping(value="/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    PlayerDetails getPlayer(@PathVariable UUID userId){
        return query.getPlayerDetails(userId);
    }
}
