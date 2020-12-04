package uni.eszterhazy.keretrendszer.service.impl;

import org.apache.log4j.Logger;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.service.TermekService;

import java.util.Collection;
import java.util.Map;

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
        return termekek.stream().mapToDouble(t -> t.getAr()).average().getAsDouble();
    }

    @Override
    public Map<Kategoria, Double> atlagarKategoriankent() {
        return null;
    }
}
