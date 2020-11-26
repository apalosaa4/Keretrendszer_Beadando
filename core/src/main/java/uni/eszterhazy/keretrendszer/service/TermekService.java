package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;

import java.util.Collection;
import java.util.Map;

public interface TermekService {
    void addTermek(Termek termek);
    Collection<Termek> getAllTermek();
    Termek getAllTermek(String id);
    void updateTermek(Termek termek);
    void removeTermek(Termek termek);
    Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria);
    double atlagar();
    Map<Kategoria, Double> atlagarKategoriankent();

}
