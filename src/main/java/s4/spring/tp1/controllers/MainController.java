package s4.spring.tp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import s4.spring.tp1.models.Element;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("items")
public class MainController {

    @ModelAttribute("items")
    public List<Element> getItems(){
        return new ArrayList<Element>();
    }

    @GetMapping("/items")
    public String viewItem(){
        return "items";
    }

    @GetMapping("/items/new")
    public String listItem(){
        return "newElement";
    }

    @PostMapping("/items/addNew")
    public RedirectView addView(@RequestParam String nom,@SessionAttribute List<Element> items){
        items.add(new Element(nom));
        return new RedirectView("/items");
    }

    @GetMapping("items/inc/{nom}")
    public RedirectView increment(@PathVariable String nom,@SessionAttribute List<Element> items) {
        int index = items.indexOf(new Element(nom));
        if(index!=-1){
            items.get(index).inc();
        }
        return new RedirectView("/items");
    }
    @GetMapping("items/dec/{nom}")
    public RedirectView decrementer(@PathVariable String nom,@SessionAttribute List<Element> items) {
        int index = items.indexOf(new Element(nom));
        if(index!=-1){
            items.get(index).dec();
        }
        return new RedirectView("/items");
    }

    @GetMapping("items/delete/{nom}")
    public RedirectView supprimer(@PathVariable String nom,@SessionAttribute List<Element> items){
        int index = items.indexOf(new Element(nom));
        if(index!=-1){
            items.remove(index);
        }
        return new RedirectView("/items");
    }


}


