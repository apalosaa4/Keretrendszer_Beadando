package uni.eszterhazy.keretrendszer.dao.relational;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
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
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(termek);
        tr.commit();
        session.close();
    }

    @Override
    public Collection<Termek> readAllTermek() {
        Session session = factory.openSession();
        Collection<Termek> result = session.createQuery("FROM Termek").list();
        return result;
    }

    @Override
    public Termek readTermek(String id) {
        Session session = factory.openSession();
        Termek result = session.get(Termek.class, id);
        return result;
    }

    @Override
    public void updateTermek(Termek termek) {

    }

    @Override
    public void deleteTermek(Termek termek) {

    }

    @Override
    public Collection<Termek> readAllTermekOfKategoria(Kategoria kategoria) {
        Session session = factory.openSession();
        String hql = "From Termek Where kategoria = :kategoria";
        Query q = session.createQuery(hql);
        q.setParameter("kategoria", kategoria);
        Collection result = q.list();
        return null;
    }
}
