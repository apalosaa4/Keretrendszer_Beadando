import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uni.eszeterhazy.keretrendszer.dao.json.TermekDAOJSON;
import uni.eszterhazy.keretrendszer.dao.TermekDAO;
import uni.eszterhazy.keretrendszer.dao.mongo.TermekDAOMongo;
import uni.eszterhazy.keretrendszer.service.TermekService;
import uni.eszterhazy.keretrendszer.service.impl.TermekServiceImpl;

import java.io.IOException;
import java.net.UnknownHostException;

@Configuration
@ComponentScan({"uni.eszterhazy.keretrendszer.controller"})

public class MyConfig {

    @Bean(name="mongoDBDAO")
    public TermekDAO mongodb(){
        try {
            return new TermekDAOMongo("mongodb://localhost:27017", "termekek","termek");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Qualifier("jsonDBDAO")
    @Bean
    public TermekDAO jsondb(){
        try {
            return new TermekDAOJSON("Termek.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public TermekService termekService(TermekDAO mongoDBDAO){
        return new TermekServiceImpl(mongoDBDAO);
    }
}
