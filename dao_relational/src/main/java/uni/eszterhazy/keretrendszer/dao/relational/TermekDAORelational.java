package uni.eszterhazy.keretrendszer.dao.relational;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;

import java.util.Collection;

public class TermekDAORelational implements TermekDAO {

    private static SessionFactory factory;

    public TermekDAORelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void createTermek(Termek termek) {

    }

    @Override
    public Collection<Termek> readAllTermek() {
        return null;
    }

    @Override
    public Termek readTermek() {
        return null;
    }

    @Override
    public void updateTermek(Termek termek) {

    }

    @Override
    public void deleteTermek(Termek termek) {

    }

    @Override
    public Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria) {
        return null;
    }
}
