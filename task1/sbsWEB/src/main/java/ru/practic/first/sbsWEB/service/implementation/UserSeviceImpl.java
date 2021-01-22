package ru.practic.first.sbsWEB.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.practic.first.sbsWEB.entity.User;
import ru.practic.first.sbsWEB.repository.UserRepository;
import ru.practic.first.sbsWEB.service.api.UserService;

@Service
@RequiredArgsConstructor
public class UserSeviceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User saveUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }
}