package uni.eszterhazy.keretrendszer.dao.relational;

import org.junit.Test;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.exception.ArNegativ;
import uni.eszterhazy.keretrendszer.exception.NevNemUres;
import uni.eszterhazy.keretrendszer.exception.RosszGyartasiNap;
import uni.eszterhazy.keretrendszer.model.Kategoria;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.exception.TermekNotFound;

import java.time.LocalDate;

public class TermekDAORelationalTest {

    @Test
    public void test() throws NevNemUres, ArNegativ, RosszGyartasiNap, TermekAlreadyAdded, TermekNotFound {
        TermekDAO dao = new TermekDAORelational();
        Termek termek = new Termek();
        termek.setNev("Fehér karfás szék");
        termek.setAr(15000);
        termek.setKategoria(Kategoria.NAPPALI);
        termek.setGyartasinap(LocalDate.of(2018,11,04));
        dao.createTermek(termek);
        System.out.println(dao.readTermek(termek.getId()));
        System.out.println(dao.readAllTermekOfKategoria(Kategoria.NAPPALI));
    }
}