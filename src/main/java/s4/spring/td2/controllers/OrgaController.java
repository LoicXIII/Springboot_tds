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

import static java.lang.Integer.parseInt;

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
    public RedirectView actionAddOrga(@RequestParam String name, @RequestParam String domain, @RequestParam String aliases)
    {
        repository.saveAndFlush(new Organization(name,domain,aliases));
        return new RedirectView("index");
    }
    @GetMapping("/orgas/delete/{id}")
    public RedirectView actionDelete(@PathVariable int id)
    {
        Organization orga=repository.findById(id);
        if(orga!=null) {
            repository.delete(orga);
        }
        return new RedirectView("/orgas/index");
    }

    @GetMapping("orgas/edit/{id}")
    public String viewEdit(ModelMap model,@PathVariable int id){
        model.put("orgas",repository.findById(id));
        return "editOrga";
    }
    @PostMapping("/orgas/editOrga")
    public RedirectView actionEditOrga(@RequestParam int id,@RequestParam String name, @RequestParam String domain, @RequestParam String aliases)
    {
        Organization orga = repository.findById(id);

        orga.setName(name);
        orga.setDomain(domain);
        orga.setAliases(aliases);
        repository.saveAndFlush(orga);
        return new RedirectView("/orgas/index");
    }

}
