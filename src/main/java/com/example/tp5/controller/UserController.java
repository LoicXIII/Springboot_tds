package com.example.tp5.controller;

import com.example.tp5.model.User;
import com.example.tp5.repository.CategoryRepository;
import com.example.tp5.repository.LanguageRepository;
import com.example.tp5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/index")
    public String index() {

        return "index";
    }
    @GetMapping("/login")
    public RedirectView pageConnexion(HttpSession session_param) {
        if(userRepository.findAll().isEmpty()) {
            User user1 = new User("loki", "1234", "loki@gmail", "Loic Le Goas");
            userRepository.saveAndFlush(user1);
        }
        User connecte = userRepository.findAll().get(0);
        session_param.setAttribute("utilisateur connecte", connecte);
        System.out.println(connecte);
        session_param.getAttribute("utilisateur connecte");
        return new RedirectView("/index");
    }

    @GetMapping("/logout")
    public RedirectView pageDeconnexion(HttpSession session_param){
        session_param.setAttribute("",session_param.getAttribute("utilisateur connecte"));

        return new RedirectView("/index");
    }
}
