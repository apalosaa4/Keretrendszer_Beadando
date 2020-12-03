import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.dao.relational.TermekDAORelational;
import uni.eszterhazy.keretrendszer.exception.ArNegativ;
import uni.eszterhazy.keretrendszer.exception.NevNemUres;
import uni.eszterhazy.keretrendszer.exception.RosszGyartasiNap;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.service.TermekService;
import uni.eszterhazy.keretrendszer.service.impl.TermekServiceImpl;

import java.time.LocalDate;

public class Proba {
    public static void main(String[] args) throws ArNegativ, NevNemUres, RosszGyartasiNap {
        TermekDAO dao = new TermekDAORelational();
        TermekService service = new TermekServiceImpl(dao);

        Termek termek = new Termek();
        termek.setAr(180000);
        termek.setNev("Arany zokni");
        termek.setGyartasinap(LocalDate.of(2018,06,07));
        service.addTermek(termek);

        System.out.println(service.atlagar());

    }
}
