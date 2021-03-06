package com.example.bookManagement;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String root() {
        return "books";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }


    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }


    @GetMapping("/recover")
    public String recover() {
        return "recover";
    }


    @GetMapping("/reset")
    public String reset() {
        return "reset";
    }

    @GetMapping("/wishlist")
    public String wishlist() {
        return "wishlist";
    }


    @GetMapping("/reading")
    public String reading() {
        return "reading";
    }

    @GetMapping("/stats")
    public String stats() {
        return "stats";
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
