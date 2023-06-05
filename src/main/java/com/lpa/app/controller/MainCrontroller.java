package com.lpa.app.controller;

import com.lpa.app.controller.request.CreateUserDTO;
import com.lpa.app.models.ERole;
import com.lpa.app.models.RoleEntity;
import com.lpa.app.models.UserEntity;
import com.lpa.app.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class MainCrontroller {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/hello")
    public String test(){
        return "Hello sin seguridad mi rey";
    }

    @GetMapping("/helloSecured")
    public String testSecured(){
        return "Hello CON seguridad mi rey";
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createuser(@Valid @RequestBody CreateUserDTO createUserDTO){

        Set<RoleEntity> roles= createUserDTO.roles().stream().map(role-> RoleEntity.builder()
                .name(ERole.valueOf(role)).build())
                .collect(Collectors.toSet());

        UserEntity userEntity= UserEntity.builder()
                .username(createUserDTO.username())
                .password(passwordEncoder.encode(createUserDTO.password()))
                .email(createUserDTO.email())
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "Se borro el usuario con el id: "+id;
    }

}
