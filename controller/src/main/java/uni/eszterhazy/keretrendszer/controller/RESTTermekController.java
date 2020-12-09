package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uni.eszterhazy.keretrendszer.exception.RosszGyartasiNap;
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

    @ExceptionHandler(TermekAlreadyAdded.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public String usedTermekId(TermekAlreadyAdded e){
        return "Egy termék az adott azonosítóval már létezik: "+e.getMessage();
    }

    @ExceptionHandler(RosszGyartasiNap.class)
    public String badrequest(RosszGyartasiNap e) {
        return e.getMessage();
    }

    @GetMapping(value = "termekek")
    public Collection<Termek> getAllTermekOfKategoria(@RequestParam(value = "kategoria", required = false) Kategoria kategoria, @RequestParam(value = "minimumar", required = false) Integer ar){
        Collection<Termek> arszerint= ar !=null? termekService.getAllTermekWithMinimumWage(ar.intValue()): termekService.getAllTermek();
        Collection<Termek> kategoriaszerint = kategoria !=null? termekService.readAllTermekOfKategoria(kategoria): termekService.getAllTermek();
        return arszerint.stream().filter(d -> kategoriaszerint.contains(d)).collect(Collectors.toList());
    }

    @PostMapping(value = "termekek", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addTermek(@RequestBody Termek termek) throws TermekAlreadyAdded {
        System.out.println("A hozzáadandó: " + termek);
        termekService.addTermek(termek);
        return "Új terméket adtunk hozzá " + termek.getNev() + " néven a/az " + termek.getId() + " azonosítóval";
    }
}
