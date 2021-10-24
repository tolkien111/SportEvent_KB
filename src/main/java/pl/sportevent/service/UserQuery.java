package pl.justmedia.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.justmedia.entity.Player;
import pl.justmedia.entity.User;
import pl.justmedia.entity.UserRepository;
import pl.justmedia.entity.UserType;
import pl.justmedia.service.dto.PlayerDetails;
import pl.justmedia.service.dto.PlayerView;

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
