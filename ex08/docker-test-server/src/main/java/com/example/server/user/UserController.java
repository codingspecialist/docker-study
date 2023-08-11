package com.example.server.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<?> main() {
        return ResponseEntity.ok().body("main");
    }

    @GetMapping("/user")
    public ResponseEntity<?> findAll() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok().body(userList);
    }
}
