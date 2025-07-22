package com.portfolio.cadastro_livros.controller;

import com.portfolio.cadastro_livros.business.UserService;
import com.portfolio.cadastro_livros.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> findUserById(@RequestParam Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestParam Long id, @RequestBody User user){
        userService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
