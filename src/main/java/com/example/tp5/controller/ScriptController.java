package com.example.tp5.controller;

import com.example.tp5.model.Script;
import com.example.tp5.model.User;
import com.example.tp5.repository.CategoryRepository;
import com.example.tp5.repository.LanguageRepository;
import com.example.tp5.repository.ScriptRepository;
import com.example.tp5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class ScriptController {

    @Autowired
    private ScriptRepository scriptRepository;

    @GetMapping("/script/new")
    public String nouveauScript() {

        return "scriptNew";
    }

    @PostMapping("/script/submit")
    public RedirectView scriptSubmit(@RequestParam String title, @RequestParam String description, @RequestParam String content, @RequestParam String date){
        Script script=new Script(title,description,content,date);
        scriptRepository.saveAndFlush(script);
        return new RedirectView("/index");
    }
    @GetMapping("/script/{id}")
    public String modifierScript(@PathVariable("id") String id){
        return "scriptNew";
    }

}
