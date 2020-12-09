package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.service.TermekService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest/")
public class RESTTermekController {

    @Autowired
    TermekService termekService;

    @GetMapping(value ="termek/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public Termek getTermekById(@PathVariable(name="id")String id) throws TermekNotFound {
        return termekService.getTermekById(id);
    }

    @GetMapping(value="termekek")
    public Collection<Termek> getAllTermekofKategoria(@RequestParam(value = "kategoria", required = false) Kategoria kategoria, @RequestParam(value = "minimumar", required = false) Integer ar){
        int arErtek;
        if(ar == null){
            arErtek = 0;
        }
        else{
            arErtek = ar.intValue();
        }
        if (kategoria != null && arErtek == 0){
            return termekService.readAllTermekOfKategoria(kategoria);
        }
        if (kategoria != null && arErtek > 0){
            return termekService.readAllTermekOfKategoria(kategoria).stream().filter(d -> d.getAr()> ar).collect(Collectors.toList());
        }
        if (kategoria == null && arErtek > 0){
            return termekService.getAllTermek().stream().filter(d -> d.getAr() > ar).collect(Collectors.toList());
        }
        return termekService.getAllTermek();
    }


    @PostMapping(value = "termekek", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addTermek(@RequestBody Termek termek) throws TermekAlreadyAdded {
        System.out.println("A hozzáadandó: " + termek);
        termekService.addTermek(termek);
        return "Új terméket adtunk hozzá " + termek.getNev() + " néven a/az " + termek.getId() + " azonosítóval";
    }
}
