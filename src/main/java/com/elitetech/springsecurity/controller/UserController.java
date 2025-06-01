
package com.elitetech.springsecurity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.elitetech.springsecurity.entity.AuthRequest;
import com.elitetech.springsecurity.entity.UserInfo;
import com.elitetech.springsecurity.repository.UserInfoRepository;
import com.elitetech.springsecurity.service.JwtService;
import com.elitetech.springsecurity.service.UserInfoService;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/auth")
public class UserController {
	
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    


    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Spring Security tutorials!");
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserInfo> getUserByEmail(@PathVariable String email) {
        UserInfo user = userInfoService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<UserInfo> updateUser(@PathVariable Long id, @RequestBody UserInfo updatedUser) {
        Optional<UserInfo> optionalUser = userInfoService.getUser(id.intValue());
        if (optionalUser.isPresent()) {
            UserInfo existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setPassword(userInfoService.encodePassword(updatedUser.getPassword())); // encode le mot de passe
            existingUser.setRoles(updatedUser.getRoles()); // facultatif si modifiable

            return ResponseEntity.ok(userInfoRepository.save(existingUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/add")
    public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo userInfo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoService.addUser(userInfo));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

            if (authentication.isAuthenticated()) {
                UserInfo user = userInfoService.getUserByEmail(authRequest.getUserName());
                if (user != null) {
                    String token = jwtService.generateToken(user.getEmail(), user.getId(), user.getRoles());
                    return ResponseEntity.ok(token);
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found or authentication failed");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        return ResponseEntity.ok(userInfoService.getAllUser());
    }
    @GetMapping("/users/count")
    public ResponseEntity<Long> countUsers() {
        return ResponseEntity.ok(userInfoService.countUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable Integer id) {
        return userInfoService.getUser(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
