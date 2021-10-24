package pl.sportevent.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sportevent.entity.Player;
import pl.sportevent.entity.User;
import pl.sportevent.entity.UserRepository;
import pl.sportevent.entity.UserType;
import pl.sportevent.service.dto.PlayerDetails;
import pl.sportevent.service.dto.PlayerView;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class UserQuery {

    @NonNull
    private final UserRepository userRepository;

    public List<PlayerView> listPlayers(){
        List<PlayerView> collect = userRepository.findByUserType(UserType.PLAYER).stream().
                filter(player -> player.getUserType().equals(UserType.PLAYER))
                // .map(p -> new Employee(p.getName(), p.getLastName(), 1000))
                .map(Player::toView)
                .collect(Collectors.toList());
        return collect;
    }
    public PlayerDetails getPlayerDetails(UUID userId){
        return userRepository.findPlayerByUserId(userId).viewDetail();
    }
}
