package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;

import java.util.Collection;

public interface TermekDAO {
    void createTermek(Termek termek) throws TermekAlreadyAdded;
    Collection<Termek> readAllTermek();
    Termek readTermek(String id) throws TermekNotFound;
    void updateTermek(Termek termek);
    void deleteTermek(Termek termek);
    Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria);
}
