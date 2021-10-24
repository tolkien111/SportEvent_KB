package pl.sportevent.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sportevent.entity.*;
import pl.sportevent.service.dto.AddSubscriptionForm;
import pl.sportevent.service.dto.RegisteredSubscription;
import pl.sportevent.service.dto.RemoveSubscriptionForm;
import pl.sportevent.service.exception.SubscriptionException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerSubscriptionService {
    @NonNull
    private UserRepository userRepository;

    public RegisteredSubscription addSubscripton(@NonNull AddSubscriptionForm form){
        if(userRepository.getById(form.getUserId()) == null){
            throw new SubscriptionException("");
        }
        if (!(userRepository.getById(form.getUserId()).getUserType().equals(UserType.PLAYER))) {
            throw new SubscriptionException("Given user is not a Player");
            }

        Player player = userRepository.getPlayerByUserId(form.getUserId());
        Subscription subscription = new Subscription(
                form.isSubscriptionPaymentDone(),
                LocalDateTime.now(),
                form.isSubscriptionApproved(),
                form.getEvent());
        player.addSubscription(subscription);
        userRepository.save(player);
        return new RegisteredSubscription(player.getUserId(),subscription.getSubscriptionId());
    }

    public void removeSubscription(@NonNull RemoveSubscriptionForm form){
        Player player = (Player) userRepository.getById(form.getUserId());
        player.removeSubscription(form.getEvent());
        userRepository.save(player);
    }

}
