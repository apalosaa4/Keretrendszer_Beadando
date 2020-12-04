import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.dao.mongo.TermekDAOMongo;
import uni.eszterhazy.keretrendszer.service.TermekService;
import uni.eszterhazy.keretrendszer.service.impl.TermekServiceImpl;

import java.io.IOException;
import java.net.UnknownHostException;

@Configuration

public class MyConfig {

    @Bean(name="mongoDBDAO")
    public TermekDAO mongodb(){
        try {
            return new TermekDAOMongo("mongodb://localhost:3308", "termekek","termek");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*@Qualifier("jsonDBDAO")
    @Bean
    public TermekDAOMongo jsondb(){
        try {
            return new TermekDAOMongo("Termek.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    @Bean
    public TermekService dolgozoService(TermekDAO mongoDBDAO){
        return new TermekServiceImpl(mongoDBDAO);
    }
}
