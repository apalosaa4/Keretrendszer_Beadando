package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;
import uni.eszterhazy.keretrendszer.service.TermekService;

@Controller
public class TermekController {

    @Autowired
    @Qualifier("termekService")
    TermekService service;

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


}
