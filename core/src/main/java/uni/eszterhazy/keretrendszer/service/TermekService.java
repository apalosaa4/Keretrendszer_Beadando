package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.exception.TermekNotFound;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;

import java.util.Collection;
import java.util.Map;

public interface TermekService {
    void addTermek(Termek termek) throws TermekAlreadyAdded;
    Collection<Termek> getAllTermek();
    Termek getTermekById(String id) throws TermekNotFound;
    void updateTermek(Termek termek);
    void removeTermek(Termek termek);
    Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria);
    double atlagar();

    Collection<Termek> getAllTermekInWageRange(int minimum, int maximum);

    Collection<Termek> getAllTermekWithMinimumWage(int minimum);

    Map<Kategoria, Double> atlagarKategoriankent();

}

