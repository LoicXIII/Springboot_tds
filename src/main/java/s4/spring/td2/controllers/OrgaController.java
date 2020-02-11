package s4.spring.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import s4.spring.td2.entities.Organization;
import s4.spring.td2.repositories.OrgaRepository;

import java.util.Optional;

@Controller
public class OrgaController {
    @Autowired
    private OrgaRepository repository;

    @GetMapping("/orgas/index")
    public String viewIndex(ModelMap map)
    {
        map.put("orgas",repository.findAll());
        return "index";
    }

    @GetMapping("/orgas/new")
    public String viewNewOrg(){
        return "ajoutOrga";
    }

    @PostMapping("/orgas/addOrga")
    public RedirectView actionAddOrga(@RequestParam String nom, @RequestParam String domain, @RequestParam String aliases)
    {
        repository.saveAndFlush(new Organization(nom,domain,aliases));
        return new RedirectView("index");
    }
    @PostMapping("/orgas/delete/{id}")
    public RedirectView actionDelete(@PathVariable int id)
    {
        repository.delete(repository.findById(id));
        return new RedirectView("index");
    }




    @GetMapping("orgas/edit/{id}")
    public String viewEdit(@PathVariable int id){
        return "editOrga";

    }



}
