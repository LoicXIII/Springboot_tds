package s4.spring.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import s4.spring.td2.entities.Organization;
import s4.spring.td2.repositories.OrgaRepository;

import java.util.List;

@RestController
public class RestOrgasController {

    @Autowired
    private OrgaRepository repository;


    @GetMapping("/rest/orgas")
    public List<Organization> read()
    {
        return repository.findAll();
    }

    @GetMapping("/rest/orgas/{id}")
    public Organization read(@PathVariable int id){
        return repository.findById(id);
    }

    @PostMapping(
            value = "/rest/orgas/create",consumes = "application/json",produces = "application/json")
    public Organization create(@RequestBody Organization orga)
    {
        return repository.saveAndFlush(orga);
    }

    @PutMapping(
            value = "/rest/orgas/update")
    public Organization update(@RequestBody Organization organi)
    {
        Organization orga=repository.findById(organi.getId());
        orga.setName(organi.getName());
        orga.setDomain(organi.getDomain());
        orga.setAliases(organi.getAliases());
        return repository.save(orga);
    }

    @DeleteMapping("/rest/orgas/delete")
    public void delete(@RequestBody Organization organi)
    {
        Organization orga=repository.findById(organi.getId());
        repository.delete(orga);

    }/*

    @GetMapping("/rest/orgas/{member}/{id}")
    public String get(@PathVariable String membre,@PathVariable int id)
    {
    //on peut pas faire se tt de suite on n'a pas les membres
        return "ajoutOrga";
    }*/
}
