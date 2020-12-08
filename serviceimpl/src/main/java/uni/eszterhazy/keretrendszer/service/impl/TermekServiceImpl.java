package uni.eszterhazy.keretrendszer.service.impl;

import org.apache.log4j.Logger;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.service.TermekService;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;


public class TermekServiceImpl implements TermekService {

    Logger logger = Logger.getLogger(this.getClass());

    private TermekDAO dao;

    public TermekServiceImpl(TermekDAO dao) {
        this.dao = dao;
    }

    @Override
    public void addTermek(Termek termek) throws TermekAlreadyAdded {
        dao.createTermek(termek);
    }

    @Override
    public Collection<Termek> getAllTermek() {
        Collection<Termek> result = dao.readAllTermek();
        logger.info(result.size()+" darab termék van az adatbázisunkban.");
        return result;
    }

    @Override
    public Termek getTermekById(String id) throws TermekNotFound {
        return dao.readTermek(id);
    }


    @Override
    public void updateTermek(Termek termek) {

    }

    @Override
    public void removeTermek(Termek termek) {

    }

    @Override
    public Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria) {
        Collection<Termek> termekek = getAllTermek();
        Collection<Termek> result = termekek.stream().filter(d -> d.getKategoria() == kategoria).collect(Collectors.toList());
        return result;
    }

    @Override
    public double atlagar() {
        Collection<Termek> termekek = getAllTermek();
        return termekek.stream().mapToDouble(t -> t.getAr()).average().getAsDouble();
    }

    @Override
    public Collection<Termek> getAllTermekInWageRange(int minimum, int maximum) {
        if (maximum <= minimum){
            throw new IllegalArgumentException("Maximum nagyobb mint a minimum");
        }
        return getAllTermek().stream().filter(d-> d.getAr() >= minimum && d.getAr()< maximum).collect(Collectors.toList());
    }

    @Override
    public Collection<Termek> getAllTermekWithMinimumWage(int minimum) {
        return getAllTermek().stream().filter(d-> d.getAr() >= minimum).collect(Collectors.toList());
    }

    @Override
    public Map<Kategoria, Double> atlagarKategoriankent() {
        return null;
    }
}
