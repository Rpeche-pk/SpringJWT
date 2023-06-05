package com.lpa.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {


    @GetMapping("/accessAdmin")
    @Secured("ROLE_ADMIN")
    public String accesAdmin(){
        return "Hello hello hellooo, has accedido con el rol ADMIN";
    }

    @Secured("ROLE_USER")
    @GetMapping("/accessUser")
    public String accesUser(){
        return "Hello hello hellooo, has accedido con el rol USER";
    }
    @Secured("ROLE_INVITED")
    @GetMapping("/accessInvited")
    public String accesInvited(){
        return "Hello hello hellooo, has accedido con el rol INIVTED";
    }
}
