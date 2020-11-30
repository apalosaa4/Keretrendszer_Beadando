package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;

import java.util.Collection;

public interface TermekDAO {
    void createTermek(Termek termek);
    Collection<Termek> readAllTermek();
    Termek readTermek(String id);
    void updateTermek(Termek termek);
    void deleteTermek(Termek termek);
    Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria);
}
