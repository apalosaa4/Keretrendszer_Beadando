package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.service.TermekService;

@Controller
public class TermekController {

    @Autowired
    @Qualifier("termekService")
    TermekService service;

    @ModelAttribute(value = "termek")
    public Termek create(){
        return new Termek();
    }

    @GetMapping(value = "/termekek")
    public ModelAndView getTermekek(){
        ModelAndView mav = new ModelAndView("termeklist.jsp");
        System.out.println(service.getAllTermek());
        mav.addObject("termekek", service.getAllTermek());
        return mav;
    }

    @GetMapping(value="/termek/{id}")
    public String getTermekById(@PathVariable String id, Model model) throws TermekNotFound {
        model.addAttribute("termek", service.getTermekById(id));
        return "termekdetails.jsp";
    }

    @GetMapping(value = "addTermek")
    public String addTermekForm(Model model){
        model.addAttribute("kategoriak", Kategoria.values());
        return "termekForm.jsp";
    }

    @PostMapping(value = "addTermek")
    public String addTermek(@ModelAttribute("termek") Termek termek, Model model){
        System.out.println(termek);
        try {
            service.addTermek(termek);
        }
        catch (TermekAlreadyAdded termekAlreadyAdded) {
            termekAlreadyAdded.printStackTrace();
        }
        return "redirect:termek/"+termek.getId();
    }
}
