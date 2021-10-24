package pl.justmedia.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.justmedia.entity.User;
import pl.justmedia.entity.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserMainteneceSerivice {
    @NonNull
    private final UserRepository userRepository;

    public void deactivateUser(String email){
        User user = userRepository.findByUserEmail(email);
        user.setUserActive(false);
    }
    public void activateUser(String email){
        User user = userRepository.findByUserEmail(email);
        user.setUserActive(true);
    }
}
