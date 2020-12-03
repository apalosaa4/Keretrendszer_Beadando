package uni.eszterhazy.keretrendszer.service.impl;

import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.service.TermekService;

import java.util.Collection;
import java.util.Map;

public class TermekServiceImpl implements TermekService {

    private TermekDAO dao;

    public TermekServiceImpl(TermekDAO dao) {
        this.dao = dao;
    }

    @Override
    public void addTermek(Termek termek) {
        dao.createTermek(termek);
    }

    @Override
    public Collection<Termek> getAllTermek() {
        return dao.readAllTermek();
    }

    @Override
    public Termek getAllTermek(String id) {
        return null;
    }

    @Override
    public void updateTermek(Termek termek) {

    }

    @Override
    public void removeTermek(Termek termek) {

    }

    @Override
    public Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria) {
        return null;
    }

    @Override
    public double atlagar() {
        Collection<Termek> termekek = getAllTermek();
        /*
        double sum=0;
        for (Termek t : termekek){
            sum += t.getAr();
        }
        return sum/ termekek.size();
         */
        return termekek.stream().mapToDouble(t -> t.getAr()).average().getAsDouble();
    }

    @Override
    public Map<Kategoria, Double> atlagarKategoriankent() {
        return null;
    }
}
