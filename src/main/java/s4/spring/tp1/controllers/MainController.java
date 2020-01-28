package s4.spring.tp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import s4.spring.tp1.models.Element;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("items")
public class MainController {

    @ModelAttribute("items")
    public List<Element> getItems(){
        return new ArrayList<>();
    }

    @GetMapping("/items")
    public String viewItem(){
        return "items";
    }
}
