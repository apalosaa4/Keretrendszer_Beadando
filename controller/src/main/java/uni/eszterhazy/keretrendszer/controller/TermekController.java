package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import uni.eszterhazy.keretrendszer.service.TermekService;

@Component
public class TermekController {

    @Autowired
    @Qualifier("termekService")
    TermekService service;

    public void printAll(){
        System.out.println(service.getAllTermek());
    }
}
