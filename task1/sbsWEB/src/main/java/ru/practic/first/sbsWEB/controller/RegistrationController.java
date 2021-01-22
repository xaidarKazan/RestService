package ru.practic.first.sbsWEB.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practic.first.sbsWEB.entity.User;
import ru.practic.first.sbsWEB.service.api.UserService;

@Api(value = "registration", description = "users registration")
@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService service;

    @ApiOperation(value = "registr")
    @PostMapping("/registr")
    public ResponseEntity userRegistr(@RequestParam String login, @RequestParam String password) {
        User user = service.findByLogin(login);
        if (user != null) return new ResponseEntity("this login is exist", HttpStatus.BAD_REQUEST);
        service.saveUser(login, password);
        return new ResponseEntity(HttpStatus.OK);
    }

}