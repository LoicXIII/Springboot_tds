package com.example.tp5.controller;

import com.example.tp5.model.History;
import com.example.tp5.model.Script;
import com.example.tp5.model.User;
import com.example.tp5.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ScriptController {

    final Date date = new Date();



    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ScriptRepository scriptRepository;

    @GetMapping("/script/new")
    public String nouveauScript() {

        return "scriptNew";
    }

    @PostMapping(path="/script/submit")
    public RedirectView scriptSubmit(@RequestParam String title, @RequestParam String description, @RequestParam String content, @RequestParam String date){
        Script script=new Script(title,description,content,date);
        scriptRepository.saveAndFlush(script);
        historyRepository.saveAndFlush(new History(date.toString(),content,"nouveau Script"));
        return new RedirectView("/index");
    }
    @GetMapping("/script/{id}")
    public String modifierScript(@PathVariable("id") String id){
        return "scriptNew";
    }

}
