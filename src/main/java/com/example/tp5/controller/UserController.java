package com.example.tp5.controller;

import com.example.tp5.model.User;
import com.example.tp5.repository.CategoryRepository;
import com.example.tp5.repository.LanguageRepository;
import com.example.tp5.repository.ScriptRepository;
import com.example.tp5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    @Autowired
    private ScriptRepository scriptRepository;

    @GetMapping("/index")
    public String index(Model model,RedirectAttributes attributes) {
        attributes.addFlashAttribute("reposScript",scriptRepository);
        return "index";
    }
    @GetMapping("/login")
    public RedirectView pageConnexion(HttpSession session_param, RedirectAttributes attribute) {
        if(userRepository.findAll().isEmpty()) {
            User user1 = new User("loki", "1234", "loki@gmail", "Loic Le Goas");
            userRepository.saveAndFlush(user1);
        }
        User connecte = userRepository.findAll().get(0);
        session_param.setAttribute("utilisateur connecte", connecte);
        session_param.getAttribute("utilisateur connecte");
        attribute.addFlashAttribute("login",connecte.getLogin());
        attribute.addFlashAttribute("mail",connecte.getEmail());
        return new RedirectView("/index");
    }

    @GetMapping("/logout")
    public RedirectView pageDeconnexion(HttpSession session_param, Model model, RedirectAttributes attribute){
        session_param.setAttribute("",session_param.getAttribute("utilisateur connecte"));
        attribute.addFlashAttribute("message","Vous vous êtes déconnecté avec succès");
        return new RedirectView("/index");
    }
}
