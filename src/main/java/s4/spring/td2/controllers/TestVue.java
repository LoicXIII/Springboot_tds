package s4.spring.td2.controllers;

import io.github.jeemv.springboot.vuejs.VueJS;

import io.github.jeemv.springboot.vuejs.utilities.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import s4.spring.td2.repositories.OrgaRepository;

@Controller
public class TestVue {

    @Autowired
    private OrgaRepository repo;

    @Autowired
    private VueJS vue;

    @GetMapping("/vueTest")
    public String index(ModelMap model){
        vue.addData("message","Test message");
        vue.addData("copie");
        vue.addData("names",new String[] {"bob","bip"});
        vue.addDataRaw("captions","['Name','domain','aliases']");
        vue.addMethod("doCopie","this.copie=this.message");
        model.put("vue", this.vue);
        return "vueTest";
    }

    @GetMapping("/dataTable")
    public String dataTable(ModelMap model){
        vue.addDataRaw("headers","[{text:'Name', value:'name'},{text:'Domain',value:'domain'},{text:'Aliases',value:'aliases'},{text:'Actions',value:'action'}]");
        vue.addData("datas",repo.findAll());
        vue.addMethod("addOrganisation", Http.post("http://localhost:8082/rest/orgas/create","d"));
        model.put("vue",this.vue);

        return "dataTable";
    }
}

