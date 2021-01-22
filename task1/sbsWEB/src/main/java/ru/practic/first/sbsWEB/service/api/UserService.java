package ru.practic.first.sbsWEB.service.api;

import ru.practic.first.sbsWEB.entity.User;

public interface UserService {

    User findByLogin(String login);
    User saveUser(String login, String password);

}