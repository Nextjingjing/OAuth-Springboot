package com.nexty.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexty.backend.dto.ResponseAPI;
import com.nexty.backend.dto.UserRequestBodyDTO;
import com.nexty.backend.entity.User;
import com.nexty.backend.repository.UserRepository;
import com.nexty.backend.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<ResponseAPI<User>> getUserInfo(OAuth2AuthenticationToken token) {
        Optional<User> userOptional = userService.getUserByToken(token);
        if(userOptional.isPresent()){
            ResponseAPI<User> res = new ResponseAPI<>();
            res.setMessage("Success");
            res.setData(userOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        ResponseAPI<User> res = new ResponseAPI<>();
        res.setMessage("Not found");
        res.setData(null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

    @PutMapping("/")
    public ResponseEntity<ResponseAPI<User>> updateUserInfo(OAuth2AuthenticationToken token, @RequestBody UserRequestBodyDTO userRequest){
        Optional<User> userOptional = userService.getUserByToken(token);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(userRequest.getFname() != null){
                user.setFname(userRequest.getFname());             
            }
            if(userRequest.getLname() != null){
                user.setLname(userRequest.getLname());
            }
            if(userRequest.getEmail() != null){
                user.setEmail(userRequest.getEmail());
            }
            if(userRequest.getBirthdate() != null){
                user.setBirthdate(userRequest.getBirthdate());
            }
            userRepository.save(user);
            ResponseAPI<User> res = new ResponseAPI<>();
            res.setMessage("User Update Success");
            res.setData(user);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }

        ResponseAPI<User> res = new ResponseAPI<>();
        res.setMessage("Not found");
        res.setData(null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

    
}
