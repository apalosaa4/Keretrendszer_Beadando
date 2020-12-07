import uni.eszeterhazy.keretrendszer.dao.json.TermekDAOJSON;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.dao.mongo.TermekDAOMongo;
import uni.eszterhazy.keretrendszer.exception.ArNegativ;
import uni.eszterhazy.keretrendszer.exception.NevNemUres;
import uni.eszterhazy.keretrendszer.exception.RosszGyartasiNap;
import uni.eszterhazy.keretrendszer.model.Termek;
import uni.eszterhazy.keretrendszer.service.TermekService;
import uni.eszterhazy.keretrendszer.exception.TermekAlreadyAdded;
import uni.eszterhazy.keretrendszer.service.impl.TermekServiceImpl;

import java.io.IOException;
import java.time.LocalDate;

public class Proba {
    public static void main(String[] args) throws ArNegativ, NevNemUres, RosszGyartasiNap, IOException {
        //TermekDAO dao = new TermekDAOJSON("termekadatok.json");
        TermekDAO dao = new TermekDAOMongo("mongodb://localhost:27017", "termekek","termek");
        TermekService service = new TermekServiceImpl(dao);

        Termek termek = new Termek();
        termek.setAr(180000);
        termek.setNev("Arany zokni");
        termek.setGyartasinap(LocalDate.of(2018,06,07));
        try {
            service.addTermek(termek);
        } catch (TermekAlreadyAdded termekAlreadyAdded) {
            termekAlreadyAdded.printStackTrace();
        }
        System.out.println(service.getAllTermek());
        System.out.println(service.atlagar());
    }
}
