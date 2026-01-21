/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erstesrping.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author darko
 */
@Controller
public class HomeKontroler {
    
    @GetMapping("/gradovi")
    public String cityPage() {
        return "gradovi";
    }

    @GetMapping("/letovi")
    public String flightPage() {
        return "letovi";
    }
    
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/letovi-auth")
    public String letoviAuth() {
        return "letovi-auth";
    }
    
    @GetMapping("/kupovna")
    public String kupovnaAuth() {
        return "kupovna";
    }
    
    @GetMapping("/kupljene")
    public String kupljeneAuth(){
        return "kupljene";
    }
}
