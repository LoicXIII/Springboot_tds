package s4.spring.td2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OrgaController {

    @GetMapping("orgas/index")
    public String viewIndex(){
        return "main/index";
    }
    @GetMapping("orgas/new")
    public String viewNewOrg(){
        return "ajoutOrga";
    }
}
